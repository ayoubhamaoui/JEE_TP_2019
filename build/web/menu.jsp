<%-- 
    Document   : menu
    Created on : 17 oct. 2019, 21:12:03
    Author     : dell
--%>

<%@page import="java.util.Calendar" %>

<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title">Employee Management System</span>
        
        <div class="mdl-layout-spacer"></div>
        
        <nav class="mdl-navigation mdl-layout--large-screen-only">
            <form action="EmployeeController" method="GET">
                <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" name="add" type="submit" >
                    <i class="material-icons">add</i>
                </button>
            </form>
        </nav>
    </div>
</header>


