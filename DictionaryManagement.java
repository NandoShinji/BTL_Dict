package Dictionary;

import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dict {
    //Variable for file path
    private String file = "Dictionary.txt";

    Scanner scanners = new Scanner(System.in);
    HashMap<String, String> hash = new HashMap<>();
    ArrayList<String> saveWord = new ArrayList<String>();

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
        System.out.print("Nhập số từ: ");
        int n = Integer.parseInt(scanners.nextLine());
        for (int i = 0; i < n; i ++){
            System.out.print("Nhập từ tiếng anh: ");
            String wt = standardizeStrings(scanners.nextLine());
            System.out.print("Nhập nghĩa: ");
            String we = standardizeStrings(scanners.nextLine());
            Word s1 = new Word(wt, we);
            super.word.add(s1);
        }
    }

    public DictionaryManagement (){
        //Emty
    }
    //Read data from file
    public void insertFromFile() throws IOException {
        try {
            File fileDir = new File(file);
            FileInputStream fi = new FileInputStream(fileDir);
            InputStreamReader isr = new InputStreamReader(fi, "utf-8");
            BufferedReader br = new BufferedReader(isr);

            String sNewLine;
            //if(word != null) word.clear();
            //Read data in file, read one line
            while ((sNewLine = br.readLine()) != null){
                String sR = "";
                sR += sNewLine;

                //Check line emty
                if(sR.isEmpty()) continue;
                //Split string
                String[] arr = sR.split("\t", 2);
                //Add line into arraylist
                Word s1 = new Word(arr[0], arr[1]);
                super.word.add(s1);
                }
            br.close();
            isr.close();
            fi.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    //Get all word
    public void getWord(){
        for(int i = 0; i < word.size(); i++){
            System.out.println(word.get(i).getwt());
        }
    }
    //Find word
    public void dictionaryLookup(){
        String line = standardizeStrings(scanners.nextLine());
        boolean check = false;
        for(int i = 0; i < word.size(); i++){
            //Compare with method startsWith
            if(line.equals(word.get(i).getwt())){
                System.out.println("| " + word.get(i).getwt() + ": " + word.get(i).getwe());
                check = true;
            }
        }
        //Case couldn't found the word
        if(check == false){
            System.out.println("Word cannot found!");
        }
    }

    //Remove word from list
    public void removeWord() throws IOException {
        boolean check = false;
            System.out.print("Nhập từ cần xóa: ");
            //Standardize strings
            String lineToRemove = standardizeStrings(scanners.nextLine());
            //Remove line from array
            for(int i = 0; i < word.size(); i++){
                if(lineToRemove.equals(word.get(i).getwt())){
                    word.remove(i);
                    check = true;
                }
            }
            //Case couldn't found the word
            if(check == false){
                System.out.println("Word cannot found!");
            } else
                System.out.println("Done!");
    }

    public void changeWord(){
        boolean check = false;
            System.out.print("Nhập từ cần sửa: ");
            String wt = standardizeStrings(scanners.nextLine());

            System.out.print("Nhập nghĩa mới: ");
            String we = standardizeStrings(scanners.nextLine());

            //Write string to file
            for(int i = 0; i < word.size(); i++){
                if(wt.equals(word.get(i).getwt())){
                    word.get(i).setwe(we);
                    check = true;
                }
            }
        //Case couldn't found the word
        if(check == false){
            System.out.println("Word cannot found!");
        } else
            System.out.println("Done!");
    }

    public void printfList() throws IOException {
        FileOutputStream fileDir = new FileOutputStream(file);
        PrintWriter bw = new PrintWriter(fileDir);
        for(int i = 0; i < word.size(); i++){
            //Write array's data to file
            bw.println(word.get(i).getwt() + "\t" + word.get(i).getwe());
        }
        System.out.println("Done!");
        bw.close();
    }
}
