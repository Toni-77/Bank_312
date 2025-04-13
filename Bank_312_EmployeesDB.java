import java.util.ArrayList;
import java.util.List;


public class Bank_312_EmployeesDB {
    public static List<Bank_312_Employee> employees = new ArrayList<>();


    public static void addEmployee(Bank_312_Employee employee){
        employees.add(employee);
    }


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

