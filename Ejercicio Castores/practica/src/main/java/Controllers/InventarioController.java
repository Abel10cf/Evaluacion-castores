package Controllers;

import models.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.InventarioService;

@Controller
@RequestMapping("/Inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("inventario", inventarioService.listarTodos());
        return "inventarios/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("inventario",new Inventario());
        return "inventarios/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Inventario inventario){
        inventarioService.guardar(inventario);
        return "redirect:/inventarios";
    }
}
