package Controllers;

import models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("productos", productoService.listarTodos());
        return "productos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("producto",new Producto());
        return "productos/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Producto producto){
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}
