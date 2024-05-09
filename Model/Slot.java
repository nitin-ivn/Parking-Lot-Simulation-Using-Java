package Model;

public class Slot {
  public int slottype;
  public int slotnumber;
  public boolean parked = false;

  public Slot(int slottype,int slotnumber,boolean parked){
      this.slottype = slottype;
      this.slotnumber = slotnumber;
      this.parked = parked;
  }
  public Slot(int slottype){
      this.slottype = slottype;
  }
}
