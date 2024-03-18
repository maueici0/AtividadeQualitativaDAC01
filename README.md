create table Produto(
	id serial primary key,
	nome varchar(20) not null,
	marca varchar(20),
	precoUnitario real,
	quantidade int
);

create table Categoria (
	id serial primary key,
	nome varchar(20) not null,
	descricao varchar(100)
);

create table ProdutoCategoria (
	id serial primary key,
	idProduto int,
	idCategoria int,
	foreign key (idProduto) references Produto(id),
	foreign key (idCategoria) references Categoria(id),
    unique (idProduto,idCategoria)
);