package Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge56 {
    public static void main(String[] args) {


    }
}


class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();


        for(int i =0;i< intervals.length;i++){
            int L = intervals[i][0],R = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] <L){
                merged.add(new int[]{L,R});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[R],R);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }

    public int[][] merge1(int[][] intervals) {
        if(intervals.length == 0)
            return new int[0][2];
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
            if(list.size() == 0 || list.get(list.size()-1)[1] <L){
                list.add(new int[]{L,R});
            }else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],R) ;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}