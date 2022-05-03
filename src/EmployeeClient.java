import javax.swing.*;
import java.util.ArrayList;

public class EmployeeClient {

    static ArrayList<Employee> employee = new ArrayList<Employee>();

    static HoursAndSalary main = new HoursAndSalary(0, 0, 0);
    static SalaryCalc arg = new SalaryCalc(main);

    public static void main(String[] args) {

        welcome();

        mainMenu();

    }

    static void welcome() {

        int choice = JOptionPane.showOptionDialog(null, "WELCOME ADMIN!", "MANAGER | WELCOME", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"START PROGRAM", "QUIT"}, "START PROGRAM");

        switch (choice) {

            case 0:
                break;

            case 1:
                System.exit(0);
                break;

            default:
                System.exit(1);
                break;

        }

    }

    static void mainMenu() {

        while (true) {

            int choice = JOptionPane.showOptionDialog(null, "SELECT MENU", "MANAGER | MAIN MENU", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"BUDGET MENU", "EMPLOYEE MENU", "QUIT"}, null);

            switch (choice) {

                case 0:
                    budgetMenu();
                    break;

                case 1:
                    employeeMenu();
                    break;

                case 2:
                    System.exit(0);
                    break;

                default:
                    System.exit(1);
                    break;

            }

        }

    }

    static void budgetMenu() {

        boolean t = true;

        while (t) {

            int choice = JOptionPane.showOptionDialog(null, main + "\n" + arg, "MANAGER | BUDGET MENU", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"CALC SALARY", "EDIT HOURS WORKED","EDIT SALARY", "EDIT BUDGET", "HELP", "GO BACK"}, null);

            switch (choice) {

                case 0:
                    calcSalary();
                    break;

                case 1:
                    editHoursWorked();
                    break;

                case 2:
                    editSalary();
                    break;

                case 3:
                    editBudget();
                    break;

                case 4:
                    helpBudget();
                    break;

                case 5:
                    t = false;
                    break;

                default:
                    System.exit(1);
                    break;


            }

        }
    }

    static void editBudget() {

        double a = 0;
        boolean t = true;

        while (t) {

            String b = JOptionPane.showInputDialog(null, "Input Budget Amount:", "MANAGER | EDIT BUDGET", JOptionPane.PLAIN_MESSAGE);

            if (b != null) {

                a = Double.parseDouble(b);

                if (a > 0) {

                    JOptionPane.showConfirmDialog(null, "Your Budget is Set!", "MANAGER | SUCCESS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                    main.setBudget(a);
                    arg.setBudget(a);
                    break;

                } else {

                    JOptionPane.showConfirmDialog(null, "Invalid Amount.\nPlease Try Again.", "MANAGER | ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                }

            } else {

                t = false;
                break;

            }
        }

    }

    static void editSalary() {

        double a = 0;
        boolean t = true;

        while (t) {

            String b = JOptionPane.showInputDialog(null, "Please Enter Salary Above Minimum Wage ($12):", "MANAGER | EDIT SAlARY", JOptionPane.PLAIN_MESSAGE);

            if (b != null) {

                a = Double.parseDouble(b);

                if (a > 0) {

                    JOptionPane.showConfirmDialog(null, "Your Salary is Set!", "MANAGER | SUCCESS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                    main.setSalary(a);
                    arg.setSalary(a);
                    break;

                } else {

                    JOptionPane.showConfirmDialog(null, "Invalid Amount.\nPlease Try Again.", "MANAGER | ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                }

            } else {

                t = false;
                break;

            }
        }
    }

    static void editHoursWorked(){

        double a = 0;
        boolean t = true;

        while (t) {

            String b = JOptionPane.showInputDialog(null, "Please Enter Total Hours Worked:", "MANAGER | EDIT HOURS", JOptionPane.PLAIN_MESSAGE);

            if (b != null) {

                a = Double.parseDouble(b);

                if (a > 0) {

                    JOptionPane.showConfirmDialog(null, "Your Hours are Set!", "MANAGER | SUCCESS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                    main.setHoursWorked(a);
                    arg.setHoursWorked(a);
                    break;

                } else {

                    JOptionPane.showConfirmDialog(null, "Invalid Amount.\nPlease Try Again.", "MANAGER | ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                }

            } else {

                t = false;
                break;

            }
        }

    }

    static void calcSalary() {

        String b = String.format("Would you Like to Change Your Salary From $%.2f to $%.2f?\nThis Calculation is Based Off Your Budget, Salary and Hours Worked.\nFor more information please refer to the Help Section of the Budget Menu.", main.getSalary(), arg.getSalary());

        int a = JOptionPane.showOptionDialog(null, b, "MANAGER | CALCULATE SALARY", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, JOptionPane.YES_OPTION);

        switch (a){

            case JOptionPane.YES_OPTION:
                main.setSalary(arg.getSalary());
                break;

            case JOptionPane.NO_OPTION:
                break;

            default:
                System.exit(1);

        }

    }

    static void helpBudget() {


        JOptionPane.showConfirmDialog(null, "EDIT BUDGET: Input New Budget.\nEDIT SALARY: Input New Salary.\nEDIT HOURS WORKED: Input the Total Hours Worked Weekly.\nCALC SALARY: Calculates the max Salary Based on the Amount of Employees, Budget, and Hours Worked.", "MANAGER | BUDGET HELP", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

    }

    static void employeeMenu() {

        boolean t = true;

        while(t) {

            int choice = JOptionPane.showOptionDialog(null, "Amount of Employees: " + employee.size(), "MANAGER | EMPLOYEE MENU", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"VIEW EMPLOYEES", "REMOVE EMPLOYEE", "EDIT EMPLOYEE", "ADD EMPLOYEE", "HELP", "GO BACK"}, null);

            switch(choice){

                case 0:
                    viewEmployee();
                    break;

                case 1:
                    removeEmployee();
                    break;

                case 2:
                    editEmployee();
                    break;

                case 3:
                    newEmployee();
                    break;

                case 4:
                    helpEmployee();
                    break;

                case 5:
                    t = false;
                    break;

                default:
                    System.exit(1);

            }

        }

    }

    static void newEmployee() {

        BasicInfo temp = new BasicInfo();

        String a = JOptionPane.showInputDialog(null, "Please Enter First Name:", "MANAGER | ENTER FIRST NAME", JOptionPane.PLAIN_MESSAGE);
        temp.setFirstName(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Last Name:", "MANAGER | ENTER LAST NAME", JOptionPane.PLAIN_MESSAGE);
        temp.setLastName(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Department:", "MANAGER | ENTER DEPARTMENT", JOptionPane.PLAIN_MESSAGE);
        temp.setDepartment(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Phone Number:", "MANAGER | ENTER PHONE NUMBER", JOptionPane.PLAIN_MESSAGE);
        temp.setPhone(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Home Address:", "MANAGER | ENTER ADDRESS", JOptionPane.PLAIN_MESSAGE);
        temp.setAddress(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Email:", "MANAGER | ENTER EMAIL", JOptionPane.PLAIN_MESSAGE);
        temp.setEmail(a.isEmpty() ? "Not Entered" : a);

        a = JOptionPane.showInputDialog(null, "Please Enter Position:", "MANAGER | ENTER POSITION", JOptionPane.PLAIN_MESSAGE);
        temp.setPosition(a.isEmpty() ? "Not Entered" : a);

        int b = JOptionPane.showOptionDialog(null, temp + "\n\nWould You Like to Create This Employee?", "MANAGER | CONFIRM EMPLOYEE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        switch (b){

            case JOptionPane.YES_OPTION:
                employee.add(new Employee(temp));
                break;

            default:
                break;

        }

    }

    static void editEmployee() {

        String em = employeeList();

        String a = JOptionPane.showInputDialog(null, em + "\n\nPlease Enter the Number Corresponding to the Employee:", "MANAGER | EDIT EMPLOYEE", JOptionPane.PLAIN_MESSAGE);
        int val = (Integer.parseInt(a)) - 1;

        BasicInfo temp = employee.get(val).getInfo();

        a = (String) JOptionPane.showInputDialog(null, "Please Enter First Name:", "MANAGER | ENTER FIRST NAME", JOptionPane.PLAIN_MESSAGE, null, null, temp.getFirstName());
        temp.setFirstName(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Last Name:", "MANAGER | ENTER LAST NAME", JOptionPane.PLAIN_MESSAGE, null, null, temp.getLastName());
        temp.setLastName(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Department:", "MANAGER | ENTER DEPARTMENT", JOptionPane.PLAIN_MESSAGE, null, null, temp.getDepartment());
        temp.setDepartment(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Phone Number:","MANAGER | ENTER PHONE NUMBER", JOptionPane.PLAIN_MESSAGE, null, null, temp.getPhone());
        temp.setPhone(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Home Address:", "MANAGER | ENTER ADDRESS", JOptionPane.PLAIN_MESSAGE, null, null, temp.getAddress());
        temp.setAddress(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Email:", "MANAGER | ENTER EMAIL", JOptionPane.PLAIN_MESSAGE, null, null, temp.getEmail());
        temp.setEmail(a.isEmpty() ? "Not Entered" : a);

        a = (String) JOptionPane.showInputDialog(null, "Please Enter Position:", "MANAGER | ENTER POSITION", JOptionPane.PLAIN_MESSAGE, null, null,temp.getPosition());
        temp.setPosition(a.isEmpty() ? "Not Entered" : a);

        int b = JOptionPane.showOptionDialog(null, temp + "\n\nWould You Like to Edit This Employee?", "MANAGER | CONFIRM EMPLOYEE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        switch (b){

            case JOptionPane.YES_OPTION:
                employee.set(val, new Employee(temp));
                break;

            default:
                break;

        }

    }

    static void removeEmployee() {

        String s = employeeList();


    }

    static void viewEmployee() {

        String s = employeeList();

        String a = JOptionPane.showInputDialog(null, s + "\n\nPlease Enter the Number Corresponding to the Employee to view it:", "MANAGER | EDIT EMPLOYEE", JOptionPane.PLAIN_MESSAGE);
        int val = (Integer.parseInt(a)) - 1;

        JOptionPane.showConfirmDialog(null, employee.get(val), "MANAGER | VIEW EMPLOYEE", JOptionPane.DEFAULT_OPTION);

    }

    static void helpEmployee() {


    }

    public static String employeeList(){

        int val = 0;
        String s = "";

        while (employee.size() > val) {

            s += String.format(val + 1 + ". %s, %s\n", employee.get(val).getInfo().getLastName(), employee.get(val).getInfo().getFirstName());
            val++;

        }

        return s;

    }



}
