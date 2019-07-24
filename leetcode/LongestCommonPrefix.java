package leetcode;
import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        String[] a = {""};
        Solution7 hh = new Solution7();
        System.out.println(hh.longestCommonPrefix(a));


    }
}
class Solution7 {
    public String longestCommonPrefix(String[] strs) {
//        int len = 0xffffff;
//        int len1 = strs.length;
//        for (int i = 0; i < len1; i++) {
//            len = Math.min(len, strs[i].length());
//        }
        boolean flag = false;
       // StringBuilder sbb = new StringBuilder(strs[0]);

        List<Character> set1 = new ArrayList<>();


        if (strs.length == 0) {
            return "";
        } else {
            int len = 0xffffff;
            int len1 = strs.length;
            for (int i = 0; i < len1; i++) {
                len = Math.min(len, strs[i].length());
            }
            String sbb = strs[0];
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < len1; j++) {
                    if (sbb.charAt(i) != strs[j].charAt(i)) {
                        if (i == 0) {
                            return "";
                        } else {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    set1.add(strs[0].charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < set1.size(); i++) {
                sb.append(set1.get(i));
            }

            //sb.append('\"');
            return sb.toString();

        }
    }
}
