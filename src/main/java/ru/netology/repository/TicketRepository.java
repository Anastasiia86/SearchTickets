package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.NotFoundException;
import ru.netology.ticket.Ticket;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketRepository {
        private Ticket[] tickets = new Ticket[0];

        public void add(Ticket ticket) {
            int length = tickets.length + 1;
            Ticket[] temp = new Ticket[length];
            System.arraycopy(tickets, 0, temp, 0, tickets.length);
            int lastInd = temp.length - 1;
            temp[lastInd] = ticket;
            tickets = temp;
        }

        public Ticket[] findAll() {
            return tickets;
        }
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found!");
        } else {
            int length = tickets.length - 1;
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (Ticket item : tickets) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            tickets = tmp;
        }
    }

}
