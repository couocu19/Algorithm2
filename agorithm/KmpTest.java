package agorithm;

public class KmpTest {
    public static void main(String[] args) {
        String s1 = "ababd";
        String s2 = "abcababd";
        kmpSearch(s1,s2);


    }

    //获得一个字符串的最长前后缀的数组
    public static void prefix_table(String s,int[] prefix,int n){
        prefix[0] = 0;
        int len = 0;
        int i =1;
        while(i<n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                prefix[i] = len;
                i++;
            }else{
                if(len>0){
                    len = prefix[len-1];
                }else{
                    prefix[i] = len;
                    i++;
                }
            }
        }
    }

    //为了方便kmp算法，将数组后移。
    public static void movePrefix(int[] prefix,int n){
        for(int i =n-1;i>0;i--){
            prefix[i] = prefix[i-1];
        }
        prefix[0] = -1;

    }

    //默认s1>s2
    public static void kmpSearch(String s1,String s2){
        int n = s2.length();
        int m = s1.length();
       // int position = 0;
        int[] prefix = new int[n];
        //得到较短字符串的最长前缀后缀数组
        prefix_table(s2,prefix,n);
        movePrefix(prefix,n);

        //s1[i] len(s1) = m;
        //s2[j]  len(s2) = n;
        int i = 0,j=0;
        while(i<m){

            if(j==n-1 && s2.charAt(j)==s1.charAt(i)) {
                //position = i - j;
                System.out.println(i-j);
            }
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                j = prefix[j];
                //当遇到j=-1时，相当于把s2整体后移一位
                if(j == -1){
                    i++;
                    j++;
                }
            }

        }
       // return position;
    }








}
