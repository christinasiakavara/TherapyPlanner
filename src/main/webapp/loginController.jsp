<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="errorController.jsp"%>
<%@ page import="theClasses.*" %>

<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UserDAO userDao = new UserDAO();

   
    try {

       User user = (User) userDao.authenticate(email, password);

       session.setAttribute("userObj2024", user);
       response.sendRedirect("index.jsp");

    } catch(Exception e) {
        request.setAttribute("message", e.getMessage());
        %>

    <jsp:forward page="login.jsp"/>

<%
    }
%>
