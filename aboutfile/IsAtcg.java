package aboutfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class IsAtcg {
    public static void main(String[] args) {
        String fpath = "D:\\protein-data-set\\yeast\\res-teat\\1.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            String line = br.readLine();
            //while (line!=null){
                char[] chars = line.toCharArray();
                int len = chars.length;
                System.out.println(len);
                System.out.println();
                for(int i = 0;i<len;i++){
                    if(chars[i] == 'n' || chars[i] == 'N'){
                        System.out.println(i);
                    }

              //  }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("yes");




    }
}
