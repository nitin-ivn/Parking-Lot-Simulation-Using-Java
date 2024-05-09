package Model;

public class Ticket {
    public int TicketNumber;
    public int slotNumber;
    public String outtime;
    public String intime;
    public String VehicleNumber;
    public int TypeOfVehicle;
    public double price;

    public Ticket(int TicketNumber, int slotNumber, String outtime, String intime, String VehicleNumber, int TypeOfVehicle){
        this.TicketNumber = TicketNumber;
        this.slotNumber = slotNumber;
        this.intime = intime;
        this.VehicleNumber = VehicleNumber;
        this.TypeOfVehicle = TypeOfVehicle;
        this.price = 10.0;

    }
}
