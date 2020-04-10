package Entry;


import java.util.HashSet;
import java.util.Iterator;

//寻找数组中的重复序列

/**
 *题目描述：
 * 对于一个给定的自然数N，有一个N+M个元素的数组，其中存放了小于等于N的所有自然数，
 * 求重复出现的自然序列{X}
 */
public class findDupPlus {

    public static void main(String[] args) {

        int[] nums = {1,2,3,3,3,4,5,5,5,5,6};
        int num = 6;
        HashSet<Integer> s = findDup(nums,num);
        Iterator<Integer> iterator = s.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }


    }

    public static HashSet<Integer> findDup(int[] nums,int n){
        HashSet<Integer> s = new HashSet<>();
        if(null == nums){
            return s;
        }
        int len = nums.length;
        int index = nums[0];
        n = n-1;
        while (true){
            if(nums[index]<0){
                n--;
                nums[index] = len - n;
                s.add(index);
            }
            if(n == 0){
                return s;
            }
            nums[index]*=-1;
            index = nums[index]*(-1);
            System.out.println(index+" "+nums[index]);
        }



    }
}
