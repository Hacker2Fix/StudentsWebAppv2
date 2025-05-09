<%-- 
    Document   : getStatsOutcome
    Created on : 09-May-2025, 02:26:39
    Author     : Hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stats Page</title>
    </head>
    <body>
        <h1>Stats</h1>
        <%
            Long cnt=(Long)request.getAttribute("cnt");
            Long totalPass=(Long)request.getAttribute("totalPass");
            Long totalfail=(Long)request.getAttribute("totalfail");
            Integer minMark=(Integer)request.getAttribute("minMark");
            Integer maxMark=(Integer)request.getAttribute("maxMark");
            //Double avg=(Double)request.getAttribute("avg");
        %>
        
        <p>
            Below are all the info.
        </p>
        <table border="1">
            <tr>
                <td>Total number of students:</td>
                <td><%=cnt%></td>
            </tr>
            <tr>
                <td>Passed students:</td>
                <td><%=totalPass%></td>
            </tr>
            <tr>
                <td>Failed students:</td>
                <td><%=totalfail%></td>
            </tr>
            <tr>
                <td>Lowest Mark:</td>
                <td><%=minMark%></td>
            </tr>
            <tr>
                <td>Highest Mark</td>
                <td><%=maxMark%></td>
            </tr>
            <tr>
                <td>Average Mark</td>
                <td></td>
            </tr>
            
            
            
            
            
        </table>
        
        <p>
            Please click <a href="lecturer_menu.html">here</a> to menu.
        </p>
    </body>
</html>
