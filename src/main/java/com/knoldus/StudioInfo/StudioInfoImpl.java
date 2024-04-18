package com.knoldus.StudioInfo;

import com.knoldus.models.StudioDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudioInfoImpl extends StudioInfo {
    protected static Map<Integer, ArrayList<String>> studioMap = new HashMap<>();

    // Function to remove the Studio details by providing the particular ID.
    @Override
   public Boolean removeById(int studioId) {
        try {
            if (studioMap.containsKey(studioId)) {
                studioMap.remove(studioId);
                return true;
            } else return false;
        } catch (Exception exception) {
            return false;
        }
    }

    // Function to fetch the details of the Studio by using the Employee ID.
    @Override
    public ArrayList<String> searchById(int studioId) {
        return studioMap.get(studioId);
    }

    // Function to remove all the Studio details from the HashMap.
    @Override
    public Boolean removeAll() {
        studioMap.clear();
        return true;
    }

    // Function to fetch all the Studios details from th HashMap.
    @Override
    public List<List<String>> listAll() {
        List<List<String>> allStudioList = new ArrayList<>();
        for (ArrayList<String> studio : studioMap.values()) {
            List<String> studioDetails = new ArrayList<>(studio);
            allStudioList.add(studioDetails);
        }
        return allStudioList;
    }

    // Function to add the new Studio details Arraylist into the HashMap.
    @Override
    public ArrayList<String> addStudio(StudioDetails studioDetails) {
        ArrayList<String> listOfStudioDetails = new ArrayList<>();
        listOfStudioDetails.add(studioDetails.studioName());
        listOfStudioDetails.add(studioDetails.studioLevel());
        listOfStudioDetails.add(studioDetails.studioManager());
        studioMap.put(studioDetails.studioId(), listOfStudioDetails);
        return listOfStudioDetails;
    }
}
