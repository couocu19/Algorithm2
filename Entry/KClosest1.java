package Entry;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class KClosest1 {

    public static void main(String[] args) {
        Solution973s s = new Solution973s();
        int[][] points = {{1,0},{0,1}};
        int k = 2;
      //  System.out.println(s.kClosest(points,k));
//        int[][] result = s.kClosest(points,k);
//        for(int i =0;i<k;i++){
//            System.out.println(result[i][0]+" "+result[i][1]);
//        }
        Solution973ss s1 = new Solution973ss();
        int[][] result = s1.kClosest(points,k);
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

/**
 * 方法二：分治法
 * (平均)时间复杂度:O(n)
 * 思路：先随机在数组中取一个位置a，然后以这个位置的距离为分界点将数组分为两部分
 *      然后判断当前分割到的位置i到原始分割点的差值和K值的关系，如果相等,那么可以直接返回数组的前k个元素即可，
 *      因为我们只要保证数组的前k个元素为数组的前k个最小值即可。
 *      如果>k,那么继续对前i个元素重复上述的工作，直到满足条件为止；
 *      如果<k,那么说明前i个元素已经是数组的前i个最小元素了，
 *      只需要对(i+1,j)中的元素进行之前的操作
 *
 *
 */
//无语,原来官方给的题解也会出问题。。这个直接给超时了
class Solution973ss{
    private int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0,points.length-1,K);
        return Arrays.copyOfRange(points,0,K);

    }

    public void work(int i,int j,int k){
        if(i>=j)
            return;

        int oi = i;
        int oj = j;
        //获取一个随机位置的距离作为分界点
        int ranDist = distance(ThreadLocalRandom.current().nextInt(i, j));

        while(i<j){
            while (i<j&&distance(i)<ranDist)
                i++;
            while(i<j&&distance(j)>ranDist)
                j--;
            swap(i,j);
        }

        if(k <= i - oi + 1)
            work(oi,i,k);
        else
            work(i+1,oj,k-(i-oi+1));

    }

    public int distance(int i){
        return points[i][0]*points[i][0] + points[i][1]*points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }

}
