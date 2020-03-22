package lanqiao;

public class Nine {
    public static void main(String[] args) {
        int n = 0;
        for(int  i = 9;i<=2019;i++){
            String s = String.valueOf(i);
            String a = "9";
            if(s.contains(a)){
                System.out.println(s);
                n++;
            }


        }
        System.out.println(n);
    }
}
