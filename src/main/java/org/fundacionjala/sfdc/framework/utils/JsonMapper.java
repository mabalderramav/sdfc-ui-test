package org.fundacionjala.sfdc.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is to methods commons i the steps.
 */
public final class JsonMapper {

    private static final String SRC_TEST_RESOURCES_JSON = "src/test/resources/json/";

    /**
     * Private constructor.
     */
    private JsonMapper() {
    }

    /**
     * This method gets a map of jason file.
     *
     * @param path is the string with the path of a json file.
     * @return a map.
     */
    public static Map<String, String> getMapJson(final String path) {
        Map<String, String> valuesMap = new HashMap<>();
        try {
            valuesMap = new ObjectMapper().readValue(new File(SRC_TEST_RESOURCES_JSON.concat(path)), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valuesMap;
    }

}
