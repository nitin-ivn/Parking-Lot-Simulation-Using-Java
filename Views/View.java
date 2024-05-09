package Views;

import Model.Slot;
import Model.Ticket;

import java.util.ArrayList;

public class View {
    public void printInputTicket(Ticket ticket){
        System.out.println();
        System.out.println("---------TICKET----------");
        System.out.println("Ticket Number:  "+ticket.TicketNumber);
        System.out.println("Vehicle Number: "+ticket.VehicleNumber);
        System.out.println("Type of Vehicle:"+ticket.TypeOfVehicle +" Wheeler");
        System.out.println("InTime:         "+ticket.intime);
        System.out.println("Slot Number:    "+ticket.slotNumber+1);
        System.out.println();
        System.out.println();
        return;
    }

    public void printOutputTicket(Ticket ticket){
        System.out.println("Unparking Successfull");
        System.out.println();
        System.out.println("-----------TICKET-------------");
        System.out.println("Ticket Number:     "+ticket.TicketNumber);
        System.out.println("Vehicle Number:    "+ticket.VehicleNumber);
        System.out.println("Type of Vehicle:   "+ticket.TypeOfVehicle +" Wheeler");
        System.out.println("InTime:            "+ticket.intime);
        System.out.println("OutTime:           "+ticket.outtime);
        System.out.println("Slot Number:       "+ticket.slotNumber+1);
        System.out.println("Amount to be paid: "+ticket.price);
        System.out.println();
        System.out.println();
    }

    public void ViewParkingSlots(ArrayList<Slot> slots,int type,int length){

        String[] park = new String[length];
        int i=0;
        for(Slot slot : slots){
            if(i==park.length) break;
            if(slot.slottype == type && !slot.parked){
                park[i] = "up";
                i++;
            }else if(slot.slottype == type && slot.parked){
                park[i] = "p";
                i++;
            }
        }
        display(park,type);
    }

    private void display(String[] park,int type){
        int[] temp = new int[park.length];
        for (int m = 0; m < park.length; m++) {
            temp[m] = m + 1;
        }

        int elements = 3;
        System.out.println();
        System.out.println("Parking Lot For "+type+" Wheelers");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + "  ");
            if ((i + 1) % elements == 0) {
                System.out.println();
                for (int j = 0; j < elements; j++) {
                    if (park[i].equals("p"))
                        System.out.print(park[i] + "  ");

                    if (park[i].equals("up"))
                        System.out.print(park[i] + " ");
                }
                System.out.println();
                System.out.println();
            }
        }
        int ele = temp.length % 3;
        if (ele != 0) {
            System.out.println();
            for (int n = ele; n > 0; n--) {
                if (park[temp.length - n].equals("up"))
                    System.out.print(park[temp.length - n] + " ");
                if (park[temp.length - n].equals("p"))
                    System.out.print(park[temp.length - n] + "  ");

            }
        }
        System.out.println();
    }
}
