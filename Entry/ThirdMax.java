package Entry;

public class ThirdMax {

    public static void main(String[] args) {
        Solution414 s = new Solution414();
        Solution414s s1 = new Solution414s();
        int nums[] = {1,-2147483648,2};
        System.out.println(s.thirdMax(nums));

        System.out.println(s1.thirdMax(nums));

    }
}

class Solution414 {
    public int thirdMax(int[] nums) {
        long MIN = Long.MIN_VALUE;
        int len = nums.length;
        if(len<3){
            int max = Integer.MIN_VALUE;
            for(int a:nums){
                if(a>max){
                    max = a;
                }
            }

            return max;
        }

        int r1 = nums[0];
        long r2 = MIN;
        long r3 = MIN;
        for(int a:nums){
            if(a>r1){
                r3 = r2;
                r2 = r1;
                r1 = a;
            }

            else if(a>r2 && a!=r1){
                r3 = r2;
                r2 = a;
            }

            else if(a>r3 && a<r2 && a!=r1){
                    r3 = a;
            }
        }
        if(r3 == (MIN) ){
            return r1;
        }

        return (int)r3;


    }
}


class Solution414s {
    private long MIN = Long.MIN_VALUE;    // MIN代表没有在值

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("nums is null or length of 0");
        int n = nums.length;

        int one = nums[0];
        long two = MIN;
        long three = MIN;

        for (int i = 1; i <  n; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) continue;    // 如果存在过就跳过不看
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == MIN) return one;  // 没有第三大的元素，就返回最大值
        return (int)three;
    }
}
