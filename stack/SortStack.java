package stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(4);
        s.push(3);
        s.push(6);
        s.push(5);
        SortStack st = new SortStack();
        st.sort(s);


        while(!s.empty()){
            System.out.print(s.pop()+" ");

        }
        System.out.println();



    }


    //将栈的reverse算法改进为排序算法
    /**
     * 过程分析：
     *    每进行一次moveToTop都会将栈中最小或者最大的元素移动到栈顶，
     *    然后将栈顶元素弹出，继续对剩下的子栈进行排序，
     *    直到栈中元素为空，这时递归结束，排序算法完成。
     * @param s
     */
    public void sort(Stack<Integer> s){
        if(s.empty())
            return;
        moveToTop(s);
        int top = s.pop();
        sort(s);
        s.push(top);
    }


    /**
     * 递归过程分析：
     *   如果每次在交换栈顶元素和子栈栈顶元素的时候不进行比较，
     *   那么这个函数所呈现的功能即为没进行一次递归就将栈底元素移动到栈顶。
     *   但是如果在每次交换的时候进行一个比较，
     *   那么每次都会将栈顶和子栈栈顶元素中较大或者较小的元素放在栈顶，
     *   所以函数结束时整个栈中最小或者最大的元素将被移动到栈顶。
     *
     * @param s
     */
    private void moveToTop(Stack<Integer> s){
        if(s.empty())
            return;

        int top1 = s.pop();

        if(!s.empty()) {
            moveToTop(s);
            int top2 = s.peek();
            //加一个判断条件
            if (top1 > top2) {
                s.pop();
                s.push(top1);
                s.push(top2);
                return;
            }
        }
        s.push(top1);
    }





}
