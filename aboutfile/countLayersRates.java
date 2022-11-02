package aboutfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class countLayersRates {
    public static void main(String[] args) {
        double[] ln = {230218,813184,316620,1531933,576874,270161,1090940,562643,439888,745751,666816,778177,924431,784333,1091291,948066,85779};

    }

    //todo:核对正确性，测试！！
    public int count(double[] ln, String dir_path,int file_num){
        int total_len = 0;
        int len1 = ln.length;
        for(int i = 0;i<len1;i++){
            total_len += ln[i];
        }
        List<Double> list = new ArrayList<>();
        double[] flag  = new double[17];
        for(int i = 1;i<=file_num;i++){ //遍历每一个bed文件
            String c = String.valueOf(i);
            String fp  = dir_path+c+".bed";
            try {
                BufferedReader br = new BufferedReader(new FileReader(fp));
                String line;
                int j = 0;
                while ((line = br.readLine())!=null){
                    String[] sline = line.split("\t");
                    String rate = sline[6];
                    double r = Double.valueOf(rate);
                    flag[j++] = r;
                }  //存储每一个rate到数组中
                br.close();
                double avg_rate = countAvg(flag,ln,total_len); //计算当前文件对应的平均rates
                list.add(avg_rate);

            }catch (Exception e){
                e.printStackTrace();
                break;
            }


        }



        return 0;


    }

    public double countAvg(double[] rates,double[] ln,double total){
        int len = ln.length;
        double res = 0;
        for(int i = 0;i<len;i++){
            res += rates[i] * (ln[i]/total);

        }
        System.out.println(res);
        return res;
    }


}
