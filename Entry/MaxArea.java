package Entry;

public class MaxArea {
    public static void main(String[] args) {

        Solution11s s = new Solution11s();

        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(nums));
    }


}

//普通循环法
class Solution11 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int len = height.length;
        int flag;
        int sum;
        for(int i =0;i<len;i++){
            for(int j = i+1;j<len;j++){
                flag = Integer.min(height[i],height[j]);
                sum = (j-i)*flag;
                if(sum>max){
                    max = sum;
                }
            }
        }

        return max;
    }
}


class Solution11s{
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0;
        int j = len-1;
        int sum;
        int max = Integer.MIN_VALUE;
        while(i<j){
            sum = (j-i)*Integer.min(height[i],height[j]);
            if(sum>max)
                max = sum;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return max;

    }


}