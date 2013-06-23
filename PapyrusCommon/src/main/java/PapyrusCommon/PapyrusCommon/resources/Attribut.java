package PapyrusCommon.PapyrusCommon.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import PapyrusCommon.PapyrusCommon.PConstants;

import org.eclipse.lyo.oslc4j.changemanagement.Constants;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

@OslcNamespace(PConstants.PAPYRUS_NAMESPACE)
@OslcResourceShape(title = "FOAF Attributs Resource Shape", describes = PConstants.TYPE_ATTRIBUT)
public class Attribut {

	private String name;
	private String type;
	
    private List<URI> validatedBy = new ArrayList<URI>();
	@OslcDescription("A FOAF name ")
	@OslcPropertyDefinition(PConstants.PAPYRUS_NAMESPACE + "name")
	@OslcTitle("Name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@OslcDescription("Type for Attributt ")
	@OslcPropertyDefinition(PConstants.PAPYRUS_NAMESPACE + "type")
 
	@OslcTitle("Type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OslcDescription("Validation  of Attribut ")
    @OslcName("validatedby")
    @OslcPropertyDefinition(Constants.QUALITY_MANAGEMENT_NAMESPACE + "validatedby")
    @OslcRepresentation(Representation.Reference)   
    
    
    @OslcTitle("ValidatedBy")

	public List<URI> getValidatedBy() {
		return validatedBy;
	}


	public void setValidatedBy(List<URI> valdiatedBy) {
		this.validatedBy = valdiatedBy;
	}
	public void addValidatedBy(URI uri){
		this.validatedBy.add(uri);
	}

}
