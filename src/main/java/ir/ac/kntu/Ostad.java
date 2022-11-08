package ir.ac.kntu;

import java.util.ArrayList;

public class Ostad {
    private String name;
    private String lastName;
    private String id;
    private String pass;
    private ArrayList<Dars> dorosInTerm;

    public Ostad() {
    }

    public Ostad(String name, String lastName, String ostadId, String pass, ArrayList<Dars> dorosInTerm) {
        this.name = name;
        this.lastName = lastName;
        this.id = ostadId;
        this.pass = pass;
        this.dorosInTerm = dorosInTerm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String ostadId) {
        this.id = ostadId;
    }

    public ArrayList<Dars> getDorosInTerm() {
        return dorosInTerm;
    }

    public void setDorosInTerm(ArrayList<Dars> dorosInTerm) {
        this.dorosInTerm = dorosInTerm;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean canSignIn(String id, String pas) {
        if (id.equals(id) && pas.equals(pass)) {
            System.out.println("Hi Mr." + lastName + " /n welcome to golestan");
            return true;
        }
        System.out.println("wrong userName or password /n if you had forgot your pass please call to amoozesh");
        return false;
    }

    @Override
    public String toString() {
        return "Ostad [lastName=" + lastName + ", name=" + name + ", ID=" + id + "]";
    }

}
