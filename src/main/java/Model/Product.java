package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.StringJoiner;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDate registered;
    LocalDate expiration;
    Double weight;
    Integer pieces;

    @Override
    public String toString() {
        StringBuilder sj = new StringBuilder();
        sj.append(id.toString())
                .append(" - ")
                .append(name)
                .append(": ")
                .append(registered.toString())
                .append(" - ")
                .append(expiration.toString())
                .append(" || ")
                .append(weight.toString())
                .append(" kg")
                .append(" - ")
                .append(pieces.toString())
                .append(" darab");

        return sj.toString();
    }
}
