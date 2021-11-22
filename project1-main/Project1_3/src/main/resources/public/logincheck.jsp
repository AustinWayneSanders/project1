<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DB Page</title>
</head>
<body>
	<%
	String username = request.getParameter("email");
	String password = request.getParameter("pass");
	if (username == null || username.trim().equals("")) {
		out.print("Please enter email");
	} else {
		//int id = Integer.parseInt(s);
		//out.print(id);
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://projectonedb.ctc7aq5bma3z.us-east-2.rds.amazonaws.com:5432/postgres", "postgres", "password");
			PreparedStatement ps = con.prepareStatement("select * from tbl_user where email = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//out.print(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				out.print("Valid Email!!!");
			}else {
				out.print("Invalid Email.");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>
</body>
</html>