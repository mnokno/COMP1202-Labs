package lab3part3;

public class SmartCard {

    private String ownersName;
    private boolean isStaffCard = false;

    public SmartCard(String ownersName){
        this.ownersName = ownersName;
    }

    public void setStaff(boolean isStaff){
        isStaffCard = isStaff;
    }

    public String getOwner(){
        return ownersName;
    }

    public boolean isStaff(){
        return isStaffCard;
    }


}
