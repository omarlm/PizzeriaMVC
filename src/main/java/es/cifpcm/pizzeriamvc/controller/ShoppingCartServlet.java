/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.controller;

import es.cifpcm.pizzeriamvc.controller.data.DatabaseConfig;
import es.cifpcm.pizzeriamvc.model.OfertaOrder;
import es.cifpcm.pizzeriamvc.model.ShoppingCart;
import es.cifpcm.pizzeriamvc.model.UserPrincipal;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
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
public class ShoppingCartServlet extends HttpServlet {

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
        response.sendRedirect("/pizzas.jsp");

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
        UserPrincipal up;
        ServletContext servletCtx = getServletContext();
        HttpSession session = request.getSession();

        if (session != null) {
            up = (UserPrincipal) session.getAttribute("PRINCIPAL");
            LOG.debug("PRINCIPAL ENCONTRADO");

            HttpSession sessionCart = request.getSession();
            ShoppingCart shoppingCart;
            shoppingCart = (ShoppingCart) sessionCart.getAttribute("SHOPPING_CART");
            if (shoppingCart == null) {
                final String query = "SELECT CONCAT(nombre,' ', apellidos) AS nombreCompleto FROM Clientes WHERE idCliente=" + up.getIdCliente();
                //LOG.debug("Va bien");
                try (Connection conn = DriverManager.getConnection(dbCfg.getDatabaseUrl(),
                        dbCfg.getDatabaseUser(), dbCfg.getDatabasePassword());
                        PreparedStatement pstmt = conn.prepareStatement(query)) {

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            shoppingCart = new ShoppingCart();
                            shoppingCart.setNombreCompleto(rs.getString("nombreCompleto"));
                        }
                        sessionCart.setAttribute("SHOPPING_CART", shoppingCart);
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));

            OfertaOrder ofertaOrder = shoppingCart.getCartItems().get(idPedido);
            // shoppingCart.setItems();

            if (ofertaOrder != null) {
                ofertaOrder.setCantidad(ofertaOrder.getCantidad() + 1);
                servletCtx.getRequestDispatcher("/customer/pizzas.jsp").forward(request, response);
                //response.sendRedirect("./customer/pizzas.jsp");

            } else {
                OfertaOrder nuevaOferta = new OfertaOrder(idPedido, up.getIdCliente(), 1);
                shoppingCart.putOferta(idPedido, nuevaOferta);
                servletCtx.getRequestDispatcher("/customer/pizzas.jsp").forward(request, response);
                //response.sendRedirect("./customer/pizzas.jsp");

            }
            shoppingCart.updateSize();
        } else {
            servletCtx.getRequestDispatcher("/error.jsp").forward(request, response);
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
