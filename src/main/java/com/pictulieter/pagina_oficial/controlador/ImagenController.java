package com.pictulieter.pagina_oficial.controlador;


import com.pictulieter.pagina_oficial.dao.ImagenDAO;
import com.pictulieter.pagina_oficial.modelo.Imagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

@Controller
public class ImagenController {

    @Autowired
    private ImagenDAO iDao;


    @GetMapping("/{idUsuario}/agregarContenido")
    public String mostrarFormContenido(Model model){
        model.addAttribute("nuevoContenido", new Imagen());
        return "agregarContenido";
    }

    @RequestMapping(value="/{idUsuario}/agregarContenido", method=RequestMethod.POST)
    public String agregarContenido(@ModelAttribute Imagen i){
        iDao.save(i);
        return "index";
    }

    @GetMapping("/Historias")
    public String escrituras(Model model) {
        List<Imagen> escrituras= iDao.findByTipo(1);
        model.addAttribute("escritos", escrituras);
        return "verHistorias";
    }

    @GetMapping("/{idUsuario}")
    public String mostrarContenido(@RequestParam("id") int id, Model model){
        Imagen contenido= iDao.findById(id);
        model.addAttribute("content", contenido);
        return "contenido";
    }

    @GetMapping("/Dibujos")
    public String dibujos(Model model){
        List<Imagen> dibujos1= iDao.findByTipo(2);
        for (int i=0;i<iDao.findByTipo(3).size();i++){
            dibujos1.add(iDao.findByTipo(3).get(i));
        }
        for(int i=0;i<iDao.findByTipo(4).size();i++){
            dibujos1.add(iDao.findByTipo(4).get(i));
        }
        model.addAttribute("dibujoAll", dibujos1);
        return "verDibujos";
    }

    @GetMapping("/Dibujos/{tipo}")
    public String mostrarDibujos(Model model,@PathVariable("tipo") int tipo){
        List<Imagen> dibujos= iDao.findByTipo(tipo);
        model.addAttribute("dibujosTipo",dibujos);
        return "verDibujosXTipo";
    }

    @GetMapping("/Historias/{tipo}")
    public String mostrarHistorias(Model model,@PathVariable("tipo") int tipo){
        List<Imagen> escrituras= iDao.findByTipo(tipo);
        model.addAttribute("escritosTipo",escrituras);
        return "verHistoriasXTipo";
    }



}
