package string;

public class Transfer {
    public static void main(String[] args) {
        String s = "We are happy.";
        Transfer t = new Transfer();
        System.out.println(t.replaceSpace(s));


    }


    public String  replaceSpace(String s){
        int len = s.length();
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<len;i++){
            char a = s.charAt(i);
            if(a == ' ')
                sb.append("%20");
            else
                sb.append(a);
        }
        return sb.toString();


    }

}


