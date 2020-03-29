package com.pictulieter.pagina_oficial.controlador;


import com.pictulieter.pagina_oficial.dao.ImagenDAO;
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
public class ImagenController {

    @Autowired
    private ImagenDAO iDao;

    @GetMapping("/imagenes")
    public String imagenes(Model model) {
        List<Imagen> imagenes= iDao.findAll();
        model.addAttribute("imagenBd", imagenes);
        return "verImagenes";
    }

    @GetMapping("/{idUsuario}/agregarContenido")
    public String mostrarFormContenido(Model model){
        model.addAttribute("nuevoContenido", new Imagen());
        return "agregarContenido";
    }

    @PostMapping("/{idUsuario}/agregarContenido")
    public String agregarContenido(@ModelAttribute Imagen i, Model model){
        iDao.save(i);
        return "index";
    }


}
