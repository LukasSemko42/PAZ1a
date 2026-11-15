package sk.upjs.paz;

public class Bod{
    private double x;
    private double y;

    public Bod(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public String toString(){
        return "["+x+","+y+"]";
    }

    public void nastav(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void nastav(Bod bod){
        this.x = bod.getX();
        this.y = bod.getY();
    }

    public boolean rovnakeSuradnice(Bod bod){
        return x == bod.getX() && y == bod.getY();
    }

    public double vzdialenostK(double x, double y){
        return Math.sqrt(Math.pow((x-this.x),2)+Math.pow((y-this.y),2));
    }

    public double vzdialenostK(Bod bod){
        return Math.sqrt(Math.pow(bod.getX()-this.x,2)+Math.pow(bod.getY()-this.y,2));
    }

    public void posunO(double dx, double dy){
        this.x+=dx;
        this.y+=dy;
    }

    public Bod posunutyBod(double dx, double dy){
        return new Bod(this.x+dx,this.y+dy);
    }
}
