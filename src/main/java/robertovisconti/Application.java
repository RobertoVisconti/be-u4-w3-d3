package robertovisconti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import robertovisconti.dao.EventsDAO;
import robertovisconti.dao.LocationDAO;
import robertovisconti.dao.PartecipazioneDAO;
import robertovisconti.dao.PersonaDAO;
import robertovisconti.entities.Evento;
import robertovisconti.entities.Location;
import robertovisconti.entities.Partecipazione;
import robertovisconti.entities.Persona;
import robertovisconti.enums.TypeEvents;
import robertovisconti.enums.TypePartecipation;
import robertovisconti.enums.TypeSex;
import robertovisconti.exceptions.NotFoundByIdException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("be-u4-w3-d3");

    public static void main(String[] args) {
        // EntityManager è il ponte tra il codice java e le tabelle del DB, grazie ad esso possiamo mappare gli oggetti creati nel DB, inoltre nel file persistence.xml
        // andrà creata una class in questo caso : <class>robertovisconti.entities.Evento</class> per poter dire ad hibernate dove andare a cercare le classi da mappare
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        // DAO
        EventsDAO eventsDAO = new EventsDAO(entityManager);// per poter passare al dao l'entity manager così anche di accedere alle sue classi sul main
        LocationDAO locationDAO = new LocationDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);


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

        Location locNapoliDB = null;
        Location locLuccaDB = null;
        Location locSalernoDB = null;
        Location locMilanoDB = null;
        Location locRomaDB = null;

        try {
            locNapoliDB = locationDAO.findByIdLocation("4215f2b1-8228-4514-b659-61607463a00f");
            locLuccaDB = locationDAO.findByIdLocation("b4756e14-4d35-42dd-840d-88ecf0258c4c");
            locSalernoDB = locationDAO.findByIdLocation("b6746828-931e-40e0-974b-2617802364da");
            locRomaDB = locationDAO.findByIdLocation("23494965-5d59-4bc9-8bc3-83575f6dd1bd");
            locMilanoDB = locationDAO.findByIdLocation("e1e1d42b-9bd6-4e2b-bcb0-02e1c940c1f5");
        } catch (NotFoundByIdException ex) {
            System.out.println(ex.getMessage());
        }


        Evento ev1 = new Evento(
                "Napoli Comicon",
                LocalDate.of(2026, 5, 1),
                "Fiera Internazionale del fumetto e sessione speciale pomeridiana dedicata alle finali delle gare Cosplay e ospiti internazionali",
                TypeEvents.PUBBLICO,
                30000,
                locNapoliDB
        );

        Evento ev2 = new Evento(
                "Lucca Comics and Games",
                LocalDate.of(2026, 10, 28),
                "La fiera del fumetto, animazione, giochi e fantasy più grande d'Europa",
                TypeEvents.PUBBLICO,
                80000,
                locLuccaDB
        );

        Evento ev3 = new Evento(
                "FantaExpo Salerno",
                LocalDate.of(2026, 9, 4),
                "Fiera del fumetto, dell'animazione e del fantasy nel cuore di Salerno",
                TypeEvents.PUBBLICO,
                15000,
                locSalernoDB
        );

        Evento ev4 = new Evento(
                "Milan Games Week",
                LocalDate.of(2026, 11, 20),
                "Il più importante evento italiano dedicato interamente al gaming e agli esports",
                TypeEvents.PUBBLICO,
                50000,
                locMilanoDB
        );

        Evento ev5 = new Evento(
                "Romics autunno",
                LocalDate.of(2026, 10, 1),
                "Grande rassegna internazionale sul fumetto, animazione e games alla Fiera di Roma",
                TypeEvents.PUBBLICO,
                40000,
                locRomaDB
        );


        // Salvo nel database tramite la funzione creata nel DAO, dopodicchè commento le righe per evitare di riaggiungere gli stessi eventi ad goni run del codice
