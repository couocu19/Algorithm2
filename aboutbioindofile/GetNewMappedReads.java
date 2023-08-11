package aboutbioindofile;

import javax.swing.plaf.FileChooserUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class GetNewMappedReads {
    public static void main(String[] args) {
        GewNewArea g = new GewNewArea();
        String path1 = "E:\\Arab\\old\\old-fst-all.bed";
        String path2 = "E:\\Arab\\new3\\new-fst-all.bed";
        String newPath = "E:\\Arab\\new3\\newArea.bed";
        g.writeArea2File(path1,path2,newPath);

    }
}


class GewNewArea{
    public void writeArea2File(String fpath1,String fpath2,String newAreaPath){
        Set<String> set = new HashSet<>();
        String[] sline;
        String line;
        String line1;
        String[] sline1;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(fpath1));
            BufferedReader br2 = new BufferedReader(new FileReader(fpath2));
            FileWriter fw = new FileWriter(newAreaPath);
            //读入旧基因组比对上的reads序列号
            while((line = br1.readLine())!=null){
                sline = line.split("\t");
                set.add(sline[3]);
            }
            //读入新基因组比对上的reads序列号，找到旧基因组没比对上的reads序列以及对应的比对信息
            while((line1 = br2.readLine())!=null){
                sline1 = line1.split("\t");
                if(!set.contains(sline1[3])){
                    fw.write(line1);
                    fw.append("\n");
                }
            }
            br1.close();
            br2.close();
            fw.close();

        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }






    }


}
