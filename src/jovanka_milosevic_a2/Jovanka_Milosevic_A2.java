package jovanka_milosevic_a2;

import jovanka_milosevic_a2.model.SalaryEmployee;
import jovanka_milosevic_a2.model.HourlyEmployee;
import jovanka_milosevic_a2.model.Employee;
import jovanka_milosevic_a2.model.CommissionEmployee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is the test class for the Employee class and its subclasses.
 *
 * @author Jovanka Milosevic
 */
public class Jovanka_Milosevic_A2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfEmployees = enterNumberOfEmployees(input);

        ArrayList<Employee> employees = new ArrayList<>(numberOfEmployees);

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee data for employee %d of %d\n", i + 1, numberOfEmployees);
            int employeeType = chooseEmployeeType(input);
            Employee employee;

            switch (employeeType) {
                case 1:
                    int employeeId = checkIdStatus(employees, input);
                    String firstName = enterFirstName(input);
                    String lastName = enterLastName(input);
                    double salary = validateSalary(input);
                    try {
                        employee = new SalaryEmployee(employeeId, firstName, lastName, salary);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        i--;
                        break;
                    }
                    employees.add(employee);
                    break;

                case 2:
                    employeeId = checkIdStatus(employees, input);
                    firstName = enterFirstName(input);
                    lastName = enterLastName(input);
                    double hours = validateHours(input);
                    double hourlyRate = validateHourlyRate(input);
                    try {
                        employee = new HourlyEmployee(employeeId, firstName, lastName, hours, hourlyRate);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        i--;
                        break;
                    }
                    employees.add(employee);
                    break;

                case 3:
                    employeeId = checkIdStatus(employees, input);
                    firstName = enterFirstName(input);
                    lastName = enterLastName(input);
                    double rate = validateCommissionRate(input);
                    double sales = validateSales(input);
                    try {
                        employee = new CommissionEmployee(employeeId, firstName, lastName, rate, sales);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        i--;
                        break;
                    }
                    employees.add(employee);
                    break;

                default:
                    break;
            }
        }
        chooseReport(employees, input);
    }

    /**
     * A static method that takes user's input and returns number of employees (type int).
     *
     * @param input number of employees
     * @return number of employees, type int
     */
    public static int enterNumberOfEmployees(Scanner input) {
        System.out.println("How many employees to create?");
        while (true) {
            try {
                int numberOfEmployees = input.nextInt();
                input.nextLine();
                if (numberOfEmployees < 0) {
                    System.out.println("Please, enter a valid number of employees.");
                } else if (numberOfEmployees == 0) {
                    System.out.println("Please, enter a valid number of employees.");
                } else {
                    return numberOfEmployees;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that takes user's input and returns type of employee
     *
     * @param input type of employee
     * @return type of employee, type int
     */
    public static int chooseEmployeeType(Scanner input) {
        while (true) {
            try {
                System.out.print("Choose type of employee to add.\n"
                        + "1. Salaried\n"
                        + "2. Hourly\n"
                        + "3. Commission: ");
                int employeeType = input.nextInt();
                input.nextLine();
                if (employeeType >= 1 && employeeType <= 3) {
                    return employeeType;
                } else {
                    System.out.println("Please, enter a valid number.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that checks if Id number is in the valid range of numbers.
     *
     * @param input id
     * @return id, type double
     */
    public static int validateId(Scanner input) {
        while (true) {
            try {
                System.out.print("Employee ID: ");
                int employeeId = input.nextInt();
                input.nextLine();
                if (employeeId > 0) {
                    return employeeId;
                } else {
                    System.out.println("Please, enter a valid number (>0).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that checks if id is already taken.
     *
     * @param employees an ArrayList of Employee type
     * @param input user's input
     * @return employee's id, type int
     */
    public static int checkIdStatus(ArrayList<Employee> employees, Scanner input) {
        int employeeId;
        while (true) {
            employeeId = validateId(input);
            boolean uniqueId = true;
            for (Employee employee : employees) {
                if (employeeId == employee.getId()) {
                    uniqueId = false;
                    System.out.print("That id is already taken: ");
                    break;
                }
            }
            if (uniqueId) {
                break;
            }
        }
        return employeeId;
    }

    /**
     * A static method that takes user's input and return user's first name
     *
     * @param input user's first name
     * @return first name, type String
     */
    public static String enterFirstName(Scanner input) {
        System.out.print("First name: ");
        String firstName = input.nextLine();
        return firstName;
    }

    /**
     * A static method that takes user's input and return user's last name
     *
     * @param input user's last name
     * @return last name, type String
     */
    public static String enterLastName(Scanner input) {
        System.out.print("Last name: ");
        String lastName = input.nextLine();
        return lastName;
    }

    /**
     * A static method that checks if user used numbers or valid numbers to enter his salary
     *
     * @param input salary
     * @return salary, type double
     */
    public static double validateSalary(Scanner input) {
        while (true) {
            try {
                System.out.print("Salary: ");
                double salary = input.nextDouble();
                input.nextLine();
                if (salary > 0) {
                    return salary;
                } else {
                    System.out.println("Please, enter a valid number (>0).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that checks if user used numbers or valid numbers to enter a number of hours he worked
     *
     * @param input number of hours
     * @return number of hours, type double
     */
    public static double validateHours(Scanner input) {
        while (true) {
            try {
                System.out.print("Hours worked: ");
                double hours = input.nextDouble();
                input.nextLine();
                if (hours > 0) {
                    return hours;
                } else {
                    System.out.println("Please, enter a valid number (>0).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that checks if user used numbers or valid numbers to enter his hourly rate
     *
     * @param input hourly rate
     * @return hourly rate, type double
     */
    public static double validateHourlyRate(Scanner input) {
        while (true) {
            try {
                System.out.print("Hourly rate: ");
                double hourlyRate = input.nextDouble();
                input.nextLine();
                if (hourlyRate > 0) {
                    return hourlyRate;
                } else {
                    System.out.println("Please, enter a valid number (>0).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    //vidi da li treba ovde da validiram uslov za 0.5 i 20
    /**
     * A static method that checks if user used numbers or valid numbers to enter his commission rate
     *
     * @param input commission rate
     * @return commission rate, type double
     */
    public static double validateCommissionRate(Scanner input) {
        while (true) {
            try {
                System.out.print("Commission rate: ");
                double commissionRate = input.nextDouble();
                input.nextLine();
                if (commissionRate >= 0.5 && commissionRate <= 20) {
                    return commissionRate;
                } else {
                    System.out.println("Please, enter a valid number (>=0.5 and <=20).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static method that checks if user used numbers or valid numbers to enter his sale
     *
     * @param input sale
     * @return sale, type double
     */
    public static double validateSales(Scanner input) {
        while (true) {
            try {
                System.out.print("Sales: ");
                double sales = input.nextDouble();
                input.nextLine();
                if (sales > 0) {
                    return sales;
                } else {
                    System.out.println("Please, enter a valid number (>0).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static void method that is used to ask user if he wants to choose a report and presents a report he selected,
     * or exits the user menu if he choose "exit".
     *
     * @param employees an ArrayList of the Employee type
     * @param input user's input (which option he wants), type int
     */
    public static void chooseReport(ArrayList<Employee> employees, Scanner input) {
        while (true) {
            try {
                System.out.print("Choose report.\n"
                        + "1. Employee listing\n"
                        + "2. Payroll listing\n"
                        + "3. Exit: ");
                int reportOption = input.nextInt();
                input.nextLine();
                if (reportOption >= 1 && reportOption <= 3) {
                    if (reportOption == 1) {
                        displayEmployeeInfo(employees);
                    } else if (reportOption == 2) {
                        displayEmployeePayroll(employees);
                    } else if (reportOption == 3) {
                        break;
                    }
                } else {
                    System.out.println("Enter a valid number.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a number.");
                input.nextLine();
            }
        }
    }

    /**
     * A static void method that displays employee info for each employee in employees ArrayList
     *
     * @param employees an ArrayList of the Employee type.
     */
    public static void displayEmployeeInfo(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    /**
     * A static void method that displays payroll info for each employee in employees ArrayList
     *
     * @param employees an ArrayList of the Employee type
     */
    public static void displayEmployeePayroll(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("Weekly pay for %s, %s employee id %d is %.2f\n", employee.getLastName(), employee.getFirstName(), employee.getId(), employee.calculatePay());
        }
    }
}
