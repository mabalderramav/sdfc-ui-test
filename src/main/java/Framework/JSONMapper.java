package Framework;

import Framework.Objects.ElementBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import Framework.Objects.Account;
import Framework.Objects.Lead;
import Framework.Objects.Opportunity;
import java.io.File;
import java.io.IOException;

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
}
