import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teacher {
    public void CreateTable(Connection conn){
        Statement statement;
        try{
            String query="create table Teacher"+"(empid SERIAL,name varchar(200),address varchar(200),Password varchar(200),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Query Executed");
        }catch (Exception e){
            System.out.println("Proble in creating teacher");
            System.out.println(e);
        }
    }

    public void InsertRows(Connection conn,String name,String address,String password){
        Statement statement;
        try {
            String query=String.format("Insert into %s(name,address,password) values('%s','%s','%s');","Teacher",name,address,password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Input Student marks
    public void InsertStudentMarks(Connection conn,String name,String itcp,String cal,String oop,String db,String maths){
        Statement statement;
        try {
            String query=String.format("Insert into %s(name,itcp,calculus,oop,database,maths) values('%s','%s','%s','%s','%s','%s');","Student",name,itcp,cal,oop,db,maths);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // Read Data
    public void readData(Connection conn){
        Statement statement;
        ResultSet rs=null;
        try {
            String query="select * from "+"Student"+";";
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

    public String[] searchByName(Connection conn, String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query="select * From "+"Teacher"+ " Where name ='"+name+"';";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("empid");
                String Teachername = rs.getString("name");
                String Pass = rs.getString("password");
                return new String[]{Teachername, Pass};
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return new String[]{"Teachername or Pass Incorrect", "Pass"};
    }

}
