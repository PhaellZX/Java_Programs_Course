package aula14;

public class Authors {
    private int authorsId;
    private String firstName;
    private String lastName;

    public Authors(int authorsId, String firstName, String lastName) {
        this.authorsId = authorsId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Authors(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAuthorsId() {
        return authorsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAuthorsId(int authorsId) {
        this.authorsId = authorsId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
