package model;

import db.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;
    private Statement stm;

    @Override
    public void insertarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL insertarUsuario('" + usuario.getNombre() +"','"+usuario.getPassword()+ "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerRegistro() {
        try {
            List<Usuario> listaUsuario = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL obtenerUsuario";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt(1));// o se pude hacer usuario.setId_usuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString(2));// o se pude hacer usuario.setNombre(rs.getString("usuario"));
                usuario.setPassword(rs.getString(3));
                listaUsuario.add(usuario);
            }

            stm.close();
            connection.close();
            return listaUsuario;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void eliminarRegistro(int id) {
        try {
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL eliminarUsuario('" + id + "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Usuario buscarRegistro(int id) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL buscarUsuario('" + id + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(1));// o se pude hacer usuario.setId_usuario(rs.getInt("idUsuario"));
            usuario.setNombre(rs.getString(2));// o se pude hacer usuario.setNombre(rs.getString("usuario"));
            stm.close();
            connection.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL actualizarUsuario('" + usuario.getNombre()+"','"+ usuario.getId_usuario()+ "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Usuario buscarRegistro(Usuario user) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL buscarUsuarioNC('" + user.getNombre() +"','"+user.getPassword()+ "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(1));// o se pude hacer usuario.setId_usuario(rs.getInt("idUsuario"));
            usuario.setNombre(rs.getString(2));// o se pude hacer usuario.setNombre(rs.getString("usuario"));
            usuario.setPassword(rs.getString(3));// o se pude hacer usuario.setNombre(rs.getString("usuario"));
            System.out.println(usuario.getId()+usuario.getNombre());
            stm.close();
            connection.close();
            return usuario;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            return null;
        }

    }

    @Override
    public Usuario buscarRegistro(String nombre) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL buscarUsuarioNombre('" + nombre +"')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(1));// o se pude hacer usuario.setId_usuario(rs.getInt("idUsuario"));
            usuario.setNombre(rs.getString(2));// o se pude hacer usuario.setNombre(rs.getString("usuario"));
            usuario.setPassword(rs.getString(3));// o se pude hacer usuario.setNombre(rs.getString("usuario")); 
            stm.close();
            connection.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
