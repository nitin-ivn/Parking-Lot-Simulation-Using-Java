import Model.*;
import Source.*;

import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class main {

    public static void main(String[] args){
        int slotsforTwo,slotsforFour,slotsforHeavy;
        Scanner sc = new Scanner(System.in);
        main Main = new main();

        while(true){
            try {
                System.out.print("Enter the slots for 2 Wheelers: ");
                slotsforTwo = sc.nextInt();
                if(slotsforTwo < 0){
                    continue;
                }
                    break;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
            }
        }

        while(true){
            try {
                System.out.print("Enter the slots for 4 Wheelers: ");
                slotsforFour = sc.nextInt();
                if(slotsforFour < 0){
                    continue;
                }
                break;
            }catch(java.util.InputMismatchException e){
                System.out.print("Enter a valid number: ");
            }
        }

        while(true){
            try {
                System.out.print("Enter the slots for Heavy Vechiles: ");
                slotsforHeavy = sc.nextInt();
                if(slotsforHeavy < 0){
                    continue;
                }
                break;
            }catch(java.util.InputMismatchException e){
                System.out.print("Enter a valid number: ");
            }
        }
        SlotService slotService = new SlotService();
        TicketService ticketService = new TicketService();

        slotService.CreateSlots(2, slotsforTwo);
        slotService.CreateSlots(4, slotsforFour);
        slotService.CreateSlots(8, slotsforHeavy);
        LocalDateTime currentDateTime = LocalDateTime.now();

        boolean shouldContinue = true;
        while(shouldContinue){
            System.out.println("1-Park\n2-Unpark\n3-View\n4-Exit");
            switch(sc.nextInt()){
                case 1 :
                    System.out.println("1 - 2 Wheelers\n2 - 4 Wheelers\n3 - Heavy Vehicles");
                    currentDateTime = LocalDateTime.now();
                    Vehicle vehicle = new Vehicle();
                    boolean isCorrectWheels = true;
                    while(isCorrectWheels) {
                        switch (sc.nextInt()) {
                            case 1:
                                    vehicle.setType(Vehicle.TypeVehicle.TwoWheelers);
                                    isCorrectWheels = false;
                                    break;
                                case 2:
                                    vehicle.setType(Vehicle.TypeVehicle.FourWheelers);
                                    isCorrectWheels = false;
                                    break;
                                case 3:
                                    vehicle.setType(Vehicle.TypeVehicle.HeavyWheelers);
                                    isCorrectWheels = false;
                                    break;
                                default:
                                    System.out.println("Wrong Input. Please Try again: ");
                                    break;
                            }
                        }
                    int freeslot = slotService.getFreeSlot(vehicle);
                    if(freeslot==-1){
                        System.out.println("No Vacant Slots");
                        break;
                    }
                    vehicle.slotNumber = freeslot;
                    Ticket ticket = Main.TakeTicketFromUser(vehicle,freeslot);
                    vehicle.VechileNumber = ticket.VehicleNumber;
                    ticketService.CreateTicket(ticket);
                    slotService.Parked(vehicle);
                    break;


                case 2 :
                    int type= Main.returnType("Unparking");
                    int DelTicket=0,slotnum;
                        System.out.println("Enter your Ticket Number: ");
                        try {
                            DelTicket = sc.nextInt();
                        }catch(java.util.InputMismatchException e){
                            sc.nextLine();
                        }
                    slotnum = ticketService.DeleteTicket(type, DelTicket,currentDateTime);
                    if (slotnum == -1) {
                        System.out.println("No Vehicle is Parked with such Ticket Number");
                    }
                    slotService.DeleteSlot(type,slotnum);
                    break;

                case 3 :
                    int typeView = Main.returnType("Viewing");
                    slotService.Viewthelot(typeView,slotsforTwo,slotsforFour,slotsforHeavy);
                    break;

                case 4 : shouldContinue = false;
                    break;

                default:
                    System.out.print("Enter a valid input: ");
            }
        }
    }

    public Ticket TakeTicketFromUser(Vehicle vehicle, int slotnumber){
        int type=0;
        if(vehicle.getType() == Vehicle.TypeVehicle.TwoWheelers){
            type = 2;
        }if(vehicle.getType() == Vehicle.TypeVehicle.FourWheelers){
            type = 4;
        }if(vehicle.getType() == Vehicle.TypeVehicle.HeavyWheelers){
            type = 8;
        }

        Scanner sc =new Scanner(System.in);
        int TicketNo =  random();
        String intime = time();
        System.out.print("Enter the Vehicle Number: ");
        String vehicleNumber = sc.next();
        return new Ticket(TicketNo,slotnumber,null,intime, vehicleNumber,type);
    }

    private int random(){
        Random rand = new Random();
        return (rand.nextInt(9000)+1000);
    }

    private String time(){
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(currentTime);
    }


    private int returnType(String str){
        Scanner sc = new Scanner(System.in);
        int type=0;
        System.out.println("Enter the Vehicle for "+str +" : ");
        System.out.println("1 - 2 Wheelers\n2 - 4 Wheelers\n3 - Heavy Vehicles");
        boolean isCorrectWheel = true;
        while(isCorrectWheel) {
            switch (sc.nextInt()) {
                case 1:
                    type = 2;
                    isCorrectWheel = false;
                    break;
                case 2:
                    type = 4;
                    isCorrectWheel = false;
                    break;
                case 3:
                    type = 8;
                    isCorrectWheel = false;
                    break;
                default:
                    System.out.println("Wrong Input. Please Try again: ");
                    break;
            }
        }
        return type;
    }
}
