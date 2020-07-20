package Entry;

public class KthSmallestPrimeFraction1 {
    public static void main(String[] args) {

        int[] A = {1,2,3,5};
        int K = 1;
        Solution786 s = new Solution786();
        //System.out.println(s.kthSmallestPrimeFraction(A,K));
        for(int a:s.kthSmallestPrimeFraction(A,K)){
            System.out.println(a);
        }

    }
}
class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int len = A.length;
        int len1 = (len)*(len-1)/2;
        int[] res = new int[2];
        double[][] nums = new double[len1][3];
        nums[0][0]  = 0;
        int p = 0;
        int q = 0;
        double pq;
        int t = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                pq = (double) A[i]/A[j];
                nums[t][0] = pq;
                nums[t][1] = A[i];
                nums[t][2] = A[j];
                t++;
            }
        }
        double[][] res1 = new double[K][3];
        res1[0][0] = 0;
        for(int i =0;i<K;i++){
            res1[i][0] = Double.MAX_VALUE;
        }
        for(int i =0;i<len1;i++){
            if(res1[0][0]>nums[i][0]){
                res1[0] = nums[i];
                adjust(res1,0,K);
            }
        }
        res[0] = (int) res1[0][1];
        res[1] = (int) res1[0][2];
        return res;

    }

    private void swap(int a,int b,double[][] num){
        double[] temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    private void adjust(double[][] nums,int index,int size){
        int left = 2*index+1;
        int right = 2*index+2;
        int largerIndex;
        while (left<size){
            if(right<size && nums[left][0]<nums[right][0]){
                largerIndex = right;
            }else{
                largerIndex = left;
            }
            if(nums[index][0] >nums[largerIndex][0]){
                largerIndex = index;
            }

            if(index == largerIndex)
                break;
            swap(largerIndex,index,nums);
            index = largerIndex;
            left = 2*index+1;
            right = 2*index+2;
        }

    }
}
