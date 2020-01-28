package lanqiao;


import java.util.Scanner;
import agorithmUtils.*;

//2019.5
public class LastYear {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = 0;

        for(int i =1;i<=n;i++){
            if(FindNum.isExist(i,1)||
                    FindNum.isExist(i,2)||
                    FindNum.isExist(i,0)||
                    FindNum.isExist(i,9)){
                sum+=i;
            }

        }

        System.out.println(sum);




    }
}
