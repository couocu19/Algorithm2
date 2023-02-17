package aboutbioindofile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class GetFtlareas {
   String[] lns = {"230218","1043403","1360024","2891958","3468833","3738995","4829936","5392580","5832469",
                    "6578221","7245038","8323216","9247648","10031982","11123274","12071341","12157121"};
    Integer[] lns1 = {0,230218,1043403,1360024,2891958,3468833,3738995,4829936,5392580,5832469,
            6578221,7245038,8323216,9247648,10031982,11123274,12071341};
    List<Map<Integer,Integer>> map_all = new ArrayList<>();

    Map<String,String> mapChr = new HashMap<>(){
        {
            put("ref|NC_001133|","chr1");
            put("ref|NC_001134|","chr2");
            put("ref|NC_001135|","chr3");
            put("ref|NC_001136|","chr4");
            put("ref|NC_001137|","chr5");
            put("ref|NC_001138|","chr6");
            put("ref|NC_001139|","chr7");
            put("ref|NC_001140|","chr8");
            put("ref|NC_001141|","chr9");
            put("ref|NC_001142|","chr10");
            put("ref|NC_001143|","chr11");
            put("ref|NC_001144|","chr12");
            put("ref|NC_001145|","chr13");
            put("ref|NC_001146|","chr14");
            put("ref|NC_001147|","chr15");
            put("ref|NC_001148|","chr16");
            put("ref|NC_001224|","chr17");
//            put("NC_001133.9","chr1");
//            put("NC_001134.8","chr2");
//            put("NC_001135.5","chr3");
//            put("NC_001136.10","chr4");
//            put("NC_001137.3","chr5");
//            put("NC_001138.5","chr6");
//            put("NC_001139.9","chr7");
//            put("NC_001140.6","chr8");
//            put("NC_001141.2","chr9");
//            put("NC_001142.9","chr10");
//            put("NC_001143.9","chr11");
//            put("NC_001144.5","chr12");
//            put("NC_001145.3","chr13");
//            put("NC_001146.8","chr14");
//            put("NC_001147.6","chr15");
//            put("NC_001148.4","chr16");
//            put("NC_001224.1","chr17");

        }
    };

    public static void main(String[] args) {
        String fp = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257.bed";
        String nfp = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257-ftl.csv";
        String nfpp = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257-ftl-smpl.csv";

        String fp1 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.bed";
        String nfp1 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.csv";

        String fp2 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.bed";
        String nfp2 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.csv";

        String fp3 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new.bed";
       // String nfp3 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl.csv";
        String nfp3 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl-smpl.csv";

//        String fp6 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new.bed";
//        // String nfp3 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl.csv";
//        String nfp6 = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl-smpl.csv";

        String fp4 = "D:\\protein-data-set\\yeast\\res-teat\\right-ftl\\r-covered-fs.bed";
        String nfp4 = "D:\\protein-data-set\\yeast\\res-teat\\right-ftl\\r-covered.csv";

        String fp5 = "D:\\fanse-work-test\\fm160.bed";
        String nfp5 = "D:\\fanse-work-test\\fm160-ftl.bed";

        String fp7 = "D:\\fanse-work-test\\fm160.bed";
        String nfp7 = "D:\\fanse-work-test\\fm160-all.bed";

        String fp8 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257.bed";
        String nfp8 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257-all.bed";

        String fp9 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered.bed";
        String nfp9 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\new-covered-all.bed";

        String fp10 = "D:\\fanse-work-test\\fatel-read-file\\r-covered.bed";
        String nfp10 = "D:\\fanse-work-test\\fatel-read-file\\r-covered-all.bed";
        GetFtlareas g = new GetFtlareas();
        g.getChrRanks();

        //System.out.println(g.writeArea2File(fp7,nfp7));
        System.out.println(g.writeAllArea2File(fp10,nfp10));
        //System.out.println(g.writeNewArea2File(fp4,nfp4));
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
     * 将匹配区域和未匹配区域写入新文件中
     * @param file_path
     * @param new_file_path
     * @return
     */
    public int writeAllArea2File(String file_path, String new_file_path) {
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
                    //未匹配区间
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lns[i]);
                    sb.append("\t");
                    sb.append(mapChr.get(chrName));
                    sb.append("\t");
                    sb.append("other");
                    //sb.append("\t");
                    sb.append("\n");
                    i++;
                    //写入
                    fw.write(sb.toString());
                    flag = String.valueOf(lns1[i]+1);

                    //匹配区间
                    fw.write(line);
                    fw.write("\t");
                    fw.write(mapChr.get(chrName));
                    fw.write("\t");
                    fw.write("new-covered");
                    fw.write("\t");
                    fw.write("\n");

                }
                chrName = sline[0];
                sb = new StringBuilder(chrName); //todo:还需要单独处理两条染色体间隔的情况！！！
                sb.append("\t");
                sb.append(flag);
                sb.append("\t");
                sb.append(sline[1]);
                sb.append("\t");
                sb.append(mapChr.get(chrName));
                sb.append("\t");
                sb.append("other");
                //sb.append("\t");
                sb.append("\n");
                flag = sline[2];
                fw.write(sb.toString());

                fw.write(line);
                fw.write("\t");
                fw.write(mapChr.get(chrName));
                fw.write("\t");
                fw.write("new-covered");
                //fw.write("\t");
                fw.write("\n");
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lns[i]);
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
