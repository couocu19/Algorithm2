package backtrack;

public class MovingCount {
    public static void main(String[] args) {
        Solution13 s = new Solution13();
        int m = 20;
        int n = 23;
        int k = 8;
        System.out.println(s.movingCount(m,n,k));



    }
}

class Solution13 {

    private int count = 0;
    private int k;
    private boolean[][] flag;
    private int m;
    private int n;
    public int movingCount(int m, int n, int k) {
        this.k = k;
        this.flag = new boolean[m][n]; //默认赋值为false
        this.n = n;
        this.m = m;

//        if(sum(m,n)<=k)
//            return m*n;

        back(0,0);
        return count;
    }

    private void back(int i,int j){

        if(sum(i,j)>k || i>=m || j>=n) {
            return;
        }
        else{
//            System.out.println("ok");
//            System.out.println(i+" "+j);
            count++;
            flag[i][j] = true;
            if((i+1)<m&&!flag[i+1][j]) {
               back(i + 1, j);
           }

           if((j+1)<n&&!flag[i][j+1]) {
               back(i, j + 1);
           }
        }

    }
    private int sum(int i ,int j){
        int s = 0;
        int tmp;
        while (i!=0){
            tmp = i%10;
            s+=tmp;
            i/=10;
        }
        while (j!=0){
            tmp = j%10;
            s+=tmp;
            j/=10;
        }
        return s;
    }
}