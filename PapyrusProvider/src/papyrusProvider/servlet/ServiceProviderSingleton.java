package papyrusProvider.servlet;

import java.net.URI;

public class ServiceProviderSingleton {
	private static URI serviceProviderURISingleton;

    private ServiceProviderSingleton()
    {
        super();
    }

    public static synchronized URI getServiceProviderURI()
    {
        return serviceProviderURISingleton;
    }

    static synchronized void setServiceProviderURI(final URI serviceProviderURI)
    {
        serviceProviderURISingleton = serviceProviderURI;
    }

}
