package dfs;

import java.util.Stack;

public class StackDfs {
    public int nVerts;

    Graph graph = new Graph();

    Stack stack = new Stack();



    public static void main(String[] args) {
        StackDfs stackDfs = new StackDfs();
        stackDfs.initGraph();
        stackDfs.Dfs();
        System.out.println();
    }

    //图的深度优先搜索
    public  void Dfs(){
        Vertex[] vertices = graph.vertices;
        vertices[0].isVisted = true;
        graph.printVertex(0); //打印第一个顶点
        stack.push(0); //将第一个顶点放入栈中

        while(!stack.isEmpty()){
            int top = Integer.parseInt(stack.peek().toString());

            int v  = graph.getUnvisitedvertex(top);
            if(v == -1){
                stack.pop();
            }else{
                vertices[v].isVisted = true;
                graph.printVertex(v);
                stack.push(v);
            }
            //重置顶点被访问过的状态，防止之后再次使用dfs
            for(int i =0; i<nVerts;i++){
                vertices[i].isVisted = false;
            }

        }

    }

    //初始化图结构
    public void initGraph(){

        //给图添加顶点到顶点数组中
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        //给图添加边到领接矩阵中

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);


    }






}

////图结构
//class Graph{
//
//
//
//}