//        eventsDAO.save(ev1);
//        eventsDAO.save(ev2);
//        eventsDAO.save(ev3);
//        eventsDAO.save(ev4);
//        eventsDAO.save(ev5);

        Persona p1 = new Persona(
                "Luffy",
                "Monkey",
                "future.pirateking@email.com",
                LocalDate.of(2007, 5, 5),
                TypeSex.MASCHIO
        );

        Persona p2 = new Persona(
                "Mikasa",
                "Ackerman",
                "ereh.protector@email.com",
                LocalDate.of(2006, 2, 10),
                TypeSex.FEMMINA
        );

        Persona p3 = new Persona(
                "Naruto",
                "Uzumaki",
                "dattebayo.hokage@email.com",
                LocalDate.of(2005, 10, 10),
                TypeSex.MASCHIO
        );

        Persona p4 = new Persona(
                "Asuka",
                "Soryu",
                "eva02.pilot@email.com",
                LocalDate.of(2004, 12, 4),
                TypeSex.FEMMINA
        );

        Persona p5 = new Persona(
                "Roronoa",
                "Zoro",
                "lost.swordsman@email.com",
                LocalDate.of(2005, 11, 11),
                TypeSex.MASCHIO
        );

//        personaDAO.savePersona(p1);
//        personaDAO.savePersona(p2);
//        personaDAO.savePersona(p3);
//        personaDAO.savePersona(p4);
//        personaDAO.savePersona(p5);


        Persona p1DB = null;
        Persona p2DB = null;
        Persona p3DB = null;
        Persona p4DB = null;
        Persona p5DB = null;
        Evento ev2DB = null;
        Evento ev1DB = null;
        Evento ev4DB = null;
        Evento ev5DB = null;
        Evento ev3DB = null;

        try {
            ev1DB = eventsDAO.findById("f38561e5-177b-4feb-9684-d04667d2fe03");
            ev2DB = eventsDAO.findById("60df0beb-edcd-4134-ad14-de394f114468");
            ev3DB = eventsDAO.findById("d77a15ec-1007-4e71-ab0b-109660ba3e41");
            ev4DB = eventsDAO.findById("8061f902-7b99-4731-b9c2-5df56e2ff97d");
            ev5DB = eventsDAO.findById("836d68a3-c5ac-4b63-8e40-698ce3621261");

            p1DB = personaDAO.findByIdPersona("b402960c-4952-461c-bc89-56621addb9c0");
            p2DB = personaDAO.findByIdPersona("edb110da-701d-4953-811f-0d9ecf0673ee");
            p3DB = personaDAO.findByIdPersona("9086a075-a212-41ac-a946-ef38e96b6c78");
            p4DB = personaDAO.findByIdPersona("d94cdbcb-b336-49f3-b0ea-b2ec15430225");
            p5DB = personaDAO.findByIdPersona("84bf00a1-436f-4e49-a664-bb4a8729796b");
        } catch (NotFoundByIdException ex) {
            System.out.println(ex.getMessage());
        }


        Partecipazione pa1 = new Partecipazione(p1DB, ev2DB, TypePartecipation.CONFERMATA);
        Partecipazione pa2 = new Partecipazione(p2DB, ev1DB, TypePartecipation.DA_CONFERMARE);
        Partecipazione pa3 = new Partecipazione(p3DB, ev4DB, TypePartecipation.CONFERMATA);
        Partecipazione pa4 = new Partecipazione(p4DB, ev5DB, TypePartecipation.CONFERMATA);
        Partecipazione pa5 = new Partecipazione(p5DB, ev3DB, TypePartecipation.DA_CONFERMARE);

//        partecipazioneDAO.savePartecipazione(pa1);
//        partecipazioneDAO.savePartecipazione(pa2);
//        partecipazioneDAO.savePartecipazione(pa3);
//        partecipazioneDAO.savePartecipazione(pa4);
//        partecipazioneDAO.savePartecipazione(pa5);


        // TEST
        System.out.println("******** test relazioni ********");
        Partecipazione testRel = partecipazioneDAO.findByIdPartecipazione("41f04bbc-03db-4847-8b13-f8e59ffc7e3a");

        if (testRel != null) {
            Persona p = testRel.getPersona();
            System.out.println("L'utente: " + p.getNome() + " " + p.getCognome());

            Evento ev = testRel.getEvento();
            System.out.println("Sta partecipando all'evento: " + ev.getTitolo());
            System.out.println("Stato della prenotazione: " + testRel.getStato());

            Location loc = ev.getLocation();
            System.out.println("L'evento si terrà a: " + loc.getNome() + " nella città di " + loc.getCitta());
        } else {
            System.out.println("Partecipazione non trovata. Controllare l'id immesso");
        }

    }
}
