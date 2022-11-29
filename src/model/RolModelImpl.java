package model;

import db.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.Rol;
import java.util.ArrayList;
import java.util.List;

public class RolModelImpl implements IRolModel {

    private Conexion conexion;
    private Connection connection;
    private Statement stm;

    @Override
    public void insertarRegistro(Rol rol) {
        try {
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            //String query="INSERT INTO Rol(rol) values('administrador')";
            //String query = "INSERT INTO Rol(rol) values('" + rol.getRol() + "')";
            String query = "CALL insertarRegistro('" + rol.getRol() + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Rol> obtenerRegistro() {
        try {
            List<Rol> listaRol = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL obtenerRegistro";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt(1));// o se pude hacer rol.setIdRol(rs.getInt("idRol"));
                rol.setRol(rs.getString(2));// o se pude hacer rol.setRol(rs.getString("rol"));
                listaRol.add(rol);
            }
            stm.close();
            connection.close();
            return listaRol;
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
            String query = "CALL eliminarRegistro('" + id + "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Rol buscarRegistro(int id) {
        try {
            Rol rol = new Rol();
            ResultSet rs;
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL buscarRegistro('" + id + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            rol.setIdRol(rs.getInt(1));// o se pude hacer rol.setIdRol(rs.getInt("idRol"));
            rol.setRol(rs.getString(2));// o se pude hacer rol.setRol(rs.getString("rol"));
            stm.close();
            connection.close();
            return rol;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

    @Override
    public void actualizarRegistro(Rol rolNuevo) {
        try {
            conexion = new Conexion();//se establecen los valores de la bd
            connection = conexion.getConnection();// se obtiene la conexión a la bd
            String query = "CALL actualizarRegistro('" + rolNuevo.getRol()+"','"+ rolNuevo.getIdRol()+ "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
