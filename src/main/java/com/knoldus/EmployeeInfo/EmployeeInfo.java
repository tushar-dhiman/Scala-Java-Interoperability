package com.knoldus.EmployeeInfo;

import com.knoldus.models.EmployeeDetails;
import java.util.ArrayList;
import java.util.List;


abstract class EmployeeInfo {

    public abstract Boolean removeById(int employeeId);

    public abstract ArrayList<String> searchById(int employeeId);

    public abstract Boolean removeAll();

    public abstract List<List<String>> listAll();

    public abstract ArrayList<String> addEmployee(EmployeeDetails employeeDetails);
}
