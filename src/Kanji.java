public class Kanji {
    private String kanjiLetter;
    private double kanjiCount;

    public String getKanjiLetter()
    {
        return this.kanjiLetter;
    }

    public Double getKanjiCount()
    {
        return this.kanjiCount;
    }

    public void addKanjiCount()
    {
        this.kanjiCount++;
    }

    Kanji(String kanji)
    {
        this.kanjiLetter = kanji;
        this.kanjiCount = 1;
    }

}
