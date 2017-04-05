/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.controller;

import es.cifpcm.pizzeriamvc.controller.data.DatabaseConfig;
import es.cifpcm.pizzeriamvc.model.UserPrincipal;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class AuthControllerServlet extends HttpServlet {

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

    private UserPrincipal getAuthenticatedLogin(String strLogin, String strPassword) {
        final String query = "SELECT * FROM usuarios WHERE login=? and password=?";
        UserPrincipal userPrincipal = null;

        LOG.debug("getAuthenticatedLogin strLogin={} strPassword={}",
                strLogin, strPassword);

        if (strLogin == null || strPassword == null || strLogin.isEmpty() || strPassword.isEmpty()) {
            LOG.warn("No se indica usuario o password");
            return userPrincipal;
        }
        try (Connection conn = DriverManager.getConnection(dbCfg.getDatabaseUrl(),
                dbCfg.getDatabaseUser(), dbCfg.getDatabasePassword());
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, strLogin);
            pstmt.setString(2, strPassword);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    LOG.debug("Usuario encontrado {}", strLogin);
                    userPrincipal = new UserPrincipal();
                    userPrincipal.setLogin(rs.getString("login"));
                }
            }
        } catch (SQLException ex) {
            LOG.error("getAuthenticatedLogin", ex);
        }
        return userPrincipal;
    }

    protected void doLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doLogOut(request, response);

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
        HttpSession session = request.getSession(true);
        UserPrincipal userPrincipal = getAuthenticatedLogin(request.getParameter("user"),
                request.getParameter("userpass"));
        LOG.debug("Usuario encontrado {}", userPrincipal != null);

        ServletContext servletCtx = getServletContext();

        if (userPrincipal != null) {
            session.setAttribute("PRINCIPAL", userPrincipal);
            servletCtx.getRequestDispatcher("/loginSucess.jsp").forward(request, response);

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
