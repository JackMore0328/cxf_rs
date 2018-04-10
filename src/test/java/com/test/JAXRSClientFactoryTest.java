package com.test;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rs.service.webservice_rs.Rs_Service;  
  
/** 
 * <pre> 
 * 调用RestFul接口，除了使用WebClient意外，还可以使用org.apache.cxf.jaxrs.client.JAXRSClientFactory; 
 * 这种方式相对比WebClient要更简单，直接使用接口中的方法即可 
 * </pre> 
 *  
 * @author Ickes 
 */  
public class JAXRSClientFactoryTest { 
	@Autowired
	Rs_Service us = null;  
  
    @Before  
    public void init() {  
        us = JAXRSClientFactory.create("http://localhost:8080/jax_rs/cxf/restFul",Rs_Service.class);  
        System.out.println(us);  
    }  
  
    /** 
     * 调用get方法 
     */  
    @Test  
    public void getTest() {  
        System.out.println(us.get("a").toJson());  
    }  
  
    /** 
     * 调用put方法 
     */  
    @Test  
    public void putTest() {  
        System.out.println(us.post("a001"));  
    }  
      
    /** 
     * 调用post方法 
     *  
     */  
    @Test  
    public void postTest() {  
        us.post("POST");  
    }  
      
    /** 
     * 调用Delete方法 
     *  
     */  
    @Test  
    public void deleteTest() {  
        us.delete("DELETE");  
    }  
      
}  
