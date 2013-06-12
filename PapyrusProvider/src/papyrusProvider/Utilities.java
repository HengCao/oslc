 
package papyrusProvider;

import PapyrusCommon.PapyrusCommon.resources.Resource;

 

public class Utilities
{
    private Utilities()
    {
        super();
    }

    public static String createResourceIdentifier(final Resource resource)
    {
        return  resource.getIdentifier();
    }

    public  static String createResourceIdentifier(final String exchange,
                                                     final String symbol)
    {
        return exchange.toLowerCase() + "_" + symbol.toLowerCase();
    }
}