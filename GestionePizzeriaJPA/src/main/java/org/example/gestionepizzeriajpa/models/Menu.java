package org.example.gestionepizzeriajpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id",  nullable = false)
    private Long id;
    @Column(name = "menu_name",  nullable = false)
    private String nome;

    @OneToMany(mappedBy = "menu",  fetch = FetchType.EAGER)
    private List<Prodotto> listaProdotto;

}
