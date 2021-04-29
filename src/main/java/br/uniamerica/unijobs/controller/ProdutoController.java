package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.model.*;

import java.util.ArrayList;

public class ProdutoController {

    public static Produto main() {
        Curso curso1 = new Curso(1, "Engenharia Software");
        Curso curso2 = new Curso(2, "Direito");
        Curso curso3 = new Curso(3, "Medicina");
        ArrayList<Curso> cursos = new ArrayList();

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);

        Universidade universidade1 = new Universidade(1, "Uniamerica", "888888888888888", cursos);

        TipoUsuario tipoUsuario1 = new TipoUsuario(1,"Administrador Geral");

        Usuario usuario1 = new Usuario("Nelson", "888888888", "888888", universidade1, curso1, 1, "teste@gmail.com", "semsenha", tipoUsuario1);

        TipoProduto tipoProduto = new TipoProduto(1, "Gastronomia", "Produtos relacionados a comestiveis");

        ArrayList<Imagem> imagens = new ArrayList();
        ArrayList<Avaliacao> avaliacoes = new ArrayList();

        Produto produto = new Produto(1, usuario1, "Rocambole", "Sabor coco com chocolate", 20.99,
                "https://www.google.com/url?sa=i&url=https%3", true, avaliacoes, imagens, 1, tipoProduto);
        return produto;
    }
}
