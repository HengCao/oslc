package oslc.consumer.main.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import olsc.consumer.ConsumerException;

import olsc.consumer.Retriever;

import org.apache.commons.io.FileUtils;
import org.apache.wink.client.ClientResponse;

import PapyrusCommon.PapyrusCommon.resources.Attribut;
import PapyrusCommon.PapyrusCommon.resources.Diagramm;
import PapyrusCommon.PapyrusCommon.resources.Modell;
import PapyrusCommon.PapyrusCommon.resources.Resource;

public abstract class DummyMain {

	/**
	 * Constant in ms for timeout for communication between consumer and
	 * provider.
	 */
	private static final int TIMEOUT = 2000;

	/**
	 * Maximum of lines that will be printed out on the console in loops (Use a
	 * very high values if you want to see everything).
	 */
	private static final int MAXLINECOUNT = 15;

	/**
	 * Temporary directory data retrieved will be stored at.
	 */
	private static final String TEMP_COMSUMER_OUTPUT_DIR = "E:\\HAW\\rhapsody_integration_example\\dummy";

	private static void updateDiagramm(Resource[] resource, Retriever retriever) {

		if (resource.length > 0) {
			Resource re = resource[0];

			Modell modell = re.getModells().get(0);
			// modell.get
			for (Diagramm dia : modell.getDiagramms()) {

				if (dia.getName().equals("Professional")) {

					Attribut attribut = new Attribut();
					attribut.setName("Bezeichnung");
					attribut.setType("String");
					attribut.addValidatedBy(URI
							.create("http://testcaseprovider/testcase1"));
					dia.addAttribut(attribut);

					System.out.println("Diagramm set");
				}
			}
			re.addTasks(URI.create("http://taskprovider/task1"));

			// stockquote.setChangePrice(changepreis);
			//
			ClientResponse response = retriever.updateSystemDefinition(re);
			// System.out.println("Update Response for " +
			// stockquote.getAbout());
			System.out.print("STATUS: " + response.getStatusCode());
			System.out.println(" - " + response.getMessage());
			// System.out.println("== ******************************************************* ==");
		}

	}

	private static Resource addResource(Retriever retriever){
		Resource newResource  = new Resource();
		UUID id =UUID.randomUUID();
		Modell modell = new Modell();
		Diagramm diagramm = new Diagramm();
		
		diagramm.setName("NewDiagramm");
		modell.setName("newModell"); 
		modell.addDiagramm(diagramm);
		newResource.addModell(modell);
		newResource.setIdentifier(modell.getName()+id);
		
		
		ClientResponse response =retriever.addResource(newResource);
		System.out.print("STATUS: " + response.getStatusCode());
		System.out.println(" - " + response.getMessage());
		return newResource;
	}
	
	/**
	 * Main Method for the command line java application.
	 * 
	 * @param args
	 *            Command line arguments for the Consumer test.
	 */
	public static void main(final String[] args) {
		System.out.println("Dummy!!");
		Float changepreis = new Float(12.5);
		Retriever retriever = null;
		Retriever poster = null;

		// URI of the OSLC4J catalog
		String registryuri = "http://localhost:8080/OSLC4JRegistry/catalog";
		String updateuri = "http://localhost:8080/PapyrusProvider/papyrusresources";

		try {
			// Construct a retriever bound to the given catalog.
			retriever = new Retriever(registryuri);

			// Check timeout.
			System.out.println("Standard Timeout: " + retriever.getTimeout());
			retriever.setTimeout(TIMEOUT);
			System.out
					.println("== ******************************************************* ==");

			Resource[] resource = retriever.getSystemDefinitions();
			System.out.println("Resourcesize++++++++" + resource.length);

			System.out.println("Papyrus: " + resource[0].getAbout());
			System.out.println("ID:    " + resource[0].getIdentifier());
			System.out.println("Title: " + resource[0].getTitle());
			//registryuri = "http://localhost:8080/PapyrusProvider/papyrusresources";
			 
			 
			updateDiagramm(resource, retriever);
			addResource(retriever);
			//retriever.deleteResource(resource[0]);

		} catch (ConsumerException e1) {
			e1.printStackTrace();
		}
	}

}
