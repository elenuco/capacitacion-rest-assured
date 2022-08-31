package org.example.clase_4.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.example.clase_4.modelos.RequestPost;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class HelperMapper {
        //Constante para indicar la ruta donde se encuntra ejemplos
        private static final String PATH_EXAMPLES = "src/test/resources/examples";

        public static RequestPost loadRequestPost(){
            ObjectMapper mapper = new ObjectMapper();

            RequestPost request = null;
            try {
                request = mapper.readValue(Paths.get(PATH_EXAMPLES + "/EjemploPostsRequest.json").toFile(), RequestPost.class);
            } catch (FileNotFoundException e) {
                System.out.println("ERROR => No se encontro el example EjemploPostsRequest.json");
                e.printStackTrace();
            }catch (InvalidDefinitionException ide){
                System.out.println("ERROR => " + ide.toString());
            }
            finally {
                return request;
            }
        }
}
