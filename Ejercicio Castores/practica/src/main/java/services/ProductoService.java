package services;

import models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
}
