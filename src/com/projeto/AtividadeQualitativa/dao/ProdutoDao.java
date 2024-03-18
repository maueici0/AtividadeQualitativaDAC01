package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.projeto.AtividadeQualitativa.conexao.ConnectionFactory;
import com.projeto.AtividadeQualitativa.entidades.Produto;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Produto criarProduto(Produto produto) {

        String sql = "insert into Produto (nome, marca, precoUnitario, quantidade) values (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getMarca());
            statement.setDouble(3, produto.getPrecoUnitario());
            statement.setInt(4, produto.getQuantidade());
            statement.execute();
            statement.close();
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
