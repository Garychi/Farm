package com.it.utils;

public class EntityUtil {

    private Object localObject;
    private String entityName;

    public EntityUtil(Class<?> clazz) {
	this.entityName=clazz.getName();
    }

    public Object getLocalObject() {
	return localObject;
    }

    public void setLocalObject(Object localObject) {
	this.localObject = localObject;
    }

    public String getEntityName() {
	return entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }

}
