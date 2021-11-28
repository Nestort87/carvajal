/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carvajal.carvajal;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositorio {
    @Autowired
    private ClienteInterface crud;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return crud.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud.save(cliente);
    }
    public void delete(Cliente cliente){
        crud.delete(cliente);
    }
}
