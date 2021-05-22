package com.rest.address;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/listservice")
public class ListService {
	@GET
	@Produces("application/json")
	public Response listContacts() throws JSONException {
		ListQuery contactDB = new ListQuery();
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			contacts = contactDB.listFromDB();
		} catch (Exception e) {
			System.out.println("Unable to execute a list query to the database.");
			e.printStackTrace();
		}
		
		String result = "{";
		JSONObject obj = new JSONObject();
		JSONArray json = new JSONArray();
		
		for(Contact c : contacts) {
			json.put(c.getJSONObject());
		}
		
		for(int i = 0; i < json.length(); i++) {
			result += ("\"contact" + (i + 1) + "\":" + json.getJSONObject(i));
			
			if(i != json.length() - 1) {
				result += ", ";
			}
		}
		
		result += "}";
		
		return Response.status(200).entity(result).build();
	}
}
