/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import DAO.MedicineDAO;
import DAO.ReservationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CardMedicine;
import model.medicine;
import model.medicineCategory;

/**
 *
 * @author win
 */
public class AddExaminationServlet extends HttpServlet {

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
            out.println("<title>Servlet AddExaminationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddExaminationServlet at " + request.getContextPath() + "</h1>");
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
        int res_id = Integer.parseInt(request.getParameter("reservation_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        int child_id = Integer.parseInt(request.getParameter("child_id"));
        List<medicine> listMedicine = new MedicineDAO().getNext3Medicine(0);
        List<medicineCategory> listCate = new MedicineDAO().getAllCate();
        int reservationDetail_id = new ReservationDAO().getReDetailIdByRSC(res_id,service_id,child_id);
        request.setAttribute("reservationDetail_id", reservationDetail_id);
        request.setAttribute("reservation_id", res_id);
        request.setAttribute("service_id", service_id);
        request.setAttribute("child_id", child_id);
        request.setAttribute("listCate", listCate);
        request.setAttribute("listMedicine", listMedicine);
        request.getRequestDispatcher("AddNewMedicine.jsp").forward(request, response);
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
        int res_id = Integer.parseInt(request.getParameter("reservation_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        int child_id = Integer.parseInt(request.getParameter("child_id"));
        List<medicine> listMedicine = new MedicineDAO().getNext3Medicine(0);
        int reservationDetail_id = new ReservationDAO().getReDetailIdByRSC(res_id,service_id,child_id);
        request.setAttribute("reservationDetail_id", reservationDetail_id);
        request.setAttribute("reservation_id", res_id);
        request.setAttribute("service_id", service_id);
        request.setAttribute("child_id", child_id);
        request.setAttribute("listMedicine", listMedicine);
        request.getRequestDispatcher("AddNewMedicine.jsp").forward(request, response);
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
