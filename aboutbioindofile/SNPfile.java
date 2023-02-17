package aboutbioindofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class SNPfile {
//    Map<String,Integer> chrSeq2Num = new HashMap<>(){
//        {
//            put("ref|NC_001133|",1);
//            put("ref|NC_001134|",2);
//            put("ref|NC_001135|",3);
//            put("ref|NC_001136|",4);
//            put("ref|NC_001137|",5);
//            put("ref|NC_001138|",6);
//            put("ref|NC_001139|",7);
//            put("ref|NC_001140|",8);
//            put("ref|NC_001141|",9);
//            put("ref|NC_001142|",10);
//            put("ref|NC_001143|",11);
//            put("ref|NC_001144|",12);
//            put("ref|NC_001145|",13);
//            put("ref|NC_001146|",14);
//            put("ref|NC_001147|",15);
//            put("ref|NC_001148|",16);
//            put("ref|NC_001224|",17);
//        }
//    };

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
    public static void main(String[] args) {
        String path = "D:\\protein-data-set\\yeast\\res-teat\\mf4257-new-ftl-smpl-bw.csv";
        String new_path = "D:\\protein-data-set\\yeast\\res-teat\\SNP-4257new.csv";

        String path1 = "D:\\fanse-work-test\\fm160-ftl-bw.csv";
        String new_path1 = "D:\\fanse-work-test\\SNP-fm160-ftl.csv";

        String path2 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\mf4257-ftl-bw.csv";
        String new_path2 = "D:\\fanse-work-test\\SNP-mf4257-old-ftl.csv";

        String path3 = "D:\\fanse-work-test\\fatel-read-file\\r-covered-bw.bed";
        String new_path3 = "D:\\fanse-work-test\\fatel-read-file\\SNP-f160-new.bed";

        String path4 = "D:\\Rbio\\new-covered-bw.bed";
        String new_path4 = "D:\\Rbio\\SNP-new-old.bed";
        SNPfile s = new SNPfile();
        System.out.println(s.write2File(path4,new_path4));
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
