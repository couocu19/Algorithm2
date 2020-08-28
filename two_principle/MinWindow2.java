package two_principle;

public class MinWindow2 {
    public static void main(String[] args) {


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
}


