package com.company.javaoop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Main{
  static void menu() {
        System.out.println("1- Add Student");
        System.out.println("2- Update Student");
        System.out.println("3- Delete Student");
        System.out.println("4- Show All Students");
        System.out.println("5- Exit");
      }
    public static void main(String[]args) {
        StudentsDao dao = new StudentsDao();
        Scanner in = new Scanner(System.in);
        String name ;
        double grade;
        while (true){
            menu();
            int choise = in.nextInt();
            in.nextLine();
            switch (choise){
                case 1:
                    System.out.println("Enter number of students");
                    int number = in.nextInt();
                    in.nextLine();
                    for (int i = 1; i <= number ; i++) {
                        System.out.print("Enter name for student : " + i +" ->> " );
                         name = in.nextLine();
                        System.out.print("Enter grade : " + i + " ->> " );
                         grade = in.nextDouble();
                        in.nextLine();
                        dao.addStudent(new Student(name, grade));
                    }
                        break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("new name: ");
                     name = in.nextLine();
                    System.out.print("new grade: ");
                     grade = in.nextDouble();
                    in.nextLine();
                    dao.update(id, name, grade);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                     id = in.nextInt();
                    in.nextLine();
                    dao.delete(id);
                    break;
                case 4:
                    dao.printAll();
                    break;
                case 5:
                    System.out.println(" Exit ");
                    return;
                default:
                    System.out.println("Error 404");
            }

        }

    }

}