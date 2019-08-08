package count;

import java.util.HashMap;
import java.util.Map;

//分数转小数
public class FractionToDecimal1 {
    public static void main(String[] args) {
        SolutionK s = new SolutionK();
        int a = 1;
        int b = 7;
        System.out.println(s.fractionToDecimal(a,b));

    }
}
class SolutionK {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if(numerator<0 ^ denominator<0){
            sb.append("-");
        }

        //防止数据溢出
        long divided = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        sb.append(String.valueOf(divided/divisor));
        System.out.println(sb.toString());

        //设置两数相除的余数，当余数出现重复值时，则证明小数开始循环
        long remainder = divided % divisor;
        System.out.println(remainder);

        //如果余数为0，说明是整数，直接返回
        if(remainder == 0){
            return sb.toString();
        }

        sb.append(".");

        //key-余数，value-这个余数出现在字符串的位置
        Map<Long,Integer> map = new HashMap<>();
        while(remainder !=0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            }
            //除法取余数的过程
            map.put(remainder,sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }
        return sb.toString();

    }

}


