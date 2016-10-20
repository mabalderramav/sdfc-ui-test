package org.fundacionjala.sfdc.framework.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.fundacionjala.sfdc.framework.objects.ElementBase;

/**
 * This class manage the json.
 */
public final class JsonMapper {

    private static final LoggerManager loggerManager = LoggerManager.getInstance();

    /**
     * Constructor private.
     */
    private JsonMapper() {
    }

    /**
     * This method obtains the data the a json.
     *
     * @param path        Path the json.
     * @param elementBase Element base object.
     * @return ElementBase objects
     */
    public static ElementBase getData(final String path, final ElementBase elementBase) {
        ElementBase newElementBase = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            newElementBase = mapper.readValue(new File(path), elementBase.getClass());
        } catch (IOException e) {
            loggerManager.addWarnLog(JsonMapper.class.getName(), e.getMessage(), e);
        }
        return newElementBase;
    }
}
