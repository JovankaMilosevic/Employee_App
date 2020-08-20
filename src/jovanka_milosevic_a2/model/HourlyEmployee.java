package jovanka_milosevic_a2.model;

import jovanka_milosevic_a2.model.Employee;

/**
 * This class is child class of Employee class. It represents an employee and his salary based on number of hours he
 * worked and his hourly rate.
 *
 * @author Jovanka Milosevic
 */
public class HourlyEmployee extends Employee {

    private double numHours;
    private double hourlyRate;

    /**
     * This is a 5-param constructor. It calls the constructor from the Employee class. Also, it takes numHours and
     * hourlyRate as parameters and set those values to employee's numHours and hourlyRate.
     *
     * @param id employee's id
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param numHours employee's number of hours
     * @param hourlyRate employee's hourly rate
     */
    public HourlyEmployee(int id, String firstName, String lastName, double numHours, double hourlyRate) {
        super(id, firstName, lastName);
        this.numHours = numHours;
        this.hourlyRate = hourlyRate;
    }

    /**
     * an accessor
     *
     * @return employee's numHours, type double
     */
    public double getNumHours() {
        return numHours;
    }

    /**
     * an accessor
     *
     * @return employee's hourlyRate, type double
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * A mutator that takes numHours as a parameter and sets that value as employee's number of worked hours
     *
     * @param numHours hours, type double
     */
    public void setNumHours(double numHours) {
        this.numHours = numHours;
    }

    /**
     * A mutator that takes hourlyRate as a parameter and sets that value as employee's hourly rate
     *
     * @param hourlyRate hourlyRate, type double
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * An overridden method that calculates pay using formula numHours * hourlyRate
     *
     * @return pay, type double
     */
    @Override
    public double calculatePay() {
        return numHours * hourlyRate;
    }

    @Override
    public String toString() {
        String format = "Employee %d: %s, %s\n"
                + "Hours: %f\n"
                + "Rate: %.2f";
        return String.format(format, super.getId(), super.getLastName(), super.getFirstName(), numHours, hourlyRate);
    }

}
