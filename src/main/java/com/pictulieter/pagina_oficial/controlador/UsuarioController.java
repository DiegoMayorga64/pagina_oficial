package com.pictulieter.pagina_oficial.controlador;

import com.pictulieter.pagina_oficial.dao.UsuarioDAO;
import com.pictulieter.pagina_oficial.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDAO uDao;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {

        List<Usuario> usuarios = uDao.findAll();
        model.addAttribute("usuarioBd", usuarios);
        return "verUsuarios";
    }

    @GetMapping("/usuarios/{idUsuario}/perfil")
    public String verPerfilUsuario(@PathVariable(name="idUsuario") Integer id, Model model){

        Usuario u= uDao.findById(id.intValue());

        if(u.getTipo()!=1 && u.getTipo()!=0){
            model.addAttribute("usuario", u);
            return "verPerfilComun";
        }else {
            model.addAttribute("usuario", u);
            return "verPerfilAdmin";
        }
    }

    @GetMapping("/registrarUsuario")
    public String mostrarForm(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());
        return "agregarUsuario";
    }

    @PostMapping("/registrarUsuario")
    public String agregarUsuario(@ModelAttribute Usuario u){
        uDao.save(u);
        return "";
    }



}
