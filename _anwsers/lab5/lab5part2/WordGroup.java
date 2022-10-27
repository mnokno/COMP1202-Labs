package lab5part2;

import java.util.HashSet;

public class WordGroup{

    private String words;

    public WordGroup(String words){
        this.words = words.toLowerCase();
    }

    public String[] getWordArray(){
        return words.split(" ");
    }

    public HashSet<String> getWordSet(WordGroup otherWordGroup){
        HashSet<String> hashSet = new HashSet<String>();
        // Would do it in a more efficient way but i believe that the question want me to use loops
        for (String s : this.getWordArray()){
            hashSet.add(s);
        }
        for (String s : otherWordGroup.getWordArray()){
            hashSet.add(s);
        }
        return hashSet;
    }

}