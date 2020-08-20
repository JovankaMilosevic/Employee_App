package jovanka_milosevic_a2.model;

/**
 * This class is superclass (a parent class). It has data fields and the methods that its subclasses inherit. Since it
 * is abstract class, we cannot make an instance of Employee type.
 *
 * @author Jovanka Milosevic
 */
public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;

    /**
     * This is a 3-param constructor. It takes id, firstName and lastName as parameters and set those values as
     * employee's id, firstName and lastName.
     *
     * @param id employee's id
     * @param firstName employee's first name
     * @param lastName employee's last name
     */
    public Employee(int id, String firstName, String lastName) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * an accessor
     *
     * @return empolyee's id, type int
     */
    public int getId() {
        return id;
    }

    /**
     * an accessor
     *
     * @return empolyee's first name, type String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * an accessor
     *
     * @return employee's last name, type String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A mutator that takes id as a parameter, and sets that value as employee's id.
     *
     * @param id employee's id
     */
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("The id should be greater than 0.");
        }
    }

    /**
     * A mutator that takes firstName as a parameter, and sets that value as employee's first name.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * A mutator that takes lastName as a parameter, and sets that value as employee's last name.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * An abstract method.
     *
     * @return type double
     */
    public abstract double calculatePay();

    /**
     * A abstract method. It is an overridden toString() method inherited from the Object class.
     *
     * @return String type
     */
    @Override
    public abstract String toString();

}
