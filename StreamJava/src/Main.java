import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Lo Stream è un interfaccia che mi restituisce un flusso di dati
        // su cui è possibile fare delle operazioni

        // La sorgente di uno Stream è l'elemento che lo genera
        // Collection, Array, Stream

        Collection<String> c = new ArrayList<>();
        c.add("Java");
        c.add("Javascript");
        c.add("Python");
        c.add("C#");
        c.add("NodeJS");
        c.add("Php");

        String[] arr = {"Java", "Javascript", "Python", "C#", "NodeJS", "Php"};
        String[] arrCollection = c.toArray(String[]::new); // Cast da una Collection ad un array
        List<String> listArr = Arrays.asList(arr); // Cast da un array ad una Collection
        List<String> lista = Arrays.asList("Java", "Javascript", "Python", "C#", "NodeJS", "Php");

//        Random rand = new Random();
//        double d = rand.nextDouble();
//        System.out.println(d);
//
//        double d = new Random().nextDouble();
//        double d = new Random()::nextDouble;

        // Sorgente di uno Stream
        Stream<String>  myStream1 = c.stream();
        Stream<String>  myStream2 = lista.stream();
        Stream<String>  myStream3 = Stream.of("Java", "Javascript", "Python", "C#", "NodeJS", "Php");
        Stream<Integer> myStream4 = Stream.iterate(0, n -> n + 2).limit(10);
        Stream<Double>  myStream5 = Stream.generate(new Random()::nextDouble).limit(10);
        Stream<String>  myStream6 = Stream.<String>builder().add("Java").add("Javascript"). add("Python").build();

        // myStream5.forEach(System.out::println); // e -> System.out.println()

        // Posso operare su uno Stream in due modi
        // -> Tramite operazioni intermedie
        // -> Tramite operazioni finali

        // Operazioni intermedie
        // Sono tutte quelle operazioni che effettuano delle trasformazioni allo Stream e
        // che restituiscono uno stream modificato
        // Le operazioni intermedie possono essere concatenate e la concatenazione di queste operazioni viene chiamata pipeline
        // Le operazioni intermedie si dividono in:
        //  -> iteration
        //  -> filtering
        //  -> mapping

        Stream<String> myStream = Stream.of("Java", "Javascript", "Python", "C#", "Java", "NodeJS", "Php");
//        Stream<String> myStreamDistinct = myStream.distinct();
//        Stream<String> myStreamFilter = myStreamDistinct.filter(str -> str.length() > 3);
//        Stream<String> myStreamSorted = myStreamFilter.sorted();
//        myStreamSorted.forEach(System.out::println);
        List<String> listaMod = myStream.distinct()
                .filter(str -> str.length() > 3)
                .map(str -> str + "!!!")
                .sorted()
                .limit(3)
                //.forEach(System.out::println);
                .toList();

        // listaMod.forEach(System.out::println);

        List<User> userList = new ArrayList<>();
        userList.add(new User("Mario","Rossi","Roma", 45));
        userList.add(new User("Giuseppe","Verdi","Milano", 21));
        userList.add(new User("Francesca","Neri","Napoli", 32));
        userList.add(new User("Antonio","Bianchi","Roma", 29));
        userList.add(new User("Simona","Viola","Palermo", 40));

        userList.get(0).getHobby().add("Calcio");
        userList.get(0).getHobby().add("Padel");
        userList.get(2).getHobby().add("Calcio");
        userList.get(3).getHobby().add("Golf");
        userList.get(3).getHobby().add("Calcio");
        userList.get(1).getHobby().add("Padel");
        userList.get(1).getHobby().add("Calcio");
        userList.get(4).getHobby().add("Tennis");

        //userList.forEach(System.out::println);
        //userList.get(0).getHobby().forEach(System.out::println);

        // Vecchio metodo senza l'utilizzo degli Stream
