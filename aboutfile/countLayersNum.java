package aboutfile;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class countLayersNum {
    public static void main(String[] args) {
        countLayersNum s = new countLayersNum();
        int layers = 307;
        int ln = 79981;
        int total = 24521708;
        int match_total = 16532532;
        String path = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\1.r";
        String path1 = "D:\\protein-data-set\\yeast\\res-teat\\1.r";
        int[] lyseq = s.count(layers,ln,total,path1,match_total);
        int[] res = s.transfer(lyseq);
      //  res = s.reverse(res);
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
        String bed_path = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\fanse-4257.bed";
        String split_dir = "D:\\protein-data-set\\yeast\\SRR4072457\\split-bed-data-res2\\split1\\";

        String bed_path1 = "D:\\protein-data-set\\yeast\\res-teat\\new-fanse-4257.bed";
        String split_dir1 = "D:\\protein-data-set\\yeast\\SRR4072457\\split-teat\\split2\\";
        System.out.println(s.splitBedData(bed_path1,split_dir1,res));

    }
    /**
     * 按照数据层数将匹配后的总文件分割的位点记录到数组中
     * @param layers
     * @param ly_lineNum
     * @param total_len
     * @param path
     * @param match_total
     * @return
     */
    public int[] count(int layers,int ly_lineNum,int total_len, String path,int match_total){
        int[] ly = new int[layers];
        ly[0] = ly_lineNum;
        int i;
        for(i = 1;i<(layers-1);i++){
            ly[i] = ly_lineNum*(i+1);
        }
        ly[i] = total_len;
//        for(int m = 0;m<layers;m++){
//            System.out.println(ly[m]+" ");
//        }
//        System.out.println();
        int[] ly_seq = new int[layers];
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line ;
            int le = 1;
            int j  = 0;
            String[] sline = null;
            while ((line=br.readLine())!=null){
                if(le%2 == 0){
                    le++;
                    continue;
                }
                sline = line.split("\t");
                String chrSeq = sline[0];
                Integer seq = Integer.valueOf(chrSeq);
                //System.out.println(seq);
                if(seq >= ly[j] && j <=layers){
                    //System.out.println(seq +" "+ly[j]);
                    ly_seq[j] = le;
                    j++;
                }
                le++;
            }
            ly_seq[layers-1] = match_total;
            System.out.println();
//            for(int m = 0;m<layers;m++){
//                System.out.print(ly_seq[m]+" ");
//            }
//            System.out.println();
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return ly_seq;
    }

    /**
     * 将r文件中的分割位点转为bed文件中的分割位点
     * @param lyseq
     * @return
     */
    public int[] transfer(int[] lyseq){
        int len = lyseq.length;
        if(len == 0)
            return null;
        int[] result = new int[len];
        for(int i = 0;i<len;i++){
            int real = (lyseq[i] +1)/2;
            result[i] = real;
        }
        return result;

    }

    public int splitBedData(String bed_path,String split_dir,int[] ly_lines){
        ly_lines = reverse(ly_lines);
        int len = ly_lines.length;
        try {
          //  BufferedReader br = new BufferedReader(new FileReader(bed_path));
            String line = null;
            int count = 2;
            int total = ly_lines[len-1];
           // System.out.println(total);
            String c ;
            String sp_data_path ;
            BufferedWriter bw ;
//            for(int i = 0;i<total;i++){
//                line = br.readLine();
//                //开启下一个分割文件的写入
//                if((i+1) > ly_lines[count-1]){
//                    bw.close();
//                    //System.out.println("开启下一个分割文件~~~");
//                    count++;
//                    c = String.valueOf(count);
//                    bw = new BufferedWriter(new FileWriter(split_dir+c+".bed"));
//                }
//
//                bw.write(line);
//                bw.write("\n");
//            }
            for(int i = 1;i<=306;i++){
               // System.out.println("分割第"+i+"个文件");
                BufferedReader br = new BufferedReader(new FileReader(bed_path));
                c = String.valueOf(i);
                sp_data_path = split_dir+c+".bed";
                bw = new BufferedWriter(new FileWriter(sp_data_path));
                int read_count = ly_lines[i];
                for(int j = 0;j<read_count;j++){
                    line = br.readLine();
                    bw.write(line);
                    bw.write("\n");
                }
                bw.close();
            }

        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }







        return 0;
    }

    public int[] reverse(int[] num){
        int len = num.length;
        int[] res = new int[len];
        int j = 0;
        for(int i = len-1;i>=0;i--){
            res[j++] = num[i];
        }
        return res;
    }


}
