package Test7_29September2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(flag) {
            System.out.println("\n1.Insert New Employee  " +
                    "\n2.Update Employee Record " +
                    "\n3.Delete Employee Record " +
                    "\n4.Fetch All Records" +
                    "\n5.Records having salary >= 25000 " +
                    "\nPlease Enter Your Choice : ");
            int choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1 :
                    new Employee().insertRecord();
                    break;
                case 2 :
                    new Employee().updateEmployee();
                    break;
                case 3 :
                    new Employee().deleteEmployee();
                    break;
                case 4 :
                    new Employee().fetchAllRecords();
                    break;
                case 5 :
                    new Employee().salaryGreater25000();
                    break;
                default:
                    flag = false;
            }
        }
    }
}


/*  DESC EMPLOYEE :

+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   | PRI | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

create table employee (id int primary key,name varchar(20));

* */

/* DESC PART TIME EMPLOYEE :

+---------------+------+------+-----+---------+-------+
| Field         | Type | Null | Key | Default | Extra |
+---------------+------+------+-----+---------+-------+
| id            | int  | YES  | MUL | NULL    |       |
| hours         | int  | YES  |     | NULL    |       |
| salaryperhour | int  | YES  |     | NULL    |       |
| salary        | int  | YES  |     | NULL    |       |
+---------------+------+------+-----+---------+-------+

create table parttimeemployee (id int,hours int,salaryperhour int,
salary int, foreign key (id) references employee(id) on delete cascade on update cascade);

* */

/* DESC FULL TIME EMPLOYEE :

+---------------+------+------+-----+---------+-------+
| Field         | Type | Null | Key | Default | Extra |
+---------------+------+------+-----+---------+-------+
| id            | int  | YES  | MUL | NULL    |       |
| hours         | int  | YES  |     | NULL    |       |
| salaryperhour | int  | YES  |     | NULL    |       |
| fixedsalary   | int  | YES  |     | NULL    |       |
| salary        | int  | YES  |     | NULL    |       |
+---------------+------+------+-----+---------+-------+

create table fulltimeemployee (id int,hours int,salaryperhour int,fixedsalary int,
salary int, foreign key (id) references employee(id) on delete cascade on update cascade);

* */


