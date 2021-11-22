<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.revature.project.dao.ReimbursementDAOImp, com.revature.project.model.*,java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reimbursement Form</title>
<link href="./assets/dist/css/bootstrap.min.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="navbar.css" rel="stylesheet">


</head>

<br></br>
<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="offcanvasNavbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu" aria-labelledby="offcanvasNavbarDropdown">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </div>
  </div>
</nav>


<%
List<User> listUsers=ReimbursementDAOImp.getRdao().getAllUsers();
request.setAttribute("user",listUsers);
%>


<body>
	<h1 style="color: black; text-align: center;">Reimbursement Form</h1>
	<form action="/reimbursement" method="post">
		<table cellpadding="3pt">
			<tr>
				<td>Amount :</td>
				<td><input type="text" name="amountRequested" size="30" /></td>
			</tr>

			<tr>
				<td sytle="">Comments :</td>
				<td><input type="text" name="employeeComments" size="60" /></td>
			</tr>
		<select name="users">
        <c:forEach items="${listUsers}" var="users">
            <option value="${users.id}">${users.userName}</option>
        </c:forEach>
    </select>
		</table>
		<p />
		<input type="submit" value="Submit" />
	</form>
	
</body>
</html>