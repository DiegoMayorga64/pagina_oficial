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

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/{idUsuario}/perfil")
    public String verPerfilUsuario(@PathVariable(name="idUsuario") Integer id, Model model){

        Usuario u= uDao.findById(id.intValue());

        if(u.getTipo()>0){
            model.addAttribute("usuario", u);
            return "verPerfilComun";
        }else {
            model.addAttribute("usuario", u);
            return "verPerfilAdmin";
        }
    }

    @GetMapping("/registrarUsuario")
    public String mostrarFormRegistro(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());
        return "agregarUsuario";
    }

    @PostMapping("/registrarUsuario")
    public String agregarUsuario(@ModelAttribute Usuario u){
        u.setTipo(0);
        uDao.save(u);
        return "index";
    }

    @GetMapping("/login")
    public String mostrarFormLogin(Model model){
        model.addAttribute("usuario",new Usuario());
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(Model model,@ModelAttribute Usuario u, HttpServletRequest request){
        Usuario usuarioBD= uDao.findByCorreoAndContraseña(u.getCorreo(),u.getContraseña());
        if(usuarioBD!=null){
            request.getSession().setAttribute("usuarioLogueado",usuarioBD);
            return "index";
        }else{
            model.addAttribute("usuario",new Usuario());
            model.addAttribute("error",true);
            return "loginPage";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
       request.getSession().invalidate();
       return "redirect:/";
    }

}
