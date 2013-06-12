package PapyrusCommon.PapyrusCommon.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;
import PapyrusCommon.PapyrusCommon.Constants;

@OslcNamespace(Constants.CHANGE_MANAGEMENT_NAMESPACE)
@OslcResourceShape(title = "Change Management Resource Resource Shape", describes = Constants.TYPE_RESOURCE)
public class Resource extends AbstractResource {
	
//	  /**
////     * Local variable of type {@link java.util.Set Set} storing RDF type URIs of this OSLC-CM Resource.
////     */
////    private final Set<URI> rdfTypes = new TreeSet<URI>();
////    
////    /**
////     * Local variable of type {@link java.util.Set Set} storing a short string representations 
////     * of types, example  Resource.
////     */
////    private final Set<String> dctermsTypes = new TreeSet<String>();
////    /**
//     * Modells in the Resources, 
//     */
    
    private  List<Modell> modells = new ArrayList <Modell>();
    /**
     *   related task , which created by gPM  
     */
    private   List<URI> tasks = new ArrayList<URI>() ;
    
    
    private   List<URI> validatedBy = new ArrayList<URI>() ;
    
    
    /**
     * Local variable of type {@link java.util.Set Set} storing {@link URI URIs}
     * to other OSLC resources that validate this OSLC-CM Resource.
     */
//    private final Set<URI> validatedBy = new HashSet<URI>();
//
//    /**
//     * Local variable storing the timestamp of the OSLC-AM Resource creation.
//     */
//    private Date created;
//    
    /**
     * Local variable storing a String representation of a unique identifier for a OSLC-CM Resource. 
     * Assigned by the service provider when a resource is created.
     */
    private String identifier;
    
    /**
     * Local variable storing the URI of the OSLC-CM Resource resource shape.
     * The Resource Shape provides hints as to resource property value-types and allowed values.
     */
//    private URI instanceShape;
//    
//    /**
//     * Local variable storing a timestamp of the latest resource modification. 
//     */
//    private Date modified;
//    
//    /**
//     * Local variable storing the URI of the resource's OSLC Service Provider.
//     */
    private URI serviceProvider;
//    
    /**
     * Local variable of type {@link org.eclipse.lyo.oslc4j.core.model.Link Link} storing the resource URI a 
     * client can perform a get on to obtain the original non-OSLC CM formatted resource 
     * that was used to create this OSLC-AM Resource. The source resource is usually a binary or proprietary format 
     * that the service provider can consume and convert into an OSLC CM format. The service may use content 
     * negotiation with the Accept header to obtain the desired content type.
     */
//    private URI source;
//        
//    /**
//     * Local variable of type {@link org.eclipse.lyo.oslc4j.core.model.Link Link} storing the URI a client can 
//     * perform a get on to obtain the file containing the original System Definition this OSLC-CM Resource was build on.
//     */
//    private URI systemDefinitionFile;
//    
//    /**
//     * Descriptive text (reference: Dublin Core) about resource represented as rich text in XHTML content.
//     * SHOULD include only content that is valid and suitable inside an XHTML 'div' element.
//     */
    private String description;
        
    /**
     * Short name identifying a resource, often used as an abbreviated identifier for presentation to end-users.
     */
    private String title;
    
