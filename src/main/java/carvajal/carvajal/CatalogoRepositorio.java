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
public class CatalogoRepositorio {
    @Autowired
    private CatalogoInterface crud;

    public List<Catalogo> getAll(){
        return (List<Catalogo>) crud.findAll();
    }

    public Optional<Catalogo> getCatalogo(int id){
        return crud.findById(id);
    }

    public Catalogo save(Catalogo catalogo){
        return crud.save(catalogo);
    }
    public void delete(Catalogo catalogo){
        crud.delete(catalogo);
    }
}
