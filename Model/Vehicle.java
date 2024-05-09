package Model;

public class Vehicle {
    public String VechileNumber;
    public int slotNumber;
    public TypeVehicle type;

    public Vehicle(){}

    public Vehicle(int slotNumber){
        this.slotNumber = slotNumber;
    }

    public TypeVehicle getType(){
        return type;
    }

    public void setType(TypeVehicle type){
        this.type = type;
    }



    public enum TypeVehicle{
        TwoWheelers,FourWheelers,HeavyWheelers
    }
}
