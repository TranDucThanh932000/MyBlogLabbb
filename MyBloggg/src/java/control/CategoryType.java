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
public class CategoryType extends HttpServlet {

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
            out.println("<title>Servlet CategoryType</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryType at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String category = request.getParameter("category");
            request.setAttribute("category", category);
            String pageIndex = request.getParameter("index");
            BlogDAO dao = new BlogDAO();
            
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = 0;
            int total = 0;
            int maxPage = 0;
            int pageSize = 2;
            Blog checkDB = dao.getTop1();
            if (checkDB != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                    request.setAttribute("index", index);
                    total = dao.count(category);
                    maxPage = total / pageSize;
                    if (total % pageSize != 0) {
                        maxPage++;
                    }
                    if(index>maxPage){
                        request.setAttribute("error", "No posts exist!");
                    }
                    request.setAttribute("maxPage", maxPage);
                } catch (Exception e) {
                    request.setAttribute("error", "Just enter a number!");
                }
                List<Blog> listCategoryByType = dao.getByIndex(category, index, pageSize);
                request.setAttribute("categorybytype", listCategoryByType);
                List<String> listCategory = dao.getAllCategory();
                request.setAttribute("listCategory", listCategory);
                List<Blog> list = dao.getTop3(3);
                request.setAttribute("list", list);
            } else {
                request.setAttribute("error", "No posts exist!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            request.setAttribute("indexMenu", 1);
            request.getRequestDispatcher("/categoryType.jsp").forward(request, response);
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
