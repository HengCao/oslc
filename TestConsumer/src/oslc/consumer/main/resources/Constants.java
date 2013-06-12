/**
 * Copyright (c) 2012 Virtual Vehicle (ViF). www.v2c2.at
 * 
 * Created at: 13.06.2012
 * 
 * Authors:
 * 
 * @author Stefan Paschke
 * 
 */
package oslc.consumer.main.resources;

/**
 * Contains constant values needed in all sub packages of the OSLC Rhapsody integration.
 * 
 * @author stefanpaschke
 * 
 */
// CHECKSTYLE:OFF
public interface Constants {
    // CHECKSTYLE:ON

    /**
     * URL of OSLC architecture management domain.
     */
	  public static String STOCK_QUOTE_DOMAIN           = "http://yourcompany.com/ns/stockquote#";
	    public static String STOCK_QUOTE_NAMESPACE        = "http://yourcompany.com/ns/stockquote#";
	    public static String STOCK_QUOTE_NAMESPACE_PREFIX = "stockquote";

	    public static String TYPE_STOCK_QUOTE = STOCK_QUOTE_NAMESPACE + "StockQuote";

	    public static String PATH_STOCK_QUOTE = "stockQuote";

    /**
     * URL of OLSC architecture management namespace.
     */
    String ARCHITECTURE_MANAGEMENT_NAMESPACE = "http://yourcompany.com/ns/stockquote#";

    /**
     * Prefix for OSLC architecture management namespace.
     */
    String ARCHITECTURE_MANAGEMENT_PREFIX = "oslc_am";

    /**
     * URL of friend of a friend (FOAF) namespace.
     */
    String FOAF_NAMESPACE = "http://xmlns.com/foaf/0.1/";

    /**
     * Prefix for friend of a friend (FOAF) domain.
     */
    String FOAF_NAMESPACE_PREFIX = "foaf";

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
    String TYPE_RESOURCE = "http://yourcompany.com/ns/stockquote#StockQuote";

    /**
     * OSLC resource-type URI for FOAF Person.
     */
    String TYPE_PERSON = FOAF_NAMESPACE + "Person";

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
    String PATH_RESOURCE = "resource";

    /**
     * An identifier URI specifying the usage 'list' of a service as VIF OSLC-AM domain extension.
     */
    String USAGE_LIST = VIF_AM_NAMESPACE + "list";
}
