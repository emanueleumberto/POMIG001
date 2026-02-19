import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //stampaRisultato();
        try {
            stampaRisultato();
        } catch (ArithmeticException e) {
            System.err.println("Non puoi fare una divisione per 0");
        } catch (NumberFormatException e) {
            System.err.println("Non puoi inserire una stringa");
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore Generico!!!");
        }
    }

    public static int calcolaDivisione() throws CustomException {
        System.out.print("Inserisci un numero: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int y = Integer.parseInt(sc.nextLine());
        int div = x / y;
        if(div < 10 ) {
            // Sollevo una eccezione al verificarsi di una determinata condizione
            // throw new IllegalArgumentException("Valore minor di 10");
            throw new CustomException("Valore minore di 10!!");
        }
        return div;
//        try {
//            int div = x / y;
//            return div;
//        } catch (Exception e) {
//            System.err.println("Errore!!!");
//        }
//        return 0;
    }

    public static void stampaRisultato() throws CustomException {
        int risultato = calcolaDivisione();
        System.out.println("La divisione è: " + risultato);
//        try {
//            int risultato = calcolaDivisione();
//            System.out.println("La divisione è: " + risultato);
//        } catch (Exception e) {
//            System.err.println("Errore!!!");
//        }
    }
}