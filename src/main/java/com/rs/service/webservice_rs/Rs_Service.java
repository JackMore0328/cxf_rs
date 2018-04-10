package com.rs.service.webservice_rs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rs.model.Student;

/**
 * @Description:
 * @Title: Rs_Service.java
 * @Company: DOOR
 * @author jiangwenwu
 * @date 2018年3月30日下午5:40:08
 */
@Path("/")
public interface Rs_Service {

	/**
	 * 测试get请求
	 * 
	 * @Description:
	 * @Title: getAPI
	 * @Company: DOOR
	 * @author jiangwenwu
	 * @date 2018年3月30日下午5:39:55
	 */
	@GET
	@Path("/getAPI")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getAPI(@QueryParam("req") String req);

	/**
	 * 测试post请求
	 * 
	 * @Description:
	 * @Title: postApi
	 * @Company: DOOR
	 * @author jiangwenwu
	 * @date 2018年3月30日下午5:39:55
	 */
	@POST
	@Path("/postApi")
	@Produces({ MediaType.TEXT_PLAIN })
	public String postApi(String req);

	/**
	 * 测试GET方法，传人对象、普通参数；返回对象
	 * 
	 */
	@GET
	@Path("/get")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student get(@QueryParam("id") String id);

	/**
	 * 测试PUT方法，传人对象、普通参数；返回对象 id来源于url后面的参数
	 * 
	 * @param user
	 * @return
	 */
	@PUT
	@Path("/put/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student put(@PathParam("id") String id);

	/**
	 * 测试POST方法，传人对象、普通参数；返回对象
	 * 
	 */
	@POST
	@Path("/post/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student post(@PathParam("id") String id);

	/**
	 * 测试DELETE方法 ,传人普通参数；返回对象
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student delete(@PathParam("id") String id);

	
	@POST
	@Path("/notify")
	@Produces({ MediaType.TEXT_PLAIN })
	public String notify(String sRquest);
	
}