//        List<User> utentiFiltrati = new ArrayList<>();
//        for (int i = 0; i < userList.size(); i++) {
//            if(userList.get(i).getAge() > 30){
//                utentiFiltrati.add(userList.get(i));
//            }
//        }
//
//        utentiFiltrati.forEach(System.out::println);
//
//        System.out.println("---------------------------");

        // Utilizzo degli Stream
        userList.stream().filter(u -> u.getAge() > 30).forEach(System.out::println);
        OptionalInt maxAge = userList.stream()
                .mapToInt(User::getAge)
                .max();
        System.out.println("L'età massima degli utenti nella lista è: " + maxAge.getAsInt());

        double avg = userList.stream()
                .mapToInt(User::getAge)
                //.max()
                //.min()
                //.sum()
                .average()
                .orElse(0);
        System.out.println("L'età media degli utenti nella lista è: " + avg);

        userList.stream()
                .flatMap(u -> u.getHobby().stream())
                .distinct()
                .forEach(System.out::println);

        // Comparators
        // Comparator è un metodo per la gestione avanzata degli ordinamenti di uno Stream
        // .sorted(Comparator.comparing(Obj::Prop))
        // .sorted(Comparator.comparingInt(Obj::PropInt))
        // .sorted(Comparator.comparingLong(Obj::PropLong))
        // .sorted(Comparator.comparingDouble(Obj::PropDouble))

        List<User> userListSortedByAge = userList.stream().sorted(Comparator.comparingInt(User::getAge)).toList();
        userListSortedByAge.forEach(System.out::println);

        // Operazioni finali
        // Sono tutte quelle operazioni che restituiscono un valore finale
        // terminando la manipolazione dello Stream

        // Le operazioni finali si dividono in:
        // -> Matching
        // -> Reduction
        // -> Collection

        // Reduction

        // Soluzione senza Stream
int[] arrNum = {0,2,4,6,8,10,12,14,16,18};
//        int acc = 0;
//        for (int i = 0; i < arrNum.length; i++) {
//            acc += arrNum[i];
//        }

        // Soluzione CON Stream
        int res = Arrays.stream(arrNum).reduce(0, (acc, val) -> acc + val);
        System.out.println("La somma di tutti i valori contenuti in myStreamNum è: " + res);

        // Matching
        boolean any = Arrays.stream(arrNum).anyMatch(v -> v > 5); // true
        boolean all = Arrays.stream(arrNum).allMatch(v -> v > 5); // false
        boolean none = Arrays.stream(arrNum).noneMatch(v -> v > 5); // false
        System.out.println("anyMatch -> v > 5: " + any);
        System.out.println("allMatch -> v > 5: " + all);
        System.out.println("noneMatch -> v > 5: " + none);

        boolean calcio = userList.stream().allMatch(u -> u.getHobby().contains("Calcio"));
        System.out.println("Tutti gli utenti hanno come hobby il calcio?: " + calcio);

        // Collection
        // .collect(Collectors)


        Stream<String> s = Stream.of("Java", "Javascript", "Python", "C#", "Java", "NodeJS", "Php");
        Set<String> prog = s.sorted().collect(Collectors.toSet());
        prog.forEach(System.out::println);

        // Collectors
        // Collectors.toSet() -> .toSet() -> Raccoglie tutti i dati manipolati da uno Stream in una Collection di tipo Set<E>
        // Collectors.toList() -> .toList() -> Raccoglie tutti i dati manipolati da uno Stream in una Collection di tipo List<E>
        // Collectors.toMap() -> .toMap() -> Raccoglie tutti i dati manipolati da uno Stream in una Map<K,V>
        // Collectors.groupingBy() -> Raggruppa gli elementi di uno Stream in una mappa in cui
        //                          la chiave sarà la proprietà per il quale voglio raggruppare,
        //                          il valore sarà una lista di elementi raggruppati.
        // Collectors.summingInt() -> Calcola la somma dei valori int contenuti in uno Stream
        // Collectors.summingLong() -> Calcola la somma dei valori long contenuti in uno Stream
        // Collectors.summingDouble() -> Calcola la somma dei valori double contenuti in uno Stream
        // Collectors.averageInt() -> Calcola la media dei valori int contenuti in uno Stream
        // Collectors.averageLong() -> Calcola la media dei valori long contenuti in uno Stream
        // Collectors.averageDouble() -> Calcola la media dei valori double contenuti in uno Stream

        Map<String, List<User>> utentiPerCitta = userList.stream().collect(Collectors.groupingBy(User::getCity));
        utentiPerCitta.forEach((key, val) -> System.out.println(key + " -> " + val));

        double userAvg = userList.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println("La media delle età degli utenti nella lista è: " + userAvg);

    }

    public static void testLambdaFunction() {
        // () -> { blocco di istruzioni }
        // (param) -> { blocco di istruzioni }
        // (param1, param2, ..., paramN) -> { blocco di istruzioni }

        // Le espressioni Lambda introdotto da Java 8
        // permettono la scrittura di codice più compatto migliorandone la leggibilità


        List<String> lista = Arrays.asList("Java", "Javascript", "Python", "C#", "NodeJS", "Php");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(0));
        }

        for (String s : lista) {
            System.out.println(s);
        }

        lista.forEach(e -> System.out.println(e));
        lista.forEach(e -> {
            if(e.length() > 5) {
                System.out.println(e);
            } else {
                e += "!!";
                System.out.println(e);
            }
        });
    }

}

