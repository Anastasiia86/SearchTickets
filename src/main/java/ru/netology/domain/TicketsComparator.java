package ru.netology.domain;

import ru.netology.ticket.Ticket;

import java.util.Comparator;

public class TicketsComparator implements Comparator<Ticket> {

        public int compare(Ticket o1, Ticket o2) {
            return o1.getPrice() - o2.getPrice();
        }
}
