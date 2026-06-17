package robertovisconti.entities;


import jakarta.persistence.*;
import robertovisconti.enums.TypePartecipation;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")

public class Partecipazione {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private TypePartecipation stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, TypePartecipation stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public TypePartecipation getStato() {
        return stato;
    }

    public void setStato(TypePartecipation stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
