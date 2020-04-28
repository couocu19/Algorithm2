package Entry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一系列点的集合，返回距离远点最近的k个点
 *
 */
public class KClosest {
    public static void main(String[] args) {
        Solution973 s = new Solution973();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] result = s.kClosest(points,k);
        for(int i =0;i<k;i++){
            for(int j =0;j<2;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        double[] resultLen = new double[K];
        for(int i =0;i<K;i++){
            resultLen[i] = Double.MAX_VALUE;
        }
        int len = points.length;
        double length = 0;
        int j = 0;
        Map<Double,Integer> map = new HashMap<>();
        for(int i =0;i<len;i++){
            length = Math.sqrt(points[i][0]*points[i][0]
                    +points[i][1]*points[i][1]);
            if(length<resultLen[0]){
                resultLen[0] = length;
                int f = map.get(length);
                adjustHeap(resultLen,0,K);
                sort(resultLen,K);
                if(j<K){
                    result[j++] = points[i];
                    map.put(length,j-1);
                }else{
//                    int f = map.get()
                    result[K-1] = points[i];
                }
            }
        }
        return result;
    }

    public static void adjustHeap(double[] nums,int index,int len){
        int left = 2*index+1;
        int right = 2*index+2;
        int minIndex = 0;
        while(left<len){
            if(right<len && nums[left]>nums[right] ){
                minIndex = right;
            }else{
                minIndex = left;
            }
            if(nums[minIndex]>nums[index]){
                minIndex = index;
            }
            if(minIndex == index){
                break;
            }
            swap(nums,minIndex,index);
            index = minIndex;
            left = 2*index+1;
            right = 2*index+2;
        }

    }


    public static void swap(double[] nums,int a,int b){
        double temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sort(double[] nums,int len){
        swap(nums,0,len-1);
        len--;
        adjustHeap(nums,0,len);
    }
}
