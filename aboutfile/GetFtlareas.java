package aboutfile;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class GetFtlareas {
   String[] lns = {"230218","1043403","1360024","2891958","3468833","3738995","4829936","5392580","5832469",
                    "6578221","7245038","8323216","9247648","10031982","11123274","12071341","12157121"};
    Integer[] lns1 = {0,230218,1043403,1360024,2891958,3468833,3738995,4829936,5392580,5832469,
            6578221,7245038,8323216,9247648,10031982,11123274,12071341};
    List<Map<Integer,Integer>> map_all = new ArrayList<>();

    public static void main(String[] args) {
        String fp = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257.bed";
        String nfp = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257-ftl.csv";

        String fp1 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.bed";
        String nfp1 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.csv";

        GetFtlareas g = new GetFtlareas();
        g.getChrRanks();
          System.out.println(g.writeArea2File(fp,nfp));
        //System.out.println(g.writeNewArea2File(fp1,nfp1));
    }

    /**
     * 获取首次匹配后匹配失败的区域并将统计结果写入新文件中
     * @param file_path
     * @param new_file_path
     * @return
     */
    public int writeArea2File(String file_path, String new_file_path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            FileWriter fw = new FileWriter(new_file_path);
            String line = "";
            String[] sline;
            String chrName = "";
            String flag = "0";
            StringBuilder sb ;
            int i = 0;
            while ((line = br.readLine()) != null) {
                sline = line.split("\t");
                if((!chrName.equals("")) && (!sline[0].equals(chrName))){
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lns[i]);
                    sb.append("\t");
                    sb.append(getAreaLen(flag,lns[i]));
                    sb.append("\t");
                    sb.append(getAreaRank(i,flag,lns[i]));
                    sb.append("\n");
                    i++;
                    fw.write(sb.toString());
                    flag = String.valueOf(lns1[i]+1);

                }

                chrName = sline[0];
                sb = new StringBuilder(chrName); //todo:还需要单独处理两条染色体间隔的情况！！！
                sb.append("\t");
                sb.append(flag);
                sb.append("\t");
                sb.append(sline[1]);
                sb.append("\t");
                sb.append(getAreaLen(flag,sline[1]));

                sb.append("\t");
                sb.append(getAreaRank(i,flag,sline[1]));
                sb.append("\n");
                flag = sline[2];
                fw.write(sb.toString());
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lns[i]);
            sb.append("\t");
            sb.append(getAreaLen(flag,lns[i]));
            sb.append("\t");
            sb.append(getAreaRank(i,flag,lns[i]));

            sb.append("\n");
            fw.write(sb.toString());

            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    /**
     * 获取二次匹配后的新区域对应的具体区域以及统计分类结果并写入新文件中
     * @param file_path
     * @param new_file_path
     * @return
     */
    public int writeNewArea2File(String file_path, String new_file_path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            FileWriter fw = new FileWriter(new_file_path);
            String line = "";
            String[] sline;
            String chrName = "";
            StringBuilder sb;
            int i = 0;
            while ((line = br.readLine()) != null) {
                sb = new StringBuilder(line);
                sline = line.split("\t");
                if(!chrName.equals("")&&!chrName.equals(sline[0])){
                    i++;
                }
                String len = getAreaLen(sline[1],sline[2]);
                chrName = sline[0];
                int rank = getAreaRank(i,sline[1],sline[2]);
                sb.append("\t");
                sb.append(len);
                sb.append("\t");
                sb.append(rank);
                sb.append("\n");
                fw.write(sb.toString());
            }

            br.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }


        return 0;
    }

    //得到当前区间的长度
    public String getAreaLen(String start, String end){
        Integer s = Integer.valueOf(start);
        Integer e = Integer.valueOf(end);
        Integer len = e - s;
       // System.out.println(s+"  "+e);
        String ln = String.valueOf(len);
        return ln;
    }
    public int getAreaRank(Integer chrSeq,String start,String end){
        Map<Integer,Integer> m = map_all.get(chrSeq);
        Integer s = Integer.valueOf(start);
        Integer e = Integer.valueOf(end);
        Integer flag = 0;
        for(Integer a: m.keySet()){
             if(e<=a){
                 if( s>= flag){
                     return m.get(a);
                 }else{
                     if((s - flag)>(e - flag)){
                         return m.get(flag);
                     }else
                         return m.get(a);
                 }
             }
             flag = a; //保存上一次遍历到的区间值
        }

        return -1;
    }
    public List<Map<Integer,Integer>>  getChrRanks() {
        int[] intervals = {23022,81319,31662,153194,57688,27017,109094,56265,43989,74576,66682,77818,92444,78434,109130,94807,8575};
        int len = intervals.length;
        Map<Integer,Integer> map= new TreeMap<>();
       // List<Map<Integer,Integer>> map_all = new ArrayList<>();
        for(int i = 0;i<len;i++){
            for(int j = 0;j<9;j++){
                Integer area = lns1[i]+intervals[i]*(j+1);
                map.put(area,j+1);
            }
            Integer last = Integer.valueOf(lns[i]);
            map.put(last,10);
            map_all.add(map);
            map = new TreeMap<>();
        }
//       for(int i = 0;i<17;i++){
//           for(Integer a: map_all.get(i).keySet()){
//               System.out.println(a+" "+ map_all.get(i).get(a));
//           }
//           System.out.println("---------------------------");
//       }

        return map_all;
    }
}
