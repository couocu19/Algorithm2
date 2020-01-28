package lanqiao;

/**
 *  *
 *  * @ClassName: SequenceEvaluation数列求值
 *  * @Description: 此题类似于斐波那契数列，但是所求20190324项的最后四位数字，要是单纯按照斐波那契数列的
 *  *               思想求下去，别说long类型，BigInteger类型都存不了这么大的数，然后我们发现，所求
 *  *               20190324项的最后四位数字（也就是变相的告诉我们运算过程只和每个数的后四位有关系），
 *                  那么我们只需要保留每次运算结果的后四位就OK了，这样绝对不会溢出。
 *  * @author: colou
 **/
public class ThreeNumSum1 {
    public static void main(String[] args) {
        int a = 1,b = 1,c = 1;
        int temp = 0;

        for(int i =3;i<20190324;i++){
            temp = (a +b +c)%10000;
            a = b;
            b = c;
            c = temp;
        }

        System.out.println(c);
    }
}
