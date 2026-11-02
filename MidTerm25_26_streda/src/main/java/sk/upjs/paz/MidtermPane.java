package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class MidtermPane extends WinPane {
    Turtle[] korytnacky = new Turtle[20];

    public MidtermPane() {
        for (int i = 0; i < korytnacky.length; i++) {
            korytnacky[i]=new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(this.getWidth()*Math.random(),this.getHeight()*Math.random());
            korytnacky[i].setDirection((int)(Math.random()*8)*45);
        }
    }

    public double popularDirection(){
        double[] angles = new double[korytnacky.length];
        int[] count = new int[8];

        for (int i = 0; i < korytnacky.length; i++) {
            angles[i]=korytnacky[i].getDirection();
        }

        for (double uhol : angles) {
            if (uhol == 0){
                count[0]++;
            } else if (uhol == 45){
                count[1]++;
            } else if (uhol == 90){
                count[2]++;
            }  else if (uhol == 135){
                count[3]++;
            }  else if (uhol == 180){
                count[4]++;
            }  else if (uhol == 225){
                count[5]++;
            }   else if (uhol == 270){
                count[6]++;
            } else count[7]++;
        }

        int maxIndex=0;

        for (int i = 0; i < count.length; i++) {
            if (count[i]>count[maxIndex]){
                maxIndex=i;
            }
        }

        return maxIndex*45;
    }
}
