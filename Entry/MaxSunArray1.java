package Entry;

public class MaxSunArray1 {
    private int begin = 0;
    private int end = 0;
    public static void main(String[] args) {
        int nums[] = {1,-2,4,8,-4,7,-1,-5};
        System.out.println(getMax(nums));
        MaxSunArray1 m = new MaxSunArray1();
        System.out.println(m.getMaxPlus(nums));
        System.out.println(m.begin + " "+m.end);
    }

    //只获取数组中的最大和
    public static int getMax(int[] nums){
        int resultMax = nums[0];
        int endMax = nums[0];
        int len = nums.length;
        for(int i =1;i<len;i++){
            endMax = Math.max(nums[i],endMax+nums[i]);
            resultMax = Math.max(resultMax,endMax);

        }
        return resultMax;
    }


    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    //不仅获取数组中的最大子数组和，还可以求得最大子数组的起始终点位置
    public int getMaxPlus(int[] nums){
        int len = nums.length;
        int endMax = nums[0];
        int resultMax = nums[0];
        int nStart = 0;
        for(int i =1;i<len;i++){
            //endMax代表的是(1~i-1)的最大子数组,如果他的值小于0,
            // 那么当前最大子数组一定是最后一个元素本身
            //所以此时要更新最大子数组的起始位置
            if(endMax<0){
                endMax = nums[i];
                nStart = i;
            }else{
                endMax += nums[i];
            }

            if(endMax>resultMax){
                resultMax = endMax;
                begin = nStart;
                end = i;
            }

        }
        return resultMax;
    }


}
