package aboutbioindofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class SNPfile {
    Map<String,Integer> chrSeq2Num = new HashMap<>(){
        {
            put("ref|NC_001133|",1);
            put("ref|NC_001134|",2);
            put("ref|NC_001135|",3);
            put("ref|NC_001136|",4);
            put("ref|NC_001137|",5);
            put("ref|NC_001138|",6);
            put("ref|NC_001139|",7);
            put("ref|NC_001140|",8);
            put("ref|NC_001141|",9);
            put("ref|NC_001142|",10);
            put("ref|NC_001143|",11);
            put("ref|NC_001144|",12);
            put("ref|NC_001145|",13);
            put("ref|NC_001146|",14);
            put("ref|NC_001147|",15);
            put("ref|NC_001148|",16);
            put("ref|NC_001224|",17);
        }
    };
    public static void main(String[] args) {
        String path = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl-smpl-bw.csv";
        String new_path = "D:\\protein-data-set\\yeast\\res-teat\\SNP-4257new.csv";
        SNPfile s = new SNPfile();
        System.out.println(s.write2File(path,new_path));


    }


    public int write2File(String path,String npath){
        String f = "SNP_";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(npath));
            String line;
            int count = 1;
            String flag = "";
            while((line=br.readLine())!=null){
                String[] sline = line.split("\t");
                if(!flag.equals(sline[0])){
                    count = 1;
                }
                Integer seq = chrSeq2Num.get(sline[0]);
                String chr_s = String.valueOf(seq);
                String area_seq = String.valueOf(count);
                String snp_seq = f+chr_s+"_"+area_seq;
                bw.write(snp_seq);
                bw.write("\t");
                bw.write(sline[0]);
                bw.write("\t");
                bw.write(sline[1]);
                bw.write("\n");
                flag = sline[0];
                count++;
            }
            bw.close();
            br.close();

        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
}
