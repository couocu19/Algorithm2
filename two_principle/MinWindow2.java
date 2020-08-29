package two_principle;

public class MinWindow2 {
    public static void main(String[] args) {
        String S = "ADOBECODBANC";
        String C = "ABC";
        Solution76ss s = new Solution76ss();
        System.out.println(s.minWindow1(S,C));



    }

}

class Solution76ss {

    public String minWindow(String s, String t){
        if(s == null || s == ""|| t == null || t == "" || s.length()<t.length())
            return "";

        int[] needs = new int[128];
        int[] windows = new int[128];

        for(Character c:t.toCharArray()){
            needs[c]++;
        }

        int left = 0;
        int right = 0;

        String res = "";
        int count = 0;
        int minLen = s.length()+1;

        while(right<s.length()){
            char ch = s.charAt(right);
            windows[ch]++;

            //判断当前字符在不在T字符串中
            if(needs[ch]>0 && needs[ch]>=windows[ch]){
                count++;
            }

            while(count == t.length()){
                ch = s.charAt(left);

                if(needs[ch]>0 && needs[ch]>=windows[ch]){
                    count--;
                }
                if(right-left+1 <minLen){
                    minLen = right - left +1;
                    res = s.substring(left,right+1);
                }

                windows[ch]--;
                left++;
            }

            right++;

        }

        return res;
    }

    public String minWindow1(String s, String t){
        int[] need = new int[90];
        int[] window = new int[90];
        int minLen  = s.length()+1;

        String res = "";
        int left = 0;
        int right = 0;

        for(Character c:t.toCharArray()){
            need[c]++;
        }


        int count = 0;

        while(right<s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            if(need[ch]>0 && need[ch]>=window[ch]){
                count++;
            }

            while (count == t.length()){
                 ch = s.charAt(left);
                if(need[ch]>0 && need[ch]>=window[ch]){
                    count--;
                }

                if(right-left+1 <minLen){
                    minLen = right-left+1;
                    res = s.substring(left,right+1);
                }

                left++;
                window[ch]--;

            }

            right++;

        }

        return res;




    }
}


