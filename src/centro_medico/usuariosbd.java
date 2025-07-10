package centro_medico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class usuariosbd {

    public void mostrarUsuarios() {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                mostrarDatosUsuario(rs);
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void buscarPorId(int id) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE id_usuario = " + id);
            if (rs.next()) {
                mostrarDatosUsuario(rs);
            } else {
                System.out.println("Usuario no encontrado.");
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void buscarPorDocumento(int documento) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE documento_usuario = " + documento);
            if (rs.next()) {
                mostrarDatosUsuario(rs);
            } else {
                System.out.println("Documento no encontrado.");
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void buscarPorNombre(String nombre) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE nombre_usuario LIKE '%" + nombre + "%'");
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                mostrarDatosUsuario(rs);
            }
            if (!encontrado) {
                System.out.println("Nombre no encontrado.");
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void insertarUsuario(int documento, String nombre, String apellido, String correo, String direccion, String telefono) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            String sql = "INSERT INTO usuario (documento_usuario, nombre_usuario, apellido_usuario, correo_usuario, direccion_usuario, telefono_usuario) " +
                         "VALUES (" + documento + ", '" + nombre + "', '" + apellido + "', '" + correo + "', '" + direccion + "', '" + telefono + "')";
            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                System.out.println("Usuario insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el usuario.");
            }
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void actualizarUsuario(int id, String correo, String direccion, String telefono) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            String sql = "UPDATE usuario SET correo_usuario = '" + correo + "', direccion_usuario = '" + direccion + "', telefono_usuario = '" + telefono + "' " +
                         "WHERE id_usuario = " + id;
            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID " + id);
            }
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        Connection conexion = conexionbd.conectar();
        try {
            Statement stmt = conexion.createStatement();
            String sql = "DELETE FROM usuario WHERE id_usuario = " + id;
            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID " + id);
            }
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    private void mostrarDatosUsuario(ResultSet rs) throws Exception {
        System.out.println("ID: " + rs.getInt("id_usuario"));
        System.out.println("Documento: " + rs.getInt("documento_usuario"));
        System.out.println("Nombre: " + rs.getString("nombre_usuario") + " " + rs.getString("apellido_usuario"));
        System.out.println("Correo: " + rs.getString("correo_usuario"));
        System.out.println("Dirección: " + rs.getString("direccion_usuario"));
        System.out.println("Teléfono: " + rs.getString("telefono_usuario"));
        System.out.println("-----------------------------");
    }
}

