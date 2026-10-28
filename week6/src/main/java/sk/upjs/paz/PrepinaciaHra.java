package sk.upjs.paz;

import java.awt.Color;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.*;

public class PrepinaciaHra extends WinPane {
    private int[][] doska = new int[6][6];
    private boolean hraBezi = true;

    public PrepinaciaHra() {
        this.kresliMriezku();
        this.randomStart();
        this.zamiesaj(30);
        this.kresliDosku();
    }

    public void randomStart() {
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska[i].length; j++) {
                doska[i][j] = (Math.random() <= 0.5) ? 0 : 1;
            }
        }
    }

    public void kresliMriezku() {
        Turtle k = new Turtle();
        this.add(k);

        for (int i = 1; i < 6; i++) {
            k.setPosition(i * 50, 0);
            k.moveTo(i * 50, this.getHeight());
        }

        for (int i = 1; i < 6; i++) {
            k.setPosition(0, i * 50);
            k.moveTo(this.getWidth(), i * 50);
        }

        this.remove(k);
    }

    public void kresliDosku() {
        Turtle k = new Turtle();
        this.add(k);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (doska[i][j] == 0) {
                    k.setFillColor(Color.red);
                } else {
                    k.setFillColor(Color.blue);
                }
                k.setPosition(i * 50 + 25, j * 50 + 25);
                k.dot(22);
            }
        }
        this.remove(k);
    }

    public boolean dobraSuradnica(int r, int s) {
        return (r >= 0) && (r < 6) && (s >= 0) && (s < 6);
    }

    public void tah(int r, int s) {
        int[][] smery = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        if (hraBezi && dobraSuradnica(r, s)) {
            for (int i = 0; i < 4; i++) {
                int nx = r + smery[i][0];
                int ny = s + smery[i][1];
                if (dobraSuradnica(nx, ny)) {
                    if (doska[nx][ny] == 0) {
                        doska[nx][ny] = 1;
                    } else {
                        doska[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public void zamiesaj(int pocetMiesani) {
        for (int i = 0; i < pocetMiesani; i++) {
            tah((int) (Math.random() * 6), (int) (Math.random() * 6));
        }
    }

    public boolean jeVyherna() {
        int vzor = doska[0][0];
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska[i].length; j++) {
                if (doska[i][j] != vzor) {
                    return false;
                }
            }
        }
        this.hraBezi = false;
        return true;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (hraBezi) {
            tah(x / 50, y / 50);
            kresliDosku();
            jeVyherna();
        }
    }
}