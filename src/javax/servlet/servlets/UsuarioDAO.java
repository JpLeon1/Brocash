package javax.servlet.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    public boolean registrarUsuario(Usuario usuario) {

        boolean registrado = false;

        try {

            Connection con = Conexion.conectar();

            String sql = "INSERT INTO registro_usuario "
                    + "(ID_USUARIO, NOMBRE, APELLIDO, EDAD, EMAIL, TELEFONO) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getTelefono());

            ps.executeUpdate();

            registrado = true;

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return registrado;
    }
}