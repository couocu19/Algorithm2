package lanqiao;


//2019.3
public class ThreeNumSum {

    static long result ;
    public static void main(String[] args) {


       // System.out.println(fSum(8));
        System.out.println(numToString(stringTonum("65535")));
//        for(Integer a:stringTonum("65535")){
//            System.out.print(a);
//        }

       // System.out.println(bigSum("1","0","0"));
//        for(Integer a:bigSum("65535","65535","65535")){
//            System.out.print(a);
//        }



    }
     static void fSum(){
//
//        String[] s = new String[Math.]
//        for()


     }

     static int[] bigSum(String s1,String s2,String s3){
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        int len = Math.max(Math.max(len1,len2),len3);
        int sum = 0;
        int num1[] = stringTonum(s1);
        int num2[] = stringTonum(s2);
        int num3[] = stringTonum(s3);
        int num[] = new int[len+1];
        for(int i =0;i<len;i++){
            num[i]+=num1[i]+num2[i]+num3[i];
            num[i+1] = num[i]/10;
            num[i] %= 10;
        }
        return num;
     }

     static int[] stringTonum(String s){
        int len = s.length();
        int num[] = new int[len];
        int t = 0;
        for(int i =len-1;i>=0;i--){
            int a = s.charAt(i) - '0';
            num[t++] = a;
           // System.out.println(num[i]);
        }
        return num;
     }


     static String numToString(int[] num){
        StringBuilder sb = new StringBuilder("");
        int len = num.length;
        for(int i =len-1;i>0;i--){
            String c = String.valueOf(num[i]) ;
            sb.append(c);
        }
        if(num[0]!=0){
            sb.append(String.valueOf(num[0]));
        }

        return sb.toString();
     }





}
