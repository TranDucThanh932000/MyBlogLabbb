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
import model.Blog;

/**
 *
 * @author admin2
 */
public class HomePage extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomePage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            BlogDAO dao = new BlogDAO();
            String id = request.getParameter("id");
            String indexM = request.getParameter("indexMenu");
            if (indexM == null) {
                indexM = "1";
            }
            request.setAttribute("indexMenu", indexM);
            int id_blog = 0;
            Blog current = dao.getTop1();
            if (current != null) {
                if (id != null) {
                    try {
                        id_blog = Integer.parseInt(id);
                        current = dao.getBlog(id_blog);
                    } catch (Exception e) {
                        request.setAttribute("error", "Just enter a number of id!");
                    }
                }
                List<String> listCategory = dao.getAllCategory();
                request.setAttribute("listCategory", listCategory);
                List<Blog> list = dao.getTop3(3);
                request.setAttribute("list", list);
                if (current != null) {
                    request.setAttribute("current", current);
                } else {
                    request.setAttribute("error", "This post does not exist!");
                }
            } else {
                request.setAttribute("error", "No posts exist!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
            request.getRequestDispatcher("/left.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error occuring!");
            request.setAttribute("indexMenu", 1);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
        processRequest(request, response);
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
