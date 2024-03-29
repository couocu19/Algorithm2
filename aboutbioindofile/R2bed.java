package aboutbioindofile;

import java.io.*;
import java.util.*;

public class R2bed {

    Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        R2bed r = new R2bed();
        String index_path = "D:/protein-data-set/831-testdata/fast_index.txt";
        String index_path1 = "D:/giraffe/fanse2-res2/fast_index.txt";
        String index_path2 = "D:/protein-data-set/yeast/res-teat/fast_index.txt";
        String index_path3 = "D:\\fanse-work-test\\fast_index.txt";
        String index_path4 = "E:\\Arab\\old\\fast_index.txt";
        String index_path5 = "E:\\Arab\\new3\\fast_index.txt";

        List<ChrIndexInfo> list = r.get_fast_idx_file(index_path5);
        for(ChrIndexInfo a : list){
            System.out.print(a.fileSeq +" "+a.chrName+" "+a.chrIndex);
            System.out.println();
        }
        String dir_path = "D:/protein-data-set/831-testdata/";
        String bed_path = "D:/protein-data-set/831-testdata/test.bed";

        String dir_path1 = "D:/giraffe/fanse2-res2/";
        String bed_path1 = "D:/giraffe/fanse2-res2/fanse-4257.bed";

        String dir_path2 = "D:\\protein-data-set\\yeast\\res-teat\\";
        String bed_path2 = "D:\\protein-data-set\\yeast\\res-teat\\new-fanse-4257.bed";

        String dir_path3 = "D:\\fanse-work-test\\";
        String bed_path3 = "D:\\fanse-work-test\\fanse-160-4257.bed";

        String dir_path4 = "D:\\fanse-work-test\\";
        String bed_path4 = "E:\\remake-res-data\\new\\new-first-all.bed";

        String dir_path5 = "E:\\Arab\\old\\";
        String bed_path5 = "E:\\Arab\\old\\old-fst-all.bed";

        String dir_path6 = "E:\\Arab\\new3\\";
        String bed_path6 = "E:\\Arab\\new3\\new-fst-all.bed";



        int f = r.get_r2bed(dir_path6,list,bed_path6);
        System.out.println(f);

    }

    public List<ChrIndexInfo> get_fast_idx_file(String file_path){
        List<ChrIndexInfo> chrList = new ArrayList<>();
        map.put("1",0);
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            String line;
            String[] sline;
            while ((line = br.readLine()) != null) {
                ChrIndexInfo c = new ChrIndexInfo();
                sline = line.split(" ",6);
                if((!chrList.isEmpty()) && (sline[0].equals(chrList.get(chrList.size()-1).fileSeq)) && (sline[4].equals(chrList.get(chrList.size()-1).chrName)))
                    continue;
                if((!chrList.isEmpty()) && (!sline[0].equals(chrList.get(chrList.size()-1).fileSeq)))
                    map.put(sline[0],i);
                c.fileSeq = sline[0];
                c.chrIndex = sline[1];
                c.chrName = sline[4];
                chrList.add(c);
                i++;
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return chrList;
    }

    public int get_r2bed(String dir_path,List<ChrIndexInfo> list,String bed_file_path){
        File dirFile = new File(dir_path);
        //推断该文件或文件夹是否存在。不存在时在控制台输出提醒
        if (!dirFile.exists()) {
            System.out.println("do not exit");
            return -1;
        }
        //推断假设不是一个文件夹，就推断是不是一个文件，时文件则输出文件路径
        if (!dirFile.isDirectory()) {
            System.out.println("当前文件夹不是r文件所在的文件夹！");
            return -1;
        }
        String[] fileList = dirFile.list();
        int len = fileList.length;
        try {
            FileWriter bw = new FileWriter(bed_file_path);
            for (int i = 1; i <= len; i++) {
                String seq = String.valueOf(i);
                String r_path = dir_path+ seq + ".r"; //确定当前遍历到的r文件
                System.out.println(r_path);
                try {
                    BufferedReader rFile = new BufferedReader(new FileReader(r_path));
                    String line;
                    int j = 0;
                    int slen = 0;
                    String realSeq = "";
                    while ((line = rFile.readLine()) != null) {
                        String[] sline = line.split("\t");
                       // System.out.println(11111);

                        if (j % 2 == 0) {
                            String readsSeq = sline[0];   //获取当前比对到的reads对应的序号
                            realSeq = getReadsSeq(readsSeq);
                            String s = sline[1];
                            slen = s.length();
                        } else {
                            String index_l = sline[3];
                            //求出左右区间
                            Integer l = Integer.valueOf(index_l);
                            Integer r = l + slen;
                            String index_r = String.valueOf(r);
                            String chrName = getChrName(l, seq, list);
                            StringBuilder sb = new StringBuilder(chrName);
                            sb.append("\t");
                            sb.append(index_l);
                            sb.append("\t");
                            sb.append(index_r);
                            sb.append("\t");
                            sb.append(realSeq);

                            sb.append("\n");
                            bw.write(sb.toString());
                            //bw.close();
                           // System.out.println(sb.toString());
                        }
                        j++;

                    }
                    System.out.println(j);
                    bw.close();


                } catch (Exception ex) {
                    //ex.printStackTrace();
                    System.out.println("rFile not exist");
                    break;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }

        return 0;

    }

    public String getReadsSeq(String  preSeq){
        String resSeq = "";
        Integer num = Integer.valueOf(preSeq);
        //Integer realNum = num/2 + 1;
        Integer realNum = num;  //拟南芥的比对不需要转换序列

        resSeq = String.valueOf(realNum);

        return resSeq;


    }


    public String getChrName(int lIdx,String fileSeq,List<ChrIndexInfo> list){
        int startIdx = map.get(fileSeq);
        int len = list.size();
        String chrName = "";
        for(int i = len-1;i>=0;i--){  //todo:这里的逻辑后面需要大改！！
            ChrIndexInfo c = list.get(i);
            Integer cIdx = Integer.valueOf(c.chrIndex);
            if(lIdx>= cIdx){
                chrName = c.chrName;
                break;
            }
        }

        return chrName;
    }





}

class ChrIndexInfo{
    String fileSeq;
    String chrName;
    String chrIndex;

    public ChrIndexInfo(String fileSeq, String chrName, String chrIndex) {
        this.fileSeq = fileSeq;
        this.chrName = chrName;
        this.chrIndex = chrIndex;
    }

    public ChrIndexInfo(){

    }
}
