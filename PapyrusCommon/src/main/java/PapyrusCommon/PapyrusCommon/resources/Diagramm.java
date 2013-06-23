package PapyrusCommon.PapyrusCommon.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import PapyrusCommon.PapyrusCommon.PConstants;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
 
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

@OslcNamespace(PConstants.PAPYRUS_NAMESPACE)
@OslcResourceShape(title = "FOAF Diagramm Resource Shape", describes = PConstants.TYPE_DIAGRAMM)
public class Diagramm extends AbstractResource {

	private URI uri = null;
	private String name;
	private List<Attribut> attributs = new ArrayList<Attribut>();
	
	private String type;

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	@OslcDescription("A Diagramm name ")
	@OslcPropertyDefinition(PConstants.PAPYRUS_NAMESPACE + "name")
	 
	@OslcTitle("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OslcDescription("Attributs of Diagram ")
    @OslcName("attributs")
    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "attributs")
    @OslcRepresentation(Representation.Inline)     
    @OslcValueType(ValueType.LocalResource)
    @OslcRange(PConstants.TYPE_ATTRIBUT)
    @OslcTitle("attributs")
	public List<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(List<Attribut> attributs) {
		this.attributs = attributs;
	}

	public void addAttribut(Attribut attribut) {
		this.attributs.add(attribut);
	}
	@OslcDescription("Type")
	@OslcName("type")
	@OslcPropertyDefinition(PConstants.PAPYRUS_NAMESPACE + "type")
	 
	@OslcTitle("Type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
