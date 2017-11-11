package com.sample;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/*
 * http://localhost:8080/myapp/service/main/foo?id=1
 */
@Path("main")
public class Main {
	@Inject
	private SessionDTO dto;
	@EJB
	private PersonDB db;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("foo")
	public String foo(@QueryParam("id") int id) {
		Integer n = (Integer) dto.get("COUNT");
		if (n == null) {
			n = 0;
		}
		n++;
		dto.put("COUNT", n);

		Person p = db.find(id);
		return (p != null) ? "result=" + id + ":" + p.getName() + ":" + n : "ERROR!!";
	}

	@GET
	@Produces("text/plain")
	@Path("bar")
	public Response bar(@QueryParam("id") int id) {
		byte[] b = new byte[] { (byte) 0x97, (byte) 0x98, (byte) 0x99, (byte) 0x100 };

		ByteArrayInputStream bos = new ByteArrayInputStream(b);
		ResponseBuilder response = Response.ok(bos);
		String headerVal = "attachment; filename=hogehoge.txt";
		response.header("Content-Disposition", headerVal);
		return response.build();
	}
}
