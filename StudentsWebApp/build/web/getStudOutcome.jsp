<%-- 
    Document   : getStudOutcome
    Created on : 09-May-2025, 00:30:13
    Author     : Hello
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records Page</title>
    </head>
    <body>
        <h1>Records</h1>
        <%
            List<Student> stud=(List<Student>)request.getAttribute("students");
            
        %>
        
        <p>
            Below are all the students.
        </p>
        
        <table border="1">
            <th>ID</th>
            <th>Name</th>
            <th>DAte of Birth</th>
            <th>Age</th>
            <th>Gender</th>
            <th>ST1</th>
            <th>Creation Date</th>
            <%
                for(int i=0;i<stud.size();i++){
                   Student s=stud.get(i);
                   Long id=s.getId();
                   String name=s.getName();
                   
                   Date dob=s.getDob();
                   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
                   String db=sdf.format(dob);
                   
                   Integer age=s.getAge();
                   char gender=s.getGender();
                   Integer mark=s.getMarkObtainted();
                   Date cd=s.getCreationDate();
                   %>
            
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
                <td><%=db%></td>
                <td><%=age%></td>
                <td><%=gender%></td>
                <td><%=mark%></td>
                <td><%=cd%></td>
            </tr>
            
                 <%  
                }
            %>
            
            
        </table>
        
        <p>
            Please click <a href="tutor_menu.html">here</a> to menu.
        </p>
    </body>
</html>
