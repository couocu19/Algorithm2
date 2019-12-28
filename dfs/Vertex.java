package dfs;


//定义图中的顶点
public class Vertex {

    public String name; //结点的名称
    public boolean isVisted; //标记结点是否被访问过

    public Vertex(String name) {
        this.name = name;
        isVisted = false;
    }

    public Vertex(){

    }
}
