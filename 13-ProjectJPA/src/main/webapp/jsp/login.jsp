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
    <h1>Login Page</h1>
        <form action="/login" method="POST">
            <div class="mb-3">
                <input type="email" name="email" class="form-control" placeholder="Email...">
            </div>
            <div class="mb-3">
                <input type="password" name="password" class="form-control" placeholder="Password...">
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" name="check" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3" role="alert">${error}</div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success mt-3" role="alert">${success}</div>
        </c:if>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>