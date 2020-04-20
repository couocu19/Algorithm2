package Entry;

import java.util.*;

//找出数组中最大的前k个数
public class FindTop3 {
    public static void main(String[] args) {
        int nums[] = {4,6,3,8,0,1,11,20,7,5,77,888,9999};
        int k = 6;
       // System.out.println(find(nums,k));
        System.out.println(find1(nums,k));


    }

    //适用于k值较小的情况
    //假设k的值为3
    public static List<Integer> find(int[] nums,int k){
        int r1 = Integer.MIN_VALUE;
        int r2 = Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE;

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

            else if(a>r3 && a<r2){
                r3 = a;

            }


        }
        List<Integer> list  = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        return list;
    }

    //适用于k值比较大的情况
    //使用一个小顶堆来保存数据
    public static List<Integer> find1(int[] nums,int k){
        Integer result[] = new Integer[k];
        int k1;
        for(int i =0;i<k;i++){
            result[i] = Integer.MIN_VALUE;
        }
        int len = nums.length;

        for(int i =0;i<len;i++){
            if(nums[i]>result[0]){
                result[0] = nums[i];
                k1 = k;
                for(int j =0;j<k1;j++){
                    adjustHeap(result,0,k1);
                    k1--;
                }
            }
        }
        sort(result);

        List<Integer> list = Arrays.asList(result);
        return list ;

    }

    public static void swap(Integer[] nums,int a,int b){
        int temp ;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }


    public static void sort(Integer[] arr){
        int len = arr.length;
        while(len>1) {
            swap(arr, 0, len - 1);
            len--;
            adjustHeap(arr, 0,len);
        }
    }


    //调整剩下的堆为小顶堆
    public static void adjustHeap(Integer[] nums,int index,int len){
        int left = 2*index+1;
        int right = 2*index+2;
        //int len = nums.length;
        int minIndex;
        while(left<len){
            //先找出left和right中比较大的下标
            if(right<len&&nums[right]<nums[left] ){
                minIndex = right;
            }else{
                minIndex = left;
            }

            //判断当前的堆是不是已经是小顶堆
            if(nums[minIndex]>nums[index]){
                minIndex = index;
            }
            if(minIndex == index){
                break;
            }
            swap(nums,minIndex,index);
            index = minIndex;
            left = 2*index+1;
            right = 2*index+2;

        }

    }



}
