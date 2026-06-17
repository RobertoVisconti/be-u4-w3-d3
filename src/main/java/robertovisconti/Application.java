package robertovisconti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import robertovisconti.dao.EventsDAO;
import robertovisconti.dao.LocationDAO;
import robertovisconti.entities.Evento;
import robertovisconti.entities.Location;
import robertovisconti.enums.TypeEvents;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("be-u4-w3-d3");

    public static void main(String[] args) {
        // EntityManager è il ponte tra il codice java e le tabelle del DB, grazie ad esso possiamo mappare gli oggetti creati nel DB, inoltre nel file persistence.xml
        // andrà creata una class in questo caso : <class>robertovisconti.entities.Evento</class> per poter dire ad hibernate dove andare a cercare le classi da mappare
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventsDAO eventsDAO = new EventsDAO(entityManager);// per poter passare al dao l'entity manager così anche di accedere alle sue classi sul main
        LocationDAO locationDAO = new LocationDAO(entityManager);


        Location locNapoli = new Location("Napoli", "Mostra D'oltremare");
        Location locLucca = new Location("Lucca", "Centro Storico Lucca");
        Location locSalerno = new Location("Salerno", "Parco dell'Irno");
        Location locRoma = new Location("Roma", "Fiera di Roma");
        Location locMilano = new Location("Milano", "Fiera Milano Rho");

//        locationDAO.saveLocation(locNapoli);
//        locationDAO.saveLocation(locLucca);
//        locationDAO.saveLocation(locSalerno);
//        locationDAO.saveLocation(locRoma);
//        locationDAO.saveLocation(locMilano);


        Evento ev1 = new Evento(
                "Napoli Comicon",
                LocalDate.of(2026, 5, 1),
                "Fiera Internazionale del fumetto e sessione speciale pomeridiana dedicata alle finali delle gare Cosplay e ospiti internazionali",
                TypeEvents.PUBBLICO,
                30000,
                locNapoli
        );

        Evento ev2 = new Evento(
                "Lucca Comics and Games",
                LocalDate.of(2026, 10, 28),
                "La fiera del fumetto, animazione, giochi e fantasy più grande d'Europa",
                TypeEvents.PUBBLICO,
                80000,
                locLucca
        );

        Evento ev3 = new Evento(
                "FantaExpo Salerno",
                LocalDate.of(2026, 9, 4),
                "Fiera del fumetto, dell'animazione e del fantasy nel cuore di Salerno",
                TypeEvents.PUBBLICO,
                15000,
                locSalerno
        );

        Evento ev4 = new Evento(
                "Milan Games Week",
                LocalDate.of(2026, 11, 20),
                "Il più importante evento italiano dedicato interamente al gaming e agli esports",
                TypeEvents.PUBBLICO,
                50000,
                locMilano
        );

        Evento ev5 = new Evento(
                "Romics autunno",
                LocalDate.of(2026, 10, 1),
                "Grande rassegna internazionale sul fumetto, animazione e games alla Fiera di Roma",
                TypeEvents.PUBBLICO,
                40000,
                locRoma
        );


        // Salvo nel database tramite la funzione creata nel DAO, dopodicchè commento le righe per evitare di riaggiungere gli stessi eventi ad goni run del codice
//        eventsDAO.save(ev1);
//        eventsDAO.save(ev2);
//        eventsDAO.save(ev3);
//        eventsDAO.save(ev4);
//        eventsDAO.save(ev5);

    }
}
