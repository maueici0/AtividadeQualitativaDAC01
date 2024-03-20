package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.AtividadeQualitativa.conexao.ConnectionFactory;
import com.projeto.AtividadeQualitativa.entidades.Produto;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Produto criaProduto(Produto produto) throws SQLException {

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

    public Produto buscaProdutoPorId(Long id) throws SQLException {

        String sql = "select * from Produto where id=?";
        Produto produto = new Produto();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                produto.setId(result.getLong("id"));
                produto.setNome(result.getString("nome"));
                produto.setMarca(result.getString("marca"));
                produto.setPrecoUnitario(result.getDouble("precoUnitario"));
                produto.setQuantidade(result.getInt("quantidade"));
            }
            result.close();
            statement.close();
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Produto> buscaProdutos() throws SQLException {

        String sql = "select * from Produto";
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getLong("id"));
                produto.setNome(result.getString("nome"));
                produto.setMarca(result.getString("marca"));
                produto.setPrecoUnitario(result.getDouble("precoUnitario"));
                produto.setQuantidade(result.getInt("quantidade"));
                produtos.add(produto);
            }
            result.close();
            statement.close();
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletaProduto(Long id) throws SQLException {

        String sql = "delete from Produto where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Produto atualizaProduto (Produto produto) throws SQLException {

        String sql = "update Produto set precoUnitario=?, quantidade=? where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, produto.getPrecoUnitario());
            statement.setInt(2, produto.getQuantidade());
            statement.setLong(3, produto.getId());
            statement.execute();
            statement.close();
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
