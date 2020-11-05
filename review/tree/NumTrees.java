package review.tree;

public class NumTrees {
    public static void main(String[] args) {
        int n = 10;
        Solution96 s=  new Solution96();
        for(int i =1;i<=n;i++){
            System.out.println(s.numTrees(i));
        }



    }
}

class Solution96 {
    public int numTrees(int n) {
        long C = 1;
        for(int i =0;i<n;i++){
            C = C * 2 * (2 * i +1)/(i + 2);
        }

        return (int)C;
    }
}