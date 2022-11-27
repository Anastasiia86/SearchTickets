package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.ticket.Ticket;

public class TicketRepositoryTest {

    TicketRepository ticketRepository = new TicketRepository();
    TicketRepository repositoryEmpty = new TicketRepository();


    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 3500, "DME", "KZN", 90);
    private Ticket ticket4 = new Ticket(4, 4100, "SVO", "KZN", 120);
    private Ticket ticket5 = new Ticket(5, 4500, "ZIA", "KZN", 140);
    private Ticket ticket6 = new Ticket(6, 6500, "GOJ", "KZN", 200);

    @BeforeEach
    public void setup() {
        ticketRepository.add(ticket1);
        ticketRepository.add(ticket2);
        ticketRepository.add(ticket3);
        ticketRepository.add(ticket4);
        ticketRepository.add(ticket5);
        ticketRepository.add(ticket6);

    }

    @Test
    public void shouldAddTicket() {
        Ticket[] expected = new Ticket[]{
                ticket1,
                ticket2,
                ticket3};
        repositoryEmpty.add(ticket1);
        repositoryEmpty.add(ticket2);
        repositoryEmpty.add(ticket3);


        Assertions.assertArrayEquals(expected, repositoryEmpty.findAll());
    }


}



