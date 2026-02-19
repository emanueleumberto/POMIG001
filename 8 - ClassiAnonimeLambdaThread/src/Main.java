import ThreadExample.TestCharThread;
import ThreadExample.TestRunnable;
import ThreadExample.TestThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Lambda Expression
        // Una funzione Lambda è una funzione anonima che possiamo passare come argomento di un metodo
        // Le espressioni Lambda introdotto da Java 8
        // permettono la scrittura di codice più compatto migliorandone la leggibilità

        // () -> { blocco di istruzioni }
        // (param) -> { blocco di istruzioni }
        // (param1, param2, ..., paramN) -> { blocco di istruzioni }

        // Per poter comprendere meglio le espressioni lambda è necessario comprendere cosa
        // sono le interfacce funzionali

        // Le Functional interface sono delle interfacce che definiscono un solo metodo
        // Le interfacce funzionali hanno l'annotazione @FunctionalInterface che indica
        // al compilatore che si tratta di una interfaccia funzionale

        // Le funzioni Lambda ci permettono di scrivere codice che fa uso di classi anonime
        // in modo molto più compatto e leggibile permettendo una significativa riduzione del codice


        // Soluzione 1
        ClasseConcreta c = new ClasseConcreta();
        stampaMessaggio(c);
//        TestMessage t = new TestMessage();
//        stampaMessaggio(t);

        // Soluzione 2
        stampaMessaggio(new ClasseConcreta());

        // Soluzione 3
        stampaMessaggio(new IMessage() {
            @Override
            public String getMessage() {
                return "Messaggio da Classe Anonima";
            }
        });

        // Soluzione 4 -> Solo se ho delle interfacce funzionali
        stampaMessaggio(() -> "Messaggio Lambda Anonima");

        // Thread
        // Un Thread rappresenta un flusso di esecuzione indipendente dello stesso programma
        // Una applicazione Java può eseguire più operazioni
        // contemporaneamente condividendo la stessa memoria
        // Ogni programma Java contiene almeno un thread -> Main Thread

        // Perchè i Thread sono importanti
        // -> Sfruttano CPU multi-core
        // -> Permettone elaborazioni in parallelo
        // -> UI non bloccata
        // -> Server capaci di gestire più utenti contemporaneamente

        TestThread t1 = new TestThread("Primo Thread");
        TestThread t2 = new TestThread("Secondo Thread");
        TestCharThread t3 = new TestCharThread();
        Thread t4 = new Thread(new TestRunnable("Runnable Thread"));
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        log.info("Thread anonimo! ");
                        Thread.sleep(100);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t6 = new Thread(() -> log.info("Thread Lambda! "));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        log.info("Fine");
    }

    public static void stampaMessaggio(IMessage o) {
        System.out.println(o.getMessage());
    }
}