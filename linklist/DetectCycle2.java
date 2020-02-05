package linklist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle2 {
    public static void main(String[] args) {


    }
}


class Solution142ss{
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;

        while(p!=null && p.next!=null){
            if(visited.contains(p)){
                return p;
            }

            visited.add(p);
            p = p.next;
        }

        return null;

    }

}


