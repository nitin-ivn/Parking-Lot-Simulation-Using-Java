package Source;

import Contracts.ISLOT;
import Model.Slot;
import Model.Vehicle;
import Views.View;

import java.util.ArrayList;

public class SlotService implements ISLOT {
    public ArrayList<Slot> slots = new ArrayList<>();
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
        int length=0;
        switch (type){
            case 2 : length = slotsfortwo;
                    break;
            case 4 : length = slotsforfour;
                    break;
            case 8 : length = slotforheavy;
                     break;
        }
        View view = new View();
        view.ViewParkingSlots(slots,type,length);
    }
}
