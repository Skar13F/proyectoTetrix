
package entity;

import entity.base.IRegistroEntityBase;

public class Jugador extends Persona implements IRegistroEntityBase{
    private int id_jugador;
    
    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    @Override
    public int getId() {
        return getId_jugador();
    }

    @Override
    public void setId(int id) {
        setId_jugador(id_jugador);
    }
    
}
