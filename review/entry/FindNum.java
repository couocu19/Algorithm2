package review.entry;

//二维数组中的查找
public class FindNum {
    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 33;
        FindNum f = new FindNum();
        System.out.println(f.isExist1(null,target));


    }


    private int[][] nums;
    private int target;
    private int len1;
    private int len2;
    public boolean isExist(int[][] nums,int target){
        this.nums = nums;
        this.target = target;
        len1 = nums.length;
        len2 = nums[0].length;

        return find(0,len2-1);

    }


    private boolean find(int i,int j){
        if(i<len1 && j<len2) {
            if (nums[i][j] == target)
                return true;

            if (j > 0) {
                if (nums[i][j] > target) {
                    return find(i, j - 1);
                }
            }

            if (i < len1) {
                if (nums[i][j] < target)
                    return find(i + 1, j);
            }
        }
        return false;
    }


    public boolean isExist1(int[][] nums,int target){

        if(nums == null)
            return false;
        int len1 = nums.length;
        int len2 = nums[0].length;
        int i = 0;
        int j = len2-1;
        boolean flag = false;



        while (i<len1 && j>=0){

            if(nums[i][j] == target){
                flag = true;
                break;
            }
            else if(nums[i][j]>target){
                j--;
            }else{
                i++;
            }
        }

        return flag;





    }

}
