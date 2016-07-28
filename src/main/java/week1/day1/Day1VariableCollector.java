package main.java.week1.day1;

/**
 * Created by Ari on 7/11/16.
 */
public class Day1VariableCollector {

    String s = ("Hello World");
    int x = 100;
    boolean isGreen = true;
    long complex = 99999;
    char b = 'v';
    char[] ca = {'a', 'b', 'c'};


    String getS () {
        return s;

    }

    void setS(String newS) {
        s = newS;
    }

    public int getX() {
        return x;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public long getComplex() {
        return complex;
    }

    public char getB() {
        return b;
    }

    public char[] getCa() {
        return ca;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public void setComplex(long complex) {
        this.complex = complex;
    }

    public void setB(char b) {
        this.b = b;
    }

    public void setCa(char[] ca) {
        this.ca = ca;
    }
}
