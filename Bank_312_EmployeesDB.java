import java.util.ArrayList;
import java.util.List;
// This class will serve as a database of employees
// it comes with some existing employees added in it

public class Bank_312_EmployeesDB {
    // list of employees;
    public static List<Bank_312_Employee> employees = new ArrayList<>();

    // Method to add employee to list
    public static void addEmployee(Bank_312_Employee employee){
        employees.add(employee);
    }

    // Method to find employee by username and password
    public static boolean  findEmployee(String userName, String password){
        for(Bank_312_Employee employee:employees){
            if(employee.getUserName().equals(userName) && employee.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


    public static void populateEmpDB(){
        addEmployee(new Bank_312_Employee("Toni","412","edede@luc.edu"));
        addEmployee(new Bank_312_Employee("Nick","312", "ncwikla@luc.edu"));
    }


    public static boolean findEmployee(String email){
        for(Bank_312_Employee employee:employees){
            if(employee.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}

