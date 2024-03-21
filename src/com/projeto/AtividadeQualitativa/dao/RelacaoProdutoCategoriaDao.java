package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.AtividadeQualitativa.conexao.ConnectionFactory;
import com.projeto.AtividadeQualitativa.entidades.Categoria;
import com.projeto.AtividadeQualitativa.entidades.Produto;
import com.projeto.AtividadeQualitativa.entidades.RelacaoProdutoCategoria;

public class RelacaoProdutoCategoriaDao {

    private Connection connection;

    public RelacaoProdutoCategoriaDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public RelacaoProdutoCategoria criaRelacaoProdutoCategoria(RelacaoProdutoCategoria relacao) throws SQLException {
        String sql = "insert into relacaoProdutoCategoria (idProduto,idCategoria) values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, relacao.getProduto().getId());
            statement.setLong(2, relacao.getCategoria().getId());
            statement.execute();
            statement.close();
            return relacao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RelacaoProdutoCategoria buscaRelacaoProdutoCategoriaPorId(Long id) throws SQLException {

        String sql = "select * from relacaoProdutoCategoria where id=?";
        RelacaoProdutoCategoria relacao = new RelacaoProdutoCategoria();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                relacao.setId(result.getLong("id"));
                ProdutoDao produtoDao = new ProdutoDao();
                Produto produto = produtoDao.buscaProdutoPorId(result.getLong("idProduto"));
                relacao.setProduto(produto);
                CategoriaDao categoriaDao = new CategoriaDao();
                Categoria categoria = categoriaDao.buscaCategoriaPorId(result.getLong("idCategoria"));
                relacao.setCategoria(categoria);
            }
            return relacao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<RelacaoProdutoCategoria> buscaRelacoesProdutoCategoria() throws SQLException {
        
        String sql = "select * from RelacaoProdutoCategoria";
        ArrayList<RelacaoProdutoCategoria> relacoes = new ArrayList<RelacaoProdutoCategoria>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                RelacaoProdutoCategoria relacao = new RelacaoProdutoCategoria();
                relacao.setId(result.getLong("id"));
                ProdutoDao produtoDao = new ProdutoDao();
                Produto produto = produtoDao.buscaProdutoPorId(result.getLong("idProduto"));
                relacao.setProduto(produto);
                CategoriaDao categoriaDao = new CategoriaDao();
                Categoria categoria = categoriaDao.buscaCategoriaPorId(result.getLong("idCategoria"));
                relacao.setCategoria(categoria);
                relacoes.add(relacao);
            }
            return relacoes;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeRelacaoProdutoCategoria(Long id) throws SQLException {

        String sql = "delete from RelacaoProdutoCategoria where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
