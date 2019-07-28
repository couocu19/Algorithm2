package string;

import java.util.Scanner;
//实现strstr函数

public class StrStr {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        String temp = "";
//        temp = s1;
//        s1 = s2;
//        s2 = temp;
//        System.out.println(s1);
//        System.out.println(s2);
        Solution12 d = new Solution12();
        System.out.println(d.strStr(s1,s2));


    }
}
class Solution12 {

    public int strStr(String haystack, String needle) {
        int m = 0;
        int k;
        String temp = "";
        int len1 = haystack.length();
        int len2 = needle.length();
        boolean flag = false;

            if (len1 <= len2) {
                if (len1 == 0) {
                    return 0;
                } else {

                    for (int i = 0; i < len2; i++) {
                        if (needle.charAt(i) == haystack.charAt(0)) {
                            int j = i;
                            m = i;
                            for (k = 0; k < Math.min(len2 - m, len1); k++) {
                                if (haystack.charAt(k) != needle.charAt(j++)) {
                                    return -1;
                                }
                            }
                            if (k == len1) {
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
                                    return -1;
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
