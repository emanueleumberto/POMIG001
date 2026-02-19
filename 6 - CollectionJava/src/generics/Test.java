package generics;

public class Test<T, K> {

    private T val;
    private String txt;
    private K x;

    public Test(T val) {
        this.val = val;
    }

    public Test(T val, String txt) {
        this.val = val;
        this.txt = txt;
    }

    public Test(T val, String txt, K x) {
        this.val = val;
        this.txt = txt;
        this.x = x;
    }

    public T getVal() {
        return val;
    }
    public void setVal(T val) {
        this.val = val;
    }

    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }

    public K getX() {
        return x;
    }
    public void setX(K x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Test{" +
                "val=" + val +
                ", txt='" + txt + '\'' +
                ", x=" + x +
                '}';
    }
}
