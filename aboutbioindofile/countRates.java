package aboutbioindofile;

public class countRates {
    public static void main(String[] args) {
        double[] ln = {230218,813184,316620,1531933,576874,270161,1090940,562643,439888,745751,666816,1078177,924431,784333,1091291,948066,85779};
        double[] rates1 = {0.6076545,0.690484,0.6909987,0.6629918,0.6673762,0.6479506,0.6603223,0.6566526,0.6508839,0.6764966,0.6673205,0.6489295,0.6869220,0.6987389,0.6690351,0.6766586,0.6457991};
        double[] rates2 = {0.1483039,0.2134043,0.1917820,0.2118513,0.1934807,0.1902162,0.2029974,0.2008929,0.2042134,0.2009679,0.2206261,0.2047892,0.2069046,0.2103176,0.2062860,0.2001253,0.0220100};
        double[] rates3 = {0.0482152,0.0738750,0.0680974,0.0762227,0.0690532,0.0637102,0.0727483,0.0713810,0.0701883,0.0673697,0.0797671,0.0731646,0.0667816,0.0688700,0.0739519,0.0671082,0.0057706};
        double[] rates5= {0.8326152,0.9774910
        ,0.9848241
        ,0.9665906
        ,0.9526101,0.9372892
        ,0.9498469
        ,0.9338977
        ,0.9197978
        ,0.9342194
        ,0.9630063
        ,0.9118337
        ,0.9604124
        ,0.9596001
        ,0.9510406
        ,0.9525940
        ,0.6278343
        };

        double[] rates6 = {	0.1472952,
                0.1645052,
                0.1784284,
                0.1551001,
                0.1560791,
                0.1577134,
                0.1534493,
                0.1548389,
                0.1514022,
                0.1563297,
                0.1579701,
                0.1733778,
                0.1585548,
                0.1569945,
                0.1646371,
                0.1544175,
                0.1639446};

        double[] rates4 = {
                0.0042004,
                0.0014941,
                0.0010865,
                0.0023088,
                0.0016780,
                0.0030389,
                0.0021669,
                0.0055346,
                0.0037873,
                0.0028092,
                0.0017216,
                0.0152472,
                0.0017016,
                0.0026468,
                0.0041025,
                0.0012246,
                0.0295410};

        double[] rates7 ={
                0.1677280,
                0.1850799,
                0.2004074,
                0.1757140,
                0.1803253,
                0.1791857,
                0.1757924,
                0.1726352,
                0.1702479,
                0.1772026,
                0.1809765,
                0.1896683,
                0.1835032,
                0.1773418,
                0.1882294,
                0.1776575,
                0.1836347
        };

        double[] rates8 = {
                0.0056772,
                0.0016872,
                0.0018697,
                0.0023167,
                0.0021946,
                0.0040939,
                0.0025693,
                0.0044415,
                0.0049831,
                0.0037211,
                0.0020770,
                0.0114527,
                0.0018552,
                0.0028151,
                0.0049675,
                0.0024914,
                0.0334464
        };

        double[] rates9 = {
                0.0035836,
                0.0015851,
                0.0018224,
                0.0020947,
                0.0028880,
                0.0025503,
                0.0023613,
                0.0036897,
                0.0041715,
                0.0024298,
                0.0016301,
                0.0108841,
                0.0014344,
                0.0023408,
                0.0034455,
                0.0017035,
                0.0270929
        };
        //调参后的rates
        double[] rates10 = {
                0.8449643,
                0.9805936,
                0.9873981,
                0.9697546,
                0.9570426,
                0.9410722,
                0.9522274,
                0.9367805,
                0.9253060,
                0.9377111,
                0.9656667,
                0.9147854,
                0.9621518,
                0.9616272,
                0.9536998,
                0.9533724,
                0.6457991
        };

        double[] rates11 = {
                0.0049084,
                0.0015987,
                0.0020277,
                0.0019779,
                0.0017213,
                0.0039791,
                0.0023411,
                0.0042283,
                0.0041465,
                0.0032383,
                0.0015956,
                0.0119498,
                0.0019774,
                0.0023064,
                0.0028315,
                0.0021391,
                0.0310799
        };

        double[] rates12 = {
                0.1574725,
                0.1705002,
                0.1807687,
                0.1581375,
                0.1576167,
                0.1686698,
                0.1598869,
                0.1611501,
                0.1528434,
                0.1609022,
                0.1616458,
                0.1727861,
                0.1638435,
                0.1586405,
                0.1710515,
                0.1558098,
                0.1865025
        };


        int total_len = 0;
        int len1 = ln.length;
        for(int i = 0;i<len1;i++){
            total_len += ln[i];
        }
        double avg_r1 = 0;
        double avg_r2 = 0;
        double avg_r3 = 0;
        double avg_r4 = 0;
        for(int i = 0;i<len1;i++){
            avg_r1 +=  (ln[i]/total_len) * rates9[i];
            avg_r2 +=  (ln[i]/total_len) * rates11[i];
            avg_r3 +=  (ln[i]/total_len) * rates12[i];
            avg_r4 +=  (ln[i]/total_len) * rates10[i];
//            System.out.println(avg_r1);
//            System.out.println(avg_r2);
//            System.out.println(avg_r3);

        }
        System.out.println(total_len);
        System.out.println(avg_r2);
        System.out.println(avg_r3);
        System.out.println(avg_r4);





    }
}
