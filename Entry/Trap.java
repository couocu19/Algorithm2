package Entry;

public class Trap {
    public static void main(String[] args) {


    }

}

class Solution42 {
    //按列求
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水，所以下标从1到length-2
        for(int i = 1;i<height.length-1;i++){
            int max_left = 0;
            //找出左边最高
            for(int j =i-1;j>=0;j--){
                if(height[j]>max_left){
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for(int j =i+1;j<height.length;j++){
                if(height[j]>max_right){
                    max_right = height[j];
                }
            }
            //找出两边较小的
            int min = Math.min(max_left,max_right);

            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if(min>height[i]){
                sum = sum+(min - height[i]);
            }

        }
        return sum;

    }
    public int trap1(int[] height){
        int len = height.length;


        int sum = 0;

        for(int i =1;i<len-1;i++){
            int max_left = 0;
            for(int j =i-1;j>=0;j--){
                if(height[j]>max_left){
                    max_left = height[j];
                }
            }

            int max_right = 0;
            for(int j=i+1;j<len;j++){
                if(height[j]>max_right){
                    max_right = height[j];
                }
            }

            int min = Math.min(max_left,max_right);

            if(min>height[i]){
                sum = sum +(min-height[i]);
            }

        }

        return sum;

    }

    //动态规划
    //每次求当前列两边的最高的墙的高度时使用两个数组来求
    //时间复杂度：O(n)
    public int trap2(int[] height){
        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for(int i =1;i<len-1;i++){
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }

        for(int i =len-2;i>=0;i--){
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for(int i =1;i<height.length-1;i++){
            int min = Math.min(max_left[i],max_right[i]);
            if(min>height[i]){
                sum = sum+(min-height[i]);
            }
        }

        return sum;

    }

    public int trap3(int[] height){
        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for(int i =1;i<len-1;i++){
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }

        for(int i =len-2;i>=0;i--){
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for(int i =1;i<len-1;i++){
            int min = Math.min(max_left[i],max_right[i]);
            if(min>height[i]){
                sum = sum +(min - height[i]);
            }
        }

        return sum;


    }

    public int trap4(int[] height){
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for(int i =1;i<len;i++){
            max_left[i] = Math.max(max_left[i-1],height[i-1]);

        }

        for(int i =len-2;i>=0;i--){
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        int sum = 0;
        for(int i =1;i<len-1;i++){
            int min = Math.min(max_left[i],max_right[i]);

            if(min>height[i]){
                sum = sum + (min - height[i]);
            }
        }

        return sum;

    }


}