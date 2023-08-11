package aboutbioindofile;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetChrNum {

    public static void main(String[] args) {
        String path = "E:\\ref-abrb\\Col-PEK1.5_assembly_and_annotation\\file7.Col-PEK1.0_Chr1-5_20211029.fna";
       Get g = new Get();
        System.out.println(g.getNum(path));


    }



}

class Get{

    //获取参考基因组中染色体数量
    public int getNum(String path){
        int num = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine())!=null){
                if(line.charAt(0) == '>'){
                    System.out.println(line);
                    //   System.out.println(num);
                    num++;
                    //System.out.println(num);
                }

            }

            br.close();
        }catch (Exception e){
            System.out.println("read--error");
            e.printStackTrace();
        }

        return num;


    }

    public void getString(String path,int index){
        int num = -1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine())!=null){
                if(line.equals(">Chr4")){
                    break;
                }
            }
            String line1;



            br.close();
        }catch (Exception e){
            System.out.println("read--error");
            e.printStackTrace();
        }




    }



}
