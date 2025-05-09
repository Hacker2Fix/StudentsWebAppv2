/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Hello
 */
public class AddStudServlet extends HttpServlet {

    @EJB private StudentFacadeLocal sfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long id=Long.parseLong(request.getParameter("id"));
            String name=request.getParameter("name");
            
            String date=request.getParameter("date");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
            Date dob = sdf.parse(date);
            
            
            Integer age=Integer.parseInt(request.getParameter("age"));
            Character gender=request.getParameter("gender").charAt(0);
            Integer mark=Integer.parseInt(request.getParameter("marks"));
            
            Student student=CreateStudent(id,name,dob,age,gender,mark);
            sfl.create(student);
            
            RequestDispatcher disp = request.getRequestDispatcher("addStudOutcome.jsp");
            disp.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddStudServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private Student CreateStudent(Long id,String name, Date dob, Integer age, Character gender, Integer mark) {
        Student s= new Student();
        s.setId(id);
        s.setName(name);
        s.setDob(dob);
        s.setAge(age);
        s.setGender(gender);
        s.setMarkObtainted(mark);
        s.setCreationDate(new Date());
        
        return s;
    }

}
