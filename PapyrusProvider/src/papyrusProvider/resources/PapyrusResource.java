
package papyrusProvider.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.wink.json4j.JSONException;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

import PapyrusCommon.PapyrusCommon.Constants;
import PapyrusCommon.PapyrusCommon.resources.Resource;
import papyrusProvider.Persistence;
import papyrusProvider.Utilities;
import papyrusProvider.resourceaccess.ResourceAccess;
import papyrusProvider.servlet.ServiceProviderSingleton;

@OslcService(Constants.CHANGE_MANAGEMENT_DOMAIN)
@Path("papyrusresources")
public class PapyrusResource
{
    private static final Logger logger = Logger.getLogger(PapyrusResource.class.getName());

    public PapyrusResource()
    {
        super();
    }

    @OslcDialog
    (
         title = "Resources Selection Dialog",
         label = "Resources Selection Dialog",
         uri = "",
         hintWidth = "1000px",
         hintHeight = "600px",
          resourceTypes = {Constants.TYPE_RESOURCE},
         usages = {OslcConstants.OSLC_USAGE_DEFAULT}
    )
    @OslcQueryCapability
    (
        title = "Resources Query Capability",
        label = "Resources Catalog Query",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Constants.PATH_RESOURCE,
        resourceTypes = {Constants.TYPE_RESOURCE},
        usages = {OslcConstants.OSLC_USAGE_DEFAULT}
    )
    @GET
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.TEXT_XML, OslcMediaType.APPLICATION_JSON})
    public Resource[] getResources()
           throws JSONException
    {
        final Resource[] resources = Persistence.getResources();
        
       // retrievePapyrusInformation(resources);

        for (final Resource re : resources)
        {
        	re.setServiceProvider(ServiceProviderSingleton.getServiceProviderURI());
        }

        return resources;
    }

    @GET
    @Path("{resourceId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.TEXT_XML, OslcMediaType.APPLICATION_JSON})
    public Resource getResource(@PathParam("resourceId") final String resourceId)
           throws JSONException
    {
        final Resource resource = Persistence.getResource(resourceId);

        if (resource != null)
        {
          //  retrievePapyrusInformation(resource);

            resource.setServiceProvider(ServiceProviderSingleton.getServiceProviderURI());

            return resource;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }



    @OslcCreationFactory
    (
         title = "Papyrus Resource Creation Factory",
         label = "Papyrus Resource Creation",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Constants.PATH_RESOURCE},
         resourceTypes = {Constants.TYPE_RESOURCE},
         usages = {OslcConstants.OSLC_USAGE_DEFAULT}
    )
    @POST
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.TEXT_XML, OslcMediaType.APPLICATION_JSON})
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.TEXT_XML, OslcMediaType.APPLICATION_JSON})
    public Response addResource(@Context final HttpServletRequest httpServletRequest,
                                           final Resource         resource)
           throws URISyntaxException
    {
        final String identifier =  resource.getIdentifier();

        final URI about = new URI(httpServletRequest.getScheme(),
                                  null,
                                  httpServletRequest.getServerName(),
                                  httpServletRequest.getServerPort(),
                                  httpServletRequest.getContextPath() + "/papyrusresource/" + identifier,
                                  null,
                                  null);

        System.out.println("SSSSSSSSSSSSSSSSS");
        resource.setAbout(about);
        resource.setIdentifier(identifier);
        resource.setServiceProvider(ServiceProviderSingleton.getServiceProviderURI());

        Persistence.addResource(resource);

        return Response.created(about).entity(resource).build();
    }

    @DELETE
    @Path("{resourceId}")
    public Response deletePapyrusResource(@PathParam("resourceId") final String resourceId)
    {
        final Resource resource = Persistence.deleteResource(resourceId);

        if (resource != null)
        {
            return Response.noContent().build();
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    
    
    @PUT
    @Consumes({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Path("{resourceId}")
    public Response updateResource(@PathParam("resourceId") final String resourceId, final Resource resource) {
        final Resource originalResource = Persistence.getResource(resourceId);

        

        if (originalResource == null) {
            throw new WebApplicationException(Status.NOT_FOUND);
        } else {
        	 
        	originalResource.setTasks(resource.getTasks());
        	originalResource.setModells(resource.getModells());

            return Response.ok().build();
        }
    }

    private static void retrievePapyrusInformation(final Resource ... resources)
            throws JSONException
    {
         

        final Map<String, Resource> map = new HashMap<String, Resource>();

     
         

        boolean first = true;
        for (final Resource resource : resources)
        {
            final String requestedExchange = resource.getTitle();
            final String requestedSymbol   = resource.getIdentifier();

            final String googleKey = requestedExchange + ":" + requestedSymbol;

//            if (first)
//            {
//                first = false;
//            }
//            else
//            {
//                uri += ",";
//            }
//
//            uri += googleKey;
          
            map.put(resource.getIdentifier(),
                    resource);
        }

       

      //  final Resource resource =Example.retrievePapyrusData(null);

       // final ClientResponse clientResponse = resource.accept(MediaType.APPLICATION_JSON).get();

         
    }

    private static String toString(final Object object)
    {
        if (object != null)
        {
            return object.toString();
        }

        return null;
    }

    private static Float toFloat(final Object object)
    {
        if (object != null)
        {
            try
            {
                return Float.valueOf(object.toString());
            }
            catch (final NumberFormatException exception)
            {
                logger.warning("Unable to parse '" + object + "' as float");
            }
        }

        return null;

    }

    private static Date toDate(final DateFormat dateFormat,
                               final Object     object)
    {
        if (object != null)
        {
            try
            {
                return dateFormat.parse(object.toString());
            }
            catch (final ParseException exception)
            {
                logger.warning("Unable to parse '" + object + "' as date");
            }
        }

        return null;
    }
}
