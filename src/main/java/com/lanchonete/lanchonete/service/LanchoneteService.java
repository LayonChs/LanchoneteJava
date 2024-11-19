package com.lanchonete.lanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.lanchonete.lanchonete.model.*;

import java.util.List;
import java.util.Map;

@Service
public class LanchoneteService {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void criarPrato(PratoModel prato){
        String query = "INSERT INTO pratos (nome,descricao,preco,disponivel) VALUES (?,?,?,?)";
        jdbcTemplate.update(query,prato.getNome(),prato.getDescricao(),prato.getPreco(),prato.isDisponivel());
    }

    public List<Map<String, Object>> listarPratos(){
        String query = "SELECT * FROM pratos";
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> buscarPrato(Map<String, Object> buscar){
        String nome = (String) buscar.get("nome");
        String query = "SELECT * FROM pratos WHERE nome LIKE ?";
        return jdbcTemplate.queryForList(query,"%"+nome+"%");
    }

    public int atualizarPrato(PratoAtualizadoModel pratoAtualizado){
        String query = "UPDATE pratos SET nome = ?, descricao = ?, preco = ?, disponivel = ? WHERE id = ?";
        return jdbcTemplate.update(query,pratoAtualizado.getNome(),pratoAtualizado.getDescricao(),pratoAtualizado.getPreco(),pratoAtualizado.isDisponivel(), pratoAtualizado.getId());
    }

    public int excluirPrato(int id){
        String query = "DELETE FROM pratos WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

}
