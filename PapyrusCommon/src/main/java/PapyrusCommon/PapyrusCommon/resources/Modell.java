package PapyrusCommon.PapyrusCommon.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

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

import PapyrusCommon.PapyrusCommon.Constants;

@OslcNamespace(Constants.PAPYRUS_NAMESPACE)
@OslcResourceShape(title = "FOAF Diagramm Resource Shape", describes = Constants.TYPE_MODELL)
public class Modell extends AbstractResource {

	private List<Diagramm> diagramms = new ArrayList<Diagramm>();

	private Date creationDate;

	private String name;

	private URI uri = null;

	@OslcDescription("Diagramms from Papyrus ")
	@OslcName("diagramm")
	@OslcPropertyDefinition(Constants.PAPYRUS_NAMESPACE + "diagramm")
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.LocalResource)
	@OslcRange(Constants.TYPE_DIAGRAMM)
	@OslcTitle("Diagramms")
	public List<Diagramm> getDiagramms() {
		return diagramms;
	}

	public void setDiagramms(List<Diagramm> diagramms) {
		this.diagramms = diagramms;
	}

	public void addDiagramm(Diagramm diagramm) {
		this.diagramms.add(diagramm);
	}

	@OslcDescription("createion Date")
	@OslcPropertyDefinition(Constants.PAPYRUS_NAMESPACE + "creationDate")
	@OslcReadOnly
	@OslcTitle("Creation Date")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@OslcDescription("Name")
	@OslcName("name")
	@OslcPropertyDefinition(Constants.PAPYRUS_NAMESPACE + "name")
	 
	@OslcTitle("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

}
