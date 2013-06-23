package PapyrusCommon.PapyrusCommon;


// CHECKSTYLE:OFF
public interface PConstants {
    // CHECKSTYLE:ON

    /**
     * URL of OSLC architecture management domain.
     */
    String CHANGE_MANAGEMENT_DOMAIN = "http://open-services.net/ns/cm#";

    /**
     * URL of OLSC architecture management namespace.
     */
    String CHANGE_MANAGEMENT_NAMESPACE = "http://open-services.net/ns/cm#";

    /**
     * Prefix for OSLC architecture management namespace.
     */
    String CHANGE_MANAGEMENT_PREFIX = "oslc_cm";

    /**
     * URL of friend of a friend (FOAF) namespace.
     */
    String PAPYRUS_NAMESPACE = "http://papyrusnamespace/";

    /**
     * Prefix for friend of a friend (FOAF) domain.
     */
    String PAPYRUS_NAMESPACE_PREFIX = "papyrus";
    

    /**
     * URL of OLSC quality management domain.
     */
    String QUALITY_MANAGEMENT_DOMAIN = "http://open-services.net/ns/qm#";

    /**
     * URL of OLSC quality management namespace.
     */
    String QUALITY_MANAGEMENT_NAMESPACE = "http://open-services.net/ns/qm#";

    /**
     * Prefix for OSLC quality management namespace.
     */
    String QUALITY_MANAGEMENT_PREFIX = "oslc_qm";

    /**
     * URL of VIF OSLC quality management domain.
     */
    String VIF_QM_DOMAIN = "http://oslc.vif.at/ns/vif_qm#";

    /**
     * URL of VIF OSLC quality management namespace.
     */
    String VIF_QM_NAMESPACE = "http://oslc.vif.at/ns/vif_qm#";

    /**
     * Prefix for VIF OSLC quality management namespace.
     */
    String VIF_QM_NAMESPACE_PREFIX = "vif_qm";

    /**
     * URL of VIF OSLC architecture management domain.
     */
    String VIF_AM_DOMAIN = "http://oslc.vif.at/ns/vif_am#";

    /**
     * URL of VIF OSLC architecture management namespace.
     */
    String VIF_AM_NAMESPACE = "http://oslc.vif.at/ns/vif_am#";

    /**
     * Prefix for VIF OSLC architecture management namespace.
     */
    String VIF_AM_NAMESPACE_PREFIX = "vif_am";

    /**
     * OSLC resource-type URI for OSLC-AM Resource.
     */
    String TYPE_RESOURCE = CHANGE_MANAGEMENT_NAMESPACE + "PapyrusResource";

    /**
     * OSLC resource-type URI for FOAF Diagramm.
     */
    String TYPE_DIAGRAMM = PAPYRUS_NAMESPACE + "Diagramm";
    
    /**
     * OSLC resource-type URI for FOAF Attribut.
     */
    String TYPE_ATTRIBUT = PAPYRUS_NAMESPACE + "Attribut";
    
    /**
     * OSLC resource-type URI for FOAF Modell.
     */
    String TYPE_MODELL = PAPYRUS_NAMESPACE + "Modell";
    
    /**
     * OSLC resource-type URI for FOAF Task.
     */
    String TYPE_TASK = PAPYRUS_NAMESPACE + "Task";



    /**
     * OSLC resource-type URI for VIF OSLC-AM extension system definition.
     */
    String TYPE_SYSDEF = VIF_AM_NAMESPACE + "SystemDefinition";

    /**
     * OSLC resource-type URI for OSLC-QM TestCase.
     */
    String TYPE_TEST_CASE = QUALITY_MANAGEMENT_NAMESPACE + "TestCase";

    /**
     * URI artifact that's added when pointing to OSLC-AM Resource e.g. in the resource shape URL.
     */
    String PATH_RESOURCE = "Payprus_resource";

    /**
     * An identifier URI specifying the usage 'list' of a service as VIF OSLC-AM domain extension.
     */
    String USAGE_LIST = VIF_AM_NAMESPACE + "list";
}
