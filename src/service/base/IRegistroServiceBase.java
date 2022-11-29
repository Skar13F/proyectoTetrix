
package service.base;

import entity.Rol;
import java.util.List;

public interface IRegistroServiceBase <T>{
    public void insertarRegistro(T registro);
    public List<T> obtenerRegistro();
    public void eliminarRegistro(int id);
    public T buscarRegistro(int id);
    public void actualizarRegistro(T registro);
}
