<%-- 
    Document   : addUpdate
    Created on : 18 oct. 2019, 02:48:45
    Author     : dell
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <%@include file="./menu.jsp" %>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <div class="mdl-grid center-items">
                        <div class="mdl-cell mdl-cell--4-col">
                            <div class="mdl-card mdl-sadow--6dp">
                                <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                                    <h2 class="mdl-card__title-text">
                                        <c:if test="${emp != null}">Edit Employee</c:if>
                                        <c:if test="${emp == null}">Add New Employee</c:if>
                                    </h2>
                                </div>
                                <div class="mdl-card__supporting-text">
                                    <form name="myForm" action="EmployeeController" method="post" onsubmit="return validateForm()">
                                        <c:if test="${emp != null}">
                                            <input type="hidden" name="id" value="${emp.getEmployeeNo()}" />
                                        </c:if>
                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input type="text" name="firstname" class="mdl-textfield__input" value="${emp.getFirstName()}" id="firstname" />
                                            <label class="mdl-textfield__label" for="firstname">First name</label>
                                        </div>
                                            
                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input type="text" name="lastname" class="mdl-textfield__input" value="${emp.getLastName()}" id="lastname" />
                                            <label class="mdl-textfield__label" for="lastname">Last name</label>
                                        </div>
                                        
                                        <div class="mdl-textfield mdl-js-textfield">
                                            Birthday:<input type="date" name="birthday" class="" value="${emp.getDateOfBirth()}" id="birthday" />
                                        </div>
                                        
                                        <div class="mdl-textfield mdl-js-textfield">
                                            Hire Day:<input type="date" name="hiredate" class="" value="${emp.getHireDate()}" id="birthday" />
                                        </div>
                                            
                                        <input class="mdl-button mdl-button-colore mdl-js-button mdl-js-ripple-effect"
                                               type="submit"
                                               value="save" />
                                    </form>    
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
