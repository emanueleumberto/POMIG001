package org.example.gestionepizzeriajpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.gestionepizzeriajpa.utilities.StringListConverter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends Prodotto{

    @Column(name = "ingredients")
    @Convert(converter = StringListConverter.class)
    private List<String> ingredienti;

    @Override
    public String toString() {
        return " - " + super.toString() + " ingredienti: " + ingredienti;
    }

}
