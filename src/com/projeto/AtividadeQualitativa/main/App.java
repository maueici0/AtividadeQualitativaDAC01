package com.projeto.AtividadeQualitativa.main;

import com.projeto.AtividadeQualitativa.dao.CategoriaDao;
import com.projeto.AtividadeQualitativa.dao.ProdutoDao;
import com.projeto.AtividadeQualitativa.dao.RelacaoProdutoCategoriaDao;
import com.projeto.AtividadeQualitativa.entidades.Categoria;
import com.projeto.AtividadeQualitativa.entidades.Produto;
import com.projeto.AtividadeQualitativa.entidades.RelacaoProdutoCategoria;

import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        ProdutoDao produtoDao = new ProdutoDao();
        CategoriaDao categoriaDao = new CategoriaDao();
        RelacaoProdutoCategoriaDao relacaoProdutoCategoriaDao = new RelacaoProdutoCategoriaDao();

        Scanner scanner = new Scanner(System.in);

        int resp = 0;

        do{
            
        resp = menu(scanner);

        if(resp == 1){
            int opcao = menuProduto(scanner);

            switch (opcao){
                case 1:
                //inserir um produto
                Produto produto = new Produto();
                System.out.println("Insira o id do produto:");
                produto.setId((long) scanner.nextInt());

                System.out.println("Insira o nome do produto:");
                produto.setNome(scanner.next());

                System.out.println("Insira a marca do produto:");
                produto.setMarca(scanner.next());

                System.out.println("Insira o preço unitário:");
                produto.setPrecoUnitario(scanner.nextDouble());

                System.out.println("Informe a quantidade em estoque:");
                produto.setQuantidade(scanner.nextInt());

                produtoDao.criaProduto(produto);

                System.out.println("Produto criado com sucesso!");

                scanner.next();
                break;

                case 2:
                //atualizar produto
                System.out.println("Informe o id do produto a ser atualizado:");
                produto = produtoDao.buscaProdutoPorId((long) scanner.nextInt());

                System.out.println("Insira o novo preço unitário:");
                produto.setPrecoUnitario(scanner.nextDouble());

                System.out.println("Insira a nova quantidade do estoque:");
                produto.setQuantidade(scanner.nextInt());

                produtoDao.atualizaProduto(produto);

                System.out.println("Produto atualizado com sucesso!");

                scanner.next();
                break;
                
                case 3:
                //listar produtos
                for (Produto p : produtoDao.buscaProdutos()) {

                    System.out.println("Id: "+ p.getId());
                    System.out.println("Nome: "+ p.getNome());
                    System.out.println("Marca: "+ p.getMarca());
                    System.out.println("Preço: "+ p.getPrecoUnitario());
                    System.out.println("Quantidade: "+ p.getQuantidade());
                    System.out.println("\n");
                  
                };

                scanner.next();
                break;

                case 4:
                //buscar produto por id
                System.out.println("Insira o id do produto desejado:");
                produto = produtoDao.buscaProdutoPorId((long) scanner.nextInt());

                System.out.println("Nome: " + produto.getNome());
                System.out.println("Marca: " + produto.getMarca());
                System.out.println("Preço: " + produto.getPrecoUnitario());
                System.out.println("Quantidade: " + produto.getQuantidade());

                scanner.next();
                break;

                case 5:
                //excluir produto
                System.out.println("Insira o id do produto a ser excluídO:");
                produtoDao.deletaProduto((long) scanner.nextInt());

                System.out.println("Produto excluído com sucesso!");
                scanner.next();
                break;

                case 6: break;
            }

        }
        else if(resp == 2){
            int opcao = menuCategoria(scanner);

            switch(opcao){
                case 1:
                //criar categoria
                Categoria categoria = new Categoria();
                System.out.println("Informe um id para a categoria:");
                categoria.setId((long) scanner.nextInt());

                System.out.println("Informe o nome da categoria:");
                categoria.setNome(scanner.next());

                System.out.println("Descreva a categoria:");
                categoria.setDescricao(scanner.next());

                categoriaDao.criaCategoria(categoria);

                System.out.println("Categoria criada com sucesso!");
                scanner.next();
                break;

                case 2:
                //atualizar categoria
                System.out.println("Informe o id da categoria a ser atualizada:");
                categoria = categoriaDao.buscaCategoriaPorId((long) scanner.nextInt());

                System.out.println("Insira a nova descrição:");
                categoria.setDescricao(scanner.next());

                categoriaDao.atualizaCategoria(categoria);

                System.out.println("Categoria atualizada com sucesso!");
                
                scanner.next();
                break;

                case 3:
                //listar categorias
                for (Categoria c : categoriaDao.buscaCategoria()) {

                    System.out.println("Id: "+ c.getId());
                    System.out.println("Nome: "+ c.getNome());
                    System.out.println("Marca: "+ c.getDescricao());

                };
                scanner.next();
                break;

                case 4:
                //procurar categoria por id
                System.out.println("Informe o id da categoria desejada:");
                categoria = categoriaDao.buscaCategoriaPorId((long) scanner.nextInt());

                System.out.println(categoria.getNome());
                System.out.println(categoria.getDescricao());
                
                scanner.next();
                break;

                case 5:
                //deletar categoria
                System.out.println("Informe o id da categoria a ser excluída:");
                categoriaDao.deletaCategoria((long) scanner.nextInt());

                System.out.println("Categoria excluída com sucesso!");
                
                scanner.next();
                break;

                case 6: break;
            }

        }
        else if(resp == 3){
            int opcao = menuRelacao(scanner);

            switch (opcao) {
                case 1:
                //cria relação
                RelacaoProdutoCategoria relacaoProdutoCategoria = new RelacaoProdutoCategoria();

                System.out.println("Informe o id da relação:");
                relacaoProdutoCategoria.setId((long) scanner.nextInt());

                System.out.println("Informe o id do produto relacionado:");
                Produto produto = produtoDao.buscaProdutoPorId((long) scanner.nextInt());
                relacaoProdutoCategoria.setProduto(produto);

                System.out.println("Informe o id da categoria relacionado:");
                Categoria categoria = categoriaDao.buscaCategoriaPorId((long) scanner.nextInt());
                relacaoProdutoCategoria.setCategoria(categoria);

                System.out.println("Relação entre produto e categoria criada.");

                scanner.next();
                break;

                case 2:
                //lista relacoes
                
                for (RelacaoProdutoCategoria r: relacaoProdutoCategoriaDao.buscaRelacoesProdutoCategoria()){

                    System.out.println(r.getId());
                    System.out.println(r.getProduto());
                    System.out.println(r.getCategoria());

                }

                scanner.next();
                break;

                case 3:
                //busca relacao por id
                System.out.println("Informe o id da relação desejada:");
                relacaoProdutoCategoria = relacaoProdutoCategoriaDao.buscaRelacaoProdutoCategoriaPorId((long) scanner.nextInt());

                System.out.println(relacaoProdutoCategoria);
                
                scanner.next();
                break;

                case 4:
                //deleta relacao
                System.out.println("Informe o id da relação a ser excluida:");
                relacaoProdutoCategoriaDao.removeRelacaoProdutoCategoria((long) scanner.nextInt());

                System.out.println("Relação entre produto e categoria excluída.");
                
                scanner.next();
                break;

                case 5: break;
            }
        }
    } while(resp != 4);

    scanner.close();
    System.exit(0);
}

    public static int menu(Scanner scanner) {

        System.out.println("-------Selecione uma opção------");
        System.out.println("1 - Operações relacionadas a produto");
        System.out.println("2 - Operações relacionadas a categoria");
        System.out.println("3 - Operações relacionadas a produto e categoria");
        System.out.println("4 - Sair do programa");
        int res = scanner.nextInt();

        limpaTela();
        return res;
    }

    public static int menuProduto(Scanner scanner){

        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Atualizar produto");
        System.out.println("3 - Listar produtos");
        System.out.println("4 - Procurar produto por id");
        System.out.println("5 - Deletar produto");
        System.out.println("6 - Voltar");
        int res = scanner.nextInt();

        limpaTela();
        return res;
    }

    public static int menuCategoria(Scanner scanner){

        System.out.println("1 - Adicionar categoria");
        System.out.println("2 - Atualizar categoria");
        System.out.println("3 - Listar categorias");
        System.out.println("4 - Procurar categoria por id");
        System.out.println("5 - Deletar categoria");
        System.out.println("6 - Voltar");

        int res = scanner.nextInt();

        limpaTela();
        return res;
    }

    public static int menuRelacao(Scanner scanner){

        System.out.println("1 - Criar relacão entre produto e categoria");
        System.out.println("2 - Listar relações");
        System.out.println("3 - Buscar relação por id");
        System.out.println("4 - Deletar relação");
        System.out.println("5 - Voltar");

        int res = scanner.nextInt();
        
        limpaTela();
        return res;
    }

    //limpa tudo o que veio antes
    public static void limpaTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
