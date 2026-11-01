package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class Midtermarka extends Turtle {

    public void mon (double sideLength, int levels){
        double size=sideLength/levels;
        for (int i = levels; i > 0; i--) {
            this.oneLevel(size,i);
            this.turn(30);
            this.step(size);
            this.turn(-30);
        }
        this.turn(30);
        this.step(-sideLength);
        this.turn(60);
        this.step(sideLength/2);
        this.turn(-90);
    }
    public void triangle(double size){
        this.setFillColor(Color.yellow);
        this.penUp();
        this.openPolygon();
        this.turn(30);
        for (int i = 0; i < 3; i++) {
            this.step(size);
            this.turn(120);
        }
        this.turn(-30);
        this.closePolygon();
    }

    public void oneLevel(double size, int n){
        this.penUp();
        for (int i = 0; i < n; i++) {
            this.triangle(size);
            this.turn(90);
            this.step(size);
            this.turn(-90);
        }
        this.turn(-90);
        this.step(n*size);
        this.turn(90);
    }

    public int goldbach(int n) {
        if (n <= 2 || n % 2 != 0) {
            return 0;
        }

        int maxPrime = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                int currentMax = Math.max(i, n - i);
                if (currentMax > maxPrime) {
                    maxPrime = currentMax;
                }
            }
        }
        return maxPrime;
    }

    public boolean isPrime(int n) {
        int count = 0;
        if (n < 1) {
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else return false;
    }

    public boolean subsequence(String s1, String s2) {
        int indexS1 = 0;
        int indexS2 = 0;

        while (indexS1 < s1.length() && indexS2 < s2.length()) {
            if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
                indexS1++;
            }
            indexS2++;
        }
        return indexS1 == s1.length();
    }
}
