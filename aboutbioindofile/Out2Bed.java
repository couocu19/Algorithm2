package aboutbioindofile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Out2Bed {
    public static void main(String[] args) {
        String path = "C:\\Users\\couco\\Desktop\\Col-CEN_v1.2.fna.out.csv.txt";
        String n_path = "E:\\Arab\\repeat\\Col-CEN_v1.2.bed";
        O2b o = new O2b();
        o.transfer(path,n_path);
    }
}

class O2b{
    public void transfer(String path,String n_path){
        String[] sline;
        String s;
        String a;
        String b;
        String c;
        try{
          BufferedReader bw = new BufferedReader(new FileReader(path));
          FileWriter fw = new FileWriter(n_path);
          while ((s = bw.readLine())!=null){
              sline = s.split("\t");
              a = sline[4].trim();
              b = sline[5].trim();
              c = sline[6].trim();
              System.out.println(a+" "+b+"  ");
              fw.write(a);
              fw.write("\t");
              fw.write(b);
              fw.write("\t");
              fw.write(c);
              fw.write("\n");
          }
          bw.close();
          fw.close();
        }catch(Exception e){
          System.out.println("error");
          e.printStackTrace();
       }





    }
}
