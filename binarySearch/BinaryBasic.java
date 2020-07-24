package binarySearch;

public class BinaryBasic {
    public static void main(String[] args) {

        int[] nums = {1,2,4,5,6,7,9,10};
        int target = 10;
       System.out.println(findLR(nums,target));
        int[] nums1 = {1,2,2,2,2,2,4,5};
        int t1 = 888;
        //System.out.println(findL(nums1,t1));
       // System.out.println(findR(nums1,t1));


    }

    //基础模板
    public static int find1(int[] nums,int target){
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<=high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target){
                high = mid-1;

            }else {
                low = mid+1;
            }
        }

        return -1;
    }

    //模板二
    //查找元素的右邻居/得到元素的左侧边界

    /**
     * 注意:
     *  这里的区间遍历区间换成了
     *     low = mid+1;high = mid
     *  原因为：
     *    因为现在的循环条件变成了 while(low<high)而不是 while(low<=high)
     *    所以相当于循环遍历的空间为[low,high),是一个左闭右开空间
     *    所以分割之后的遍历空间也是左闭右开空间,即为：
     *    [low,mid),[mid+1,high)
     *
     */
    public static int  findL(int[] nums,int target){
        int low = 0;
        int high = nums.length;
        int mid;
        while(low<high){
            mid = low+((high - low)>>1);
            if(nums[mid] == target){
                //return mid;
                high = mid;
            }
            else if(nums[mid]>target){
                high = mid;
            }else {
                low = mid+1;
            }
            System.out.println(low+" "+high);
        }
        if(low!=nums.length && nums[low] == target)
            return low;
        return -1;
    }

    //模板三
    //得到元素的右侧边界
    public static int findR(int[] nums,int target){
        int low = 0;
        int high = nums.length;
        int mid;
        while (low<high){
            mid = low + ((high-low)>>1);
            if(nums[mid] == target){
                //return mid;
                low = mid+1;
                //mid = low - 1;
            }

            else if(nums[mid]>target){
                high = mid;
            }else{
                low = mid+1;
            }
        }
//        if(low!=nums.length && nums[low] ==  target)
//            return low;
//
//        return -1;

        System.out.println(low);

        if(low!=0 && nums[low-1] == target)
            return low-1;

        return -1;
    }

    //模板四
    //查找元素的左右邻居元素
    public static int findLR(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low+1<high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                high = mid;
            }else{
                low = mid;
            }
        }


        if(nums[low] == target)
            return low;

        if(nums[high] == target)
            return high;


        return -1;
    }

}
