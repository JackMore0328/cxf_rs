package com.test;

import javax.ws.rs.core.MediaType;  
import org.apache.cxf.jaxrs.client.WebClient;  
import org.junit.Before;  
import org.junit.Test;

import com.rs.model.Student;  
  
/** 
 * @author Ickes 
 */  
  
public class WebClientTest {  
  
    WebClient client = null;  
  
    @Before  
    public void init() {  
        client = WebClient.create("http://localhost:8080/rest/");  
    }  
  
    /** 
     * 调用get方法,get方式是将参数加入到URL地址后面的，所以不能传人Bean，但是可以转换为json的格式进行传递 
     *  
     * @param client 
     */  
    @Test  
    public void getTest() {  
        // 测试URL传递数据  
        client = WebClient.create("http://localhost:8080/rest/restFul/get?id=ickes");  
        Student u = client.accept(MediaType.APPLICATION_XML).get(Student.class);  
        System.out.println(u.toJson());  
    }  
  
    /** 
     * 调用put方法,可以看到这种方式可以传人一个JavaBean参数， 但是集合对象不行，可以将集合写在JavaBean里面进行传递 
     */  
    @Test  
    public void putTest() {  
    	Student user = new Student(1, "jww");
        client.path("restFul/put/{id}", "ickes")  
                .accept(MediaType.APPLICATION_XML).put(user);  
    }  
  
    /** 
     * 调用post方法，这种方式的调用跟put方式异曲同工 
     *  
     */  
    @Test  
    public void postTest() {  
    	Student user = new Student(1, "jww");
        client.accept(MediaType.APPLICATION_XML)  
                .path("/restFul/post/{id}", "post").post(user);  
    }  
  
    /** 
     * 调用Delete方法,这个方法可以看到delete方法是不能传递参数的，只能通过其他方式，例如URL 
     *  
     */  
    @Test  
    public void deleteTest() {  
        client.accept(MediaType.APPLICATION_XML).path("/restFul/delete/{id}", "post").delete();  
    }  
}  
