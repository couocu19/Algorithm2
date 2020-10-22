package review.dp;

//剪绳子
public class CuttingRope {
    public static void main(String[] args) {




    }

    public static int cutting(int n){

        if(n<=3)
            return n-1;

        int b = n%3;
        int p = 1000000007;
        int lineN = n/3;
        long ret = 1;
        for(int i =1;i<lineN;i++){
            ret = ret*3%p;
        }
        if(b == 0)
            return (int)(3*ret%p);

        if(b == 1)
            return (int)(4*ret%p);

        return (int)(6*ret%p);

    }

    public static int cutting1(int n){
        if(n<=3)
            return n-1;

        int p = 1000000007;
        int lineNums = n/3;
        int b = n%3;
        long ret = 1;

        for(int i =1;i<lineNums;i++){
            ret = ret*3%p;
        }

        if(b == 0)
            return (int)(3*ret%p);
        if(b == 1)
            return (int)(4*ret%p);
        //if(b == 2)
            return (int)(6*ret%p);
    }


}
