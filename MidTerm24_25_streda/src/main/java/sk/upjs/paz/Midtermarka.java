package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class Midtermarka extends Turtle {
    public boolean digitsMultiplied(int n){
        String s = String.valueOf(n);

        for (int i = 0; i < s.length(); i++) {
            int c1=s.charAt(i);
            int c2=s.charAt(i+1);

            if (c2==0 || c1%c2!=0){
                return false;
            }
        }
        return true;
    }

    public int finePasswords(String s){
        String[] slova = s.split(" ");
        int count=0;

        for (String slovo : slova){
            boolean hasUpper=false;
            boolean hasLower=false;
            boolean hasDigit=false;

            for (int i = 0; i < slovo.length(); i++) {
                if (Character.isUpperCase(slovo.charAt(i))){
                    hasUpper=true;
                }
                if (Character.isLowerCase(slovo.charAt(i))){
                    hasLower=true;
                }
                if (Character.isDigit(slovo.charAt(i))){
                    hasDigit=true;
                }
            }
            if (hasDigit && hasLower && hasUpper) count++;
        }
        return count;
    }

}
