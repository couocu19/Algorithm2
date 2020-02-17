package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        int n = 3;
        System.out.println(s.generateParenthesis(n));


    }
}

class Solution22 {
    private List<String> outPuts = new ArrayList<>();
    private int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        String s = "";

        backTrack(s,0,0);

        return outPuts;
    }

    private void backTrack(String s,int open,int close){
        if(s.length() == n*2){
            outPuts.add(s);
        }

        //切记不能写成open++ ,close++
        if(open<n){
            backTrack(s+"(",open+1,close);
        }

        if(close<open){
            backTrack(s+")",open,close+1);
        }
    }



}