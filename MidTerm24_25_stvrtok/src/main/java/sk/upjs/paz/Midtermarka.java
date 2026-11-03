package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class Midtermarka extends Turtle {
    public boolean divisibleDigitsSums(int m, int n){
        int sucet1=0;
        int sucet2=0;
        int tempNum1=m;
        int tempNum2=n;

        while (tempNum1>0){
            sucet1+=tempNum1%10;
            tempNum1=tempNum1/10;
        }

        while (tempNum2>0){
            sucet2+=tempNum2%10;
            tempNum2=tempNum2/10;
        }

        return ((Math.max(sucet1,sucet2)%Math.min(sucet1,sucet2))==0);
    }
}
