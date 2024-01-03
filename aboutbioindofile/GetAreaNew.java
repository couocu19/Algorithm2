package aboutbioindofile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

//原来写的代码bug太多了，重写一个妈的
//根据得到的区间获取其对应的间隔区间
//根据老区域获取新区域
public class GetAreaNew {

    //人类染色体编号
    Map<String,String> mapChr = new HashMap<>() {
        {
            put("NC_060925.1","chr1");
            put("NC_060926.1","chr2");
            put("NC_060927.1","chr3");
            put("NC_060928.1","chr4");
            put("NC_060929.1","chr5");
            put("NC_060930.1","chr6");
            put("NC_060931.1","chr7");
            put("NC_060932.1","chr8");
            put("NC_060933.1","chr9");
            put("NC_060934.1","chr10");
            put("NC_060935.1","chr11");
            put("NC_060936.1","chr12");
            put("NC_060937.1","chr13");
            put("NC_060938.1","chr14");
            put("NC_060939.1","chr15");
            put("NC_060940.1","chr16");
            put("NC_060941.1","chr17");
            put("NC_060942.1","chr18");
            put("NC_060943.1","chr19");
            put("NC_060944.1","chr20");
            put("NC_060945.1","chr21");
            put("NC_060946.1","chr22");
            put("NC_060947.1","chrX");
            put("NC_060948.1","chrY");
        }
    };

    //香蕉染色体编号
    Map<String,String> mapChr1 = new HashMap<>() {
        {
            put("chr01","chr1");
            put("chr02","chr2");
            put("chr03","chr3");
            put("chr04","chr4");
            put("chr05","chr5");
            put("chr06","chr6");
            put("chr07","chr7");
            put("chr08","chr8");
            put("chr09","chr9");
            put("chr10","chr10");
            put("chr11","chr11");
            put("putative_mitochondrion","chrM");
        }
    };

    //小鼠染色体编号
    Map<String,String> mapChr6 = new HashMap<>() {
        {
            put("chr1","chr1");
            put("chr2","chr2");
            put("chr3","chr3");
            put("chr4","chr4");
            put("chr5","chr5");
            put("chr6","chr6");
            put("chr7","chr7");
            put("chr8","chr8");
            put("chr9","chr9");
            put("chr10","chr10");
            put("chr11","chr11");
            put("chr12","chr12");
            put("chr13","chr13");
            put("chr14","chr14");
            put("chr15","chr15");
            put("chr16","chr16");
            put("chr17","chr17");
            put("chr18","chr18");
            put("chr19","chr19");
            put("chrX","chrX");
            put("chrY","chrY");
        }
    };
    //小鼠chr7 猪chr2 香蕉chr3
    Map<String,String> mapChr4 = new HashMap<>() {
        {
           // put("chr7","mouse-chr7");
            //put("NC_010444.4","pg-chr2");
            //put("chr4","mouse-chr4");
            put("chr03","banana-chr3");
        }
    };
    //小鼠chr7 猪chr2
    //String[] ms7 = {"144995196","151935994"};
    //小鼠chr4 香蕉chr3
    String[] ms7 = {"43931233"};

    //拟南芥染色体编号
    Map<String,String> mapChr3 = new HashMap<>() {
        {
            put("Chr1","chr1");
            put("Chr2","chr2");
            put("Chr3","chr3");
            put("Chr4","chr4");
            put("Chr5","chr5");
        }
    };
    //山羊染色体编号
    Map<String,String> mapChrSheep = new HashMap<>() {
        {
            put("NC_056054.1","chr1");
            put("NC_056055.1","chr2");
            put("NC_056056.1","chr3");
            put("NC_056057.1","chr4");
            put("NC_056058.1","chr5");
            put("NC_056059.1","chr6");
            put("NC_056060.1","chr7");
            put("NC_056061.1","chr8");
            put("NC_056062.1","chr9");
            put("NC_056063.1","chr10");
            put("NC_056064.1","chr11");
            put("NC_056065.1","chr12");
            put("NC_056066.1","chr13");
            put("NC_056067.1","chr14");
            put("NC_056068.1","chr15");
            put("NC_056069.1","chr16");
            put("NC_056070.1","chr17");
            put("NC_056071.1","chr18");
            put("NC_056072.1","chr19");
            put("NC_056073.1","chr20");
            put("NC_056074.1","chr21");
            put("NC_056075.1","chr22");
            put("NC_056076.1","chr23");
            put("NC_056077.1","chr24");
            put("NC_056078.1","chr25");
            put("NC_056079.1","chrX");
            put("NC_056080.1","chrY");
            put("NC_001941.1","chrMT");
        }
    };


