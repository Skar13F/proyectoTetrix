
package model;

import entity.Jugador;
import java.util.List;

public interface IJugadorModel {

    public void insertarRegistro(Jugador jugador);
    public List<Jugador> obtenerRegistro();
    public void eliminarRegistro(int id);
    public Jugador buscarRegistro(String telefono);
    public void actualizarRegistro(Jugador jugador);
}
