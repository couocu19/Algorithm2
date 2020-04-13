package Entry;

public class FindMaxAndMin {

    public static void main(String[] args) {
        int nums[] = {3,2,6,8,99,454,-4,44432};
        find1(nums);
        find2(nums);


    }


    public static void find1(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a:nums){
            if(a<min){
                min = a;
            }else {

                if (a > max) {
                    max = a;
                }
            }
        }

        System.out.println("最大值："+max);
        System.out.println("最小值："+min);

    }


    /**
     *方法:分治法
     *过程:将数组分为两组，较小值都放在左半部分，较大部分都放在右半部分。
     *(如果数组长度为奇数，就将最后一个元素单独分为一组)
     * 然后从左半部分找出最小值，右半部分找出最大值。
     * 如果长度为奇数，需要将最后一组的元素和最大值最小值比较。
     *
     * 优点：相对于第一种方法，可以减少最大比较次数
     * @param nums
     */
    public static void find2(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        //将数组分为左半部分和右半部分
        for(int i =0;i<nums.length-1;i+=2){
            if(nums[i] > nums[i+1]){
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }

        for(int i =0;i<nums.length;i+=2){
            if(nums[i]<min){
                min = nums[i];
            }
        }

        for(int i =1;i<nums.length;i+=2){
            if(nums[i]>max){
                max = nums[i];
            }
        }

        if(nums.length%2 == 1){
            if(nums[nums.length-1]>max){
                max = nums[nums.length-1];
            }else if(nums[nums.length-1]<min){
                min = nums[nums.length-1];
            }
        }

        System.out.println("最大值："+max);
        System.out.println("最小值："+min);
    }
}
