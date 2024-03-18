package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.AtividadeQualitativa.conexao.ConnectionFactory;
import com.projeto.AtividadeQualitativa.entidades.Categoria;

public class CategoriaDao {

    private Connection connection;

    public CategoriaDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Categoria criaCategoria(Categoria categoria) throws SQLException {
        return categoria;
    }

    public Categoria buscaCategoriaPorId(Long id) throws SQLException {
        return null;
    }

    public ArrayList<Categoria> buscaCategoria() throws SQLException {
        return null;
    }

    public void deletaCategoria(Long id) throws SQLException {

    }

    public Categoria atualizCategoria(Categoria categoria) throws SQLException {
        return categoria;
    }
}
