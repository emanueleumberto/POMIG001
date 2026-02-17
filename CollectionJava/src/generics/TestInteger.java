package generics;

public class TestInteger {

    private Integer val;

    public TestInteger(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TestInteger{" +
                "val=" + val +
                '}';
    }
}
