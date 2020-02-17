package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis1 {
    public static void main(String[] args) {
        Solution22s s = new Solution22s();
        int n = 3;
        System.out.println(s.generateParenthesis(n));

    }
}

class Solution22s {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        //如果我们还剩一个位置，我们可以开始放一个左括号。
        // 如果它不超过左括号的数量，我们可以放一个右括号。
        //每次回溯之前产生的序列都是有效序列
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);

    }
}


