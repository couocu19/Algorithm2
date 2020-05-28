package tree;

/**
 * 判断一个数组的序列是否是二元查找数的后序遍历的序列
 */
public class IsAfterOrder {
    public static void main(String[] args) {



    }


    /**
     * 执行步骤：
     * 1.首先根据后序遍历的特点在数组中找到root结点对应的值（数组的最后一个值）
     * 2.根据二元查找树的特点，在数组中找到第一个大于root值的位置
     * 3.检查该位置到数组最后一个值之前的值是不是都大于root的值，如果不是，返回false
     * 4.现在验证比root小的数值序列是否满足二元查找树的后序遍历序列
     * 5.然后验证比root大的数值序列是否满足二元查找树的后序遍历序列
     * 注意：4和5两步均通过递归来实现
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static boolean isAfter(int[] arr,int start,int end){
        if(arr == null)
            return false;

        //数组的最后一个
        int root = arr[end];

        int i,j;
        //找到第一个大于root的值，那么前面所有的结点都位于root的左子树上

        for(i =start;i<end;i++){
            if(arr[i]>root)
                break;
        }
        //todo:计组
        //如果序列是后序遍历的序列，那么从i开始的所有值都大一root的值
        for(j=i;j<end;j++){
            if(arr[j]<root)
                return false;
        }

        boolean left_IsAfterOrder = true;
        boolean right_IsAfterOrder = true;
        //判断小于root的值的序列是不是二元查找树的后序遍历
        if(i>start)
            left_IsAfterOrder = isAfter(arr,start,i-1);


        //判断大于root的值的序列是不是二元查找树的后序遍历
        if(j<end)
            right_IsAfterOrder = isAfter(arr,i+1,end);

        return (left_IsAfterOrder && right_IsAfterOrder);

    }


}
