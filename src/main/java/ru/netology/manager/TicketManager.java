package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;
import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class TicketManager {
    TicketRepository repository = new TicketRepository();
    private Ticket[] tickets = new Ticket[0];

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

    public Ticket[] findFromToSorted(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            int length = result.length;
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

}


