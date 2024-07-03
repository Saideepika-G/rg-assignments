package com.Week2;
import java.util.*;

public class EmployeeCRUD {
    ArrayList<Employee> employees;

    EmployeeCRUD(){
        employees = new ArrayList<>();
    }

    public void createEmployee(int id, String name, String department){
        Employee emp = new Employee(id, name, department);
        employees.add(emp);
        System.out.println("Employee with id " + id + " created and added");
    }

    public Employee getEmployeeById(int id){
        for(Employee emp: employees){
            if(emp.getId() == id)
                return emp;
        }
        System.out.println("Employee with id "+id+" not found");
        return null;
    }

    public ArrayList<Employee> getAllEmployees(){
        return employees;
    }

    public void updateEmployee(int id, String name, String department){
        Employee emp = getEmployeeById(id);
        if(emp != null){
            emp.setName(name);
            emp.setDepartment(department);
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee with given id was not found, so a new employee created");
            createEmployee(id, name, department);
        }
    }

    public void deleteEmployeeById(int id){
        for(Employee emp: employees){
            if(emp.getId() == id){
                employees.remove(emp);
                System.out.println("Employee with given id "+ id + " removed successfully");
                return;
            }
        }
        System.out.println("Employee with id " + id + " not found");
    }

    public void deleteAllEmployees(){
        employees.clear();
        System.out.println("All employees were deleted successfully");
    }

    public static void main(String[] args) {

        EmployeeCRUD ec = new EmployeeCRUD();
        //CREATE OPERATION
        ec.createEmployee(100, "A", "Admin");
        ec.createEmployee(200,"B", "HR" );
        ec.createEmployee(300,"C", "HR" );
        System.out.println("**********************************");

        //READ OPERATION
        System.out.println("\n\n" + ec.getAllEmployees());

        //UPDATE OPERATION
        ec.updateEmployee(300, "C","Finance");
        ec.updateEmployee(400, "D","Finance");

        //DELETE OPERATION
        ec.deleteEmployeeById(100);
        System.out.println("\n\n" + ec.getAllEmployees());
        ec.deleteAllEmployees();
        System.out.println("\n\n" + ec.getAllEmployees());
    }
}
