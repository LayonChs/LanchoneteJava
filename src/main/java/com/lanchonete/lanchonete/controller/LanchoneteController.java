package com.lanchonete.lanchonete.controller;

import com.lanchonete.lanchonete.model.PratoAtualizadoModel;
import com.lanchonete.lanchonete.model.PratoModel;
import com.lanchonete.lanchonete.service.*;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/atualizar_prato")
    public String atualizarPrato(@RequestBody PratoAtualizadoModel pratoAtualizado){
        lanchoneteService.atualizarPrato(pratoAtualizado);
        return "Prato atualizado com sucesso";
    }

    @DeleteMapping("/excluir_prato/{id}")
    public String excluirPrato(@PathVariable int id){
        lanchoneteService.excluirPrato(id);
        return "Prato excluido com sucesso";
    }

}
