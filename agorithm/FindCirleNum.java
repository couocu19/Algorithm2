package agorithm;

//并查集实例
public class FindCirleNum {
    public static void main(String[] args) {
        int[][] M = {{1,1,0},{1,1,1},{0,1,1}};
        //System.out.println(M.length);
        Solution s = new Solution();
        System.out.println(s.findCircleNum(M));


    }
}

class Solution {
    public static int pre[] = new int[200];
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int ans = 0;
        setPre(len);
        //注意j的循环条件，应该为i+1
        for(int i =0;i<len;i++){
            for(int j =i+1;j<len;j++){
                if(M[i][j]==1){
                    join(i,j);

                }
            }
        }
        for(int i =0;i<len;i++){

            System.out.println(pre[i]);
            if(pre[i] == i){
               // System.out.println(pre[i]);
                ans++;
            }
        }
        return ans;

    }
    public static void setPre(int len){
        for(int i =0;i<len;i++){
            pre[i] = i;
        }

    }

    public static  int find(int x){
        if(pre[x] == x){
            return x;
        }else{
            //路径压缩(使搜索祖宗的过程中，路径中搜索的结点的父亲的变为祖宗)
            pre[x] = find(pre[x]);
            return pre[x];
        }

    }

    public static void join(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx!=fy){
            pre[fx] = fy;

        }
    }
}

