package com.rs.framwork.utils;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionContext {
	private static HashMap<Object,Object> mymap = new HashMap<Object,Object>();
	private static Logger logger = LoggerFactory.getLogger(MySessionContext.class); // 日志记录
    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
        	session.setAttribute("valid", "valid");
        	String userid = (String) session.getAttribute("UseName");
        	boolean containsKey = mymap.containsKey(userid);
        	if(containsKey){
        		Object sessionId = mymap.get(userid);
        		mymap.remove(sessionId);
        	}
    		mymap.put(userid,session.getId());
    		mymap.put(session.getId(), session);
        }
    }
    
    public static synchronized void AddSessionNew(HttpSession session) {
        if (session != null) {
        	session.setAttribute("valid", "valid");
            mymap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
        	Collection<Object> co = mymap.values();
        	co.remove(session.getId());
            mymap.remove(session.getId());
            try {
            	session.invalidate();
			} catch (Exception e) {
				logger.error("接口session已经过期、",e);
			}
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
    	if(session_id != null){
    		HttpSession session = (HttpSession)mymap.get(session_id);
    		try {
    			session.getAttribute("valid");
			} catch (Exception e) {
				MySessionContext.DelSession(session);
				session = null;
				logger.error("接口获取session异常：：", e);
			}
    		return session;
    	}
    	return null;
    }
}