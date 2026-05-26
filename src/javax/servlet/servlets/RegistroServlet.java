package servlets; // <-- Ajusta esto al nombre real de tu paquete de origen

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// Importa tus clases de modelo según tus paquetes, por ejemplo:
// import modelo.Usuario;
// import modelo.UsuarioDAO;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // CUMPLE REQUISITO GET: Si acceden directo a la URL del Servlet, los manda al formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("registro_usuario.jsp");
    }

    // CUMPLE REQUISITO POST: Procesa los datos del formulario de forma segura
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        try {
            Usuario usuario = new Usuario();

            // Captura de parámetros
            usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApellido(request.getParameter("apellido"));
            usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
            usuario.setEmail(request.getParameter("email"));
            usuario.setTelefono(request.getParameter("telefono"));

            // Interacción con la base de datos a través del DAO
            UsuarioDAO dao = new UsuarioDAO();
            dao.registrarUsuario(usuario);

            // Redirección exitosa
            response.sendRedirect("principal.jsp");
            
        } catch (Exception e) {
            // Es buena práctica manejar excepciones por si envían datos erróneos
            e.printStackTrace();
            response.sendRedirect("registro_usuario.jsp?error=1");
        }
    }
}