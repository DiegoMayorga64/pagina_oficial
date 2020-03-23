package com.pictulieter.pagina_oficial.controlador;


import com.pictulieter.pagina_oficial.dao.ImagenDAO;
import com.pictulieter.pagina_oficial.modelo.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
