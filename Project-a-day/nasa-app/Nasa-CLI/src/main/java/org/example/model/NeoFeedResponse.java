package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class NeoFeedResponse {

    //This map will hold the date as the key
    //value is an array being tuned into a List
    @JsonProperty("near_earth_objects")
    private Map<String, List<Neo>> nearEarthObject;

    public Map<String, List<Neo>> getNearEarthObject() {
        return nearEarthObject;
    }

    public void setNearEarthObject(Map<String, List<Neo>> nearEarthObject) {
        this.nearEarthObject = nearEarthObject;
    }

    @Override
    public String toString() {
        return "NeoFeedResponse{" +
                "nearEarthObject=" + nearEarthObject +
                '}';
    }
}
