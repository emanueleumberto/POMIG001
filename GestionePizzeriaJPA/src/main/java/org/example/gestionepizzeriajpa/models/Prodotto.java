package org.example.gestionepizzeriajpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;
    @Column(name = "product_name",  nullable = false)
    private String nome;
    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT '5.00'")
    private Double prezzo;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Override
    public String toString() {
        return id + " - " + nome + ", prezzo: €" + prezzo + ", menu: " + menu.getNome();
    }


}
