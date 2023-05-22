package com.prozenda.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

/**
 * @author Rebeka Alajtner
 * @created 19/04/2023 - 11:51
 * @project SiliconDreams
 */
public class Version {

    public Version init(JSONObject json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json.toString(), Version.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String versionNumber;

    public String getVersionNumber() {
        return versionNumber;
    }

}
