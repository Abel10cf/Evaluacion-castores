package services;

import models.Inventario;
import models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import repository.InventarioRepository;
import repository.ProductoRepository;

import java.util.List;

public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarTodos(){
        return inventarioRepository.findAll();
    }

    public Inventario guardar(Inventario inventario){
        return inventarioRepository.save(inventario);
    }
}
