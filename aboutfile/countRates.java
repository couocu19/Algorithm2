package aboutfile;

public class countRates {
    public static void main(String[] args) {
        double[] ln = {230218,813184,316620,1531933,576874,270161,1090940,562643,439888,745751,666816,778177,924431,784333,1091291,948066,85779};
        double[] rates1 = {0.6076545,0.690484,0.6909987,0.6629918,0.6673762,0.6479506,0.6603223,0.6566526,0.6508839,0.6764966,0.6673205,0.6489295,0.6869220,0.6987389,0.6690351,0.6766586,0.6457991};
        double[] rates2 = {0.1483039,0.2134043,0.1917820,0.2118513,0.1934807,0.1902162,0.2029974,0.2008929,0.2042134,0.2009679,0.2206261,0.2047892,0.2069046,0.2103176,0.2062860,0.2001253,0.0220100};
        double[] rates3 = {0.0482152,0.0738750,0.0680974,0.0762227,0.0690532,0.0637102,0.0727483,0.0713810,0.0701883,0.0673697,0.0797671,0.0731646,0.0667816,0.0688700,0.0739519,0.0671082,0.0057706};
        int total_len = 0;
        int len1 = ln.length;
        for(int i = 0;i<len1;i++){
            total_len += ln[i];
        }
        double avg_r1 = 0;
        double avg_r2 = 0;
        double avg_r3 = 0;
        for(int i = 0;i<len1;i++){
            avg_r1 +=  (ln[i]/total_len) * rates1[i];
            avg_r2 +=  (ln[i]/total_len) * rates2[i];
            avg_r3 +=  (ln[i]/total_len) * rates3[i];

//            System.out.println(avg_r1);
//            System.out.println(avg_r2);
//            System.out.println(avg_r3);

        }
        System.out.println(total_len);
        System.out.println(avg_r1);
        System.out.println(avg_r2);
        System.out.println(avg_r3);





    }
}
