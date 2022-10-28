package lab9part3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Quiz {

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Questions.txt");
    }

    private final ArrayList<FlashCard> flashCards;
    private final boolean saveResults;

    public Quiz(String fileName) {
        System.out.println("Would you like to save the results");
        Toolbox toolbox = new Toolbox();
        if (Objects.equals(toolbox.readStringFromCmd(), "Y")){
            saveResults = true;
        }
        else{
            saveResults = false;
        }

        FlashCardReader flashCardReader = new FlashCardReader(fileName);
        flashCards = flashCardReader.getFlashCards();
        play();
    }

    public void play(){
        Toolbox toolbox = new Toolbox();
        String[] answers = new String[flashCards.size()];
        int answeredCorrectly = 0;

        for (int i = 0; i < flashCards.size(); i++){
            System.out.println(flashCards.get(i).getQuestion());
            String userAnswer = toolbox.readStringFromCmd();
            answers[i] = userAnswer;
            if (Objects.equals(userAnswer, flashCards.get(i).getAnswer())){
                System.out.println("right");
                answeredCorrectly++;
            }
            else {
                System.out.println("wrong");
                System.out.println(flashCards.get(i).getAnswer());
            }
        }

        if (saveResults){
            try {
                FileWriter fileWriter = new FileWriter("save.txt");
                String data = "";
                for (int i = 0; i < flashCards.size(); i++){
                    String correctAnswerString;
                    if (Objects.equals(answers[i], flashCards.get(i).getAnswer())){
                        correctAnswerString = "right";
                    }
                    else{
                        correctAnswerString = "wrong";
                    }
                    data += (flashCards.get(i).getQuestion() + "," + flashCards.get(i).getAnswer() + "," + correctAnswerString + "\n");
                }
                data += (answeredCorrectly + "," + flashCards.size() + "," + ((float)answeredCorrectly * 100 / (float)flashCards.size()));
                fileWriter.write(data);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
