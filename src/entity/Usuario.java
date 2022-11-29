
package entity;

import entity.base.IRegistroEntityBase;

public class Usuario implements IRegistroEntityBase{
    private int id_usuario;
    private String nombre;
    private String password;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String password) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getId() {
        return getId_usuario();
    }

    @Override
    public void setId(int id) {
        setId_usuario(id);
    }
    
}
