
package com.pratica01.controller;


import com.pratica01.domain.Estado;
import com.pratica01.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
public class IndexController {
    @Autowired
    
    private EstadoService estadoService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        var estados = estadoService.getEstados();
        
        model.addAttribute("estados", estados);
        
        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(Estado estado){
        return "modificarEstado";
    }
    
    @PostMapping("/guardarEstado")
    public String guardarEstado(Estado estado){
        estadoService.save(estado);
        return"redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    public String modificarEstado(Estado estado, Model model){
        estado = estadoService.getEstado(estado);
        model.addAttribute("estado", estado);
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarEstado(Estado estado){
        estadoService.delete(estado);
        return"redirect:/";
    }
}
