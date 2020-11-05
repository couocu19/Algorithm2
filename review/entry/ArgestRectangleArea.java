package review.entry;

public class ArgestRectangleArea {
    public static void main(String[] args) {




    }
}

 class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len  = heights.length;
        if(len == 0)
            return 0;
        int max = 0;
        for(int i =0;i<len;i++){
            int curHeight = heights[i];
            int left = i;

            while (left> 0 && heights[left-1]>=curHeight){
                left--;
            }
            int right = i;

            while (right<len-1 && heights[right+1]>=curHeight){
                right++;
            }
            max = Math.max(max,heights[i]*(right-left+1));

        }
        return max;

    }



}

