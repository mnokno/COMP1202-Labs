package lab9part2;

public class FlashCard {

    private final String question;
    private final String answer;

    public FlashCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {return question;}
    public String getAnswer() {return answer;}
}
