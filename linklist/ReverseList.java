package linklist;

//将单链表进行逆置的操作
public class ReverseList {

    public static void Reverse(LNode head){

        if(head==null || head.next == null)
            return;

        LNode p;
        LNode q = null;
        p = head.next;
        head.next = null; //将原表置空

        while(p.next!=null){
            q = p;
            p = p.next; //向后移动一位
            q.next = head.next; //头插法
            head.next = q;  //每次逆置一次都要更新一次表头！！！
        }
        p.next = q;  //将最后一个节点和当前的表头相接
        head.next = p; //将整个表的第一个元素指向原来链表的尾结点
    }

    public static void main(String[] args) {
        //链表头结点
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;  //构造单链表的当前结点
        //构造单链表
        for(int i = 0;i<8;i++){
            tmp = new LNode();  //构造临时结点
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }

        System.out.println("逆序前:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data+" ");
        }
        Reverse(head);
        System.out.println();
        System.out.println("逆序后:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data+" ");
        }

    }



}


class LNode{
    int data;
    LNode next;
}