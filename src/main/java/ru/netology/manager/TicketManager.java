package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class TicketManager {
    TicketRepository repository = new TicketRepository();

    public void save(Ticket ticket) {
        repository.add(ticket);
    }


    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (ticket.getFrom().equals(from) || ticket.getTo().equals(to)) {
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}


