package com.sample;

import java.util.HashMap;
import java.util.Map;

public class DTO {
    private final Map<String, Object> map = new HashMap<String, Object>();
    
    public void put(String key, Object value){
        map.put(key, value);
    }
    
    public Object get(String key){
        return map.get(key);
    }
    
    public Map<String, Object> getMap(){
        return map;
    }
}
