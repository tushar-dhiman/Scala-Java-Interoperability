package com.knoldus.ManagersInfo;

import com.knoldus.models.ManagersDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ManagersInfoImpl extends ManagerInfo {
    ArrayList<String> listOfManagerDetails = new ArrayList<>();
    protected static Map<Integer, ArrayList<String>> managerMap = new HashMap<>();

    // Function to remove the Manager details by providing the particular ID.
    @Override
    public Boolean removeById(int managerId) {
        try {
            if (managerMap.containsKey(managerId)) {
                managerMap.remove(managerId);
                return true;
            } else return false;
        } catch (Exception exception) {
            return false;
        }
    }

    // Function to fetch the details of the Manager by using the Employee ID.
    @Override
    public ArrayList<String> searchById(int managerId) {
        return managerMap.get(managerId);
    }

    // Function to remove all the Managers details from the HashMap.
    @Override
    public Boolean removeAll() {
        managerMap.clear();
        return true;
    }

    // Function to fetch all the Managers details from th HashMap.
    @Override
    public List<List<String>> listAll() {
        List<List<String>> allManagersList = new ArrayList<>();
        for (ArrayList<String> employee : managerMap.values()) {
            List<String> employeeDetails = new ArrayList<>(employee);
            allManagersList.add(employeeDetails);
        }
        return allManagersList;
    }

    // Function to add the new Manager details Arraylist into the HashMap.
    @Override
    public ArrayList<String> addManager(ManagersDetails managersDetails) {
        ArrayList<String> listOfManagersDetails = new ArrayList<>();
        listOfManagersDetails.add(managersDetails.managerName());
        listOfManagersDetails.add(managersDetails.managerLevel());
        listOfManagersDetails.add(managersDetails.managerDepartment());
        managerMap.put(managersDetails.managerId(), listOfManagersDetails);
        return listOfManagersDetails;
    }
}
