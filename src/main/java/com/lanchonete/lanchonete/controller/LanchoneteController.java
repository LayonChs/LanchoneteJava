package com.lanchonete.lanchonete.controller;

import com.lanchonete.lanchonete.model.PratoModel;
import com.lanchonete.lanchonete.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/pratos")
public class LanchoneteController {
    
    @Autowired
    private LanchoneteService lanchoneteService;

    @PostMapping("/criar_prato")
    public String criarPrato(@RequestBody PratoModel prato){
        lanchoneteService.criarPrato(prato);
        return "Prato criado com sucesso";
    }

    @GetMapping("/listar_pratos")
    public List<Map<String, Object>> listarPratos(){
        return lanchoneteService.listarPratos();
    }

    @GetMapping("/buscar_prato")
    public List<Map<String, Object>> buscarPrato(@RequestBody Map<String, Object> buscar){
        return lanchoneteService.buscarPrato(buscar);
    }

}
