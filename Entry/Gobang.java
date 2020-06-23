package Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现语言：java
 * 解题思路:广度优先搜索
 * 解题方法：回溯算法
 * 具体实现：
 *    1.首先，判断数组长度是否大于等于5，如果小于等于5，那么此时一定是不分胜负的。
 *    2.其次，我们可以现在一个map中将1,-1,0所代表的的棋子对应保存起来，函数返回的值即为某个颜色棋子代表的数字，
 *      然后我们将这个数字对应的棋子输出即可。
 *    3.对于一个棋子的坐标（x,y）,我们需要做的就是从这个位置开始依次从右，从下，
 *      从斜对角线三个方向来寻找是否有一个方向连为5个连续的棋子。
 *    4.在向三个方向去寻找棋子的过程中，需要有一个记录连续棋子个数的变量，设为n，
 *      同时需要有一个值标记当前遍历到的位置的值，用flag来表示，以便与下一次回溯的位置值比较。
 *    5.每进行一次回溯，都要判断当前位置的值和上个位置的值是否相等且不等于0，如果满足，则将n值+1；
 *      如果当前位置值为0，则说明该位置上没有棋子，这时将n恢复为0，重新进行寻找，如果当前位置值与上一个位置
 *      的值不相等，则将n的值恢复到1，继续寻找。
 */
public class Gobang {
    public static void main(String[] args) {
        Gobang g = new Gobang();
        int[][] nums = {{1,0,0,0,0},
                        {1,1,0,0,0},
                        {-1,-1,-1,-1,-1},
                        {1,0,0,1,0},
                        {1,0,0,0,1}};

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"黑棋赢");
        map.put(-1,"白棋赢");
        map.put(0,"不分胜负");
        int x = g.blackOrWhite(nums);
        System.out.println(map.get(x));


    }
    private int len;
    private int[][] nums;
    List<Integer> result = new ArrayList<>(); //用来保存胜出的棋子对应的值
    public  int blackOrWhite(int[][] nums){
        result.add(0);
        this.len = nums.length;
        if(len<5)   //如果数组长度不够5，直接返回0，代表当前不分胜负
            return 0;
        this.nums = nums;
        int flag = nums[0][0];
        int n = Math.abs(flag);
        backtrack1(0,0,n,flag);
        return result.get(0);

    }
    private void backtrack1(int x,int y,int n,int flag){
        if(n == 5) {
            result.add(0,flag);
            return ;
        }

        flag = nums[x][y];

        int flagN = -1;
        //判断当前位置的下方(x+1,y)
        if((x+1)<len){
            if(nums[x+1][y] == 0){
                flagN = 0;
            } else if(nums[x+1][y] == flag ){
                flagN = n+1;
            } else
                flagN = 1;
            //回溯
            backtrack(x+1,y,flagN,flag);
        }

        //判断当前位置的右方(x,y+1)
        if((y+1)<len){
            if(nums[x][y+1] == 0){
                flagN = 0;
            } else if(nums[x][y+1] == flag){
                flagN = n+1;
            } else
                flagN = 1;
            //回溯
            backtrack(x,y+1,flagN,flag);
        }

        //判断当前位置的斜对角线方(x+1,y+1)
        if((x+1)<len && (y+1)<len){
            if(nums[x+1][y+1] == 0){
                flagN=0;
            } else if(nums[x+1][y+1] == flag){
                flagN = n+1;
            } else
                flagN = 1;

            //回溯
            backtrack(x+1,y+1,flagN,flag);
        }

    }




    private void backtrack(int x,int y,int n,int flag){
        if(n == 5) {
           //System.out.println(map.get(flag)+"胜出");
            result.add(0,flag);
            return;
        }
        flag = nums[x][y];

        if((x+1)<len){
            if(nums[x+1][y] == 0){
                backtrack(x+1,y,0,flag);
            }
            else if(nums[x+1][y] == flag ){
                backtrack(x+1,y,n+1,flag);
            }
            else
                backtrack(x+1,y,1,flag);

        }

        if((y+1)<len){
            if(nums[x][y+1] == 0){
              backtrack(x,y+1,0,flag);
            }
            else if(nums[x][y+1] == flag){
                 backtrack(x,y+1,n+1,flag);
            }
            else
                 backtrack(x,y+1,1,flag);
        }

        if((x+1)<len && (y+1)<len){
            if(nums[x+1][y+1] == 0){
                 backtrack(x+1,y+1,0,flag);
            }
            else if(nums[x+1][y+1] == flag){
                  backtrack(x+1,y+1,n+1,flag);
            }
            else
                  backtrack(x+1,y+1,1,flag);
        }



    }





}
