package robertovisconti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import robertovisconti.entities.Persona;
import robertovisconti.exceptions.NotFoundByIdException;

import java.util.UUID;

public class PersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager em) {
        this.entityManager = em;
    }


    // METODI
    public void savePersona(Persona newPersona) {

        // Transazione, viene richiesta da Entity Manager per applicare le modifiche al DB
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin(); // qui la lanciamo
        this.entityManager.persist(newPersona); // qui andiamo ad effettuare un operazione di persist, per far diventare l'oggetto Managed, ovvero che può essere gestito
        transaction.commit(); // questo mi permette di poter passare l'oggetto nuovo creato alla tabella nel DB, quindi effettuo un commit

        System.out.println("Il nuovo evento: " + newPersona + "è stato salvato nel DB correttamente.");
    }


    public Persona findByIdPersona(String id) {
        Persona fromDB = this.entityManager.find(Persona.class, UUID.fromString(id)); // se non troverà nulla mi risulterà null quindi creo un if per gestirlo
        if (fromDB == null) throw new NotFoundByIdException(id);
        return fromDB;
    }

}
