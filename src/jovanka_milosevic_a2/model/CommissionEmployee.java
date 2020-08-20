package jovanka_milosevic_a2.model;

/**
 * This class is child class of Employee class. It represents an employee and his salary based on sale rate.
 *
 * @author Jovanka Milosevic
 */
public class CommissionEmployee extends Employee {

    private double rate;
    private double sales;

    /**
     * This is a 5-param constructor. It calls the constructor from the Employee class. Also, it takes rate and sales as
     * parameters and sets those values as employee's rate and sale.
     *
     * @param id employee's id
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param rate rate
     * @param sales sales
     */
    public CommissionEmployee(int id, String firstName, String lastName, double rate, double sales) {

        super(id, firstName, lastName);
        setRate(rate);
        setSales(sales);
    }

    /**
     * an accessor
     *
     * @return rate, type double
     */
    public double getRate() {
        return rate;
    }

    /**
     * an accessor
     *
     * @return sales, type double
     */
    public double getSales() {
        return sales;
    }

    /**
     * A mutator that takes rate as a parameter and sets that value as employee's commission rate
     *
     * @param rate rate, type double
     */
    public void setRate(double rate) {
        if (rate >= 0.5 && rate <= 20) {
            this.rate = rate;
        } else {
            throw new IllegalArgumentException("The rate should be in range 0.5-20 (inclusive).");
        }
    }

    /**
     * A mutator that takes sales as a parameter and sets that value as employee's sales
     *
     * @param sales sales, type double
     */
    public void setSales(double sales) {
        if (sales > 0) {
            this.sales = sales;
        } else {
            throw new IllegalArgumentException("The sales should be greater than 0.");
        }
    }

    /**
     * An overridden method that calculates pay using formula (sales * rate) / 100.
     *
     * @return pay, type double
     */
    @Override
    public double calculatePay() {
        return (sales * rate) / 100;
    }

    //v. sta sa ovim, bunio se kompajler za toString da nema override metodu ovde, pa sam je ubacila
    //throw treba da izbacim
    @Override
    public String toString() {
        String format = "Employee %d: %s, %s\n"
                + "Commission Rate: %.2f\n"
                + "Sales: %f";
        return String.format(format, super.getId(), super.getLastName(), super.getFirstName(), rate, sales);
    }

}
