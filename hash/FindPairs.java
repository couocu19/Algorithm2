package hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 在数组中找到和相同的两个数对，有几组就打印出几对
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] arrs = {3,4,7,10,20,9,8};

        find(arrs);



    }


    /**
     * 思路：将数对保存在hashmap中，map中键保存数对的和，值保存数对，
     *      进行两层遍历，当遇到和map中和相同的数对时，就打印
     * @param arrs
     */
    public static void find(int[] arrs){
        Map<Integer,Pairs> map = new HashMap<>();
        int len = arrs.length;

        Pairs pairs;
        Integer sum;
        for(int i =0;i<len;i++){
            for(int j =i+1;j<len;j++){
                pairs = new Pairs(arrs[i],arrs[j]);
                sum = arrs[i]+arrs[j];

                if(!map.containsKey(sum)){
                    map.put(sum,pairs);
                }else{

                    System.out.println(arrs[i]+"+"+arrs[j] +"="+ map.get(sum).getFirst()+"+"+map.get(sum).getSecond() );

                }


            }
        }





    }
}


class Pairs{
    private int first;

    private int second;

    public Pairs(){



    }

    public Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}





