create database biblioteca
use biblioteca
select database ()
create table

create table Livros( 
    id_livro int auto_increment primary key,
    titulo varchar(50),
    autor varchar(50) ,
    ano_publicacao int ,
    genero varchar(50),
    quantidade_disponivel int
)
insert into livros (id_livro, titulo, autor, ano_publicacao, genero, quantidade_disponivel)
values(1, 'O código Da Vinci','Dan Brown', 2003, 'romance', 20)
create table Usuarios( 
    id_usuario int auto_increment primary key,
    nome varchar(50) ,
    cpf varchar(50) ,
    email varchar(50) ,
    telefone varchar(50)
)
insert into usuarios (id_usuario, nome, cpf, email, telefone)
values(1, 'Manoel',12345678910, 'manoel@gmail.com', 912345678)

show tables
describe livros
describe usuarios
drop table usuarios
select * from usuarios;
UPDATE livros SET genero = 'Romance'
WHERE id_livro = 1;