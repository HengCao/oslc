/**
 * Copyright (c) 2012 Virtual Vehicle (ViF). www.v2c2.at
 * 
 * Created at: 04.07.2012
 * 
 * Authors:
 * 
 * @author stefanpaschke
 * 
 */
package olsc.consumer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.wink.client.ClientResponse;
import org.eclipse.lyo.oslc4j.client.OslcRestClient;
import org.eclipse.lyo.oslc4j.client.ServiceProviderRegistryClient;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.QueryCapability;
import org.eclipse.lyo.oslc4j.core.model.Service;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.provider.jena.JenaProvidersRegistry;
import org.eclipse.lyo.oslc4j.provider.json4j.Json4JProvidersRegistry;

import PapyrusCommon.PapyrusCommon.Constants;
import PapyrusCommon.PapyrusCommon.resources.Resource;

 

/**
 * A class wrapping the REST communication for retrieval and update of OSLC AM Resources.
 * 
 * @author stefanpaschke
 * 
 */
public class Retriever {
    /**
     * The set of general provider classes for various return formats.
     */
    private final Set<Class<?>> providers = new HashSet<Class<?>>();

    /**
     * Media type (RDF+XML, JSON, ...) the consumer uses for the communication between this consumer and the provider.
     */
    private static final String MEDIA_TYPE = OslcMediaType.APPLICATION_RDF_XML;

    /**
     * String representation of the URI of the service providing Rhapsody System Definitions.
     */
    private final String queryBase;

    /**
     * Initial timeout in ms for the communication of Retriever with the respective Service Provider.
     */
    private final int initialTimeout = 1500;
    
    /**
     * Timeout in ms for the communication of Retriever with the respective Service Provider.
     */
    private int timeout = initialTimeout;

    /**
     * Constructor for the class it will be bound to the given OSLC Catalog to search for service provider containing 
     * OSLC-AM Resource Services.
     * 
     * 
     */
    
     
    public Retriever(final String registryUri) throws ConsumerException {
        super();

        providers.addAll(JenaProvidersRegistry.getProviders());
        providers.addAll(Json4JProvidersRegistry.getProviders());

        queryBase = getQueryBase(registryUri);

    }

    /**
     * Retrieves all OSLC-AM Resources found in the catalog the Retriever class is bound to in the constructor.
     * 
     * @return An Array of all found OSLC-AM Resources
     * @throws ConsumerException When no OSLC-AM Resources can be found in catalog the Retriever is bound to in the
     * constructor.
     */
    public final Resource[] getSystemDefinitions() throws ConsumerException {
        try {
            final OslcRestClient oslcRestClient = new OslcRestClient(providers, queryBase, MEDIA_TYPE, timeout);

            final Resource[] rhapsodySystemDefinitions = oslcRestClient.getOslcResources(Resource[].class);

            return rhapsodySystemDefinitions;
        } catch (Exception e) {
            throw new ConsumerException(
                    "Unable to retrieve Rhapsody System Definitions from given registryUri and uiUri.", e);
        }
    }

    /**
     * Updates the given OSLC-AM resource in the service provider it was previously retrieved from.
     * 
     * @param updatedResource OSLC-AM resource that will be updated. It was previously retrieved and then it's values
     * where altered.
     * @return A Client Response with HTTP-Status information and so forth.
     */
    public final ClientResponse updateSystemDefinition(final Resource updatedResource) {
        String resourceBase = queryBase + "/" + updatedResource.getIdentifier();
        System.out.println(resourceBase+updatedResource.getTasks().toString());

        final OslcRestClient oslcRestClient = new OslcRestClient(providers, resourceBase, MEDIA_TYPE, timeout);

        final ClientResponse clientResponse = oslcRestClient
                .updateOslcResourceReturnClientResponse(updatedResource);

        return clientResponse;
    }
    public final ClientResponse addResource(final Resource newResource){
    	 String resourceBase = queryBase + "/" ;
    	  final OslcRestClient oslcRestClient = new OslcRestClient(providers, resourceBase, MEDIA_TYPE, timeout);
    	  
    	  final ClientResponse clientResponse = oslcRestClient
                  .addOslcResourceReturnClientResponse (newResource);
    	  
    	  return clientResponse;
    	 
    }

