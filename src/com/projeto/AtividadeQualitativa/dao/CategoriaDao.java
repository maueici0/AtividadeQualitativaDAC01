package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;

import com.projeto.AtividadeQualitativa.conexao.ConnectionFactory;
import com.projeto.AtividadeQualitativa.entidades.Categoria;

public class CategoriaDao {
    
    private Connection connection;


    public CategoriaDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

    public Categoria criarCategoria(Categoria categoria){
        
        categoria.getNome();
        
        return categoria;
    }
}
