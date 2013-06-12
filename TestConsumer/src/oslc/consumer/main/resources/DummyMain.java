 
 
package oslc.consumer.main.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import olsc.consumer.ConsumerException;
 
import olsc.consumer.Retriever;

import org.apache.commons.io.FileUtils;
import org.apache.wink.client.ClientResponse;
 

 

 
public abstract class DummyMain {

    /**
     * Constant in ms for timeout for communication between consumer and provider.
     */
    private static final int TIMEOUT = 2000;

    /**
     * Maximum of lines that will be printed out on the console in loops (Use a very high values if you want to see
     * everything).
     */
    private static final int MAXLINECOUNT = 15;

    /**
     * Temporary directory data retrieved will be stored at.
     */
    private static final String TEMP_COMSUMER_OUTPUT_DIR = "E:\\HAW\\rhapsody_integration_example\\dummy";
    
  

    /**
     * Main Method for the command line java application.
     * 
     * @param args Command line arguments for the Consumer test.
     */
    public static void main(final String[] args) {
        System.out.println("Dummy!!");
        Float changepreis = new Float(12.5);

        // URI of the OSLC4J catalog
        String registryuri = "http://localhost:8080/OSLC4JRegistry/catalog";

        try {
            // Construct a retriever bound to the given catalog.
            Retriever retriever = new Retriever(registryuri);

            // Check timeout.
            System.out.println("Standard Timeout: " + retriever.getTimeout());
            retriever.setTimeout(TIMEOUT);
            System.out.println("== ******************************************************* ==");

            // Retrieve all Rhapsody System Definitions.
            StockQuote[] stockinformation = retriever.getSystemDefinitions();
            System.out.println("Resourcesize++++++++"+stockinformation.length);

         /*
            for (StockQuote stock : stockinformation) {
                System.out.println("Stockquote: " + stock.getAbout());
                System.out.println("ID:    " + stock.getIdentifier());
                System.out.println("Title: " + stock.getTitle());
                System.out.println("Change Preis: " + stock.getChangePrice());          
                System.out.println("== ******************************************************* ==");
            }*/
            System.out.println("Stockquote: " +  stockinformation[0].getAbout());
            System.out.println("ID:    " +  stockinformation[0].getIdentifier());
            System.out.println("Title: " +  stockinformation[0].getTitle());
            System.out.println("Change Preis: " +  stockinformation[0].getChangePrice());  
            
            if (stockinformation.length > 0) {
            	StockQuote stockquote = stockinformation[0];

             

                stockquote.setChangePrice(changepreis);
//
//                ClientResponse response = retriever.updateSystemDefinition(stockquote);
//                System.out.println("Update Response for " + stockquote.getAbout());
//                System.out.print("STATUS: " + response.getStatusCode());
//                System.out.println(" - " + response.getMessage());
//                System.out.println("== ******************************************************* ==");
            }
            
            

        } catch (ConsumerException e1) {
            e1.printStackTrace();
        }
    }
 
    }
