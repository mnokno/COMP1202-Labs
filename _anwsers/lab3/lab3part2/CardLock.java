package lab3part2;

public class CardLock {

    private SmartCard lastSmartCardSeen;
    private boolean staffOnly = true;

    public void swipeCard(SmartCard smartCard){
        lastSmartCardSeen = smartCard;
    }

    public SmartCard getLastCardSeen(){
        return  lastSmartCardSeen;
    }

    public boolean isUnlocked(){
        if (lastSmartCardSeen == null){
            return false;
        }
        else {
            return !staffOnly | lastSmartCardSeen.isStaff();
        }
    }

    public void toggleStudentAccess(){
        staffOnly = !staffOnly;
    }
}
