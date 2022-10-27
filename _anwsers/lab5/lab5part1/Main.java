package lab5part1;

public class Main {

    public static void main(String[] args){

        WordGroup wordGroupA = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup wordGroupB = new WordGroup("When you play play hard when you work dont play at all");

        String[] wordsA = wordGroupA.getWordArray();
        String[] wordsB = wordGroupB.getWordArray();

        for (String s : wordsA){
            System.out.println(s);
        }
        for (String s : wordsB){
            System.out.println(s);
        }
    }
}
