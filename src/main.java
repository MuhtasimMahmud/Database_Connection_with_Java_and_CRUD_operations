import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_connection", "root", "root");
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement;
            ResultSet resultSet;



            // Data insert/create


/*
        //inserting way 1: direct insert without user input

            String query1 = "INSERT INTO students (sid, name, department) VALUES ('18', 'jj', 'cse')";
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.executeUpdate();

*/


            String sid = "",name = "",department = "";

            System.out.print("Please give me your id : ");
            sid = sc.next();

            System.out.print("Please give me your name : ");
            name = sc.next();

            System.out.print("Please give me your department : ");
            department = sc.next();


/*

        // inserting way 2:

            String query2 = "INSERT INTO students (sid, name, department) VALUES ('"+sid+"', '"+name+"', '"+department+"')";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.executeUpdate();

*/



        // inserting way 3:

            String query3 = "INSERT INTO students (sid, name, department) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query3);

            preparedStatement.setString(1, sid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, department);
            preparedStatement.executeUpdate();


            System.out.println("Your data is uploaded successfully.");




/*

        // Data read/show

            String query4 = "SELECT * FROM students";
            resultSet = statement.executeQuery(query4);
            while(resultSet.next()){
                System.out.print(resultSet.getString("sid")+ " " + resultSet.getString("name")+ " " + resultSet.getString("department"));
                System.out.println();
            }


*/


/*


        // Data update

            String query5 = "UPDATE students SET department = 'CS' WHERE name = 'mahmud'";
            preparedStatement = connection.prepareStatement(query5);
            preparedStatement.executeUpdate();

            System.out.println("DATA UPDATED SUCCESSFULLY.");


*/


/*

        // Data delete

            String query6 = "DELETE FROM students WHERE name = 'mahmud'";
            preparedStatement = connection.prepareStatement(query6);
            preparedStatement.executeUpdate();

            System.out.println("DATA DELETED SUCCESSFULLY.");

*/

        }catch (Exception e){

        }

    }
}
