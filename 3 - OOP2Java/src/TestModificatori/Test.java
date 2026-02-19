package TestModificatori;

public class Test {

    public String var1;
    String var2; // Modificatore di accesso Package o Default
    protected String var3;
    private String var4;

    public Test(String var1, String var2, String var3, String var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public void testModificatoriAccesso() {
        System.out.println("Public: " + this.var1);
        System.out.println("Private: " + this.var4 );
        System.out.println("Package: " + this.var2);
        System.out.println("Protected: " + this.var3);
    }
}
