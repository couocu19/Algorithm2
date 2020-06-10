package review.tree;


/**
 * 判断一个数组是不是二元查找树的后序遍历序列
 */
public class IsAfterOrder {

    public static void main(String[] args) {
        int[] nums = {1,4,3,6,9,8,5};
        System.out.println(isTrue(nums,0,nums.length-1));

    }


    public static boolean isTrue(int[] nums,int start,int end){
        if(nums == null)
            return false;

        int mid = nums[end];
        System.out.println(mid);
        int i,j ;
        for(i =start;i<end;i++){
            if(nums[i]>mid)
                break;
        }
        for(j =(i+1);j<end;j++){
            if(nums[j]<mid)
                return false;
        }
        boolean left = true;
        boolean right = true;
        if(i>start) {

            left = isTrue(nums, start, i - 1);
        }
        //这里的判断条件为 i不是j
        if(i<end) {
            //注意这里的倒数第二个元素要更新为（end-1）
            right = isTrue(nums, i, end-1);

        }
        return left&&right;




    }
}
