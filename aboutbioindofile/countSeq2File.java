package aboutbioindofile;

public class countSeq2File {
    public static void main(String[] args) {
        for (int i = 1;i<=307;i++){
            System.out.print("res"+i+".bed,");
        }
        System.out.println();


//        BufferedWriter bw = null;
//        try{
//             bw = new BufferedWriter(new FileWriter("D:\\protein-data-set\\yeast\\SRR4072457\\fanse2-res2\\seq.fastq"));
//            for(int i = 1;i<=24521708;i++){
//                bw.write(i);
//                bw.write("\t");
//            }
//            bw.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("error");
//
//        }
    }
}
