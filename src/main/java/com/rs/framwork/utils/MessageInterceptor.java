package com.rs.framwork.utils;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
 
/**
 * 自定义消息拦截器
 * @author Administrator
 *
 */
public class MessageInterceptor extends AbstractPhaseInterceptor<Message> {
    
    //至少要一个带参的构造函数
    public MessageInterceptor(String phase) {
        super(phase);
    }
 
    public void handleMessage(Message message) throws Fault {
        //System.out.println(message);
        if (message.getDestination() != null) {
           // System.out.println(message.getId() + "#" + message.getDestination().getMessageObserver());
        }
        if (message.getExchange() != null) {
           // System.out.println(message.getExchange().getInMessage() + "#" + message.getExchange().getInFaultMessage());
           // System.out.println(message.getExchange().getOutMessage() + "#" + message.getExchange().getOutFaultMessage());
        }
    }
}