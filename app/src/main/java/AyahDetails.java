public class AyahDetails {

    int Ayahno;
    int SurahId;
    int paraId;
    String arabic;
    String Urdu;
    String Eng;

    public AyahDetails(int ayahno, int surahId, int paraId, String arabic, String urdu, String eng) {
        Ayahno = ayahno;
        SurahId = surahId;
        this.paraId = paraId;
        this.arabic = arabic;
        Urdu = urdu;
        Eng = eng;
    }

    public int getParaId() {
        return paraId;
    }

    public void setParaId(int paraId) {
        this.paraId = paraId;
    }

    public int getAyahno() {
        return Ayahno;
    }

    public void setAyahno(int ayahno) {
        Ayahno = ayahno;
    }

    public int getSurahId() {
        return SurahId;
    }

    public void setSurahId(int surahId) {
        SurahId = surahId;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getUrdu() {
        return Urdu;
    }

    public void setUrdu(String urdu) {
        Urdu = urdu;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }
}