    /**
     * Constructs an OSLC-AM Resource.    
     */
    public Resource() {
        super();

//        try {
//            rdfTypes.add(new URI(Constants.TYPE_RESOURCE));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
    }
    
    
    /**
     * Constructs an OSLC-CM Resource with the given URI as rdf:about. 
     * 
     * @param about URI that should be uses as rdf:about.
     */
    public Resource(final URI about) {
        super(about);

//        try {
//            rdfTypes.add(new URI(Constants.TYPE_RESOURCE));
//        } catch (URISyntaxException e) {                        
//            e.printStackTrace();
//        }
    }
    
    
    public void addRdfType(final URI rdfType) {
     //   this.rdfTypes.add(rdfType);
    }
    
//    @OslcDescription("The resource type URIs.")
//    @OslcName("type")
//    @OslcPropertyDefinition(OslcConstants.RDF_NAMESPACE + "type")
//    @OslcTitle("Types")
//    public URI[] getRdfTypes() {
//        return rdfTypes.toArray(new URI[rdfTypes.size()]);
//    }
    /**
     * Replaces the internal array of RDF type URIs with the given array of URIs.
     * When an empty array is passed also the internal array will be empty.
     * 
     * @param rdfTypes Array of URIs of RDF types.
     */
//    public void setRdfTypes(final URI[] rdfTypes) {
//        this.rdfTypes.clear();
//
//        if (rdfTypes != null) {
//            this.rdfTypes.addAll(Arrays.asList(rdfTypes));
//        }
//    }
//    
//    public void addDctermsTypes(final String dctermsType) {
//        this.dctermsTypes.add(dctermsType);
//    }
    
//    @OslcDescription("A short string representation for the type, example 'Defect'.")
//    @OslcName("type")
//    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "type")
//    @OslcTitle("Types")
//    public String[] getDctermsTypes() {
//        return dctermsTypes.toArray(new String[dctermsTypes.size()]);
//    }
//    
//    public void setDctermsTypes(final String[] dctermsTypes) {
//        this.dctermsTypes.clear();
//
//        if (dctermsTypes != null) {
//            this.dctermsTypes.addAll(Arrays.asList(dctermsTypes));
//        }
//    }
//    
    public void addTasks ( URI task){
    	this.tasks.add(task);
    }
    
    @OslcDescription("Related Task created by gPM.")
    @OslcName("tasks")
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "tasks")
    @OslcRepresentation(Representation.Reference)
 //   @OslcValueType(ValueType.LocalResource)
 //   @OslcRange(Constants.TYPE_TASK)
    @OslcReadOnly(false)
    @OslcTitle("Tasks")    
    public  List<URI> getTasks (){
    	return this.tasks;
    }
    
    public void setTasks(final List<URI> tasks){
    	this.tasks.clear();
    	
    	if(tasks!=null){
    		this.tasks.addAll(tasks);
    	}
    }
    
    public void addModell(final Modell modell){
    	if(this.modells!=null)
    	this.modells.add(modell);
    }
    public void setModells(final List<Modell>modells){
    	this.modells.clear();
    	if(modells!=null){
    		this.modells.addAll(modells);
    	}
    }
    
    @OslcDescription("Modells from Papyrus ")
    @OslcName("modell")
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "modell")
    @OslcRepresentation(Representation.Inline)     
    @OslcValueType(ValueType.LocalResource)
    @OslcRange(Constants.TYPE_ATTRIBUT)
    @OslcTitle("Modells")
    public List<Modell> getModells (){
    	
    	return this.modells;
    	
    }
    
    
//    public void addValidatedBy(final URI validatedByLink) {
//        this.validatedBy.add(validatedByLink);
//    }

    /**
     * Returns an array of URIs pointing to OSLC resources that validate this OSLC-AM Resource.
     * 
     * @return Array of URIs pointing to OSLC resources that validate this OSLC-AM Resource.
     */
//    @OslcDescription("Test Cases that validate the System Definition.")
//    @OslcName("validatedBy")
//    @OslcPropertyDefinition(Constants.VIF_AM_NAMESPACE + "validatedBy")
//    @OslcRange(Constants.TYPE_TEST_CASE)
//    @OslcReadOnly(false)
//    @OslcTitle("Validated by this Test Case")
// 
//    @OslcMemberProperty(true)    
//    public URI[] getValidatedBy() {
//        return validatedBy.toArray(new URI[validatedBy.size()]);
//    }
//
//    /**
//     * Replaces the internal array of Links to OSLC resources that validate this OSLC-AM Resource.
//     * When an empty array is passed also the internal array will be empty.
//     * 
//     * @param validatedBy Array of Links to OSLC resources that validate this OSLC-AM Resource.
//     */
//    public void setValidatedBy(final URI[] validatedBy) {
//        this.validatedBy.clear();
//
//        if (validatedBy != null) {
//            this.validatedBy.addAll(Arrays.asList(validatedBy));
//        }
//    }

