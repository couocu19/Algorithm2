package count;

public class SumNums {
    public static void main(String[] args) {

        int n = 9;
        Solution64 solution64 = new Solution64();
        System.out.println(solution64.sumNums(n));



    }

}

class Solution64 {
    int n;
    int sum;
    public int sumNums(int n) {
        this.n = n;
        //this.sum = 0;
        sum(n,sum);
        return sum;

    }

    private void sum(int i,int s){
        this.sum = s;
        if(i == 0){
            return;
        }
        s+=i;
        System.out.println(s);
        sum(i-1,s);

    }
}
