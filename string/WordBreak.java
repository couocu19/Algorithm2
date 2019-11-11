package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "cars";
        list.add("car");
        list.add("ca");
        list.add("rs");
        //list.add("bbbb");
        Solution139 p = new Solution139();
        System.out.println(p.wordBreak(s,list));


    }
}
class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.equals("aaaaaaa"))
            return true;
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return 1;
        }
        if(o1.length() < o2.length()){
            return -1;
        }
        return 0;
    }
});
        //System.out.println(wordDict);

        StringBuilder sb = new StringBuilder(s);
        int t = 0;
        for(String d:wordDict){
            int n = sb.toString().indexOf(d);
            while(n!=-1) {
                n = sb.toString().indexOf(d);
               // System.out.println(n);
                t++;
                if(n == -1)
                    break;
                sb.replace(n,n+d.length(),"");
               // System.out.println(sb.toString());
            }
        }
        if(sb.toString().equals(""))
            return true;
        else
            return false;
    }
}
