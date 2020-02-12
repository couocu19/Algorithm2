package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations1 {

    public static void main(String[] args) {

        String digitis = "23";
        Solution17ss s = new Solution17ss();
        System.out.println(s.letterCombinations(digitis));


    }

}

class Solution17ss{
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
    };


    List<String> outputs = new ArrayList<String>();

    List<String> letterCombinations(String digitis){


        // 如果判断条件写成 if(digitis!=null),会有一个例子通过不了……迷惑
        if(digitis.length()!=0){
            backtrack("",digitis);
        }

        return outputs;
    }

    /*
       该回溯算法的注意事项：
          1.回溯终止条件和回溯体只能进行一个，所以判断条件要加上(if-else)
          2.回溯主体中的循环中每次更新letter时i的值要更新
     */
    private void backtrack(String combination,String nextDigitis){

        //回溯终止条件
        if(nextDigitis.length() == 0){
            outputs.add(combination);
        }else {

            String letters = map.get(nextDigitis.charAt(0));
            int len = letters.length();

            //回溯主体
            for (int i = 0; i < len; i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigitis.substring(1));

            }
        }

    }

}
