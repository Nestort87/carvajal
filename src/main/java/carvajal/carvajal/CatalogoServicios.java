/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carvajal.carvajal;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoServicios {
    
    @Autowired
    private CatalogoRepositorio metodosCrud;

    public List<Catalogo> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Catalogo> getCatalogo(int catalogoId) {
        return metodosCrud.getCatalogo(catalogoId);
    }

    public Catalogo save(Catalogo catalogo){
        if(catalogo.getId()==null){
            return metodosCrud.save(catalogo);
        }else{
            Optional<Catalogo> e=metodosCrud.getCatalogo(catalogo.getId());
            if(e.isEmpty()){
                return metodosCrud.save(catalogo);
            }else{
                return catalogo;
            }
        }
    }

    public Catalogo update(Catalogo catalogo){
        if(catalogo.getId()!=null){
            Optional<Catalogo> e=metodosCrud.getCatalogo(catalogo.getId());
            if(!e.isEmpty()){
                if(catalogo.getNombre()!=null){
                    e.get().setNombre(catalogo.getNombre());
                }
                if(catalogo.getPrecio()!=null){
                    e.get().setPrecio(catalogo.getPrecio());
                }
                if(catalogo.getCantidadstock()!=null){
                    e.get().setCantidadstock(catalogo.getCantidadstock());
                }
                if(catalogo.getCliente()!=null){
                    e.get().setCliente(catalogo.getCliente());
                }
                
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return catalogo;
            }
        }else{
            return catalogo;
        }
    }


    public boolean deleteCatalogo(int catalogoId) {
        Boolean aBoolean = getCatalogo(catalogoId).map(catalogo -> {
            metodosCrud.delete(catalogo);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
