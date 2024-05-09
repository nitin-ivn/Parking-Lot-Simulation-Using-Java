package Contracts;

import Model.Ticket;

import java.time.LocalDateTime;

public interface ITICKET {
    public void CreateTicket(Ticket ticket);

    public int DeleteTicket(int type, int ticketNumber, LocalDateTime intime);
}
