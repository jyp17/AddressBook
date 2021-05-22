package com.rest.address;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/deleteservice")
public class DeleteService {
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response editContact(String toDelete) throws JSONException {
		JSONObject obj = new JSONObject(toDelete);
		
		String id = obj.getString("id");
		
		DeleteQuery contactDB = new DeleteQuery();
		try {
			contactDB.deleteDB(new Contact(Integer.valueOf(id)));
		} catch (Exception e) {
			System.out.println("Unable to execute a delete query to the database.");
			e.printStackTrace();
		}
		
		return Response.ok().build();
	}
}
