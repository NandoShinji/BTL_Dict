package Dictionary;

public class Word {
    //Variable for word
    private String word_target;
    //Variable for word explain
    private String word_expalain;

    public String getwt(){
        return word_target;
    }
    public void setwt(String word_target){
        this.word_target = word_target;
    }

    public String getwe(){
        return word_expalain;
    }
    public void setwe(String word_expalain){
        this.word_expalain = word_expalain;
    }

    public Word(){
        //Emty
    }

    //Constructor
    public Word(String word_target, String word_expalain){
        this.word_target = word_target;
        this.word_expalain = word_expalain;
    }

    @Override
    public String toString(){
        return "| " + word_target + ": " + word_expalain;
    }
}
