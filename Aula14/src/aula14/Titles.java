package aula14;

public class Titles {
    private int isbn;
    private String title;
    private String EditionNumber;
    private String copyright;

    public Titles(int isbn, String title, String EditionNumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.EditionNumber = EditionNumber;
        this.copyright = copyright;
    }
    public Titles( String title, String EditionNumber, String copyright) {
        this.title = title;
        this.EditionNumber = EditionNumber;
        this.copyright = copyright;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditionNumber(String EditionNumber) {
        this.EditionNumber = EditionNumber;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getEditionNumber() {
        return EditionNumber;
    }

    public String getCopyright() {
        return copyright;
    }
    
}
