package org.example.clase_4.config;

import java.io.IOException;
import java.util.Properties;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

public class ApplicationProperties {
    private static Properties instance = null;

    private static final String APPLICATION_PREFIX = "application";
    private static final String APPLICATION_SUFFIX = "properties";

    public static synchronized Properties getInstance(){
        if (instance == null){
            instance = loadPropertiesFile();
        }

        return instance;
    }

    private ApplicationProperties(){
    }

    private static Properties loadPropertiesFile(){
        //Por defecto levanta la properties "local"
        String environment = "local";

        //Por definicion propia:
        // - toma como primera instancia el "env" enviado por el Runner
        // - en caso de null, mira el "env" enviado por linea de comando
        // - para el caso que ambos sean null, queda con el valor "local"
        // - para el caso que ambos no sean null, se quedará con el enviado en linea de comando
        if (System.getenv("env") != null){
            environment = System.getenv("env");
        }
        if(System.getProperty("env") != null){
            environment = System.getProperty("env");
            System.setProperty("env", null);//Para settear a null si se envia por linea de comando
        }


        String fileName = String.format("%s/%s-%s.%s", "environments", APPLICATION_PREFIX, environment, APPLICATION_SUFFIX);

        Properties prop = new Properties();
        try {
            prop.load(getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            System.out.println("ERROR. No se encontro el archivo de propiedades");
            e.printStackTrace();
        }

        return prop;
    }
}
