package review.backtrack;

public class PrintNumbers {
    public static void main(String[] args) {

        //Solution17 s = new Solution17();
        //Solution17s s = new Solution17s();

        Solution17sss s = new Solution17sss();
        int[] res = s.printNumbers(4);
        for(int a:res){
            System.out.println(a);
        }
        System.out.println();





    }
}

class Solution17 {

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }


}

class Solution17s {
    char[] loop = {'0','1','2','3','4','5','6','7','8','9'};
    private int n,nine = 0,count = 0;
    private int start;
    private char[] ch;
    private int[] res;

    public int[] printNumbers(int n){
        res = new int[(int)Math.pow(10,n)-1];
        ch = new char[n];
        this.n = n;
        this.start = n-1;

        dfs(0);

        return res;
    }

    private void dfs(int x){
        if(x == n){
            String s = String.valueOf(ch).substring(start);
            if(!s.equals("0")) {
                res[count++] = Integer.parseInt(s);
            }
            if(n-start == nine)
                start--;
            return;
        }

        for(char c:loop){
            if(c == '9'){
                nine++;
            }
            ch[x] = c;
            dfs(x+1);
        }
        nine--;
    }


}

class Solution17ss{
    char[] loop = {'0','1','2','3','4','5','6','7','8','9'};

    private int n;
    private int count = 0,nine = 0,start;
    private char[] ch;
    int[] res;

    public int[] printNumbers(int n){
        res = new int[(int)Math.pow(10,n)-1];
        ch = new char[n];
        this.start = n-1;
        this.n = n;
        dfs(0);

        return res;

    }

    private void dfs(int x){
        if(x == n){
            String s = String.valueOf(ch).substring(start);
            if(!s.equals("0")){
                res[count++] = Integer.parseInt(s);
            }
            if(n-start == nine){
                start--;
            }
            return;
        }

        for(char c:loop) {
            if (c == '9') {
                nine++;
            }
            ch[x] = c;
            dfs(x + 1);
        }
        nine--;
    }

}

class Solution17sss{
    char[] loop = {'0','1','2','3','4','5','6','7','8','9'};
    private int count = 0,nine = 0,start;
    private char[] ch;
    private int[] res;
    private int n;
    public int[] printNumbers(int n){
        this.start = n-1;
        ch = new char[n];
        res = new int[(int)(Math.pow(10,n)-1)];
        this.n = n;

        dfs(0);

        return res;
    }


    private void dfs(int x){
        if(x == n){
            String s = String.valueOf(ch).substring(start);
            if(!s.equals("0")){
                res[count++] = Integer.parseInt(s);
            }
            if(n-start == nine)
                start--;
            return;
        }

        for(char c:loop){
            if(c == '9'){
                nine++;
            }
            ch[x] = c;
            dfs(x+1);
        }

        nine--;




    }




}