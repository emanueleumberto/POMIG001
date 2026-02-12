import TestModificatori.Test;

public class TestFiglio extends Test {
    public TestFiglio(String var1, String var2, String var3, String var4) {
        super(var1, var2, var3, var4);
    }

    public void testModificatoriAccesso() {
        System.out.println("Public: " + this.var1);
        System.out.println("Private: ");
        System.out.println("Package: ");
        System.out.println("Protected: " + this.var3);
    }
}
