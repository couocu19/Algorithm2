package agorithmUtils;

public class BinaryToDecimal {

    public static void main(String[] args) {

        int n = 6;
        System.out.println(n>>>0);
    }

    public void binaryToDecimal(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }

    /**
     * 将最高位的数移至最低位（移31位），除过最低位其余位置清零，
     * 使用& 操作，可以使用和1相与（&），
     * 由于1在内存中除过最低位是1，其余31位都是零，然后把这个数按十进制输出；
     * 再移次高位，做相同的操作，直到最后一位 ，
     * @param n
     */
    public void binaryToDecimal1(int n){
            for(int i = 31;i >= 0; i--)
                     System.out.print(n >>> i & 1);
    }


    public void function1(int n){
        String result = Integer.toBinaryString(n);
        System.out.println(result);
    }
}
