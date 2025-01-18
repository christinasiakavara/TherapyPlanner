<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="errorController.jsp" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.UserDAO" %>
<%@ page import="DETsCode.User.User" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UserDAO userDao = UserDAO.getInstance();


    try {
        User user = userDao.authenticate(username, password);
        session.setAttribute("userObj2024", user);
        response.sendRedirect("dashboard.jsp");

    } catch (Exception e) {
        request.setAttribute("message", e.getMessage());
%>

<jsp:forward page="login.jsp"/>

<%
    }
%>
