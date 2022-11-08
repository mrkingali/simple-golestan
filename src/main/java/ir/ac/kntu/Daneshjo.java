package ir.ac.kntu;

import java.util.ArrayList;

/**
 * this class make Student
 * 
 * @author alireza
 * 
 * 
 */

public class Daneshjo {
    private String name; //name of student
    private String lastName; //lastName of student
    private String id; //student id or code daneshjoii
    private ArrayList<Dars> dorossGozarande;//the classes which has been passed by student
    private ArrayList<Dars> dorossInTerm;//the classe which will pass in next term
    public static final int SAGF_VAHED = 20;
    private String pass;//password for sign in

    /**
     * this in empty constructor
     */
    public Daneshjo() {
    }

    /**
     * this in full constructor
     * 
     * @param name //name of student
     * @param lastName //lastName of student
     * @param studentId //student id or code daneshjoii
     * @param dorossGozarande //the classes which has been passed by student
     * @param pass //password for sign in
     */

    public Daneshjo(String name, String lastName, String studentId, ArrayList<Dars> dorossGozarande, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.id = studentId;
        this.dorossGozarande = dorossGozarande;
        this.pass = pass;
    }
    /**
     * this method return name of Daneshjo
     * @return name
     */

    public String getName() {
        return name;
    }
    /**
     * this method will set th Daneshjos name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * this method return lastName of Daneshjo
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * this method 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String studentId) {
        this.id = studentId;
    }

    public ArrayList<Dars> getDorossGozarande() {
        return dorossGozarande;
    }

    public void setDorossGozarande(ArrayList<Dars> dorossGozarande) {
        this.dorossGozarande = dorossGozarande;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Dars> getDorossInTerm() {
        return dorossInTerm;
    }

    public void setDorossInTerm(ArrayList<Dars> dorossInTerm) {
        this.dorossInTerm = dorossInTerm;
    }

    public boolean canSignIn(String id, String pas) {
        if (id.equals(id) && pas.equals(pass)) {
            System.out.println(name + "welcome  to Golestan");
            return true;
        }
        System.out.println("wrong userName or password");
        return false;
    }

    @Override
    public String toString() {
        return "Daneshjo [" + " name=" + name + ", lastName="
                + lastName + ", id=" + id + "]";
    }

}
