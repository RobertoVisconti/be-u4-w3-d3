package robertovisconti.entities;

import jakarta.persistence.*;
import robertovisconti.enums.TypeEvents;

import java.time.LocalDate;
import java.util.UUID;


@Entity // annotazione per mappare questa classe ed una tabella del DB.

@Table(name = "events") // annotazione opzionale, serve per dare un nome alla tabella che andremo a creare
public class Evento {
    @Id // annotazione obbligatoria, serve per allocare questo campo come chiave PRIMARIA

    @GeneratedValue
    //vado ora a creare le colonne che poi popolerrano la tabella events
    @Column(name = "id")
    private UUID id;

    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "descrizione", nullable = false, length = 250)
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING) // serve per dire a Hibernate di creare una casella testuale degli enum
    private TypeEvents tipoEvento;

    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private Integer numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    // Costruttore vuoto obbligatorio per Hibernate, che gli serve per Instanziare, leggere i dati e popolare il DB
    public Evento() {
    }


    // Costruttore classico
    public Evento(String titolo, LocalDate dataEvento, String descrizione, TypeEvents tipoEvento, Integer numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    // GET & SETTER


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TypeEvents getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TypeEvents tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
