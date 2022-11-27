
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 3500, "DME", "KZN", 90);
    private Ticket ticket4 = new Ticket(4, 4100, "SVO", "KZN", 120);
    private Ticket ticket5 = new Ticket(5, 4500, "ZIA", "KZN", 140);
    private Ticket ticket6 = new Ticket(6, 6500, "GOJ", "KZN", 200);


    @BeforeEach
    public void before() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
    }

    @Test
    public void searchByFrom_() {
        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = manager.searchBy("VKO", "");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByFromOf() {
        Ticket[] expected = new Ticket[]{ticket3};
        Ticket[] actual = manager.searchBy("DME", "SVO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy_Of() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.searchBy("", "KZN");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOfFrom() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("KZN", "DME");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy__() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        Assertions.assertArrayEquals(expected, actual);
    }


}

