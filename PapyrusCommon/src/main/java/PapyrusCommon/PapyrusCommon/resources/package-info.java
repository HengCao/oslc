 
 
@OslcSchema({
        @OslcNamespaceDefinition(prefix = OslcConstants.DCTERMS_NAMESPACE_PREFIX, namespaceURI = OslcConstants.DCTERMS_NAMESPACE),
        @OslcNamespaceDefinition(prefix = OslcConstants.OSLC_CORE_NAMESPACE_PREFIX, namespaceURI = OslcConstants.OSLC_CORE_NAMESPACE),
        @OslcNamespaceDefinition(prefix = OslcConstants.OSLC_DATA_NAMESPACE_PREFIX, namespaceURI = OslcConstants.OSLC_DATA_NAMESPACE),
    //    @OslcNamespaceDefinition(prefix = org.eclipse.lyo.oslc4j.changemanagement.Constants.CHANGE_MANAGEMENT_NAMESPACE_PREFIX, namespaceURI = org.eclipse.lyo.oslc4j.changemanagement.Constants.CHANGE_MANAGEMENT_NAMESPACE),
        @OslcNamespaceDefinition(prefix = OslcConstants.RDF_NAMESPACE_PREFIX, namespaceURI = OslcConstants.RDF_NAMESPACE),
        @OslcNamespaceDefinition(prefix = OslcConstants.RDFS_NAMESPACE_PREFIX, namespaceURI = OslcConstants.RDFS_NAMESPACE),
        @OslcNamespaceDefinition(prefix = PConstants.PAPYRUS_NAMESPACE_PREFIX, namespaceURI = PConstants.PAPYRUS_NAMESPACE),
        @OslcNamespaceDefinition(prefix = PConstants.CHANGE_MANAGEMENT_PREFIX, namespaceURI = PConstants.CHANGE_MANAGEMENT_NAMESPACE),
        @OslcNamespaceDefinition(prefix = PConstants.VIF_QM_NAMESPACE_PREFIX, namespaceURI = PConstants.VIF_QM_NAMESPACE),
        @OslcNamespaceDefinition(prefix = PConstants.VIF_AM_NAMESPACE_PREFIX, namespaceURI = PConstants.VIF_AM_NAMESPACE),
        @OslcNamespaceDefinition(prefix = PConstants.QUALITY_MANAGEMENT_PREFIX, namespaceURI = PConstants.QUALITY_MANAGEMENT_NAMESPACE) })
 
package PapyrusCommon.PapyrusCommon.resources;
import org.eclipse.lyo.oslc4j.changemanagement.ChangeRequest; 
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespaceDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcSchema;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import PapyrusCommon.PapyrusCommon.PConstants;
 
