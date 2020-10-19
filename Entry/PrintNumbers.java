package Entry;

public class PrintNumbers {
    public static void main(String[] args) {
        Solution17 s = new Solution17();
       // System.out.println(s.printNumbers(1));


        s.printNumbers(1);

    }
}

class Solution17 {
    public int[] printNumbers(int n) {

        double num = Math.pow(10,n);
        int[] res = new int[(int)(num-1)];
        for(int i =0;i<(num-1);i++){

            res[i] = i+1;
            //System.out.println(i);
        }

        return res;


    }
}


class Solution17s {

    int[] res;
    int nine =0,count = 0,start,n;
    char[] num,loop = {'0','1','2','3','4','5','6','7','8','9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10,n)-1];
        num = new char[n];
        start = n-1;

        return res;

    }

    private void dfs(int x){
        if(x==n){
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0"))
                res[count++] = Integer.parseInt(s);

            if(n-start == nine)
                start--;
        }

        for(char i:loop){
            if(i == '9')
                nine++;
            num[x] = i;
            dfs(x+1);
        }

        nine--;

    }




}