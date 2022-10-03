package lab5part3;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args){

        WordGroup wordGroupA = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup wordGroupB = new WordGroup("When you play play hard when you work dont play at all");

        String[] wordsA = wordGroupA.getWordArray();
        String[] wordsB = wordGroupB.getWordArray();

        for (String s : wordsA){
            System.out.println(s);
        }
        //System.out.println("--------------------------------");
        for (String s : wordsB){
            System.out.println(s);
        }

        //System.out.println("::::::::::::::::::::::::::::::::::::");
        for (String s: wordGroupA.getWordSet(wordGroupB)){
            System.out.println(s);
        }

        //System.out.println("::::::::::::::::::::::::::::::::::::");
        HashMap<String, Integer> hashMapA = wordGroupA.getWordCounts();
        HashMap<String, Integer> hashMapB = wordGroupB.getWordCounts();
        for (String key: hashMapA.keySet()){
            System.out.println(key + ": " + hashMapA.get(key));
        }
        //System.out.println("--------------------------------");
        for (String key: hashMapB.keySet()){
            System.out.println(key + ": " + hashMapB.get(key));
        }
        //System.out.println("::::::::::::::::::::::::::::::::::::");
        HashMap<String, Integer> joinedHashMap = new HashMap<String, Integer>();
        int totalCount;
        for (String potentialKey: wordGroupA.getWordSet(wordGroupB)){
            totalCount = 0;
            if (hashMapA.containsKey(potentialKey)){
                totalCount += hashMapA.get(potentialKey);
            }
            if (hashMapB.containsKey(potentialKey)){
                totalCount += hashMapB.get(potentialKey);
            }
            joinedHashMap.put(potentialKey, totalCount);
        }
        for (String key : joinedHashMap.keySet()){
            System.out.println(key + ": " + joinedHashMap.get(key));
        }

        //System.out.println("::::::::::::::::::::::::::::::::::::");

    }
}
