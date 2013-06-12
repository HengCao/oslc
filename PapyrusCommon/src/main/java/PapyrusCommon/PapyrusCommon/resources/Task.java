package PapyrusCommon.PapyrusCommon.resources;

import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import java.net.URI;
import java.util.Set;
import PapyrusCommon.PapyrusCommon.Constants;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

@OslcNamespace(Constants.PAPYRUS_NAMESPACE)
@OslcResourceShape(title = "FOAF Diagramm Resource Shape", describes = Constants.TYPE_DIAGRAMM)
public class Task extends AbstractResource {
	/**
	 * Bezeichnung des Tasks
	 */

	private String name;

	/**
	 * URI des Tasks
	 */

	private URI uri = null;
	@OslcDescription("A Task name ")
	@OslcPropertyDefinition(Constants.PAPYRUS_NAMESPACE + "name")
 
	@OslcTitle("Task ")
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
