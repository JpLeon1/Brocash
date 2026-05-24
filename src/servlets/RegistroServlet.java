package servlets;

public class RegistroServlet {

    protected void procesarRegistro(javax.servlet.http.HttpServletRequest request) {
    Usuario usuario = new Usuario();

    usuario.setIdUsuario(
        Integer.parseInt(request.getParameter("idUsuario")));

    usuario.setNombre(request.getParameter("nombre"));

    usuario.setApellido(request.getParameter("apellido"));

    usuario.setEdad(
        Integer.parseInt(request.getParameter("edad")));

    usuario.setEmail(request.getParameter("email"));

    usuario.setTelefono(request.getParameter("telefono"));
}

}