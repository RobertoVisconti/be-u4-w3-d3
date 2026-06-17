package robertovisconti.entities;


import jakarta.persistence.*;
import robertovisconti.enums.TypeSex;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 30)
    private String cognome;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;

    @Column(name = "sesso", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeSex sesso;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, TypeSex sesso) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public TypeSex getSesso() {
        return sesso;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                '}';
    }
}
