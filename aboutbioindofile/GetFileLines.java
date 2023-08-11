package aboutbioindofile;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetFileLines {

    public static void main(String[] args) {
        GetFileLines g = new GetFileLines();
        //大麦新基因组
        String fpath = "E:\\complete-gene-ann\\Hordeum vulgare-大麦\\new\\GCA_024137805.1_yangtze_university_Zhang_lab_wild_barley_1.0_genomic.fna";
        //大麦旧基因组
        String fpath1 = "E:\\complete-gene-ann\\Hordeum vulgare-大麦\\new\\GCF_904849725.1_MorexV3_pseudomolecules_assembly_genomic.fna";

        System.out.println(g.getUnplaced(fpath1));
    }


    //获取待测基因组中unplaced序列对应的行号
    public int getUnplaced(String fpath){

        try{
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            String lines = "";
            int lineCount = 0;
            while ((lines = br.readLine())!=null){
                if(lines.length()>2 && (lines.charAt(2) == 'W')){
                //if(lines.charAt(1) == 'J'){
                    System.out.println(lines);
                    break;
                }
                lineCount++;
            }
            return lineCount;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error");
        }
        return -1;
    }


}
