<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<html>
    <body>
        <h2>Ciao a tutti!!!</h2>
        <a href="test.html">Test</a>

        <p>
            Le JSP (Java Server Pages) sono pagine dinamiche che utilizzano le scriptlet
            importantissime nello sviluppo di applicazioni web dinamiche
            Le JSP sono un mix di pagine HTML e codice Java

            Il codice java per essere interpretato, deve essere inserito in <% %>
            Questo blocco di codice viene chiamato scriptlet

        </p>
        <%
            String txt = "Sono una scriptlet!!";
            out.print(txt);
        %>

        <h2> Scriptlet: Codice Java che esegue all interno della pagina JSP</h2>
        <p>Le scriptlet genriche mi permettono ldi scrivere tutto il codice Java in una pagina JSP</p>
        <%

              // Definizione di una variabile Java
              String saluto = "Ciao, Mondo!";
              Date data = new Date();
              for(int i=0; i<3; i++) {
                   out.print(saluto.toLowerCase() + " - " + data);
              }

        %>

        <h2> Direttive - Scriptlet  -> <code>@ elenco direttive </code></h2>
        <p>Le direttive sono scriptlet che consentono di specificare alcune caratteristiche
            per il corretto funzionamento della pagina</p>

        <h2> Espressioni - Scriptlet  -> <code>= espressione </code></h2>
        <p>Le espressioni sono scriptlet che restituiscono il valore di una variabile o una espressione</p>
        <p>Saluto: <%= saluto %> oggi è il giorno: <%= data %>

        <h2> Dichiarazioni - Scriptlet  -> <code>! dichiarazione </code></h2>
        <p>Le dichiarazioni vengono utilizzate per dichiarare variabili o attributi nella jsp</p>

        <%! String pagina = "Sono una pagina JSP"; %>
        <%= "Il valore della variabile pagina è: " +  pagina %>

        <h2> Commento - Scriptlet  -> <code>-- commento </code></h2>
        <%-- Scriptlet: Codice Java che esegue all interno della pagina JSP --%>

    </body>
</html>
