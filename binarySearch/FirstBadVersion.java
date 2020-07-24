package binarySearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 21474836;
        Solution278 s = new Solution278();
        System.out.println(s.firstBadVersion(n));

      //  System.out.println(Integer.MAX_VALUE);




    }

}

class Solution278 {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n+1;
        int mid;
        while(low<high){

            mid = low +((high - low)>>1);
            boolean flag = isBadVersion(mid);
            if(flag){
                high = mid;
            }else{
                low = mid+1;

            }
            System.out.println(low+" "+high);
        }

        if(low<=n && isBadVersion(low))
            return low;

        return -1;

    }


    private boolean isBadVersion(int version){
        if(version >=2147)
            return true;
        return false;

    }
}
