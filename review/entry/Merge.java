package review.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {



    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for(int i =0;i<intervals.length;i++){
            int L = intervals[i][0];
            int R = intervals[i][1];

            if(list.size() == 0|| L> list.get(list.size()-1)[1]){
                list.add(new int[]{L,R});
            }else{
                list.get(list.size()-1)[1] = Math.max(R,list.get(list.size()-1)[1]);
            }
        }

        return list.toArray(new int[list.size()][]);


    }

}