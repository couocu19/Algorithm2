package aboutbioindofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GetDiff {
    public static void main(String[] args) {
        String p1 = "D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\1.r";
        String p2 = "D:\\fanse-work-test\\1.r";
        try{
            FileReader fr1 = new FileReader(p1);
            FileReader fr2 = new FileReader(p2);
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);

            String line1 = br1.readLine();
            String line2 = br2.readLine();
            char f;
            for(int i = 0;i<line1.length();i++){
                f = line1.charAt(i);
                if(isSmall(line1.charAt(i))){
                    if(line1.charAt(i) == 'a'){
                       f = 'A';
                    }else if(line1.charAt(i) == 't'){
                        f = 'T';
                    }else if(line1.charAt(i) == 'c'){
                        f = 'C';
                    }else{
                        f = 'G';
                    }
                }

                if(f!= line2.charAt(i)){
                    System.out.println(i);
                }
            }
            br1.close();
            br2.close();
            System.out.println("ok");



        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }



    }

    public static boolean isSmall(char a){
        if(a != 'a' && a != 't' && a !='c' && a !='g'){
            return false;
        }

        return true;

    }
}
