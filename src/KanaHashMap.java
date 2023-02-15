import java.util.HashMap;

public class KanaHashMap {
    private String docName;
    private HashMap<String, Kanji> hash;

    public String getDocName()
    {
        return this.docName;
    }
    public HashMap<String, Kanji> getHash()
    {
        return this.hash;
    }

    KanaHashMap(String name)
    {
        this.docName = name;
        this.hash = new HashMap<String, Kanji>();
    }
}
