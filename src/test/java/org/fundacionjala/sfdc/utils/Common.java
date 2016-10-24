package org.fundacionjala.sfdc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class Common {

    /**
     * @param path
     * @return
     */
    public static Map getMapJson(String path) {
        Map valuesMap = null;
        try {
            valuesMap = new ObjectMapper().readValue(new File(path), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valuesMap;
    }

}


