package Entry;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        Solutiono s = new Solutiono();
        int[] nums1 = {1,1,2,3,5,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {3,6,7,8,8,9};
        int m = 5;
        int n =nums2.length;
        s.merge(nums1,m,nums2,n);

    }
}
//实际上用 System.arraycopy()的方法将第二个数组合并到第一个数组里在进行排序即可。
class Solutiono {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m+n];
        for(int i =0;i<m;i++){
            num[i] = nums1[i];
        }
        int j =0;
        for(int i =m;i<(m+n);i++){
            num[i] = nums2[j++];
        }
        Arrays.sort(num);
        for(int i =0;i<(m+n);i++){
            nums1[i] = num[i];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
