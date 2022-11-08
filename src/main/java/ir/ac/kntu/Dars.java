package ir.ac.kntu;

import java.util.ArrayList;

public class Dars {

    private String shomareDars;
    private String name;
    private ArrayList<Dars> doroosPishniaz;

    public Dars() {
    }

    public Dars(String shomareDars, String name, ArrayList<Dars> doroosPishniaz) {
        this.shomareDars = shomareDars;
        this.name = name;
        this.doroosPishniaz = doroosPishniaz;
    }

    public String getShomareDars() {
        return shomareDars;
    }

    public void setShomareDars(String shomareDars) {
        this.shomareDars = shomareDars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Dars> getDoroosPishniaz() {
        return doroosPishniaz;
    }

    public void setDoroosPishniaz(ArrayList<Dars> doroosPishniaz) {
        this.doroosPishniaz = doroosPishniaz;
    }

    @Override
    public String toString() {
        return "Dars [" + " name=" + String.valueOf(name) + ", shomareDars=" + shomareDars + "]";
    }

 
}
