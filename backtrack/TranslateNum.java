package backtrack;

import java.util.ArrayList;
import java.util.List;

public class TranslateNum {
    public static void main(String[] args) {
        int num = 506;
        Solution46s s = new Solution46s();

        System.out.println(s.translateNum(num));



    }
}


class Solution46s {

    private int sum = 0;
    public int translateNum(int num) {

        String s = String.valueOf(num);
        int len = s.length();
       // List<String> list = new ArrayList<>();
        backtrack(s,0,len);

        return sum;
    }


    private void backtrack(String sNum, int start, int end) {
        int num = 0;
        if (start == end) {
           // System.out.println(list);
            sum++;

            return;
        }

        if(start<end){
          //  list.add(sNum.substring(start,start+1));
            backtrack(sNum,start+1,end);
        }

        if(start+1<end){

            num = Integer.parseInt(sNum.substring(start,start+2));
            if(num<=25 && num>10){
              //  System.out.println(num);
                //list.remove(list.size()-1);
                //list.add(sNum.substring(start,start+2));
                backtrack(sNum,start+2,end);


            }


        }

    }

}