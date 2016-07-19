package Framework;

import java.io.File;
import java.io.IOException;

import Framework.Objects.ElementBase;
import Framework.Objects.Lead;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Pablo Zubieta on 01/09/2015.
 */
public class JSONMapper {

    public static ElementBase getData(String path, ElementBase elementBase){

        try {
            ObjectMapper mapper = new ObjectMapper();
            elementBase = mapper.readValue(new File(path), elementBase.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementBase;
    }

    public static Lead getLeadData(String path) {
        Lead lead = (Lead) JSONMapper.getData(path,new Lead());
        return lead;
    }
}