//    /**
//     * Returns the timestamp of creation of this OSLC-AM Resource.
//     * 
//     * @return Timestamp of creation.
//     */
//    @OslcDescription("Timestamp of resource creation.")
//    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "created")
//    @OslcReadOnly
//    @OslcTitle("Created")
//    public Date getCreated() {
//        return created;
//    }
//
//    /**
//     * Sets the creation timestamp for this OSLC-AM Resource.
//     * 
//     * @param created Timestamp of creation of this OSCL-AM Resource.
//     */
//    public void setCreated(final Date created) {
//        this.created = created;
//    }

    /**
     * Returns the unique (in the context of a provider) identifier of the OSLC-AM Resource. 
     * 
     * @return String representation of the unique identifier.
     */
    @OslcDescription("A unique identifier for a resource. Assigned by the service provider when a resource" 
                   + " is created. Not intended for end-user display.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "identifier")
 
    @OslcTitle("Identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the unique (in the context of a provider) identifier of the OSLC-AM Resource.
     * 
     * @param identifier String representation of the unique identifier.
     */
    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    /**
     * Returns the URI of a OSLC-AM Resource instance resource shape.
     * The resource shape provides hints as to resource property value-types and allowed values.
     * 
     * @return URI of a OSLC-AM Resource instance resource shape.
     */
//    @OslcDescription("Resource Shape that provides hints as to resource property value-types and allowed values. ")
//    @OslcPropertyDefinition(OslcConstants.OSLC_CORE_NAMESPACE + "instanceShape")
//    @OslcRange(OslcConstants.TYPE_RESOURCE_SHAPE)
//    @OslcTitle("Instance Shape")
//    public URI getInstanceShape() {
//        return instanceShape;
//    }

    /**
     * Sets the URI of a OSLC-AM Resource instance resource shape to the given URI.
     * 
     * @param instanceShape URI of a OSLC-AM Resource instance resource shape.
     */
//    public void setInstanceShape(final URI instanceShape) {
//        this.instanceShape = instanceShape;
//    }

    /**
     * Returns the timestamp of the latest resource modification.
     * 
     * @return Timestamp of the latest resource modification.
//     */
//    @OslcDescription("Timestamp of latest resource modification.")
//    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "modified")
//    @OslcReadOnly
//    @OslcTitle("Modified")
//    public Date getModified() {
//        return modified;
//    }

    /**
     * Sets the latest resource modification timestamp to the given Date.
     * 
     * @param modified Date representation of the latest resource modification timestamp.
     */
//    public void setModified(final Date modified) {
//        this.modified = modified;
//    }

    /**
     * Returns the URI of the resource's OSLC Service Provider.
     * 
     * @return URI of the resource's OSLC Service Provider.
     */
    @OslcDescription("The scope of a resource is a URI for the resource's OSLC Service Provider.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcPropertyDefinition(OslcConstants.OSLC_CORE_NAMESPACE + "serviceProvider")
    @OslcRange(OslcConstants.TYPE_SERVICE_PROVIDER)
    @OslcReadOnly
    @OslcTitle("Service Provider")
    public URI getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Set URI of the resource's OSLC Service Provider to the given URI.
     * 
     * @param serviceProvider URI of the resource's OSLC Service Provider.
     */
    public void setServiceProvider(final URI serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    /**
     * Returns descriptive text (reference: Dublin Core) about resource represented as rich text in XHTML content.
     * 
     * @return String representation of descriptive text (reference: Dublin Core) about resource 
     * represented as rich text in XHTML content.
     */
    @OslcDescription("Descriptive text (reference: Dublin Core) about resource represented as rich text in XHTML"
    		+ " content. SHOULD include only content that is valid and suitable inside an XHTML <div> element.")
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "description")
    @OslcTitle("Description")
    @OslcValueType(ValueType.XMLLiteral)
    public String getDescription() {
        return description;
    }

    /**
     * Sets descriptive text (reference: Dublin Core) about this OSLC-AM Resource to the given String. 
     * SHOULD include only content that is valid and suitable inside an XHTML <code>&lt;div&gt;</code> element.
     * 
     * @param description String representation of descriptive text about resource represented as rich text in XHTML 
     * content.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Returns the link to the related system definition model file (location on a web server).
     * 
     * @return Link to related system definition model file (location on a web server).
     */
//    @OslcDescription("Related model file (location on a web server).")
//    @OslcOccurs(Occurs.ZeroOrOne)
//    @OslcName("systemDefinitionFile")
//    @OslcPropertyDefinition(Constants.VIF_AM_NAMESPACE + "systemDefinitionFile")
//    @OslcReadOnly(false)
//    @OslcTitle("Related model file")
//    public URI getSystemDefinitionFile() {
//        return systemDefinitionFile;
//    }

//    /**
//     * Sets the related system definition model file link (location on a web server) to the given link.
//     * 
//     * @param systemDefinitionFile Link to related system definition model file (location on a web server).
//     */
//    public void setSystemDefinitionFile(final URI systemDefinitionFile) {
//        this.systemDefinitionFile = systemDefinitionFile;
//    }

    /**
     * Returns title (reference: Dublin Core) or often a single line summary of the resource represented as rich text in
     * XHTML content.
     * 
     * @return String representation of the title (reference: Dublin Core) or often a single line summary of the 
     * resource represented as rich text in XHTML content.
     */
    @OslcDescription("Title (reference: Dublin Core) or often a single line summary of the resource represented as "
            + "rich text in XHTML content.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "title")
    @OslcTitle("Title")
    @OslcValueType(ValueType.XMLLiteral)
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the OSLC-AM Resource to the given string.
     * 
     * @param title String representation of the title (reference: Dublin Core) or often a single line summary of the 
     * resource represented as rich text in XHTML content.
     */
    public void setTitle(final String title) {
        this.title = title;
    }
    
    
    @OslcDescription("Related Task created by gPM.")
    @OslcName("validateby")
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "validateby")
    @OslcRepresentation(Representation.Reference)
 
    @OslcReadOnly(false)
    @OslcTitle("ValidateBy") 

	public List<URI> getValidatedBy() {
		return validatedBy;
	}


	public void setValidatedBy(List<URI> validatedBy) {
		this.validatedBy = validatedBy;
	}

    /**
     * Returns a link to the original non-OSLC AM formatted resource that was used to create this resource.
     * 
     * @return Link representation of URI of the original non-OSLC AM formatted resource that was used to create this 
     * resource.
     */
//    @OslcDescription("The resource URI a client can perform a get on to obtain the original non-OSLC AM formatted "
//    		+ "resource that was used to create this resource.")
//    @OslcName("source")
//    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "source")
//    @OslcTitle("URI of original non-OSLC AM formatted resource.")
//    public URI getSource() {
//        return source;
//    }
//
//    /**
//     * Sets the link to the original non-OSLC AM formatted resource that was used to create this resource to the given 
//     * link.
//     * 
//     * @param source Link representation of URI of the original non-OSLC AM formatted resource that was used to create 
//     * this resource.
//     */
//    public void setSource(final URI source) {
//        this.source = source;        
//    }

//    /**
//     * Checks whether a validatedBy URI pointing to the passed TestCase is already existing or not.
//     * 
//     * @param testCaseLink URI of the TestCase (rdf:about) that should be checked whether it's already added as
//     * validatedBy link or not.
//     * @return <b>True</b> - TestCase is already linked to this SystemDefinition as 'validatedBy TestCase'.<br>
//     * <b>False</b> - TestCase is NOT linked to this SystemDefinition as 'validatedBy TestCase'.
//     */
//    public boolean containsValidatedBy(final URI testCaseLink) {
//        boolean returnVal = false;
//        
//        for (URI validatedByLink : validatedBy) {
//            if (validatedByLink.equals(testCaseLink)) {
//                returnVal = true;            
//            }
//        }
//        
//        return returnVal;
//    }
	

}
