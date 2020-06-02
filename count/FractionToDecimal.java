package count;

import java.math.BigDecimal;
import java.util.SortedMap;

public class FractionToDecimal {
    public static void main(String[] args) {
        SolutionW w = new SolutionW();
        String m = String.valueOf(0.8);
        System.out.println(m);
        double l = (double) 1/(double) 6;
        System.out.println(l);
        System.out.println(w.isNonterminating(47,3));

    }
}

class SolutionW {
    public String fractionToDecimal(int numerator, int denominator) {
        double num ;
        String s = "";
        num = (double) numerator/(double) denominator;
        s = String.valueOf(num);
        if(!isNonterminating(numerator,denominator)){
            return s;
        }else{
            int len = s.length();
            int i;
            for(i = 0;i<len;i++){
                if(s.charAt(i) == '.')
                    break;
            }
//            for(int j = i+1;j<len;j++){
//
//            }

        }

        return s;

    }
    //判断一个数是不是无限循环小数
    public boolean isNonterminating(int a,int b){
        try{
            BigDecimal bigA=new BigDecimal(a);
            BigDecimal bigB=new BigDecimal(b);
            System.out.println("a/b="+bigA.divide(bigB));
            return false;
        }catch(Exception e){
            return true;
        }
    }
}
