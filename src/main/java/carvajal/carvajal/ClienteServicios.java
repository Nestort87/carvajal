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
public class ClienteServicios {
    
    @Autowired
    private ClienteRepositorio metodosCrud;

    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int clienteId) {
        return metodosCrud.getCliente(clienteId);
    }

    public Cliente save(Cliente cliente){
        if(cliente.getId()==null){
            return metodosCrud.save(cliente);
        }else{
            Optional<Cliente> e=metodosCrud.getCliente(cliente.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cliente);
            }else{
                return cliente;
            }
        }
    }

    public Cliente update(Cliente cliente){
        if(cliente.getId()!=null){
            Optional<Cliente> e=metodosCrud.getCliente(cliente.getId());
            if(!e.isEmpty()){
                if(cliente.getNombreCliente()!=null){
                    e.get().setNombreCliente(cliente.getNombreCliente());
                }
                if(cliente.getNombre()!=null){
                    e.get().setNombre(cliente.getNombre());
                }
                if(cliente.getPrecio()!=null){
                    e.get().setPrecio(cliente.getPrecio());
                }
                if(cliente.getCantidadstock()!=null){
                    e.get().setCantidadstock(cliente.getCantidadstock());
                }
                if(cliente.getCatalogo()!=null){
                    e.get().setCatalogo(cliente.getCatalogo());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean deleteCliente(int clienteId) {
        Boolean aBoolean = getCliente(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
