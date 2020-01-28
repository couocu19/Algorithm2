package lanqiao;


//2019.4
public class NumResolve {
    public static void main(String[] args) {
        int sum = 0;

        for(int i =1;i<2019;i++){
            for(int j = 1;j<2019 && j<i;j++){
                int k = 2019 - (i+j);
                if((k<j) && isExist1(i) && isExist1(j) && isExist1(k) && k>0){
                    sum++;
                    System.out.println(i+" "+j+" "+k);
                }

            }

        }

        System.out.println(sum);





    }


    //判断某个整数num中是否存在数字a
    public static boolean isExist(int num,int a){
        String str = String.valueOf(num);
        String str1 = String.valueOf(a);
        if(str.contains(str1)){
            return true;
        }else{
            return false;
        }

    }

    public static boolean isExist1(int num){
        if(isExist(num,2)==false && isExist(num,4) == false)
            return true;
        else
            return false;

    }

}
