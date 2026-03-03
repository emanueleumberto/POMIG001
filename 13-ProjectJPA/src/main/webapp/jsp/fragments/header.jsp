<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </div>
      </div>

       <c:choose>
           <c:when test="${not empty userLogin}">

            <span class="navbar-nav">
               <a class="nav-link" href="/user"> Hello <c:out value="${userLogin.name}" />!</a>
               <a class="nav-link" href="/logout">logout</a>
            </span>
           </c:when>
           <c:otherwise>
               <span class="navbar-nav">
                     <a class="nav-link" href="/login">login</a>
                     <a class="nav-link" href="/register">register</a>
               </span>
           </c:otherwise>
       </c:choose>
    </div>
  </nav>