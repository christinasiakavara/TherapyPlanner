<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="errorController.jsp"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="therplanner.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    UserDAO userDao = new UserDAO();

   
    try {

       User user = (User) userDao.authenticate(username, password);

       session.setAttribute("userObj2024", user);
       response.sendRedirect("dashboard.jsp");

    } catch(Exception e) {
        request.setAttribute("message", e.getMessage());
        %>

    <jsp:forward page="login.jsp"/>

<%
    }
%>
