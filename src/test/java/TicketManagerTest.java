import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketManagerTest {

    @Test
    public void testSortTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "MOW", "SPB", 900, 60);
        Ticket ticket2 = new Ticket(2, "MOW", "SPB", 200, 75);
        Ticket ticket3 = new Ticket(3, "MOW", "SPB", 600, 99);
        Ticket ticket4 = new Ticket(4, "SPB", "KAZ", 700, 85);
        Ticket ticket5 = new Ticket(5, "KAZ", "SPB", 300, 85);
        Ticket ticket6 = new Ticket(6, "KUF", "SPB", 100, 120);
        Ticket ticket7 = new Ticket(7, "MOW", "SPB", 100, 100);
        Ticket ticket8 = new Ticket(8, "MOW", "SPB", 800, 60);
        Ticket ticket9 = new Ticket(9, "SPB", "BAR", 500, 190);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expectad = {ticket7, ticket2, ticket3, ticket8, ticket1};
        Ticket[] actual = manager.findAll("MOW", "SPB");

        Assertions.assertArrayEquals(expectad, actual);
    }

    @Test
    public void testSortTicketFindZero() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "MOW", "SPB", 900, 60);
        Ticket ticket2 = new Ticket(2, "MOW", "SPB", 200, 75);
        Ticket ticket3 = new Ticket(3, "MOW", "SPB", 600, 99);
        Ticket ticket4 = new Ticket(4, "SPB", "KAZ", 700, 85);
        Ticket ticket5 = new Ticket(5, "KAZ", "SPB", 300, 85);
        Ticket ticket6 = new Ticket(6, "KUF", "SPB", 100, 120);
        Ticket ticket7 = new Ticket(7, "MOW", "SPB", 100, 100);
        Ticket ticket8 = new Ticket(8, "MOW", "SPB", 800, 60);
        Ticket ticket9 = new Ticket(9, "SPB", "BAR", 500, 190);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expectad = {};
        Ticket[] actual = manager.findAll("MOW", "KAZ");

        Assertions.assertArrayEquals(expectad, actual);
    }

    @Test
    public void testSortTicketFindRandom() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "MOW", "SPB", 900, 60);
        Ticket ticket2 = new Ticket(2, "MOW", "SPB", 200, 75);
        Ticket ticket3 = new Ticket(3, "MOW", "SPB", 600, 99);
        Ticket ticket4 = new Ticket(4, "MOW", "SPB", 700, 85);
        Ticket ticket5 = new Ticket(5, "KAZ", "SPB", 300, 85);
        Ticket ticket6 = new Ticket(6, "KUF", "SPB", 100, 120);
        Ticket ticket7 = new Ticket(7, "MOW", "SPB", 100, 100);
        Ticket ticket8 = new Ticket(8, "MOW", "SPB", 800, 60);
        Ticket ticket9 = new Ticket(9, "SPB", "BAR", 500, 190);
        manager.add(ticket2);
        manager.add(ticket5);
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket8);
        manager.add(ticket6);
        manager.add(ticket4);
        manager.add(ticket7);
        manager.add(ticket5);

        Ticket[] expected = {ticket7, ticket2, ticket3, ticket4, ticket8, ticket1,};
        Ticket[] actual = manager.findAll("MOW", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveTicketNotFoundExcept() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "MOW", "SPB", 900, 60);
        Ticket ticket2 = new Ticket(2, "MOW", "SPB", 200, 75);
        Ticket ticket3 = new Ticket(3, "MOW", "SPB", 600, 99);
        Ticket ticket4 = new Ticket(4, "SPB", "KAZ", 700, 85);
        Ticket ticket5 = new Ticket(5, "KAZ", "SPB", 300, 85);
        Ticket ticket6 = new Ticket(6, "KUF", "SPB", 100, 120);
        Ticket ticket7 = new Ticket(7, "MOW", "SPB", 100, 100);
        Ticket ticket8 = new Ticket(8, "MOW", "SPB", 800, 60);
        Ticket ticket9 = new Ticket(9, "SPB", "BAR", 500, 190);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expectad = {ticket7, ticket2, ticket3, ticket8, ticket1};
        Ticket[] actual = manager.findAll("MOW", "SPB");

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(15)
        );
    }

    @Test
    public void testRemoveTicketById() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "MOW", "SPB", 900, 60);
        Ticket ticket2 = new Ticket(2, "MOW", "SPB", 200, 75);
        Ticket ticket3 = new Ticket(3, "MOW", "SPB", 600, 99);
        Ticket ticket4 = new Ticket(4, "SPB", "KAZ", 700, 85);
        Ticket ticket5 = new Ticket(5, "KAZ", "SPB", 300, 85);
        Ticket ticket6 = new Ticket(6, "KUF", "SPB", 100, 120);
        Ticket ticket7 = new Ticket(7, "MOW", "SPB", 100, 100);
        Ticket ticket8 = new Ticket(8, "MOW", "SPB", 800, 60);
        Ticket ticket9 = new Ticket(9, "SPB", "BAR", 500, 190);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repo.removeById(9);

        Assertions.assertArrayEquals(expected, actual);

    }

}
