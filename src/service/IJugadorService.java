package service;

import entity.Jugador;
import service.base.IRegistroServiceBase;

public interface IJugadorService extends IRegistroServiceBase<Jugador>{
    public Jugador buscarRegistro(String telefono);
}
