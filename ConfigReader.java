package api.payload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader{

        private static ConfigReader configReader;
        private static Properties properties;

	private ConfigReader(){ 
	      String Filepath ="";
	      try{
	          Filepath = "/opt/product/testteam/LoadScript/REPORT_GENERATION/src/test/resources/route.properties";
	          FileReader getFile = new FileReader(Filepath);
	          BufferedReader getObject = new BufferedReader(getFile);
                  properties= new Properties();
	          properties.load(getObject);
	          getObject.close();
	          getFile.close();

	       }
	      catch(IOException e){
	          e.printStackTrace();
	      } 
        }

        public static ConfigReader getInstance(){
            if (configReader !=null){
                configReader = new ConfigReader();
            }
          return configReader;
        }


       public static String getDataProviderPath(){
 
             String providerPath = properties.getProperty("dataProviderPath");
             if (providerPath !=null){
                   return providerPath;
             }
             else{
                   throw new RuntimeException("Test data file not present in the path");
             }
              
      }
}
