package lanqiao;

public class YueShu {
    public static void main(String[] args) {

        Integer n = 1200000;
        Integer sum = 0;
        for(int i =1;i<=n;i++){
            if(n%i == 0){
                System.out.println(i);
                sum++;
            }
        }
        System.out.println(sum);


    }

}
