/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.controller;

import es.cifpcm.pizzeriamvc.controller.data.DatabaseConfig;
import es.cifpcm.pizzeriamvc.model.OferPizzas;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class PizzaSelectorServlet extends HttpServlet {

    private final DatabaseConfig dbCfg = new DatabaseConfig();
    private final static Logger LOG = LoggerFactory.getLogger(AuthControllerServlet.class);

    @Override
    public void init() throws ServletException {
        try {
            super.init(); //To change body of generated methods, choose Tools | Templates.
            ResourceBundle rb = ResourceBundle.getBundle("pizzas");
            dbCfg.setDriverClassName(rb.getString("database.driver"));
            dbCfg.setDatabaseUrl(rb.getString("database.url"));
            dbCfg.setDatabaseUser(rb.getString("database.user"));
            dbCfg.setDatabasePassword(rb.getString("database.password"));

            Class.forName(dbCfg.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            LOG.error("Error con la base de datos: ", ex);
        }
    }

    private List<OferPizzas> getListPizzas() {
        List<OferPizzas> listPizzas = new ArrayList<>();
        final String query = "SELECT  idOfertas, nombre, precioTotal,  urlImagen  FROM Ofertas";
        try (Connection conn = DriverManager.getConnection(dbCfg.getDatabaseUrl(),
                dbCfg.getDatabaseUser(), dbCfg.getDatabasePassword());
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery(query)) {
                while (rs.next()) {
                    OferPizzas op = new OferPizzas();
                    op.setIdOfertas(rs.getInt("idOfertas"));
                    op.setNombre(rs.getString("nombre"));
                    op.setPrecioTotal(Double.parseDouble(rs.getString("precioTotal")));
                    op.setUrlImagen(rs.getString("urlImagen"));

                    listPizzas.add(op);
                }
            }

        } catch (SQLException ex) {
            LOG.error("getListPizzas", ex);
        }
        return listPizzas;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");

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
        List<OferPizzas> listPizzas = getListPizzas();

        ServletContext servletCtx = getServletContext();
        if (listPizzas != null) {
            request.setAttribute("listPizzas", listPizzas);
            servletCtx.getRequestDispatcher("/customer/pizzas.jsp").forward(request, response);
        } else {
            servletCtx.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
