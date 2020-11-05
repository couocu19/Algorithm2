package review.string;

public class MinWindow {
    public static void main(String[] args) {


    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        if(s == null || s == "" || t == null || t == "" || s.length()<t.length())
            return "";
        int[] needs = new int[128];
        int[] window = new int[128];

        for(Character ch:t.toCharArray()){
            needs[ch]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = s.length()+1;
        String res = "";
        while (right < s.length()){
            char c = s.charAt(right);
            window[c]++;
            if(needs[c]>0 && needs[c]>=window[c]){
                count++;
            }
            while (count == t.length()){
                c = s.charAt(left);

                if(needs[c]>0 &&needs[c]>=window[c]){
                    count--;
                }

                if(right - left +1 < minLen){
                    minLen = right-left+1;
                    res = s.substring(left,right+1);
                }
                window[c]--;
                left++;

            }
            right++;
        }
        return res;
    }

    public String minWindow1(String s, String t) {
        if(s == null || s == "" || t == null ||t == ""|| s.length()<t.length())
            return "";
        String res = "";
        int left = 0;
        int right = 0;
        int minLen = s.length()+1;
        int[] window = new int[128];
        int[] needs = new int[128];
        char[] ch = t.toCharArray();
        for(Character c:ch){
            needs[c]++;

        }

        int count = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            window[c]++;

            if(needs[c]>0 && needs[c]>=window[c]){
                count++;
            }
            while (count == t.length()){
                c = s.charAt(left);
                if(needs[c]>0 && needs[c]>=window[c]){
                    count--;
                }

                if(right - left+1<minLen){
                    minLen = right - left+1;
                    res = s.substring(left,right+1);
                }

                window[c]--;
                left++;
            }
            right++;
        }

        return res;
    }
}