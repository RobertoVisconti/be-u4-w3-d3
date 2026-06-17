package robertovisconti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import robertovisconti.entities.Location;
import robertovisconti.exceptions.NotFoundByIdException;

import java.util.UUID;

public class LocationDAO {

    private final EntityManager entityManager;

    public LocationDAO(EntityManager em) {
        this.entityManager = em;
    }


    // METODI
    public void saveLocation(Location newLocation) {

        // Transazione, viene richiesta da Entity Manager per applicare le modifiche al DB
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin(); // qui la lanciamo
        this.entityManager.persist(newLocation); // qui andiamo ad effettuare un operazione di persist, per far diventare l'oggetto Managed, ovvero che può essere gestito
        transaction.commit(); // questo mi permette di poter passare l'oggetto nuovo creato alla tabella nel DB, quindi effettuo un commit

        System.out.println("La posizione : " + newLocation + "è stata salvata nel DB correttamente.");
    }


    public Location findByIdLocation(String id) {
        Location fromDB = this.entityManager.find(Location.class, UUID.fromString(id)); // se non troverà nulla mi risulterà null quindi creo un if per gestirlo
        if (fromDB == null) throw new NotFoundByIdException(id);
        return fromDB;
    }
}
