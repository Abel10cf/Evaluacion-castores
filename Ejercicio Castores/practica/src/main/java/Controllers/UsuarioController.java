package Controllers;

import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("usuario",new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

}
