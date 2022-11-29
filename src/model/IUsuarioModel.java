
package model;

import entity.Usuario;
import java.util.List;

public interface IUsuarioModel {

    public void insertarRegistro(Usuario usuario);
    public List<Usuario> obtenerRegistro();
    public void eliminarRegistro(int id);
    public Usuario buscarRegistro(int id);
    public Usuario buscarRegistro(Usuario user);
    public Usuario buscarRegistro(String nombre);
    public void actualizarRegistro(Usuario usuario);
}
