package backtrack;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(m,n));


    }
}

class Solution62 {
    private int m;
    private int n;
    private int count = 0;

    //超时了……
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        back(0,0);

        return count;
    }

    private void back(int i,int j){
        if(i == (m-1) && j == (n-1)){
            //System.out.println("ok");
            count++;
            return;
        }

        if((j+1)<n && i<m) {
            back(i, j + 1);
        }

        if((i+1)<m && j<n) {
            back(i + 1, j);
        }


    }
}