    //森林草莓
    Map<String,String> mapFv = new HashMap<>(){
        {
            put("chr1","chr1");
            put("chr2","chr2");
            put("chr3","chr3");
            put("chr4","chr4");
            put("chr5","chr5");
            put("chr6","chr6");
            put("chr7","chr7");
        }
    };

    //森林草莓
    String[] lnsFv = {"24346798", "29670488", "38992715", "34388015", "29536839", "39893988", "23954239"};

    //人类
    String[] lnsHum = {"248387328","242696752","201105948","193574945","182045439","172126628","160567428","146259331","150617247","134758134","135127769","133324548","113566686",
            "101161492","99753195","96330374","84276897","80542538","61707364","66210255","45090682","51324926","154259566","62460029"};
    //香蕉
    String[] lnsBan = {"41765374","34826099","43931233","45086258","46513039","43117521","39373400","51314288","47719527","40511255","34663808","10397121"};
    //猪
    String[] lnsPg = {
            "274330532","151935994","132848913","130910915","104526007","170843587","121844099","138966237","139512083","69359453","79169978","61602749"
            ,"208334590","141755446","140412725","79944280","63494081","55982971","125939595","43547828"
    };
    String[] lnsPg1 = {
            "274330532","151935994","132848913","130910915","104526007","170843587","121844099","138966237","139512083","69359453","79169978","61602749"
            ,"208334590","141755446","140412725","79944280","63494081","55982971","125939595","43547828"
    };
    //拟南芥
    String[] lnsAb = {"32540122","22217084","25743512","21578073","29480885"};

    String[] lnsSheep = {"278617202", "250202058", "226089100", "121578099", "108220788", "118469697", "101274418", "91792871", "95179658", "86459471",
            "62547497", "80403655", "83511835", "66516657", "82538637", "71897364", "73167223", "67984460", "60561550", "51451717", "47514194", "51512491",
            "62440644", "42630236", "44863754", "45052359", "143171725", "16616"
    };

    //小鼠
    String[] lnsMs = {"195154279","130530862", "121973369", "120092757", "120883175", "125139656", "104073951", "98008968", "95294699", "90720763", "61420004","181755017","159745316", "156860686", "151758149", "149588044", "144995196", "130127694", "124359700",  "169476592", "91455967"};

    //人类1号和15号染色体
    String[] lns_115 = {"248387328","99753195"};

    //拟南芥1号和5号染色体
    String[] lnsab_115 = {"32540122","29480885"};

    //森林草莓四号染色体
    String[] lnsfv_4 = {"34388015"};

