package Test7_29September2022;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FullTimeEmployee extends Employee {
    int noOfHours;
    int salaryPerHour;
    int fixedSalary;

    public void insert() throws IOException {
        System.out.println("Enter the id of Employee : ");
        employeeId = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the name of Employee : ");
        employeeName = bufferedReader.readLine();

        System.out.println("Enter the fixed salary for Full Time employee : ");
        fixedSalary = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter the hours for Full Time employee : ");
        noOfHours = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the salary per hour for Full Time Employee : ");
        salaryPerHour = Integer.parseInt(bufferedReader.readLine());

        int salary = fixedSalary + (noOfHours * salaryPerHour);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            preparedStatement = connection.prepareStatement("insert into employee values ('" + employeeId + "','" + employeeName + "');");
            preparedStatement.execute();
            preparedStatement.execute("insert into fulltimeemployee values (" + employeeId + "," + noOfHours + "," + salaryPerHour + "," + fixedSalary + "," + salary + ");");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }


}
