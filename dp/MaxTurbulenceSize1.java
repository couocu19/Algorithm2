package dp;

public class MaxTurbulenceSize1 {
    public static void main(String[] args) {
        int[] nums = {9,4,2,10,7,8,8,1,9};
        Solution978s s = new Solution978s();
        System.out.println(s.maxTurbulenceSize2(nums));


    }
}


class Solution978s {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int len = A.length;
        if (len == 0)
            return 0;
        if (len == 1 || (len == 2 && A[0] == A[1]))
            return 1;
//        if (len == 2 && A[0] != A[1])
//            return 2;

        int c;
        int c1;
        int flag = 0;
        for (int i = 1; i < len; i++) {
            c = Integer.compare(A[i - 1], A[i]);
           // c1 = Integer.compare(A[i], A[i + 1]);
            if(i == len-1 || c*Integer.compare(A[i],A[i+1])!=-1){
                if(c!=0) {
                    res = Math.max(res, i - flag + 1);
                }
                flag = i;
            }
        }
         return res;
    }


    //思路：滑动窗口根据元素和前后元素的比较结果寻找最长的“交替字符串”，这里的交替指的是“-1,1“交替的字符串
    public int maxTurbulenceSize1(int[] A){
        int len = A.length;
        int c;
        int res = 1;
        int flag = 0;

        for(int i =1;i<len;i++){
            c = Integer.compare(A[i-1],A[i]);
            //当进行到数组的最后一个元素时，第一个条件满足就不会判断||之后的条件，也就不会有数组越界的判断了
            //妙啊
            if(i==len-1 ||c*Integer.compare(A[i],A[i+1])!=-1){

                res = Math.max(res,i-flag+1);
                flag = i;
            }
        }

        return res;




    }

    //思路：动态规划
    //时间复杂度比较大，不好
    public int maxTurbulenceSize2(int[] A){
        int len = A.length;
        int[] dp = new int[len];
        for(int i =0;i<len;i++){
            dp[i] = 1;
        }

        for(int i =1;i<len;i++){
            if(A[i]!=A[i-1]){
                dp[i] = 2;
            }
            boolean b = (A[i]-A[i-1]>0);
            for(int j =i-1;j>=1;j--){
                if(A[j]==A[j-1])
                    break;
                if(A[j]-A[j-1]>0 == !b){
                    dp[i]++;
                    b = !b;
                }else{
                    break;
                }
            }

            dp[i] = Math.max(dp[i],dp[i-1]);
        }

        return dp[len-1];

    }

}