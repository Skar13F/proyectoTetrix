
package controller;

import controller.base.RegistroControllerBase;
import entity.Rol;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.IRolService;
import service.RolServiceImpl;

public class RolController extends RegistroControllerBase<Rol>{
    private IRolService service;
    
    public void init(){
        service=new RolServiceImpl();
        super.setService(service);
    }
    
    public void crearActualizarRol(Rol rol){
        //init(); ya se inicializó en la vista
        super.setRegistro(rol);
        super.crearActualizarRegistro();
    }
    
    
    public void mostrarRegistros(DefaultTableModel modelo){
        
        List<Rol> listaRol=super.obtenerRegistro();
        modelo.setRowCount(0);
        for (Rol rol : listaRol) {
            Object[] fila=new Object[2];
            fila[0]=String.valueOf(rol.getIdRol());
            fila[1]=rol.getRol();
            modelo.addRow(fila);
        }
    }
    
    public Rol buscarRegistro(int id){      
        return  super.buscarRegistro(id);
    }
    
    public void eliminarRegistro(int id){
        super.eliminarRegistro(id);
    }
    
}
