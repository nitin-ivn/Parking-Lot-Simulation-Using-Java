package Source;

import Contracts.ISLOT;
import Model.Slot;
import Model.Vehicle;
import Views.View;

import java.util.ArrayList;

public class SlotService implements ISLOT {
    public ArrayList<Slot> slots = new ArrayList<>();
    View view = new View();
    @Override
    public void CreateSlots(int type,int length){
        int prevlen = slots.size();
        for(int i= prevlen;i<prevlen+length;i++){
            Slot tmpslot = new Slot(type,i,false);
            slots.add(tmpslot);
        }
    }

    public void Parked(Vehicle vehicle){
        int type = getType(vehicle);
        for(Slot slot : slots){
            if(slot.slottype == type && slot.slotnumber == vehicle.slotNumber){
                slot.parked = true;
            }
        }
    }


    @Override
    public void DeleteSlot(int type,int slotnumber){
        for(Slot slot : slots){
            if(slot.slottype == type && slot.slotnumber == slotnumber){
                slot.parked = false;
            }
        }
    }

    public int getFreeSlot(Vehicle vehicle){
        int type = getType(vehicle);

        for (Slot slot : slots) {
            if (slot.slottype == type && !slot.parked) {
                return slot.slotnumber;
            }
        }
        return -1;
    }

    private int getType(Vehicle vehicle){
        if(vehicle.getType() == Vehicle.TypeVehicle.TwoWheelers){
            return  2;
        }if(vehicle.getType() == Vehicle.TypeVehicle.FourWheelers){
            return  4;
        }if(vehicle.getType() == Vehicle.TypeVehicle.HeavyWheelers){
            return  8;
        }
        return -1;
    }

    public void Viewthelot(int type,int slotsfortwo,int slotsforfour,int slotforheavy){
        int length = switch (type) {
            case 2 -> slotsfortwo;
            case 4 -> slotsforfour;
            case 8 -> slotforheavy;
            default -> 0;
        };
        view.ViewParkingSlots(slots,type,length);
    }
}
