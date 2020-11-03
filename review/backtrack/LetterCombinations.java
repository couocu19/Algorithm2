package review.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {


    }
}


class Solution17ssss{
    List<String> letterCombinations(String digitis){
        if(digitis.length()!=0){
            backtrack("",digitis);
        }
        return output;
    }
    private Map<Character,String> map = new HashMap<>(){
        {
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }

    } ;

    List<String> output = new ArrayList<>();
    private void backtrack(String com,String nextDigit){
        if(nextDigit.length() == 0){
            output.add(com);
        }else{
            String letters = map.get(nextDigit.charAt(0));
            int len = letters.length();
            for(int i =0;i<len;i++){
                String letter = letters.substring(i,i+1);
                backtrack(com+letter,nextDigit.substring(1));
            }
        }
    }




}

