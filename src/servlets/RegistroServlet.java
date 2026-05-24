package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")

public class RegistroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(
            Integer.parseInt(
                request.getParameter("idUsuario")));

        usuario.setNombre(
            request.getParameter("nombre"));

        usuario.setApellido(
            request.getParameter("apellido"));

        usuario.setEdad(
            Integer.parseInt(
                request.getParameter("edad")));

        usuario.setEmail(
            request.getParameter("email"));

        usuario.setTelefono(
            request.getParameter("telefono"));

        UsuarioDAO dao = new UsuarioDAO();

        dao.registrarUsuario(usuario);

        response.sendRedirect("principal.jsp");
    }
}