package br.ufra.nap01.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
}
