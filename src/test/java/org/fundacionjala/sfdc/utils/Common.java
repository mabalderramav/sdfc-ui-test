package org.fundacionjala.sfdc.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is to methods commons i the steps.
 */
public class Common {

    /**
     * This method gets a map of jason file.
     *
     * @param path is the string with the path of a json file.
     * @return a map.
     */
    public static Map getMapJson(final String path) {
        Map valuesMap = null;
        try {
            valuesMap = new ObjectMapper().readValue(new File(path), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valuesMap;
    }

}


