/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.controller;

import es.cifpcm.pizzeriamvc.controller.data.DatabaseConfig;
import es.cifpcm.pizzeriamvc.model.OfertaPizzas;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
@WebServlet(name = "InsertPizzasServlet", urlPatterns = {"/insertPizzas"})
public class InsertPizzasServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private OfertaPizzas insertPizzas(String strInsertOferm, String strDescripcion, Double dPrecioTotal, String strUrlImagen) {
        final String query = "INSERT INTO Ofertas (nombre, descripcion, precioTotal, urlImagen) VALUES (?,?,?,?)";
        OfertaPizzas ofer = null;
        try (Connection conn = DriverManager.getConnection(dbCfg.getDatabaseUrl(),
                dbCfg.getDatabaseUser(), dbCfg.getDatabasePassword());
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, strInsertOferm);
            pstmt.setString(2, strDescripcion);
            pstmt.setDouble(3, dPrecioTotal);
            pstmt.setString(4, strUrlImagen);
            int rowInserted = pstmt.executeUpdate();
            if (rowInserted > 0) {
                LOG.debug("Ofer Inserted!!!");

            }
            //int resul = pstmt.executeUpdate();
            //if (resul > 0) {
            //    try (ResultSet rs = pstmt.getGeneratedKeys()) {
            //        while (rs.next()) {
            //            LOG.debug("Introduciendo datos en la BD {}", strInsertOferm, strDescripcion, dPrecioTotal, strUrlImagen);
            //            ofer = new OfertaPizzas();
            //            ofer.setNombre(rs.getString("nombre"));
            //            ofer.setDescripcion(rs.getString("descripcion"));
            //            ofer.setPrecioTotal(Double.parseDouble(rs.getString("precioTotal")));
            //            ofer.setUrlImagen(rs.getString("UrlImagen"));
            //        }
            //    }
            //}

        } catch (SQLException ex) {
            LOG.error("insertPizzas", ex);
        }
        return ofer;
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
        OfertaPizzas ofer = insertPizzas(request.getParameter("namePizza"),
                request.getParameter("selBase"),
                Double.parseDouble(request.getParameter("inputPrice")),
                request.getParameter("urlImage"));

        LOG.debug("Oferta encontrada {}", ofer != null);

        ServletContext servletCtx = getServletContext();

        servletCtx.getRequestDispatcher("/insertSucess.jsp").forward(request, response);

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
