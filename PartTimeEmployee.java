package Test7_29September2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class PartTimeEmployee extends Employee {
    int noOfHours;
    int salaryPerHour;
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    Connection connection ;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;

    public void insert() throws IOException {
        System.out.println("Enter the id of Employee : ");
        employeeId = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the name of Employee : ");
        employeeName = bufferedReader.readLine();

        System.out.println("Enter the hours for Part Time employee : ");
        noOfHours = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the salary per hour for Part Time Employee : ");
        salaryPerHour = Integer.parseInt(bufferedReader.readLine());

        int salary = noOfHours*salaryPerHour;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            preparedStatement = connection.prepareStatement("insert into employee values ('" + employeeId + "','" + employeeName + "');");
            preparedStatement.execute();
            preparedStatement.execute("insert into parttimeemployee values ("+employeeId+","+noOfHours+","+salaryPerHour+","+salary+");");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
