package ir.ac.kntu;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    private static ArrayList<Ostad> asatid = new ArrayList<>();
    private static ArrayList<Daneshjo> daneshjoha = new ArrayList<>();
    private static ArrayList<Dars> darsha = new ArrayList<>();
    final static String USER_NAME_ADMIN = "admin";
    final static String PASS_ADMIN = "admin";
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("welcome to golestan");
        System.out.println("to start the program you should enter Admins' username and password :");
        ArrayList<Dars> d1=new ArrayList<>();
        d1.add(new Dars("44", "math", null));
        d1.add(new Dars("55", "math2", null));
        darsha.add(new Dars("44", "math", null));
        darsha.add(new Dars("55", "math2", null));

        Ostad o1=new Ostad("reza", "alavi", "100200", "123456", d1);
        asatid.add(o1);




        signInAdmin();
        
        choiceInUserlevel();

    }

    public static void printUserLevel() {
        System.out.println("choose your user level :");
        System.out.println(" 0:ADMIN \n 1:STUDENT \n 2:PROF");
    }

    public static void printAdminList() {
        System.out.println("  ADMIN item has showed below ,choose one of them :");
        System.out.println("   0:ADD NEW STUDENT \n   1:ADD NEW CLASS \n   2:EDIT CLASS \n   9:EXIT");
    }

    public static void printStudentList() {
        System.out.println("  STUDENT item has showed below ,choose one of them :");
        System.out.println("   0:SHOW STUDENT CLASSES \n   9:EXIT");
    }

    public static void printProfList() {
        System.out.println("  PROF item has showed below ,choose one of them :");
        System.out.println("   0:SHOW PROF CLASSES \n   9:EXIT ");
    }

    public static void choiceInUserlevel() {
        printUserLevel();
        String input1 = in.nextLine();
        if (input1.equals("0")) {
            signInAdmin();
            choiceInAdmin();

        } else if (input1.equals("1")) {
            System.out.print("enter your  id and pass : \n Id : ");
            String id = in.nextLine();
            System.out.print("Pass : ");
            String pass = in.nextLine();
            int studentId = signInDaneshjo(daneshjoha, id, pass);
            if (studentId < 0) {

                choiceInUserlevel();
            }
            choiceInStudent(studentId);

        } else if (input1.equals("2")) {
            System.out.print("enter your  id and pass : \n Id : ");
            String id = in.nextLine();
            System.out.print("Pass : ");
            String pass = in.nextLine();
            int profId = signInOstad(asatid, id, pass);
            if (profId < 0) {

                choiceInUserlevel();
            }
            choiceInProf(profId);

        } else {
            System.out.println("wrong input !choose the currect number !");
            choiceInUserlevel();
        }
    }

    public static void choiceInAdmin() {
        printAdminList();
        String input1 = in.nextLine();
        if (input1.equals("0")) {
            addStudent();
            choiceInAdmin();

        } else if (input1.equals("1")) {
            Dars dars = new Dars();
            System.out.print("enter the class id : ");
            dars.setShomareDars(in.nextLine());
            System.out.print("enter the class Name : ");
            dars.setName(in.nextLine());
            ArrayList<Dars> doros = new ArrayList<>();
            System.out.print("how many prerequisite classes need for this class ? ");
            int tedadDarsPishniaz = Integer.parseInt(in.nextLine());
            for (int i = 0; i < tedadDarsPishniaz; i++) {
                Dars dars1 = new Dars();
                System.out.print("enter the class id : ");
                dars1.setShomareDars(in.nextLine());
                System.out.print("enter the class Name : ");
                dars1.setName(in.nextLine());
                doros.add(dars1);
            }
            dars.setDoroosPishniaz(doros);
            darsha.add(dars);
            System.out.println("class created succesfully");
            choiceInAdmin();

        } else if (input1.equals("2")) {
            System.out.print("enter the class id : ");
            String id = in.nextLine();
            int index = findClass(id);
            changeClass(index);
            choiceInAdmin();

        } else if (input1.equals("9")) {
            choiceInUserlevel();
        } else {
            System.out.println("wrong input !choose the currect number !");
            choiceInAdmin();
        }
    }

    public static void choiceInStudent(int id) {
        printStudentList();
        String input1 = in.nextLine();
        if (input1.equals("0")) {
            System.out.println(daneshjoha.get(id).getDorossInTerm());
            choiceInStudent(id);
        } else if (input1.equals("9")) {
            choiceInUserlevel();
        } else {
            System.out.println("wrong input !choose the currect number !");
            choiceInStudent(id);
        }
    }

    public static void choiceInProf(int id) {
        printProfList();
        String input1 = in.nextLine();
        if (input1.equals("0")) {
            System.out.println(asatid.get(id).getDorosInTerm());
            choiceInProf(id);

        } else if (input1.equals("9")) {
            choiceInUserlevel();
        } else {
            System.out.println("wrong input !choose the currect number !");
            choiceInProf(id);
        }
    }

    public static int signInDaneshjo(ArrayList<Daneshjo> a, String id, String pass) {

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(id) && a.get(i).getPass().equals(pass)) {

                System.out.println("signin was succesful");
                return i;
            }

        }
        System.out.println("wrong user or pass");
        return -1;

    }

    public static int signInOstad(ArrayList<Ostad> a, String id, String pass) {

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(id) && a.get(i).getPass().equals(pass)) {

                System.out.println("signin was succesful");
                return i;
            }

        }
        System.out.println("wrong user or pass");
        return -1;

    }

    public static void signInAdmin() {
        System.out.print("enter the Admin user name : ");
        String userIn = in.nextLine();
        System.out.print("enter the Admin pass : ");
        String passIn = in.nextLine();

        while (!USER_NAME_ADMIN.equals(userIn) || !PASS_ADMIN.equals(passIn)) {
            if (!USER_NAME_ADMIN.equals(userIn) && !PASS_ADMIN.equals(passIn)) {
                System.out.println("wrong username and password !! please try again");
                System.out.print("enter the Admin user name : ");
                userIn = in.nextLine();
                System.out.print("enter the Admin pass : ");
                passIn = in.nextLine();

            } else if (!USER_NAME_ADMIN.equals(userIn)) {
                System.out.println("wrong username !!");
                System.out.print("enter the Admin user name again : ");
                userIn = in.nextLine();

            } else if (!PASS_ADMIN.equals(passIn)) {
                System.out.println("wrong password !!");
                System.out.print("enter the Admin pass again: ");
                passIn = in.nextLine();

            }
        }

    }

    public static int findClass(String id) {
        for (int i = 0; i < darsha.size(); i++) {
            if (darsha.get(i).getShomareDars().equals(id)) {
                return i;

            }
        }
        System.out.println("invalid class ");
        choiceInAdmin();
        return -1;
    }

    public static void changeClass(int id) {
        System.out.println("which field should be changed ?");
        System.out.println(" 1_id   2_className  3_prerequisite");
        int k = Integer.parseInt(in.nextLine());
        switch (k) {
            case 1:
                System.out.print("enter the class id : ");
                darsha.get(id).setShomareDars(in.nextLine());
                break;
            case 2:
                System.out.print("enter the class Name : ");
                darsha.get(id).setName(in.nextLine());
                break;
            case 3:
                ArrayList<Dars> doros = new ArrayList<>();
                System.out.print("how many prerequisite classes need for this class ? ");
                int tedadDarsPishniaz = Integer.parseInt(in.nextLine());
                for (int i = 0; i < tedadDarsPishniaz; i++) {
                    Dars dars1 = new Dars();
                    System.out.print("enter the class id : ");
                    dars1.setShomareDars(in.nextLine());
                    System.out.print("enter the class Name : ");
                    dars1.setName(in.nextLine());
                    doros.add(dars1);
                }
                darsha.get(id).setDoroosPishniaz(doros);
                break;
            default:
                System.out.println("wrong input :");
        }

    }

    public static void addStudent() {
        String name;
        String lastName;
        String id;
        String pass;
        System.out.print("please enter student name :");
        name = in.nextLine();
        System.out.print("please enter student lastName :");
        lastName = in.nextLine();
        System.out.print("please enter student Id :");
        id = in.nextLine();
        System.out.print("please enter student password :");
        pass = in.nextLine();
        ArrayList<Dars> dorosGoazande = new ArrayList<>();
        System.out.print("how many classes student has passed ? ");
        int tedadDarsGozarande = Integer.parseInt(in.nextLine());
        for (int i = 0; i < tedadDarsGozarande; i++) {
            Dars dars = new Dars();
            System.out.print("enter the class id : ");
            dars.setShomareDars(in.nextLine());
            System.out.print("enter the class Name : ");
            dars.setName(in.nextLine());
            dorosGoazande.add(dars);
        }
        Daneshjo d1 = new Daneshjo(name, lastName, id, dorosGoazande, pass);
        daneshjoha.add(d1);
        System.out.println("Student created succesfully");
    }
}