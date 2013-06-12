 
package papyrusProvider.servlet;

import java.net.URI;
import java.net.URISyntaxException;
import org.eclipse.uml2.uml.internal.impl.ElementImpl;

import papyrusProvider.Persistence;
 
import PapyrusCommon.PapyrusCommon.resources.Resource;

public final class Populate
{
    private final String basePath;
    private final URI    serviceProviderURI;

    public Populate(final String  basePath,
                    final URI     serviceProviderURI)
    {
        super();

        this.basePath           = basePath;
        this.serviceProviderURI = serviceProviderURI;
    }

    public void fixup()
    {
        final Resource[] resource = Persistence.getResources();

        for (final Resource re : resource)
        	
        {
        	try {
				persistPapyrusResource(re);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            re.setServiceProvider(serviceProviderURI);
        }
    }

    public void populate()
           throws URISyntaxException
    {
    	persistPapyrusResource(createPapyrusResource("1","Static"));
 
    }

    private static Resource createPapyrusResource(final String description,
                                               final String   symbol)
    {
        final Resource resource = new Resource();

        resource.setIdentifier(symbol) ;
        resource.setDescription(description);

        return resource;
    }

    private void persistPapyrusResource(final Resource resource)
            throws URISyntaxException
    {
        final String identifier = resource.getIdentifier();

        final URI about = new URI(basePath + "/papyrusresources/" + identifier);

        resource.setAbout(about);
        resource.setIdentifier(identifier);
        resource.setServiceProvider(serviceProviderURI);

        Persistence.addResource(resource);
    }
}
