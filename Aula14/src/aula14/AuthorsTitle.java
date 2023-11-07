package aula14;

public class AuthorsTitle {
    private int atAuthorsID;
    private int atISBN;

    public AuthorsTitle(int atAuthorsID, int atISBN) {
        this.atAuthorsID = atAuthorsID;
        this.atISBN = atISBN;
    }
    public void setAtAuthorsID(int atAuthorsID) {
        this.atAuthorsID = atAuthorsID;
    }
    public void setAtISBN(int atISBN) {
        this.atISBN = atISBN;
    }
    public int getAtAuthorsID() {
        return atAuthorsID;
    }
    public int getAtISBN() {
        return atISBN;
    }
}
