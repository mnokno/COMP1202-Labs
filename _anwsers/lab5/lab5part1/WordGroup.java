package lab5part1;

public class WordGroup{

    private String words;

    public WordGroup(String words){
        this.words = words.toLowerCase();
    }

    public String[] getWordArray(){
        return words.split(" ");
    }

}