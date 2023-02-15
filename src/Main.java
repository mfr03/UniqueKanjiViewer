import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class ReadFromTXT
{
    private File file;

    private Scanner scan;

    private ArrayList<String> arrayOfKana;

    public ArrayList<String> getArrayOfKana()
    {
        return this.arrayOfKana;
    }
    ReadFromTXT(String path)
    {
        arrayOfKana = new ArrayList<String>();
        file = new File(path);
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(scan.hasNextLine())
        {
            arrayOfKana.add(scan.nextLine());
        }
    }
}


public class Main {
    static ReadFromTXT hira = new ReadFromTXT("hiragana.txt");
    static ArrayList<String> hiragana = hira.getArrayOfKana();
    static ReadFromTXT kata = new ReadFromTXT("katakana.txt");
    static ArrayList<String> katakana = kata.getArrayOfKana();
    static ReadFromTXT special = new ReadFromTXT("specialcharacters.txt");
    static ArrayList<String> specialCharacters = special.getArrayOfKana();
    static ReadFromTXT alphanum = new ReadFromTXT("alphanumerics");
    static ArrayList<String> alphanumeric = alphanum.getArrayOfKana();
    public static void main(String[] args)
    {
        File file = new File("test.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        KanaHashMap doc1 = new KanaHashMap("document1");
        HashMap<String, Kanji> temp = doc1.getHash();
        String res;
        while(scan.hasNextLine())
        {
            res = scan.nextLine();
            for (char character: res.toCharArray())
            {
                String currentCharacter = String.valueOf(character).toLowerCase();
                if(currentCharacter.isBlank())
                {
                    continue;
                }
                if(temp.get(currentCharacter) == null)
                {
                    if((hiragana.contains(currentCharacter) || katakana.contains(currentCharacter) || specialCharacters.contains(currentCharacter) || alphanumeric.contains(currentCharacter)))
                    {
                        continue;
                    }
                    Kanji kanji = new Kanji(currentCharacter);
                    temp.put(currentCharacter, kanji);
                }
                else
                {
                    temp.get(currentCharacter).addKanjiCount();
                }
            }
        }

        for (Kanji temps: temp.values())
        {
            System.out.println(temps.getKanjiLetter() + temps.getKanjiCount());
        }
    }
}