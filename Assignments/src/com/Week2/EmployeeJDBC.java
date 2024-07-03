package com.Week2;
import javax.xml.transform.Result;
import java.sql.*;

public class EmployeeJDBC {
    private String url;
    private String user;
    private String password;

    EmployeeJDBC(){
        url = "jdbc:mysql://localhost:3306/employee";
        user = "root";
        password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createEmployeeTable(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database");
            Statement st = con.createStatement();
            String sql = "CREATE TABLE EMPLOYEE_DETAILS (" +
                    "ID INT," +
                    "NAME VARCHAR(20)," +
                    "DEPARTMENT VARCHAR(50)," +
                    "PRIMARY KEY ( id )"+
                    ")";
            st.execute(sql);
            System.out.println("Employee_Details table created successfully");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addEmployee(int id, String name, String department){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            String sql = "INSERT INTO EMPLOYEE_DETAILS VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.executeUpdate();
            System.out.println("Details of employee with id " + id + " inserted in table employee_details");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateEmployee(int id, String name, String department){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            String sql = "UPDATE EMPLOYEE_DETAILS SET NAME=?, DEPARTMENT=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Employee with id " + id + " updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getEmployeeById(int id){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            String sql = "SELECT * FROM EMPLOYEE_DETAILS WHERE ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.next();
            System.out.println("Employee id: " + result.getInt("id") +
                    "| Employee name: " + result.getString("name") +
                    "| Employee department: " + result.getString("department"));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAllEmployees(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            String sql = "SELECT * FROM EMPLOYEE_DETAILS";

            Statement s = con.createStatement();
            ResultSet result = s.executeQuery(sql);
            System.out.println("All employees in Employee_details table\n");
            while(result.next()){
                System.out.println("Employee id: " + result.getInt("id") +
                        "| Employee name: " + result.getString("name") +
                        "| Employee department: " + result.getString("department"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteEmployeeById(int id){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            String sql = "DELETE FROM EMPLOYEE_DETAILS WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee with id " + id + " deleted");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAllEmployees(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            String sql = "DELETE FROM EMPLOYEE_DETAILS";

            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("All entries in Employee details table deleted\n");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC jdbc = new EmployeeJDBC();
//        jdbc.createEmployeeTable();
        jdbc.addEmployee(100, "Abhay", "HR");
        jdbc.addEmployee(200, "Banu", "Finance");
        jdbc.addEmployee(300, "Cauvery", "HR");
        jdbc.updateEmployee(100, "Abhay", "Finance");
        jdbc.getEmployeeById(200);
        System.out.println();
        jdbc.getAllEmployees();
        System.out.println();
        jdbc.deleteEmployeeById(100);
        System.out.println();
        jdbc.deleteAllEmployees();
        System.out.println();
        jdbc.getAllEmployees();
    }
}
