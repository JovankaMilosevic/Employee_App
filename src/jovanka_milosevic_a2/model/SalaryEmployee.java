package jovanka_milosevic_a2.model;

import jovanka_milosevic_a2.model.Employee;

/**
 * This class is child class of Employee class. It represents an employee and his weekly salary.
 *
 * @author Jovanka Milosevic
 */
public class SalaryEmployee extends Employee {

    private double salary;

    /**
     * A 4-param constructor. It calls the constructor from the Employee class. Also, it takes salary as parameter and
     * sets that value as employee's salary.
     *
     * @param id employee's id
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param salary employee's salary
     */
    public SalaryEmployee(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        setSalary(salary);
    }

    /**
     * an accessor
     *
     * @return salary, type double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * A mutator that takes salary as a parameter and sets that value as employee's salary
     *
     * @param salary salary, type double
     */
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("The salary should be greater than 0.");
        }
    }

    /**
     * An overridden method that calculates pay based on formula salary / 52.
     *
     * @return pay, type double
     */
    @Override
    public double calculatePay() {
        return salary / 52;
    }

    @Override
    public String toString() {
        String format = "Employee %d: %s, %s\n"
                + "Salary: %.2f";
        return String.format(format, super.getId(), super.getLastName(), super.getFirstName(), salary);
    }

}
