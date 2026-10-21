package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class ExamTurtle extends Turtle {
//    public int sumOfSmallerDigits(int n, int maxDigit){
//        int result=0;
//        while (n>=1){
//            if (n%10 < maxDigit){
//                result += n%10;
//            }
//            n=n/10;
//        }
//        return result;
//    }
//    PISOMKA 3:
//    public boolean isPerfectNumber(int n){
//        int sucet=0;
//        for (int i = 1; i <= n; i++) {
//            if (n%i==0){
//                sucet+=i;
//            }
//        }
//        if (sucet==(2*n)){
//            return true;
//        } else return false;
//    }

    //desatminutovka 4:

    public String hviezdickovac(String s, char znak){
        if (s==null || znak==' '){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==znak){
                sb.append("*");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String longestPrefix(String s1, String s2){
        String[] s1pre = new String[s1.length()+1];
        String[] s2pre = new String[s2.length()+1];

        for (int i = 0; i <= Math.min(s1.length(),s2.length()); i++) {
            s1pre[i]=s1.substring(0,i);
            s2pre[i]=s2.substring(0,i);
        }
        int index=0;

        for (int i = 0; i < Math.min(s1pre.length,s2pre.length); i++) {
            if (s1pre[i].equals((s2pre[i])) && s1pre[i]!=null){
                index=i;
            }
        }
        return s1pre[index];
    }

    public boolean orderedLetters(String s){
        String str = s.replaceAll("\\s+", "");
        str = str.replaceAll("_", "");
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length()-1; i++) {
            char a=chars[i];
            char b=chars[i+1];
            if ((int)a<=(int)b){
                continue;
            } else return false;
        }
        return true;
    }
}
