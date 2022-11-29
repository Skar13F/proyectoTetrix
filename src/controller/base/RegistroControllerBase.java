
package controller.base;

import entity.base.IRegistroEntityBase;
import java.util.List;
import service.base.IRegistroServiceBase;

public abstract class RegistroControllerBase <T extends IRegistroEntityBase>{
    private T registro;
    private IRegistroServiceBase <T> service;
    public void crearActualizarRegistro(){
        if(registro.getId()<1){
            service.insertarRegistro(registro);
        }else{
            service.actualizarRegistro(registro);
        }
    }
    
    public List<T> obtenerRegistro(){
        return service.obtenerRegistro();
    }
    
    public void eliminarRegistro(int id){
        service.eliminarRegistro(id);
    }
    
    public T buscarRegistro(int id){
        return service.buscarRegistro(id);
    }
    //aquí se escribirán los demás métodos

    public void setService(IRegistroServiceBase<T> service) {
        this.service = service;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }
    
}
