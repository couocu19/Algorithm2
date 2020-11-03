package review.entry;

public class MaxArea {
    public static void main(String[] args) {


    }
}

class Solution11s {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        while (i<j){
            int sum = (j-i) * Math.min(height[i],height[j]);
            if(sum>max){
                max = sum;
            }

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return max;
    }
}