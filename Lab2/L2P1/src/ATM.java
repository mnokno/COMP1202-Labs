public class ATM {

    private static final String initMessage = "Welcome to online ATM banking\n" +
            "How much do you want in your account?";

    public static void main(String[] args){
        ATM myATM = new ATM();
        myATM.go();
    }

    public ATM(){

    }

    public void go(){
        System.out.println(initMessage);
        Toolbox myToolbox = new Toolbox();
        int bankBalance = myToolbox.readIntegerFromCmd();
        System.out.println((bankBalance));
    }
}
