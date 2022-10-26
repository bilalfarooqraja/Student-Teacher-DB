import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    public void CreateStudentTable(Connection conn){
        Statement statement;
        try{
            String query="create table "+"Student"+"(empid SERIAL,name varchar(200),ITCP varchar(200),Calculus varchar(200),OOP varchar(200), DataBase varchar(200),Maths varchar(200),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Query Executed");
        }catch (Exception e){
            System.out.println("Masla in Student");
            System.out.println(e);
        }
    }
    public void searchByName(Connection conn, String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query="select * From "+"Student"+ " Where name ='"+name+"';";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println("ITCP "+rs.getString("itcp")+" ");
                System.out.println("Callculus "+rs.getString("calculus")+" ");
                System.out.println("OOP "+rs.getString("OOP")+" ");
                System.out.println("DataBase "+rs.getString("database")+" ");
                System.out.println("Maths "+rs.getString("maths")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
