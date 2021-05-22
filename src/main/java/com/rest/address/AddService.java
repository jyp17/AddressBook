package com.rest.address;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/addservice")
public class AddService {
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addContact(String toBeAdded) throws JSONException {
		JSONObject obj = new JSONObject(toBeAdded);

		String firstName = obj.getString("first_name");
		String lastName = obj.getString("last_name");
		String address = obj.getString("address");
		String phone = obj.getString("phone");
		
		AddQuery contactDB = new AddQuery();
		try {
			contactDB.addToDB(new Contact(firstName, lastName, address, phone));
		} catch (Exception e) {
			System.out.println("Unable to execute an add query to the database.");
			e.printStackTrace();
		}
		
		return Response.ok().build();
	}
}
