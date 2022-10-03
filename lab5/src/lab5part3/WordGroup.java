package lab5part3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

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

    public HashMap<String, Integer> getWordCounts(){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String key : words.split(" ")){
            if (hashMap.containsKey(key)){
                hashMap.put(key, hashMap.get(key) + 1);
            }
            else{
                hashMap.put(key, 1);
            }
        }
        //if (hashMap.containsKey("play")){
        //    hashMap.put("play", 1);
        //}
        return hashMap;
    }

}