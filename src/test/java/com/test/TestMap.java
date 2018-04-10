package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestMap {
	@Test
	public void testHashMap() throws Exception {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");
		map.put(4, "4");
		map.put(5, "5");
		
		Entry<Integer, String> result=null;
		for( Iterator<Entry<Integer, String>> iterator= map.entrySet().iterator();iterator.hasNext();result=iterator.next()){
			if(result==null){
				continue;
			}
			System.out.println("key=="+result.getKey()+" || "+"value=="+result.getValue());
		}
		
		
	}

}
