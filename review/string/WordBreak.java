package review.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {



    }
}
class Solutionwo {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1;i<=len;i++){
            for(int j =0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }


            }

        }
        return dp[len];
    }
}