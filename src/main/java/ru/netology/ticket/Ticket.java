package ru.netology.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(Ticket o) {
        return (int) (price - o.price);
    }
}
