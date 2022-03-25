/*
 * © 2022 tienhuynh-tn
 * All rights reserved!
 * For more information, please contact via my email: tien.huynhlt.tn@gmail.com
 */
package sample.controller;

import com.sun.jersey.api.client.*;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author Tien Huynh - Tien Huynh TN - Huynh Le Thuy Tien
 */
public class CalculatorServlet extends HttpServlet {

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
            String action = request.getParameter("btAction");
            String url = "http://localhost:8084/RestFulCalculatorServices/webresources/generic";
            if (action.equals("Add")) {
                String num1 = request.getParameter("txtNum1");
                String num2 = request.getParameter("txtNum2");
                Client client = Client.create();
                client.setFollowRedirects(true);
                WebResource resource = client.resource(url);
                MultivaluedMap<String, String> params = new MultivaluedMapImpl();
                params.add("num1", num1);
                params.add("num2", num2);
                String res = resource.path("add").queryParams(params).get(String.class);
                out.println("Add: " + num1 + " + " + num2 + " = " + res);
            } else if (action.equals("Subtract")) {
                String num1 = request.getParameter("txtNum1");
                String num2 = request.getParameter("txtNum2");
                Client client = Client.create();
                client.setFollowRedirects(true);
                WebResource resource = client.resource(url);
                MultivaluedMap<String, String> params = new MultivaluedMapImpl();
                params.add("num1", num1);
                params.add("num2", num2);
                String res = resource.path("subtract").queryParams(params).get(String.class);
                out.println("Subtract: " + num1 + " - " + num2 + " = " + res);
            }
        } finally {
            out.close();
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
