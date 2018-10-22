package tudien;

import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dictionary {
    //Variable for file path
    private String file = "anhviet109K.txt";

    Scanner scanners = new Scanner(System.in);

   

    //Standardize strings
    public String standardizeStrings(String str)
    {
        //Converts the characters of a String into lower case characters
        str = str.toLowerCase();
        //Eliminates leading and trailing spaces
        str = str.trim();
        //Replace " "
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    public void insertFromCommandline(){
        boolean check = false;
            System.out.print("Nhập từ tiếng anh: ");
            String wt = standardizeStrings(scanners.nextLine());
            for(int i = 0; i < word.size(); i ++){
               if(wt.equals(word.get(i).getWordTarget())){
                   System.out.println("Từ này đã tồn tại!");
                   check = true;
                   break;
               }
            }
            if(check == false){
                System.out.print("Nhập nghĩa: ");
                String we = standardizeStrings(scanners.nextLine());
                Word s1 = new Word(wt, we);
                super.word.add(s1);
                System.out.println("Done!");
            }
    }

    public DictionaryManagement (){
        //Emty
    }
    //Read data from file
    public ArrayList<Word> insertFromFile() {
        try {
            File fileDir = new File(file);
            FileInputStream fileInPutStream = new FileInputStream(file);
            Reader reader = new java.io.InputStreamReader(fileInPutStream, "utf8");
            BufferedReader br = new BufferedReader(reader);
            String key;
            //Read data, read one line
            while((key = br.readLine()) != null) {
                StringBuilder value = new StringBuilder(key);
                if(key.isEmpty()) continue;
                if(key.charAt(0) == '@') {
                    //Delete @
                    value.deleteCharAt(0);
                    //Read the first word
                    if(getWordTarget() != null) {
                        //Constructor new Word
                        Word word = new Word(getWordTarget(), getWordExplain());
                        //Add word to array
                        super.word.add(word);
                        //Clear array's explain
                        wordExplain.clear();
                    }
                    //Set word target
                    setWordTarget(value.toString());
                }
                else {
                    //Put all explain into explain array
                    setWordExplain(key + "\n");
                }
            }
            br.close();
        }
        catch(UnsupportedEncodingException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return word;
    }


    //Find word
    public void dictionaryLookup(){
        String line = standardizeStrings(scanners.nextLine());
        boolean check = false;
        for(int i = 0; i < word.size(); i ++){
            //Compare with method startsWith
            if(line.equals(word.get(i).getWordTarget())){
                System.out.println(word.get(i).getWordExplain());
                check = true;
            }
        }
        //Case couldn't found the word
        if(check == false){
            System.out.println("Word cannot found!");
        }
    }

    //Remove word from list
    public void removeWord(String str){
        for(int i =0; i < word.size(); i ++){
            if(str.equalsIgnoreCase(word.get(i).getWordTarget())){
                word.remove(i);
            }
        }
    }

    public void changeWord(String str, String we){
        for (int i = 0; i < word.size(); i++) {

            if (str.equalsIgnoreCase(word.get(i).getWordTarget())) {
               word.get(i).wordExplain.clear();
                word.get(i).setWordExplain(we);
                break;
            }

        }
    }

    public void printfList() throws IOException {
        FileOutputStream fileDir = new FileOutputStream(file);
        OutputStreamWriter os = new OutputStreamWriter(fileDir, "UTF8");
        PrintWriter bw = new PrintWriter(os);
        for(int i = 0; i < word.size(); i ++){
            //Write array's data to file
            bw.println("@"+word.get(i).getWordTarget() + "\n" + word.get(i).getWordExplain());
        }
        System.out.println("Done!");
        bw.close();
        os.close();
    }
   
     DictionaryManagement(ArrayList<Word> nword) {
        this.word = nword;
    }
     
     protected ArrayList<Word> quickSort(ArrayList<Word> list) {
        if (list.size() <= 1) {
            return list; // Already sorted
        }
        ArrayList<Word> sorted = new ArrayList<Word>();
        ArrayList<Word> lesser = new ArrayList<Word>();
        ArrayList<Word> greater = new ArrayList<Word>();
        Word pivot = list.get(list.size() - 1); // Use last Vehicle as pivot
        for (int i = 0; i < list.size() - 1; i++) {
            //int order = list.get(i).compareTo(pivot);
            if (list.get(i).compareTo(pivot) < 0) {
                lesser.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        lesser = quickSort(lesser);
        greater = quickSort(greater);

        lesser.add(pivot);
        lesser.addAll(greater);
        sorted = lesser;

        return sorted;
    }
}
