package dfs;


import java.util.Stack;

//图结构
public class Graph {

    private final int MaxNodes = 20;
    public Vertex vertices[]; //顶点数组
    private int adjMat[][]; //邻接矩阵
    private int nVerts; //当前顶点总数;
   // private int nSides; //图的边总数
    private Stack stack;

    //构造一个图
    public Graph(){
        vertices = new Vertex[MaxNodes];
        adjMat = new int[MaxNodes][MaxNodes];
        nVerts = 0;
//        stack = new Stack();

        //给邻接矩阵赋初值
        for(int i =0;i<MaxNodes;i++){
            for(int j =0;j<MaxNodes;j++){
                adjMat[i][j] = 0;
            }
        }
        //创建一个栈
        stack = new Stack();
    }


    //添加顶点
    public void addVertex(String name){
        vertices[nVerts++] = new Vertex(name);
    }

    //添加边
    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //打印数组中v位置下的顶点的名称
    public void printVertex(int v){
        System.out.print(vertices[v].name+" ");
    }

    //获取和v邻接的未访问的顶点
    public int getUnvisitedvertex(int v){

        for(int i =0;i<nVerts;i++){

            //判断条件需同时满足邻接以及未访问
            if(adjMat[v][i] == 1 && vertices[i].isVisted == false){
                return i;
            }
        }
        return -1;
    }
}
