/*
 * © 2022 tienhuynh-tn
 * All rights reserved!
 * For more information, please contact via my email: tien.huynhlt.tn@gmail.com
 */
package sample.restFul;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Tien Huynh - Tien Huynh TN - Huynh Le Thuy Tien
 */
@Path("generic")
public class CalculatorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculatorResource
     */
    public CalculatorResource() {
    }

    /**
     * Retrieves representation of an instance of sample.restFul.CalculatorResource
     * @param num1
     * @param num2
     * @return an instance of java.lang.String
     */
    @Path("/add")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String add(
            @DefaultValue("5") @QueryParam("num1") double  num1,
            @DefaultValue("3") @QueryParam("num2") double num2) {
        double result = num1 + num2;
        return "" + result;
    }

    /**
     * PUT method for updating or creating an instance of CalculatorResource
     * @param num1
     * @param num2
     * @return 
     */
    @Path("/subtract")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public String subtract(
            @QueryParam("num1") double num1, 
            @QueryParam("num2") double num2) {
        double result = num1 - num2;
        return "" + result;
    }
}
