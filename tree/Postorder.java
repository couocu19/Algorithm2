package tree;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public static void main(String[] args) {

    }
}

class SolutionE {
    public List<Integer> postorder(Node root) {
        List<Integer> list4 = new ArrayList<>();

        help4(root,list4);

        return list4;
    }

    public void help4(Node root,List<Integer> list4){
       if(root!=null){
           if(root.children!=null){
               for(Node node:root.children){
                   help4(node,list4);
               }
           }
           list4.add(root.val);

       }

    }
}