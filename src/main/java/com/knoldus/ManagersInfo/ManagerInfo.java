package com.knoldus.ManagersInfo;

import java.util.ArrayList;
import java.util.List;
import com.knoldus.models.ManagersDetails;

abstract class ManagerInfo {

    abstract Boolean removeById(int managerId);

    abstract ArrayList<String> searchById(int managerId);

    abstract Boolean removeAll();

    abstract List<List<String>> listAll();

    // Function to add the new Manager details Arraylist into the HashMap.
    abstract ArrayList<String> addManager(ManagersDetails managersDetails);
}
