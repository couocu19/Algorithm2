package sort;

public class HeapSort2 {
    public static void main(String[] args) {
        int num[] = {1,4,2,6,7,66,8,9};
        num = HeapConstructor(num);
        for(int a:num){
            System.out.print(a+" ");
        }
        System.out.println();
        sort(num);
        for(int a:num){
            System.out.print(a+" ");
        }

    }


    public static void sort(int[] arr){
        int len = arr.length;
        while(len>1) {
            swap(arr, 0, len - 1);
            len--;
            adjustHeap(arr, 0,len);
        }
    }


    //构造大顶堆
    public static int[] HeapConstructor(int[] arr){
        int len = arr.length;
        int curIndex;
        int fatherIndex;

        for (int i =0;i<len;i++){
            curIndex = i;
            fatherIndex = (i-1)/2;

            //直到变为大大顶堆之后再结束循环
            while(arr[curIndex]>arr[fatherIndex]){
                swap(arr,curIndex,fatherIndex);
                curIndex = fatherIndex;
                fatherIndex = (curIndex-1)/2;
            }

        }

        return arr;

    }
    
    //调整剩下的节点为大顶堆
    public static void adjustHeap(int[] arr,int index,int len){
        int left = 2*index+1;
        int right = 2*index+2;

        int curIndex ;
        while(left<len) {
            if (arr[left] <arr[right] && right<len) {
                curIndex = right;
            } else {
                curIndex = left;
            }

            if(arr[index]>arr[curIndex]){
                curIndex = index;
            }

            if(curIndex == index){
                break;
            }
            swap(arr,curIndex,index);
            index = curIndex;
            left = 2*index+1;
            right = 2*index+2;
        }
    }




    public static void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
