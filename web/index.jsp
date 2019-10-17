<%-- 
    Document   : index
    Created on : 16 oct. 2019, 20:03:37
    Author     : dell
--%>

<%@page import="Entity.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.EmployeeDAO"%>
<% 
    EmployeeDAO em = new EmployeeDAO();
    List<Employee> empList= em.FindAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <%
                for(Employee e:empList){
            %>
            <tr bgcolor="#DEB887">

                <td><%=e.getFirstName() %></td>
                <td><%=e.getLastName() %></td>
                <td><%=e.getDateOfBirth() %></td>
                <td><%=e.getEmployeeNo() %></td>
                <td><%=e.getHireDate() %></td>
            </tr>
            <% 
                }
            %>
        </table>
    </body>
</html>
