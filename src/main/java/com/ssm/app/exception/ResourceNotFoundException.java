//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssm.app.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String resourseName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourseName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourseName, fieldName, fieldValue));
        this.resourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourseName() {
        return this.resourseName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Object getFieldValue() {
        return this.fieldValue;
    }
}