    public final ClientResponse deleteResource(final Resource  deleteesource){
   	 String resourceBase = queryBase + "/"+deleteesource.getIdentifier() ;
   	  final OslcRestClient oslcRestClient = new OslcRestClient(providers, resourceBase, MEDIA_TYPE, timeout);
   	  
   	  final ClientResponse clientResponse = oslcRestClient.removeOslcResourceReturnClientResponse() ;
   	  
   	  return clientResponse;
   	 
   }
//    /**
//     * Retrieves the file the OSLC-AM Resource was build on and stores it to the given directory.
//     * 
//     * @param rhapsodySystemDefinition OSLC-AM Resource for which the file should be retrieved.
//     * @param dir Directory the file will be stored to (Note WITHOUT trailing '\'). It will be created if it doesn't
//     * already exist. Any existing file will be overwritten.
//     * @throws ConsumerException Throws an exception when [1] the URL stored in the OSLC-AM Resource is not valid or [2]
//     * the file can't be written to the provided directory (check stack trace for further details).
//     */
//    public void retrieveToFile(final Resource rhapsodySystemDefinition, final String dir) throws ConsumerException {
//        try {
//            URL source = rhapsodySystemDefinition.getSystemDefinitionFile().toURL();
//
//            File destination = new File(dir + File.separatorChar + rhapsodySystemDefinition.getTitle());
//
//            FileUtils.copyURLToFile(source, destination, timeout, timeout);
//        } catch (MalformedURLException e) {
//            throw new ConsumerException("RawData URL stored in Rhapsody System Definition is not valid.", e);
//        } catch (IOException e) {
//            throw new ConsumerException("Unabale to write file to provided dir.", e);
//        }
//    }

//    /**
//     * Opens an Input Stream for the URL stored in the given OSLC-AM Resource, pointing to the file the OSLC-AM Resource
//     * was build on.
//     * 
//     * @param rhapsodySystemDefinition OSLC-AM Resource for which an input stream will be opened for the URL returned by
//     * <code>rhapsodySystemDefinition.</code>{@link Resource#getSystemDefinitionFile() getSystemDefinitionFile()}.
//     * @return Returns an Input Stream for the URL stored under <div><code>rhapsodySystemDefinition.</code>
//     * {@link Resource#getSystemDefinitionFile() getSystemDefinitionFile()}</div>.
//     * @throws ConsumerException When [1] the URL stored in the OSLC-AM Resource is not valid or [2]
//     * it's not possible to open a input stream for this URL.
//     */
//    public InputStream getRawDataStream(final Resource rhapsodySystemDefinition) throws ConsumerException {
//        try {
//            URL rawData = rhapsodySystemDefinition.getSystemDefinitionFile().toURL();
//
//            return rawData.openStream();
//        } catch (MalformedURLException e) {
//            throw new ConsumerException("RawData URL stored in Rhapsody System Definition is not valid.", e);
//        } catch (IOException e) {
//            throw new ConsumerException("Unable to open a stream for URL stored in Rhapsody System Definition.",
//                    e);
//        }
//    }

    /**
     * Returns the timeout in ms for all communications of Retriever with the respective Service Provider.
     * 
     * @return Timeout in ms for all communications of Retriever with the respective Service Provider.
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Sets the timeout in ms for the communication of Retriever with the respective Service Provider.
     * 
     * @param timeout Timeout in ms.
     */
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the URI of the first service providing Rhapsody System Definitions found in the given service provider 
     * catalog.
     * 
     * @param registryUri URI of the OSLC4J catalog containing the serviceProvider for OSLC-AM Resource Services. e.g.
     * http://INNB00889.v2c2.at:8080/OSLC4JRegistry/catalog
     * @return String representation of the URI of the first service providing Rhapsody System Definitions found in the 
     * given service provider catalog.
     * @throws ConsumerException When no services were found providing Rhapsody System Definitions under the given 
     * <code>registryUri</code>.
     */
    private String getQueryBase(final String registryUri)
            throws ConsumerException {
        try {             
            String domain = Constants.CHANGE_MANAGEMENT_DOMAIN;
            String type = Constants.TYPE_RESOURCE;
            
            final ServiceProvider[] serviceProviders = new ServiceProviderRegistryClient(providers, MEDIA_TYPE,
                    registryUri).getServiceProviders(); // (PROVIDERS, mediaType).getServiceProviders();

            if (serviceProviders != null) {
                for (final ServiceProvider serviceProvider : serviceProviders) {
                    final Service[] services = serviceProvider.getServices();

                    for (final Service service : services) {
                        if (domain.equals(String.valueOf(service.getDomain()))) {
                            final QueryCapability[] queryCapabilities = service.getQueryCapabilities();

                            for (final QueryCapability queryCapability : queryCapabilities) {
                                final URI[] resourceTypes = queryCapability.getResourceTypes();

                                for (final URI resourceType : resourceTypes) {
                                    if (resourceType.toString().equals(type)) {
                                        return queryCapability.getQueryBase().toString();
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            String msg = "Unable to determine Query Base. No services found providing Rhapsody System Definitions.";

            throw new ConsumerException(msg, e); // ConsumerException(e);
        }

        return null;
    }
}
