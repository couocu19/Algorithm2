package Entry;

import java.util.ArrayDeque;

public class maxSlidingWindow {

    public static void main(String[] args) {


    }

}


class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int lo = 0,hi = 0;
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        while (hi<nums.length){
            if(hi - lo <k){
                offer(q,nums,hi++);
            }else{
                res[lo] = nums[q.getFirst()];
                if(q.getFirst() == lo++){
                    q.removeFirst();
                }
            }
        }
        res[lo] = nums[q.getFirst()];
        return res;
    }

    private void offer(ArrayDeque<Integer> q,int[] nums,int i){
        while (!q.isEmpty() && nums[q.getLast()] < nums[i]){
            q.removeLast();
        }

        q.offer(i);
    }
}


class Solution239s {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int lo = 0,hi = 0;
        int res[] = new int[len-k+1];
        while (hi<len){
            if((hi-lo)<k){
                offer(deque,nums,hi++);
            }else{

                res[lo] = nums[deque.getFirst()];
                if(deque.getFirst() == lo++){
                    deque.removeFirst();
                }

            }
        }
        res[lo] = nums[deque.getFirst()] ;

        return res;
    }


    private void offer(ArrayDeque<Integer> q,int[] nums,int i){
        while (!q.isEmpty() || nums[q.getLast()]<nums[i]){
            q.removeLast();
        }

        q.offer(i);
    }



}