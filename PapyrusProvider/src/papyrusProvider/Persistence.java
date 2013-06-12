package papyrusProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.TreeMap;

import javax.xml.datatype.DatatypeConfigurationException;

import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.provider.jena.JenaModelHelper;

import papyrusProvider.resourceaccess.ResourceAccess;
import papyrusProvider.servlet.Populate;
import PapyrusCommon.PapyrusCommon.resources.Resource;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.util.FileUtils;

public class Persistence {
	private  static TreeMap<String, Resource> RESOURCE_MAP = new TreeMap<String, Resource>();
	private  static ResourceAccess retriver = new ResourceAccess();
	private static Populate populate;
	private static String basePath;
	private static URI serviceProviderURI;
	private Persistence() {
		super();
	}

	public static boolean load(final String uriString, URI providerURI)
			throws DatatypeConfigurationException, FileNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InstantiationException, InvocationTargetException,
			OslcCoreApplicationException, URISyntaxException,
			SecurityException, NoSuchMethodException {
		 String fileName = createFileName(uriString);
		basePath = uriString;
		serviceProviderURI = providerURI;
		populate = new Populate(basePath, serviceProviderURI);
		 File file = new File(fileName);

		if ((file.exists()) && (file.isFile()) && (file.canRead())) {
			final Model model = ModelFactory.createDefaultModel();

			model.read(new FileInputStream(file), null, FileUtils.langXMLAbbrev);

			final Object[] resources = JenaModelHelper.fromJenaModel(model,
					Resource.class);

			synchronized (RESOURCE_MAP) {
				RESOURCE_MAP.clear();

				if (resources != null) {
			 

						for (final Object resource : resources) {
							if (resource instanceof Resource) {
								 Resource res = (Resource) resource;

								 String identifier = res.getIdentifier();

								RESOURCE_MAP.put(identifier, res);
							}
						}
					//}
				}
			}

			return true;
		}
//		else  
//		{
//			synchronized (RESOURCE_MAP) {
//			final Example retrive = new Example();
//			final Resource resource = retrive.getResource();
//			 
//			RESOURCE_MAP.put(papyrursResource.getIdentifier(), resource);
//			}
//			return true;
//		}

		return false;
	}
	
	public static void retrive (final String uriString){
		synchronized (RESOURCE_MAP) {
		 Resource resource = retriver.getResource();
	 
 
		 
		RESOURCE_MAP.clear();
		RESOURCE_MAP.put(resource.getIdentifier(), resource);
		
		populate.fixup();
		}
	}

	public static void save(final String uriString) throws URISyntaxException,
			OslcCoreApplicationException, IllegalArgumentException,
			DatatypeConfigurationException, IllegalAccessException,
			InvocationTargetException, FileNotFoundException {
		 String fileName = createFileName(uriString);

		 Resource[] resource = getResources();

		 Model model = JenaModelHelper.createJenaModel(resource);

		if (model != null) {
			final RDFWriter writer = model.getWriter(FileUtils.langXMLAbbrev);

			writer.setProperty("showXmlDeclaration", "true");

			writer.write(model, new FileOutputStream(fileName), null);
		}
	}

	private static String createFileName(final String uriString)
			throws URISyntaxException {
		final URI uri = new URI(uriString);

		final String host = uri.getHost();
		final int port = uri.getPort();
		final String path = uri.getPath();

		final String tmpDir = System.getProperty("java.io.tmpdir");

		final String fileName = tmpDir + "/" + host + "_" + port
				+ path.replace('/', '_').replace('\\', '_') + ".xml";

		return fileName;
	}

	public static Resource[] getResources() {
		synchronized (RESOURCE_MAP) {
			return RESOURCE_MAP.values().toArray(
					new Resource[RESOURCE_MAP.size()]);
		}
	}

	public static Resource getResource(final String identifier) {
		synchronized (RESOURCE_MAP) {
			return RESOURCE_MAP.get(identifier);

		}
	}

	public static void addResource(final Resource resource) {
		synchronized (RESOURCE_MAP) {
			System.out.println("Size1"+RESOURCE_MAP.size()+"id"+RESOURCE_MAP.firstKey());
			RESOURCE_MAP.put(resource.getIdentifier(), resource);
			System.out.println("Size2"+RESOURCE_MAP.size()+"id"+resource.getIdentifier());
		}
	}

	public static Resource deleteResource(final String identifier) {
		synchronized (RESOURCE_MAP) {
			return RESOURCE_MAP.remove(identifier);
		}
	}
}
