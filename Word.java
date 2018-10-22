package tudien;

import java.util.ArrayList;
import java.util.Comparator;

public class Word {
    public String wordTarget;
    ArrayList<String> wordExplain = new ArrayList<String>();

    //Constructor
    public Word(String wordTagret, String wordExplain) {
        this.wordTarget = wordTagret;
        this.wordExplain.add(wordExplain);
    }

    //Constructor
    public Word() {
        //Empty
    }

    //Method set new word
    public void setWordTarget(String wordTaget) {
        this.wordTarget = wordTaget;
    }
    public String getWordTarget(){
        return wordTarget;
    }

    //Method set word explain
    public void setWordExplain(String wordExplain) {
        this.wordExplain.add(wordExplain);
    }
    public String getWordExplain(){
        String str = "";
        for(String we : wordExplain){
            str += we;
        }
        return str;
    }

    //Method clean
    public void clean() {
        this.wordTarget = null;
        this.wordExplain.clear();
    }

    @Override
    public String toString(){
        return getWordTarget() + getWordExplain();
    }
   
    public int compareTo(Word employee) {
        if (wordTarget.compareTo(employee.wordTarget) == 0)
            return 0;
        else if (wordTarget.compareTo(employee.wordTarget) > 0)
            return 1;
        else
            return -1;
    }
  

}
