<%-- 
    Document   : index
    Created on : 16 oct. 2019, 20:03:37
    Author     : dell
--%>

<%@page import="Entity.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="DAO.EmployeeDAO"%>
<% 
    EmployeeDAO em = new EmployeeDAO();
    List<Employee> empList= em.FindAll();
%>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <%@include file="./menu.jsp" %>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <div class="mdl-grid center-items">
                        <div class="mdl-cell mdl-cell---col">
                            <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">NO</th>
                                        <th>Hire Date</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>                                
                                        <th>Birth Day</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   <%
                                        for(Employee e:empList){
                                    %>
                                    <tr>
                                        <td class="mdl-data-table__cell--non-numeric"><%= e.getEmployeeNo() %></td>
                                        <td><%=e.getHireDate() %></td>
                                        <td><%=e.getFirstName() %></td>
                                        <td><%=e.getLastName() %></td>
                                        <td><%=e.getDateOfBirth() %></td>
                                        <td>
                                            <form action="EmployeeController" method="GET">
                                                <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" name="update" type="submit" value="<%= e.getEmployeeNo() %>">
                                                    <i class="material-icons">update</i>
                                                </button>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--accent" name="delete" type="submit" value="<%= e.getEmployeeNo() %>">
                                                    <i class="material-icons">delete</i>
                                                </button>
                                            </form>
                                        </td>
                                        
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
