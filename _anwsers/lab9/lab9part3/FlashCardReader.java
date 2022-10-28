package lab9part3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardReader {

    BufferedReader bufferedReader;

    public FlashCardReader(String file){
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            //throw new RuntimeException(e);
        }
    }

    public String getLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("something went wrong.");
            throw new RuntimeException(e);
        }
    }

    public boolean fileIsReady(){
        if (bufferedReader == null){
            return false;
        }
        else {
            try {
                return bufferedReader.ready();
            } catch (IOException e) {
                System.out.println("something went wrong.");
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<FlashCard> getFlashCards() {
        ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();

        String line;
        String[] parts;
        while ((line = getLine()) != null){
            parts = line.split(":");
            flashCards.add(new FlashCard(parts[0],parts[1]));
        }

        return flashCards;
    }
}
