package com.knoldus.EmployeeInfo;

import com.knoldus.models.EmployeeDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeInfoImpl extends EmployeeInfo {
    protected static Map<Integer, ArrayList<String>> employeeMap = new HashMap<>();

    // Function to remove the employee details by providing the particular ID.
    @Override
    public Boolean removeById(int employeeId) {
        try {
            if (employeeMap.containsKey(employeeId)) {
                employeeMap.remove(employeeId);
                return true;
            } else return false;
        } catch (Exception exception) {
            return false;
        }
    }

    // Function to fetch the details of the employee by using the Employee ID.
    @Override
    public ArrayList<String> searchById(int employeeId) {
        return employeeMap.get(employeeId);
    }

    // Function to remove all the employees details from the HashMap.
    @Override
    public Boolean removeAll() {
        employeeMap.clear();
        return true;
    }

    // Function to fetch all the employees details from th HashMap.
    @Override
    public List<List<String>> listAll() {
        List<List<String>> allEmployeeList = new ArrayList<>();
        for (ArrayList<String> employee : employeeMap.values()) {
            List<String> employeeDetails = new ArrayList<>(employee);
            allEmployeeList.add(employeeDetails);
        }
        return allEmployeeList;
    }

    // Function to add the new Employee details Arraylist into the HashMap.
    @Override
    public ArrayList<String> addEmployee(EmployeeDetails employeeDetails) {
        ArrayList<String> listOfEmployeeDetails = new ArrayList<>();
        listOfEmployeeDetails.add(employeeDetails.employeeName());
        listOfEmployeeDetails.add(employeeDetails.employeeEmail());
        listOfEmployeeDetails.add(employeeDetails.employeeDepartment());
        listOfEmployeeDetails.add(employeeDetails.employeeCity());
        employeeMap.put(employeeDetails.employeeId(), listOfEmployeeDetails);
        return listOfEmployeeDetails;
    }
}
