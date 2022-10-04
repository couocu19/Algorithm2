package top100;

import java.util.Arrays;
import java.util.List;

public class No56 {
    public static void main(String[] args) {
        int[][] num = {{1,4},{0,4},{8,10},{15,18},{16,40}};
        Solution56 s = new Solution56();
        int[][] res = s.merge(num);
        for(int i = 0;i<res.length;i++){
            System.out.println(res[i][0] + " " +res[i][1]);
        }
    }
}


class Solution56 {

    //思路二：遍历，每次将符合要求的区间加入list中，不需要二次遍历，速度更快，内存消耗基本一致
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int flag = len;
        if(len == 1)
            return intervals;
        //二维数组排序

        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        for(int i = 1;i<len;i++){
            if(intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = Integer.min(intervals[i][0],intervals[i-1][0]);
                intervals[i][1] = Integer.max(intervals[i][1],intervals[i-1][1]);

                intervals[i-1][0] = Integer.MIN_VALUE;
                intervals[i-1][1] = Integer.MIN_VALUE;
                flag--;
            }
        }
        int[][] result = new int[flag][2];
        int j = 0;
        for(int i = 0;i<len;i++){
            if(intervals[i][0]!=Integer.MIN_VALUE && intervals[i][1]!=Integer.MIN_VALUE){
                result[j][0] = intervals[i][0];
                result[j++][1] = intervals[i][1];
            }
        }
        return result;
    }


}