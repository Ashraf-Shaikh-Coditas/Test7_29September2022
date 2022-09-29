package Test7_29September2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Employee {
    int employeeId;
    String employeeName;
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;

    public void insertRecord() throws IOException {

        System.out.println("Enter the Type of Employee to be inserted : PT or FT");
        String ans = bufferedReader.readLine();
        if (ans.equals("PT")) {
            new PartTimeEmployee().insert();
        } else {
            new FullTimeEmployee().insert();
        }

        System.out.println("EMPLOYEE ADDED SUCESSFULLY.");

    }

    public void updateEmployee() throws IOException {
        System.out.println("Enter the id of employee to be updated : ");
        int id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the new name to be updated : ");
        String newName = bufferedReader.readLine();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            preparedStatement = connection.prepareStatement("update employee set name = '" + newName + "' where id = " + id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("EMPLOYEE UPDATED SUCESSFULLY.");

    }

    public void deleteEmployee() throws IOException {
        System.out.println("Enter the id of employee to be deleted : ");
        int id = Integer.parseInt(bufferedReader.readLine());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            preparedStatement = connection.prepareStatement("delete from employee where id = " + id);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("EMPLOYEE DELETED SUCESSFULLY.");

    }

    public void fetchAllRecords() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            preparedStatement = connection.prepareStatement("select employee.id,employee.name,parttimeemployee.hours,parttimeemployee.salaryperhour," +
                    "parttimeemployee.salary from employee inner join parttimeemployee on employee.id=parttimeemployee.id");
            resultSet = preparedStatement.executeQuery();

            System.out.println("Part Time Employee Records : ");
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + " Name : " + resultSet.getString(2) + " Hours : " + resultSet.getInt(3) +
                        "Salary Per Hour : " + resultSet.getInt(4) + " Salary : " + resultSet.getInt(5));
            }
            resultSet.close();

            resultSet = preparedStatement.executeQuery("select employee.id,employee.name,fulltimeemployee.hours,fulltimeemployee.salaryperhour," +
                    "fulltimeemployee.salary,fulltimeemployee.fixedsalary from employee inner join fulltimeemployee on " +
                    "employee.id=fulltimeemployee.id;");
            System.out.println("Full Time Employee Records : ");

            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + " Name : " + resultSet.getString(2) + " Hours : " + resultSet.getInt(3) +
                        "Salary Per Hour : " + resultSet.getInt(4) + " Salary : " + resultSet.getInt(5) + " Fixed Salary : " + resultSet.getInt(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void salaryGreater25000() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            preparedStatement = connection.prepareStatement("select employee.id,employee.name,parttimeemployee.hours,parttimeemployee.salaryperhour," +
                    "parttimeemployee.salary from employee inner join parttimeemployee on employee.id=parttimeemployee.id where parttimeemployee.salary > 25000");
            resultSet = preparedStatement.executeQuery();

            System.out.println("Part Time Employee Records : ");
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + " Name : " + resultSet.getString(2) + " Hours : " + resultSet.getInt(3) +
                        "Salary Per Hour : " + resultSet.getInt(4) + " Salary : " + resultSet.getInt(5));
            }
            resultSet.close();

            resultSet = preparedStatement.executeQuery("select employee.id,employee.name,fulltimeemployee.hours,fulltimeemployee.salaryperhour," +
                    "fulltimeemployee.salary,fulltimeemployee.fixedsalary from employee inner join fulltimeemployee on " +
                    "employee.id=fulltimeemployee.id where fulltimeemployee.salary > 25000;");
            System.out.println("Full Time Employee Records : ");

            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + " Name : " + resultSet.getString(2) + " Hours : " + resultSet.getInt(3) +
                        "Salary Per Hour : " + resultSet.getInt(4) + " Salary : " + resultSet.getInt(5) + " Fixed Salary : " + resultSet.getInt(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
