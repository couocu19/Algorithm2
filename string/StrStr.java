package string;

import java.util.Scanner;
//实现strstr函数

public class StrStr {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        String s1 = "mississippi";
        String s2 = "issip";

        Solution12 d = new Solution12();
        System.out.println(d.strStr(s1,s2));


    }
}
class Solution12 {

    public int strStr(String haystack, String needle) {
        int m = 0;
        int k;
        int len1 = haystack.length();
        int len2 = needle.length();
        boolean flag = false;

            if (len1 < len2) {

              return -1;

            } else {

                if (len2 == 0) {
                    return 0;
                } else {

                    for (int i = 0; i < len1; i++) {
                        if (haystack.charAt(i) == needle.charAt(0)) {
                            int j = i;
                            m = i;
                            for (k = 0; k < Math.min(len1 - m, len2); k++) {
                                if (needle.charAt(k) != haystack.charAt(j++)) {
                                    break;
                                }
                            }
                            if (k == len2) {
                                flag = true;
                                break;
                            }
                        }

                    }
                    if (!flag) {
                        return -1;
                    } else {
                        return m;
                    }

                }

        }
    }
}
