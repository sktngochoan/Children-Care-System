/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserRegister;

/**
 *
 * @author win
 */
public class VerifyRegisterController extends HttpServlet {

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
            HttpSession session = request.getSession();
            UserDAO accountDao = new UserDAO();
            UserRegister user = (UserRegister) session.getAttribute("authcode");
            String code1 = request.getParameter("authcode1");
            String code2 = request.getParameter("authcode2");
            String code3 = request.getParameter("authcode3");
            String code4 = request.getParameter("authcode4");
            String code5 = request.getParameter("authcode5");
            String code6 = request.getParameter("authcode6");
            String code = code1 + code2 + code3 + code4 + code5 + code6;

            String username = (String) session.getAttribute("username");
            Boolean gender = (Boolean) session.getAttribute("gender");
            String address = (String) session.getAttribute("address");
            String useremail = (String) session.getAttribute("useremail");
            String phone = (String) session.getAttribute("phone");
            String password = (String) session.getAttribute("password");
            String repeatpassword = (String) session.getAttribute("repeatpassword");

            if (code.equals(user.getCode())) {
                accountDao.register(username, gender, address, password, useremail, phone);
                response.sendRedirect("login");
                // out.println("Verification Successfully!");
            } else {
                 request.setAttribute("error", "Incorrect verification code!");
            request.getRequestDispatcher("verifyRegister.jsp").forward(request, response);
            }
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
        processRequest(request, response);
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