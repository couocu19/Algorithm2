package aboutfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 将BWA生成的bed文件的合并集的index范围转为整体染色体上的index区域
 */
public class BwaBed2Fbed {

    Map<String,Integer> chrSeq2Num = new HashMap<>(){
        {
            put("NC_001133.9",1);
            put("NC_001134.8",2);
            put("NC_001135.5",3);
            put("NC_001136.10",4);
            put("NC_001137.3",5);
            put("NC_001138.5",6);
            put("NC_001139.9",7);
            put("NC_001140.6",8);
            put("NC_001141.2",9);
            put("NC_001142.9",10);
            put("NC_001143.9",11);
            put("NC_001144.5",12);
            put("NC_001145.3",13);
            put("NC_001146.8",14);
            put("NC_001147.6",15);
            put("NC_001148.4",16);
            put("NC_001224.1",17);
        }
    };

    Map<Integer,Integer> chrNum2len = new HashMap<>(){
        {
            put(1,230218);
            put(2,1043403);
            put(3,1360024);
            put(4,2891958);
            put(5,3468833);
            put(6,3738995);
            put(7,4829936);
            put(8,5392580);
            put(9,5832469);
            put(10,6578221);
            put(11,7245038);
            put(12,8323216);
            put(13,9247648);
            put(14,10031982);
            put(15,11123274);
            put(16,12071341);
            put(17,12157121);

        }
    };

    public static void main(String[] args) {
        String path = "D:\\giraffe\\fanse2-res2\\merge-4257.bed";
        String new_path = "D:\\giraffe\\fanse2-res2\\new-merge-4257.bed";
        BwaBed2Fbed bwaBed2Fbed = new BwaBed2Fbed();
        System.out.println( bwaBed2Fbed.transferBwaIdx(path,new_path));


    }
    public int transferBwaIdx(String file_path,String new_file_path){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            FileWriter fw = new FileWriter(new_file_path);
            String line = "";
            String[] sline;
            while((line = br.readLine()) != null ){
                sline = line.split("\t");
                String chrName = sline[0];
                Integer chrSeq = chrSeq2Num.get(chrName);
                System.out.println(chrSeq);
                String idx_l = sline[1];
                String idx_r = sline[2];
                if(chrSeq != 1){
                    Integer l = Integer.valueOf(idx_l);
                    Integer r = Integer.valueOf(idx_r);
                    Integer inc = chrNum2len.get(chrSeq-1);
                    l += inc;
                    r += inc;
                    idx_l = String.valueOf(l);
                    idx_r = String.valueOf(r);
                }

                StringBuilder sb = new StringBuilder(chrName);
                sb.append("\t");
                sb.append(idx_l);
                sb.append("\t");
                sb.append(idx_r);
                sb.append("\n");
                fw.write(sb.toString());
            }
            fw.close();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            return -1;

        }

        return 0;
    }
}

