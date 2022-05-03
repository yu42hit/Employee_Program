public class HoursAndSalary {

    protected double salary = 0;
    protected double budget = 0;
    protected double hoursWorked = 0;

    public HoursAndSalary(double s, double b, double h) {

        salary = s;
        budget = b;
        hoursWorked = h;

    }

    public void setSalary(double s){

        salary = s;

    }

    public void setBudget(double b){

        budget = b;

    }

    public void setHoursWorked(double h){

        hoursWorked = h;

    }

    public double getSalary(){

        return salary;

    }

    public double getBudget(){

        return budget;

    }

    public double getHoursWorked(){

        return hoursWorked;

    }

    public String toString(){

        return String.format("Budget: $%.2f\nSalary: $%.2f\nTotal Hours Worked (Weekly): %.1f", budget, salary, hoursWorked);

    }


}

class SalaryCalc extends HoursAndSalary {

    protected double budgetAmount = 0;
    protected double salaryAmount = 0;

    public SalaryCalc(HoursAndSalary has){

        super(has.getSalary(), has.getBudget(), has.getHoursWorked());

        this.budgetAmount = budget - ((hoursWorked) * (salary * EmployeeClient.employee.size()));
        this.salaryAmount = budget > 0 ? budget / (hoursWorked / EmployeeClient.employee.size()) : 0;

    }

    public SalaryCalc(double s, double b, double h){

        super(s, b, h);

        this.budgetAmount = budget - ((hoursWorked) * (salary * EmployeeClient.employee.size()));
        this.salaryAmount = budget > 0 ? budget / (hoursWorked / EmployeeClient.employee.size()) : 0;


    }

    public double getBudget(){

        return this.budgetAmount = budget - ((hoursWorked) * (salary * EmployeeClient.employee.size()));

    }

    public double getSalary(){

        return this.salaryAmount = budget > 0 ? budget / (hoursWorked / EmployeeClient.employee.size()) : 0;

    }

    public String toString(){

        return String.format((this.getBudget() > 0 ? "You have a $%.2f Surplus in Your Budget." : this.getBudget() == 0 ? "You Have No Money Left in Your Budget." : "You Have a $%.2f Deficit in Your Budget.") + "\nSuggested Salary Per Employee: $%.2f", budgetAmount, budgetAmount, salaryAmount);

    }

}