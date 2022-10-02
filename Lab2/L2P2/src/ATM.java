import java.text.MessageFormat;

public class ATM {

    private static final String initMessage = "Welcome to online ATM banking\n" +
            "How much do you want in your account?";
    private static final String optionsMessage = "What do you want to do?\n" +
            "1 : Withdraw\n" +
            "2 : Deposit\n" +
            "3 : Inquire\n" +
            "4 : Quit";
    private static final String withdrawMessage = "*****************************************\n" +
            "              Withdrawal                 \n" +
            "*****************************************\n" +
            "How much would you like to withdraw?";
    private static final String withdrawMessageEnd = "*****************************************\n" +
            "         Your new balance is {0}       \n" +
            "***************************************** ";
    private static final String depositMessage = "*****************************************\n" +
            "              Deposit                 \n" +
            "*****************************************\n" +
            "How much would you like to deposit?";
    private static final String depositMessageEnd = "*****************************************\n" +
            "         Your new balance is {0}       \n" +
            "***************************************** ";
    private static final String inquireMessage = "*****************************************\n" +
            "          Your balance is {0}       \n" +
            "***************************************** ";
    private static final String quitMessage = "******************************************\n" +
            "         GoodBye!\n" +
            "******************************************";

    private int bankBalance;
    private Toolbox toolbox;


    public static void main(String[] args){
        ATM myATM = new ATM();
        myATM.go();
    }

    public ATM(){
        toolbox = new Toolbox();
    }

    public void go(){
        // Initialization (ask for bank balance)
        System.out.println(initMessage);
        bankBalance = toolbox.readIntegerFromCmd();
        System.out.println((bankBalance));

        // Options (asks the user what actions they want to perform)
        System.out.println(optionsMessage);
        int action = toolbox.readIntegerFromCmd();
        // NOTE: from my understanding the task want us to use multiple if statements
        // instead of if followed by multiple if else statements
        if (action == 1){
            withdraw();
        }
        if (action == 2){
            deposit();
        }
        if (action == 3){
            inquire();
        }
        if (action == 4){
            quit();
        }
    }

    private void withdraw(){
        System.out.println(withdrawMessage);
        int input = toolbox.readIntegerFromCmd();
        bankBalance -= input;
        System.out.println(MessageFormat.format(withdrawMessageEnd, bankBalance));
    }

    private void deposit(){
        System.out.println(depositMessage);
        int input = toolbox.readIntegerFromCmd();
        bankBalance += input;
        System.out.println(MessageFormat.format(depositMessageEnd, bankBalance));
    }

    private void inquire(){
        System.out.println(MessageFormat.format(inquireMessage, bankBalance));
    }

    private void quit(){
        System.out.println(quitMessage);
    }
}
