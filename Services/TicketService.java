package Services;

import Contracts.ITICKET;
import Model.Ticket;
import Views.View;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.time.temporal.ChronoUnit;

public class TicketService implements ITICKET {
    public ArrayList<Ticket> tickets = new ArrayList<>();
    View views = new View();


    @Override
    public void CreateTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket Created Successfully");
        views.printInputTicket(ticket);
    }

    @Override
    public int DeleteTicket(int type, int ticketNumber, LocalDateTime intime) {
        int slotn=-1;
        LocalDateTime outtime = LocalDateTime.now();
        for(Ticket ticket : tickets){
            if(ticket.TypeOfVehicle == type && ticket.TicketNumber == ticketNumber){
                slotn = ticket.slotNumber;
                ticket.outtime = time();
                ticket.price += calculatePrice(intime,outtime);
                views.printOutputTicket(ticket);
                tickets.remove(ticket);
                return slotn;
            }
        }
        return slotn;
    }

    private String time(){
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(currentTime);
    }


    private double calculatePrice(LocalDateTime startTime, LocalDateTime endTime) {
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime) % 60;
        double totalHours = hours + (minutes / 60.0);
        return totalHours * 10.0;
    }
}
