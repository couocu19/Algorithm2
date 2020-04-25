package lanqiao;

import java.util.Scanner;

public class SnakeArray {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m = s.nextInt();
        int tempN=n;
        int [][]a=new int [n][m];
        int i,j,num=0,nn=1;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                a[i][j]=0;
            }
            System.out.println();
        }
        while(n>0)
        {
            if(n==1)
                a[num][num]=nn;
            a[num][num]=nn;
            if(n>1){
                a[num+1][num]=4*n-5+a[num][num];
                for(i=num,j=num+1;j<num+n;j++)//上边横着
                    a[i][j]=a[num][num]+j-num;
                for(j=num+n-1,i=num+1;i<num+n;i++)//右边竖着
                {
                    a[i][j]=a[i-1][j]+1;
//if(n==2)
// a[i][j]=tempN*tempN-1;
                }
                for(i=num+n-1,j=n+num-2;j>=num;j--)//下面横着
                {
                    a[i][j]=a[i][j+1]+1;
                }
                for(j=num,i=num+n-2;i>num;i--)//左面竖着
                {
                    a[i][j]=a[i+1][j]+1;
                }
            }
            else {
                break;
            }
            nn+=4*n-4;
            n=n-2;
            num++;
        }
        for(i=0;i<tempN;i++)
        {
            for(j=0;j<tempN;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}