    public static void main(String[] args) {
        GetAreaNew g = new GetAreaNew();
        //人类
        String fp13 = "E:\\complete-gene-ann\\human\\hmmerge-5000.bed";
        String nfp13 = "E:\\complete-gene-ann\\human\\hm-newGeneArea.bed";
        String nfp13_all = "E:\\complete-gene-ann\\human\\hm-AllArea-1.txt";
        //System.out.println(g.get(fp13,nfp13));
        //System.out.println(g.getAll(fp13,nfp13_all));
        //香蕉
        String fp1 = "E:\\complete-gene-ann\\banana-香蕉\\l5000\\bn-merge.bed";
        String nfp1 = "E:\\complete-gene-ann\\banana-香蕉\\l5000\\bn-NewArea.bed";
        String nfp1_all = "E:\\complete-gene-ann\\banana-香蕉\\l5000\\bn-AllArea.txt";
       // System.out.println(g.get(fp1,nfp1));
       // System.out.println(g.getAll(fp1,nfp1_all));
        //人类重复区域
        String fp4 = "E:\\complete-gene-ann\\human\\rpmaker\\hmrpt115-sml.txt";
        String nfp4 = "E:\\complete-gene-ann\\human\\rpmaker\\hmrpt115-all.txt";
        //System.out.println(g.getAll_repeat(fp4,nfp4));
        //人类重复区域和新区域的交叉区域（chr1、chr15）
        String fp5 = "E:\\complete-gene-ann\\human\\rpmaker\\hm-newAndRpt-115.bed";
        String nfp5 = "E:\\complete-gene-ann\\human\\rpmaker\\hm-newAndRpt115-all.txt";
        //System.out.println(g.getAll_repeat(fp5,nfp5));
        //拟南芥重复区域和新区域的交叉区域（chr1、chr5）
        //String fp6 = "E:\\complete-gene-ann\\Arab\\bed-files\\repeta-重复区域\\ab-NR-15.bed";
        //String nfp6 = "E:\\complete-gene-ann\\Arab\\bed-files\\repeta-重复区域\\ab-NR-15-all.bed";
        //System.out.println(g.getAll_repeat(fp6,nfp6));
        //小鼠
        String fp7 = "E:\\complete-gene-ann\\Mouse\\ms-mrg.bed";
        String nfp7 = "E:\\complete-gene-ann\\Mouse\\ms-newArea.bed";
        String nfp7_all = "E:\\complete-gene-ann\\Mouse\\ms-AllArea.bed";
       // System.out.println(g.getAll(nfp7,nfp7_all));
        //小鼠-chr4
         String fp8 = "E:\\complete-gene-ann\\Mouse\\ms-NR-chr4.bed";
         String nfp8_all = "E:\\complete-gene-ann\\Mouse\\ms-NR-chr4-all.bed";
         //System.out.println(g.getAll_repeat(fp8,nfp8_all));
         //香蕉-chr3
        String fp9 = "E:\\complete-gene-ann\\repeat-all-stat\\repeat-all\\bn-NR-chr3.bed";
        String nfp9_all = "E:\\complete-gene-ann\\repeat-all-stat\\repeat-all\\bn-NR-chr3-all.bed";
        //System.out.println(g.getAll_repeat(fp9,nfp9_all));
        //森林草莓
        String fp10 = "E:\\complete-gene-ann\\f.vesca-草莓\\fv-mergeMatch.bed";
        String nfp10 = "E:\\complete-gene-ann\\f.vesca-草莓\\fv-new.bed";
        String fp10_chr4 = "E:\\complete-gene-ann\\f.vesca-草莓\\fv-new-chr4.txt";
        String nfp10_chr4 = "E:\\complete-gene-ann\\f.vesca-草莓\\fv-new-chr4-all.txt";
        //System.out.println(g.get(fp10,nfp10));
        //System.out.println(g.getAll(nfp10,nfp10_chr4));

        String pth1 = "E:\\pangenome\\hrpc_human\\hm-allSvCount.bed";
        String pth2 = "E:\\pangenome\\hrpc_human\\hm-allSvCount_all.bed";
        System.out.println(g.getAllSvRegion(pth1,pth2));

    }
    //获取差集，就是获取除了已有区域以外剩下的区域
    public int get(String fpath,String fnpath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            FileWriter fw = new FileWriter(fnpath);
            String line = "";
            String[] sline;
            String chrName = "";
            String flag = "0";
            StringBuilder sb ;
            int i = 0;
            while ((line = br.readLine()) != null) {
                sline = line.split("\t");
                if((!chrName.equals("")) && (!sline[0].equals(chrName))){
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lnsFv[i]);
                    sb.append("\n");
                    i++;
                    fw.write(sb.toString());
                    flag = "0";
                }
                chrName = sline[0];
                sb = new StringBuilder(chrName);
                sb.append("\t");
                sb.append(flag);
                sb.append("\t");
                sb.append(sline[1]);
                sb.append("\n");
                flag = sline[2];
                fw.write(sb.toString());
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lnsFv[i]);
            sb.append("\n");
            fw.write(sb.toString());
            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
    //获取差集和原本区域的合集
    public int getAll(String fpath,String fnpath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            FileWriter fw = new FileWriter(fnpath);
            String line = "";
            String[] sline;
            String chrName = "";
            String flag = "0";
            StringBuilder sb ;
            int i = 0;
            while ((line = br.readLine()) != null) {
                sline = line.split("\t");
                if((!chrName.equals("")) && (!sline[0].equals(chrName))){
                    //新区域
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lnsFv[i]);
                    sb.append("\t");
                    sb.append(mapFv.get(chrName)); //添加染色体名称
                    sb.append("\t");
                    sb.append("commonArea");
                    sb.append("\n");
                    i++;
                    fw.write(sb.toString());
                    flag = "0";

                }
                chrName = sline[0];
                sb = new StringBuilder(chrName);
                sb.append("\t");
                sb.append(flag);
                sb.append("\t");
                sb.append(sline[1]);
                sb.append("\t");
                sb.append(mapFv.get(chrName));
                sb.append("\t");
                sb.append("commonArea");
                sb.append("\n");
                flag = sline[2];
                fw.write(sb.toString());

                fw.write(line);
                fw.append("\t");
                fw.append(mapFv.get(chrName));
                fw.write("\t");
                fw.write("newArea");
                fw.write("\n");
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lnsFv[i]);
            sb.append("\t");
            sb.append(mapFv.get(chrName));
            sb.append("\t");
            sb.append("commonArea");
            sb.append("\n");
            fw.write(sb.toString());

            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    //针对重复序列以及重复区域处理
    public int getAll_repeat(String fpath,String fnpath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            FileWriter fw = new FileWriter(fnpath);
            String line = "";
            String[] sline;
            String chrName = "";
            String flag = "0";
            StringBuilder sb ;
            int i = 0;
            int k = 0;
            while ((line = br.readLine()) != null) {
                k++;
                sline = line.split("\t");
                if((!chrName.equals("")) && (!sline[0].equals(chrName))){
                    System.out.println(k+" "+chrName);
                    //新区域
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lnsAb[i]);
                    sb.append("\t");
                    sb.append(mapChr3.get(chrName)); //添加染色体名称
                    sb.append("\t");
                    sb.append("other");
                    sb.append("\n");
                    i++;
                    fw.write(sb.toString());
                    flag = "0";

                }

            //    if(!flag.equals(sline[1])){
                    chrName = sline[0];
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(sline[1]);
                    sb.append("\t");
                    sb.append(mapChr3.get(chrName));
                    sb.append("\t");
                    sb.append("other");
                    sb.append("\n");
                    fw.write(sb.toString());
              //  }

                flag = sline[2];
                fw.write(sline[0]);
                fw.append("\t");
                fw.append(sline[1]);
                fw.append("\t");
                fw.append(sline[2]);
                fw.append("\t");
                fw.append(mapChr3.get(chrName));
                fw.write("\t");
                fw.write(sline[3]);
               // System.out.println(sline[3]);
                fw.write("\n");
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lnsAb[i]);
            sb.append("\t");
            sb.append(mapChr3.get(chrName));
            sb.append("\t");
            sb.append("other");
            sb.append("\n");
            fw.write(sb.toString());

            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     * 获取所有sv区间以及其余区域
     * @param fpath
     * @param fnpath
     * @return
     */
    public int getAllSvRegion(String fpath,String fnpath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            FileWriter fw = new FileWriter(fnpath);
            String line = "";
            String[] sline;
            String chrName = "";
            String flag = "0";
            StringBuilder sb ;
            int i = 0;
            int k = 0;
            while ((line = br.readLine()) != null) {
                k++;
                sline = line.split("\t");
                if((!chrName.equals("")) && (!sline[0].equals(chrName))){
                    System.out.println(k+" "+chrName);
                    //新区域
                    sb = new StringBuilder(chrName);
                    sb.append("\t");
                    sb.append(flag);
                    sb.append("\t");
                    sb.append(lnsHum[i]);
                    sb.append("\t");
                    sb.append(mapChr.get(chrName)); //添加染色体名称
                    sb.append("\t");
                    sb.append("other");
                    sb.append("\n");
                    i++;
                    fw.write(sb.toString());
                    flag = "0";
                }

                chrName = sline[0];
                if(!flag.equals(sline[1])){
                sb = new StringBuilder(chrName);
                sb.append("\t");
                sb.append(flag);
                sb.append("\t");
                sb.append(sline[1]);
                sb.append("\t");
                sb.append(mapChr.get(chrName));
                sb.append("\t");
                sb.append("other");
                sb.append("\n");
                fw.write(sb.toString());
                }
                flag = sline[2];
                fw.write(sline[0]);
                fw.append("\t");
                fw.append(sline[1]);
                fw.append("\t");
                fw.append(sline[2]);
                fw.append("\t");
                fw.append(mapChr.get(chrName));
                fw.write("\t");
                fw.write(sline[3]);
                // System.out.println(sline[3]);
                fw.write("\n");
            }
            sb = new StringBuilder(chrName);
            sb.append("\t");
            sb.append(flag);
            sb.append("\t");
            sb.append(lnsHum[i]);
            sb.append("\t");
            sb.append(mapChr.get(chrName));
            sb.append("\t");
            sb.append("other");
            sb.append("\n");
            fw.write(sb.toString());

            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }


}
