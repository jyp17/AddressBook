package com.rest.address;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/editservice")
public class EditService {
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response editContact(String newData) throws JSONException {
		JSONObject obj = new JSONObject(newData);

		String firstName = obj.getString("first_name");
		String lastName = obj.getString("last_name");
		String address = obj.getString("address");
		String phone = obj.getString("phone");
		String id = obj.getString("id");
		
		EditQuery contactDB = new EditQuery();
		try {
			contactDB.updateDB(new Contact(firstName, lastName, address, phone, Integer.valueOf(id)));
		} catch (Exception e) {
			System.out.println("Unable to execute an edit query to the database.");
			e.printStackTrace();
		}
		
		return Response.ok().build();
	}
}
