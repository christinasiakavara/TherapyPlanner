<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="therplanner.*" %>
<%@ page import="java.util.*, java.sql.*" %>

<%
    // Check if the user is logged in
    if (session.getAttribute("userObj2024") == null) {
        request.setAttribute("message", "You are not authorized to access this resource. Please login.");
        response.sendRedirect("login.jsp");
        return;
    }

    // Retrieve user and therapistId from the session and request
    User user = (User) session.getAttribute("userObj2024");
    String therapistId = request.getParameter("therapistId");

    if (therapistId != null && !therapistId.isEmpty()) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // Assign therapist to the user
            DB db = new DB();
            String query = "INSERT INTO user_therapist (user_id, therapist_id) VALUES (?, ?) ON DUPLICATE KEY UPDATE therapist_id = VALUES(therapist_id)";
            con = db.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, user.getId());
            stmt.setInt(2, Integer.parseInt(therapistId));
            stmt.executeUpdate();

            // Redirect to confirmation or dashboard
            response.sendRedirect("dashboard.jsp?success=therapist_assigned");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?error=assignment_failed");

        } finally {
            // Close resources in finally block
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    } else {
        // If no therapistId is provided, redirect with an error
        response.sendRedirect("dashboard.jsp?error=invalid_therapist");
    }
%>
