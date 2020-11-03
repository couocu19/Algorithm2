package review.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {


    }
}

class Solution20{
    List<String> out = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        backtrack("",0,0);
        return out;
    }

    private void backtrack(String str,int open,int close){
        if(str.length() == n*2) {
            out.add(str);
        }

        if(open<n){
            backtrack(str+"(",open+1,close);
        }

        if(close<open){
            backtrack(str+")",open,close+1);
        }

    }


}
