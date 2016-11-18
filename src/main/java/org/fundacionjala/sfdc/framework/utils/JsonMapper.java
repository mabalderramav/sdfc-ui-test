package org.fundacionjala.sfdc.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is to methods commons i the steps.
 */
public final class JsonMapper {

    private static final Logger LOGGER = LogManager.getLogger(JsonMapper.class);

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
    public static Map getMapJson(final String path) {
        Map valuesMap = new HashMap<>();
        try {
            valuesMap = new ObjectMapper().readValue(new File(SRC_TEST_RESOURCES_JSON.concat(path)), Map.class);
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);

        }
        return valuesMap;
    }
}
