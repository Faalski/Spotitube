package Service;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Lars on 21-3-2017.
 */
@ApplicationPath("/rest")
public class RestResourceConfig extends ResourceConfig {

    public static final String JSON_SERIALIZER = "jersey.config.server.provider.packages";
    public static final String JACKSON_JSON_SERIALIZER = "com.fasterxml.jackson.jaxrs.json;service";

    public RestResourceConfig() {
        packages(true, "oose.dea.services.rest");
        property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
    }
}

