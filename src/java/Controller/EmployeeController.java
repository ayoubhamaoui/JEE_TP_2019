/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmployeeDAO;
import Entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getParameterMap().containsKey("update")) {
            int id = Integer.valueOf(request.getParameter("update"));
            EmployeeDAO emdao = new EmployeeDAO();
            Employee emp = emdao.FindByID(id);
            if(emp == null){
                request.removeAttribute("update");
                request.setAttribute("add", null);
                request.getRequestDispatcher("addUpdate.jsp").forward(request, response);
            }
            
            System.out.println(emp.getFirstName());
            request.setAttribute("emp", emp);
            
            request.getRequestDispatcher("addUpdate.jsp").forward(request, response);
        }
        
        if (request.getParameterMap().containsKey("delete")) {
            Integer id = Integer.valueOf(request.getParameter("delete"));
            //System.out.print(id);
            EmployeeDAO emdao = new EmployeeDAO();
            emdao.Delete(id);
            RequestDispatcher dispatcher
            = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameterMap().containsKey("add")) {
                RequestDispatcher dispatcher
                = request.getRequestDispatcher("/addUpdate.jsp");
                dispatcher.forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if(request.getParameterMap().containsKey("id")){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = format.parse(request.getParameter("birthday"));
                    Date hiredate = format.parse(request.getParameter("hiredate"));
                    EmployeeDAO emdao = new EmployeeDAO();
                    
                    Employee emp = new Employee(request.getParameter("firstname"),request.getParameter("lastname"),birthday,hiredate);
                    emp.setEmployeeNo(Integer.valueOf(request.getParameter("id")));
                    
                    emdao.Update(emp);
                
            }else{
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = format.parse(request.getParameter("birthday"));
                Date hiredate = format.parse(request.getParameter("hiredate"));
                EmployeeDAO emdao = new EmployeeDAO();

                Employee emp = new Employee(request.getParameter("firstname"),request.getParameter("lastname"),birthday,hiredate);

                emdao.Add(emp);
                RequestDispatcher dispatcher
                = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
