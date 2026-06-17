package robertovisconti.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 20)
    private String citta;


    public Location() {
    }

    public Location(String citta, String nome) {
        this.citta = citta;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
