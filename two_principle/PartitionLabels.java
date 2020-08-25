package two_principle;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";

        Solution763 s = new Solution763();

        System.out.println(s.partitionLabels1(str));

    }

}

class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();

        //妙啊
        for(int i =0;i<len;i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0,anchor = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i =0;i<len;i++){
            j = Math.max(j,last[S.charAt(i) - 'a']);
            //当遍历到了当前区间的末尾时(即i==j)，把当前区间加入答案，同时将start设为i+1去寻找下一个区间

            if(i == j){
                ans.add(i - anchor + 1);
                anchor = i+1;
            }
        }

        return ans;
    }


    public List<Integer> partitionLabels1(String S){
        int len = S.length();
        List<Integer> res = new ArrayList<>();
        //用来保存字符串中每个字母最后出现的位置
        int[] last = new int[26];

        for(int i =0;i<len;i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int j =0;
        int anchor = 0;
        for(int i =0;i<len;i++){
            //重点！
            //通过扫描字符串，将当前区间的右端值和当前字符串出现的最小区间进行比较，将较大的值作为区间的右端值。
            j = Math.max(j,last[S.charAt(i) - 'a']);
            if(i == j){
                res.add(i - anchor+1);
                anchor = i+1;
            }
        }

        return res;



    }
}
