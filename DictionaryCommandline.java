package Dictionary;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {

    DictionaryManagement s = new DictionaryManagement();

    public DictionaryCommandline(){
        //Emty
    }

    //Find word with exactly search
    public void dictionaryBasic() throws IOException {
        //insertFromCommandline();
        showAllWord();
    }

    //Show all data
    public void showAllWord(){
        for(Word words : word){
            System.out.println(words);
        }
    }

    //Find word with start with...
    public void dictionaryAdvanced() throws IOException {
            //insertFromFile();
            //showAllWord();
            dictionaryLookup();
    }

    //Find with startswith
    public void dictionarySearcher()
    {
        String line = standardizeStrings(scanners.nextLine());
        for(int i = 0; i < word.size(); i++){
            //Compare with method startsWith
            if(word.get(i).getwt().startsWith(line)){
                System.out.println(word.get(i).getwt());
            }
        }
    }

    void dictionary() throws IOException {
        Scanner scanners = new Scanner(System.in);
        int n;
        boolean exit = false;
        System.out.println("1. Tra từ");
        System.out.println("2. Tra từ gần đúng");
        System.out.println("3. Thêm từ");
        System.out.println("4. Xóa từ");
        System.out.println("5. Sửa nghĩa của từ");
        System.out.println("6. Xuất danh sách từ và nghĩa");
        System.out.println("7. Xóa toàn bộ từ");
        System.out.println("8. Lưu thay đổi");
        System.out.println("0. Exit");
        insertFromFile();
        while(true) {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                n = scanners.nextInt();
                switch (n) {
                    case 1:
                        System.out.print("Nhập từ cần tra: ");
                        dictionaryAdvanced();
                        break;
                    case 2:
                        System.out.print("Nhập từ gần đúng: ");
                        dictionarySearcher();
                        System.out.print("Nhập từ cần tra: ");
                        dictionaryLookup();
                        break;
                    case 3:
                        insertFromCommandline();
                        System.out.println("Done!");
                        break;
                    case 4:
                        removeWord();
                        break;
                    case 5:
                        changeWord();
                        break;
                    case 6:
                        System.out.println("Danh sách từ và nghĩa có trong từ điển: ");
                        showAllWord();
                        break;
                    case 7:
                        System.out.println("Hành động này sẽ xóa toàn bộ dữ liệu đang có, bạn có chắc chắn không?");
                        System.out.println("1. OK ---- 2. Exit");
                        boolean exitt = false;
                        int m;
                        while(true) {
                            m = scanners.nextInt();
                            switch (m) {
                                case 1:
                                    System.out.println("đã xóa");
                                    exitt = true;
                                    break;
                                case 2:
                                    System.out.println("đã hủy thao tác");
                                    exitt = true;
                                    break;
                                default:
                                    System.out.println("Không hợp lệ! Vui lòng nhập lại: ");
                                    break;
                            }
                            if(exitt) break;
                        }
                        case 8:
                            printfList();
                            break;

                        case 0:
                            System.out.println("Exited!");
                            exit = true;
                            break;

                        default:
                            System.out.println("Không hợp lệ! Vui lòng nhập lại: ");
                            break;
                    }
                if (exit) {
                    break;
                }
        }
    }
}

