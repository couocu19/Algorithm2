package midleetcode;
import java.util.Set;
import java.util.HashSet;

public class LengthOfLongestSubstring2 {
    public static void main(String[] args) {


    }
}
//双指针
class Solution{
    public int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0,j = 0,max = 0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return max;

    }

}
