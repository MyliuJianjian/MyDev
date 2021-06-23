package com.my.eum;

public enum UserTypeEnum {
    A_TYPE("A", "A类用户");
    private String code;
    private String name;


    private UserTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String byName(String code) {
        for(UserTypeEnum type:values()){
            if(type.code.equals(code)){
                return type.name;
            }
        }
        return "";
    }

    public UserTypeEnum byType(String code) {
        for(UserTypeEnum type:values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
