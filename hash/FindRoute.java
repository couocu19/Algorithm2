package hash;

import java.util.HashMap;
import java.util.Map;

public class FindRoute {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("西安","成都");
        map.put("北京","上海");
        map.put("大连","西安");
        map.put("上海","大连");
        System.out.println(find(map));

        
    }

    /**
     *  函数功能，根据map中不同城市之间的去向，确定一条不重复的路线。
     *  难点：找到路线的起点
     *  思路：再申请一个reverseMap，将map中的元素倒置，作为起点的城市在map的键对应的值中不可能存在
     *       所以如果map中的某个键在reverMap中的键中找不到，那么这个城市就是路线的起点
     * @param map
     * @return
     */

    public static String find(Map<String,String> map){

        //找到路线的起点
        Map<String,String> reverseMap = new HashMap<>();

        for(String str:map.keySet()){
            reverseMap.put(map.get(str),str);
        }

        String start = null;
        for(String str:map.keySet()){
            if(!reverseMap.containsKey(str)){
                start = str;
                break;
            }
        }

        System.out.println(start);
        StringBuilder sb = new StringBuilder(start);
        while(map.containsKey(start)){
            sb.append("->"+map.get(start));
            start = map.get(start);
        }

        return sb.toString();

    }


}
