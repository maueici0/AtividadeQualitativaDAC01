package com.projeto.AtividadeQualitativa.entidades;

public class RelacaoProdutoCategoria {
    
    private Long id;
    private Categoria categoria;
    private Produto produto;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
