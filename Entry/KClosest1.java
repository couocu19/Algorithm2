package Entry;

import java.util.Arrays;

public class KClosest1 {

    public static void main(String[] args) {
        Solution973s s = new Solution973s();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
      //  System.out.println(s.kClosest(points,k));
        int[][] result = s.kClosest(points,k);
        for(int i =0;i<k;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }


    }

}

class Solution973s {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        double length[] = new double[len];
        for(int i =0;i<len;i++){
            length[i] = dist(points[i]);
        }
        Arrays.sort(length);
        int[][] result = new int[K][];
        int j = 0;
        for(int i =0;i<len;i++){
            if(dist(points[i])<=length[K-1]){
                result[j++] = points[i];
            }
        }
        return result;
    }

    private double dist(int[] nums){
        return Math.sqrt(nums[0]*nums[0] + nums[1]*nums[1]);

    }


}
