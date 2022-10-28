package lab9part2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Quiz {

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Questions.txt");
    }

    private ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();

    public Quiz(String fileName) {
        FlashCardReader flashCardReader = new FlashCardReader(fileName);
        flashCards = flashCardReader.getFlashCards();
        play();
    }

    public void play(){
        Toolbox toolbox = new Toolbox();
        for (FlashCard flashCard: flashCards) {
            System.out.println(flashCard.getQuestion());
            String userAnswer = toolbox.readStringFromCmd();
            if (Objects.equals(userAnswer, flashCard.getAnswer())){
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
                System.out.println(flashCard.getAnswer());
            }
        }
    }
}
