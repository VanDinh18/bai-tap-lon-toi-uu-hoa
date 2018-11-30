package Main;

public class Bucket {
    private int a = -1;
    private int b = -1;
    private int c = -1;

    public Bucket(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Bucket(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Bucket(){}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
