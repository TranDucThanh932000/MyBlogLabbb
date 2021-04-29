/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.BlogDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class Contact extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.setCharacterEncoding("UTF-8");

            BlogDAO dao = new BlogDAO();
            String indexM = "2";
            List<String> listCategory = dao.getAllCategory();

            request.setAttribute("indexMenu", indexM);
            request.setAttribute("listCategory", listCategory);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String company = request.getParameter("company");
            String mess = request.getParameter("cmt");
            String phone = request.getParameter("phone");
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("company", company);
            request.setAttribute("mess", mess);
            request.setAttribute("phone", phone);

            request.getRequestDispatcher("contact.jsp").forward(request, response);

        }catch(Exception e){
            out.print(e);
        }
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
        PrintWriter out = response.getWriter();
        try {

            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            BlogDAO dao = new BlogDAO();
            String indexM = "2";
            List<String> listCategory = dao.getAllCategory();
            request.setAttribute("indexMenu", indexM);
            request.setAttribute("listCategory", listCategory);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String company = request.getParameter("company");
            String mess = request.getParameter("cmt");
            String phone = request.getParameter("phone");
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("company", company);
            request.setAttribute("mess", mess);
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        } catch (Exception e) {
            out.print(e);
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
        PrintWriter out = response.getWriter();
        try {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String company = request.getParameter("company");
            String mess = request.getParameter("cmt");
            String phone = request.getParameter("phone");
            validate.Validate v = new Validate();
            String error = "";
            boolean flag = false;
            if (v.checkPhone(phone) == false) {
                error = "Invalid phone <br/>";
                flag = true;
            }
            if (v.checkEmail(email) == false) {
                error += "Invalid email";
                flag = true;
            }
            if (flag == false) {
                error = "Successfully!";
            }
            //} else {
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("company", company);
            request.setAttribute("mess", mess);
            request.setAttribute("phone", phone);
            //}
            BlogDAO dao = new BlogDAO();
            String indexM = "2";
            List<String> listCategory = dao.getAllCategory();
            request.setAttribute("indexMenu", indexM);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("error", error);
            if (!error.equals("Successfully!")) {
                request.getRequestDispatcher("SaveInformation").forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            out.print(e);
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
