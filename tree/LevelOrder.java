package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrder {
    public static void main(String[] args) {

    }
}

class SolutionF{
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list5  =new ArrayList<>();
        if(root == null)
            return list5;
        helpn(root,list5,0);
        return list5;

    }

    public void helpn(Node root,List<List<Integer>> list5,int depth){
        if(root == null)
            return;
        //判断是否是新的一层
        //每多一层就要在相应层再新建一个List，一层对应一个List.
        if(depth+1>list5.size()){
            list5.add(new ArrayList<>());
        }
        list5.get(depth).add(root.val);
        //处理子节点
        for(Node node :root.children){
            if(node!=null){
                helpn(node,list5,depth+1);
            }

        }


    }
}