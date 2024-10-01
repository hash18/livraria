package com.maislivros.livraria.entity;

/**
 *
 * @author Rangel
 */
//controller -> service -> repository

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
    @Id // Gera a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Responsagem por gerar valores de maneira crescente, começando pelo número 1
    private Long id;
    private String nome;
    // Atributos privados, usando os getters and setters para disponibilizar os resultados
    
    //relacionamento com a tabela autor
    @ManyToOne
    @JoinColumn(name = "autor_id") // foreing key na tabela livros
    private Autor autor;

    // Getter para id
    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para nome
    public String getNome() {
        return nome;
    }

    // etter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }
}