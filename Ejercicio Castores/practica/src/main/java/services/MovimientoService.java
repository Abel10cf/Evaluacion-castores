package services;

import models.Movimiento;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import repository.MovimientoRepository;
import repository.UsuarioRepository;

import java.util.List;

public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> listarTodos(){
        return movimientoRepository.findAll();
    }

    public Movimiento guardar(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
}
