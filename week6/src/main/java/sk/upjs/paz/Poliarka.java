package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.util.Arrays;

public class Poliarka extends Turtle {
    int[] pole;

    public Poliarka(){
    }

    public double priemer(int[] pole){
        int sucet=0;
        for (int x:pole){
            sucet+=x;
        }
        return (double) sucet /pole.length;
    }

    public int pocetOpakovani(int[] pole,int cislo){
        int count=0;
        for (int x:pole){
            if (x==cislo){
                count++;
            }
        }
        return count;
    }

    public int[] zdvojPole(int[] pole){
        int index=0;
        int[] novePole=new int[pole.length*2];
        for (int i = 0; i < novePole.length; i++) {
            if (i%2==0 && i!=0){
                index++;
            }
            novePole[i]=pole[index];
        }
        return novePole;
    }

    public boolean jeNeklesajuce(int[] pole){
        for (int i = 0; i < pole.length-1; i++) {
            if (pole[i+1]<pole[i]){
                return false;
            }
        }
        return true;
    }

    public int indexNajmensieho(int[] pole,int start, int koniec){
        int najmensieCislo=Integer.MAX_VALUE;
        int index=0;
        for (int i = start; i <= koniec ; i++) {
            if (pole[i]<najmensieCislo) {
                najmensieCislo=pole[i];
                index=i;
            }
        }
        return index;
    }

    public void vymen(int[] pole,int idx1, int idx2){
        int temp=pole[idx1];
        pole[idx1]=pole[idx2];
        pole[idx2]=temp;
    }

}
