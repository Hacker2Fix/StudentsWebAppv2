/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class GetStatsServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal sfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long cnt=sfl.getStudentCount();
        Long totalPass=sfl.getTotalPassed();
        Long totalfail=sfl.getTotalFailed();
        
        Integer minMark=sfl.getMinimunMark();
        Integer maxMark=sfl.getMaximunMark();
        //Double avg=sfl.getAvgMark();
        
        request.setAttribute("cnt", cnt);
        request.setAttribute("totalPass", totalPass);
        request.setAttribute("totalfail", totalfail);
        request.setAttribute("minMark", minMark);
        request.setAttribute("maxMark", maxMark);
       // request.setAttribute("avg", avg);
        
        RequestDispatcher disp = request.getRequestDispatcher("getStatsOutcome.jsp");
        disp.forward(request, response);
    }

}
