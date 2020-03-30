package com.pictulieter.pagina_oficial.controlador;

import com.pictulieter.pagina_oficial.dao.UsuarioDAO;
import com.pictulieter.pagina_oficial.modelo.Imagen;
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


    @GetMapping("/Conocenos")
    public String usuarios(Model model) {
        List<Usuario> usuarios= uDao.findByTipo(1);
        for (int i=0;i<uDao.findByTipo(2).size();i++){
            usuarios.add(uDao.findByTipo(2).get(i));
        }
        for (int i=0;i<uDao.findByTipo(3).size();i++){
            usuarios.add(uDao.findByTipo(3).get(i));
        }
        model.addAttribute("listaUsuarios", usuarios);
        return "conocenos";
    }

   /* @GetMapping("/{idUsuario}/perfil")
    public String verPerfilUsuario(@PathVariable(name="idUsuario") Integer id, Model model){

        Usuario u= uDao.findById(id.intValue());
        model.addAttribute("usuario", u);
        return "verPerfilComun";
    }*/

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

    @GetMapping("/Dibujos/Dibujantes")
    public String mostrarDibujantes(Model model){
        List<Usuario> dibujantes= uDao.findByTipo(3);
        for (int i=0;i<uDao.findByTipo(1).size();i++){
            dibujantes.add(uDao.findByTipo(1).get(i));
        }
        model.addAttribute("dibujantes",dibujantes);
        return "verDibujosXTipo";
    }

    @GetMapping("/Historias/Autores")
    public String mostrarEscritores(Model model){
        List<Usuario> escritores= uDao.findByTipo(2);
        for (int i=0;i<uDao.findByTipo(1).size();i++){
            escritores.add(uDao.findByTipo(1).get(i));
        }
        model.addAttribute("escritores",escritores);
        return "verHistoriasXTipo";
    }

}
