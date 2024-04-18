package com.knoldus.StudioInfo;

import java.util.ArrayList;
import java.util.List;
import com.knoldus.models.StudioDetails;

abstract class StudioInfo {

    abstract Boolean removeById(int studioId);

    abstract ArrayList<String> searchById(int studioId);

    abstract Boolean removeAll();

    abstract List<List<String>> listAll();

    // Function to add the new Studio details Arraylist into the HashMap.
    abstract ArrayList<String> addStudio(StudioDetails studioDetails);
}
