package robertovisconti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import robertovisconti.entities.Evento;
import robertovisconti.exceptions.NotFoundByIdException;

public class EventsDAO {
    // DAO stà per Data Access Object e ci serve per fornire dei metodi semplici da usare nel main nascondendo la complessità delle righe di codice


    // serve per poter parlare col DB, così al lancio dei nostri metodi essi verranno letti ed eseguiti dal DB
    private final EntityManager entityManager;

    public EventsDAO(EntityManager em) {
        this.entityManager = em;
    }


    // METODI
    public void save(Evento newEvento) {

        // Transazione, viene richiesta da Entity Manager per applicare le modifiche al DB
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin(); // qui la lanciamo
        this.entityManager.persist(newEvento); // qui andiamo ad effettuare un operazione di persist, per far diventare l'oggetto Managed, ovvero che può essere gestito
        transaction.commit(); // questo mi permette di poter passare l'oggetto nuovo creato alla tabella nel DB, quindi effettuo un commit

        System.out.println("Il nuovo evento: " + newEvento + "è stato salvato nel DB correttamente.");
    }


    public Evento findById(long id) {
        Evento fromDB = this.entityManager.find(Evento.class, id); // se non troverà nulla mi risulterà null quindi creo un if per gestirlo
        if (fromDB == null) throw new NotFoundByIdException(id);
        return fromDB;
    }


    public void deleteById(long id) {
        Evento fromDB = this.findById(id); // gli passo la funzione custom di ricerca id creata in prcedenza
        // ricreiamo la transazion di prima per poter gestire l oggetto del DB
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin(); // qui la lanciamo
        this.entityManager.remove(fromDB); // qui gli diciamo che l'oggetto equivalente all id in questo caso l evento dovrà essere rimosso
        transaction.commit(); // qui gli diciamo che la record corrispondente all id dell'oggetto è da rimuovere
        System.out.println("L'evento " + fromDB + " è stato rimosso con successo.");
    }

    public void updateEvent(long id, Evento update) {
        Evento trovato = this.findById(id); // gli passo la funzione custom di ricerca id creata in prcedenza
        EntityTransaction transaction = this.entityManager.getTransaction();// ricreiamo la transazion di prima per poter gestire l oggetto del DB
        transaction.begin(); // qui la lanciamo

        // qui vado ad aggiornare i dati dell'evento
        trovato.setTitolo(update.getTitolo());
        trovato.setDescrizione(update.getDescrizione());
        trovato.setDataEvento(update.getDataEvento());
        trovato.setTipoEvento(update.getTipoEvento());
        trovato.setNumeroMassimoPartecipanti(update.getNumeroMassimoPartecipanti());

        transaction.commit(); // qui gli diciamo che la record corrispondente all id dell'oggetto è da rimuovere

        System.out.println("L'evento con id " + id + " è stato aggiornato correttamente.");
    }
}
