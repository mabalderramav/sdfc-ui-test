package org.fundacionjala.sfdc.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.sfdc.framework.objects.ElementBase;

import java.io.File;
import java.io.IOException;

/**
 * This class manage the json.
 */
public final class JsonMapper {

    private static final Logger LOGGER = LogManager.getLogger(JsonMapper.class);

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
            LOGGER.warn(e.getMessage(), e);
        }
        return newElementBase;
    }
}
