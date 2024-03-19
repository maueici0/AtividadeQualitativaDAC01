package com.projeto.AtividadeQualitativa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        String sql = "insert into Categoria (nome, descricao) values (?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, categoria.getNome());
            statement.setString(2, categoria.getDescricao());
            statement.execute();
            statement.close();
            return categoria;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Categoria buscaCategoriaPorId(Long id) throws SQLException {
        String sql = "select * from Categoria where id=?";

        Categoria categoria = new Categoria();

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                categoria.setId(result.getLong("id"));
                categoria.setNome(result.getString("nome"));
                categoria.setDescricao(result.getString("descricao"));
            }

            result.close();
            statement.close();

            return categoria;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Categoria> buscaCategoria() throws SQLException {

        String sql = "Select * from Categoria";

        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(result.getLong("id"));
                categoria.setNome(result.getString("nome"));
                categoria.setDescricao(result.getString("descricao"));
                categorias.add(categoria);
            }
            result.close();
            statement.close();
            return categorias;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletaCategoria(Long id) throws SQLException {

        String sql = "Delete from Categoria where id=?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);
            statement.execute();
            statement.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Categoria atualizaCategoria(Categoria categoria) throws SQLException {

        String sql = "Update Categoria set nome=?, descricao=? where id=?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, categoria.getId());
            statement.setString(2, categoria.getNome());
            statement.setString(3, categoria.getDescricao());

            statement.execute();
            statement.close();
            return categoria;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
