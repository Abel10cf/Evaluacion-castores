package Controllers;

import models.Movimiento;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.MovimientoService;
import services.UsuarioService;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("movimientos", movimientoService.listarTodos());
        return "movimientos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("movimiento",new Movimiento());
        return "movimientos/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Movimiento movimiento){
        movimientoService.guardar(movimiento);
        return "redirect:/movimientos";
    }
}
