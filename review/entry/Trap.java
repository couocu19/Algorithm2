package review.entry;

public class Trap {
    public static void main(String[] args) {


    }
}

class Solution {
    public int trap(int[] height){
        if(height == null || height.length <2)
            return 0;
        int len = height.length;
        int i =0;
        int j = len-1;
        int sum = 0;
        int flagH = 0;
        while (i<j){
            if(height[i]<height[j]){
                flagH = Math.max(flagH,height[i]);
                sum += flagH - height[i];
                i++;
            }else{
                flagH = Math.max(flagH,height[j]);
                sum += flagH - height[j];
                j--;
            }
        }

        return sum;
    }


}