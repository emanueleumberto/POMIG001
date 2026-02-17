package generics;

public class TestString {

    private String val;

    public TestString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TestString{" +
                "val='" + val + '\'' +
                '}';
    }
}
