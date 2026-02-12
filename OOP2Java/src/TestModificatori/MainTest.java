package TestModificatori;

public class MainTest {
    public static void main(String[] args) {
        Test t = new Test("public", "package", "protected", "private");
        System.out.println("Public: " + t.var1);
        System.out.println("Private: ");
        System.out.println("Package: " + t.var2);
        System.out.println("Protected: " + t.var3);
    }
}
