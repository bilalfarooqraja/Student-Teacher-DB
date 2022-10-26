import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBConnection db= new DBConnection();
        Connection conn=db.connectToDb("postgres","postgres","admin");

        Teacher t= new Teacher();
        Student s= new Student();


        t.CreateTable(conn);
        s.CreateStudentTable(conn);

        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 if you are Teacher\nPress 2 if you are Student");

        int num = Integer.parseInt(input.nextLine());


        if(num==1) {
            System.out.println("Press 1 for Signup\nPress 2 for Signin");
            int num2 = Integer.parseInt(input.nextLine());
            if (num2 == 1) {
                System.out.println("Please Enter Your Name");
                String Na = input.nextLine();
                System.out.println("Please Enter Your Address");
                String Add = input.nextLine();
                System.out.println("Please Enter Your Password");
                String Pas = input.nextLine();
                t.InsertRows(conn, Na, Add, Pas);
            }
            if (num2 == 2) {
                System.out.println("Please Enter Your Name");
                String N = input.nextLine();
                System.out.println("Please Enter Your password");
                String P = (input.nextLine());
                String[] result = t.searchByName(conn, N);

                if (result[0].equals(N) && result[1].equals(P)) {
                    System.out.println("Welcome " + N);
                    boolean loop = true;
                    while (loop) {
                        System.out.println("Press 1 to enter record\nPress 2 See students Record\n Press 3 Exit");
                        int num1 = Integer.parseInt(input.nextLine());

                        if (num1 == 1) {
                            System.out.println("Enter Student Name ");
                            Scanner inputs = new Scanner(System.in);
                            String name = inputs.nextLine();
                            System.out.println("Enter itcp ");
                            String itcp = inputs.nextLine();
                            System.out.println("Enter calculus marks ");
                            String cal = inputs.nextLine();
                            System.out.println("Enter oop marks");
                            String oop = inputs.nextLine();
                            System.out.println("Enter database marks ");
                            String datab = inputs.nextLine();
                            System.out.println("Enter maths marks ");
                            String maths = inputs.nextLine();
                            t.InsertStudentMarks(conn, name, itcp, cal, oop, datab, maths);
                        }

                        if (num1 == 2) {
                            t.readData(conn);
                        }
                        if (num1 == 3) {
                            loop = false;
                        }

                    }
                }else{
                    System.out.println("Teacher or Pass Incorrect");
                }
            }
        }
        if (num==2){
            System.out.println("Enter your name to see your result");
            String N=input.nextLine();
            s.searchByName(conn,N);
        }
    }
}
