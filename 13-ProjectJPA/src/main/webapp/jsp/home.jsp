<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
  <jsp:include page="fragments/header.jsp" />
  <div class="container w-50">
    <h1>Home Page</h1>
        <div class="w-50 m-3">
            <p><strong>Nome: </strong> ${userLogin.name} ${userLogin.lastName}</p>
            <p><strong>Email: </strong> ${userLogin.email}</p>
            <p><strong>Età: </strong> ${userLogin.age}</p>
            <p><strong>Città: </strong> ${userLogin.address.city}</p>
            <p><strong>Via: </strong> ${userLogin.address.street}</p>
            <p><strong>Stato: </strong> ${userLogin.address.state}</p>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>