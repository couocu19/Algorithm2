package Entry;


//todo:用另一种递归法实现
public class GetMid {
    private int pos = 0;
    public static void main(String[] args) {
        int arr[] = {1,1,3,5,9,7,11};
        System.out.println(new GetMid().getMid(arr));
    }

    /**
     * 以arr[0]为基准把数组分为两部分
     * @param arr
     * @param low
     * @param high
     */
    private void partition(int arr[],int low,int high){
        int key = arr[low];
            while(low<high){
                while(low<high&&arr[high]>=key)
                    high--;
                arr[low] = arr[high];
                while(low<high&&arr[low]<=key)
                    low++;
                arr[high] = arr[low];
            }
            arr[low] = key;
            pos = low;
    }


    //只适用于数组长度为奇数的情况
    //如果数组长度为偶数，可能会出错
    public  int getMid(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        while(true){
            partition(arr,low,high);
            if(pos == mid)
                break;
            else if(pos>mid)
                high = pos-1;
            else
                low = pos+1;
        }
        return (arr.length%2)!=0?arr[mid]:(arr[mid]+arr[mid+1])/2;
    }


}
