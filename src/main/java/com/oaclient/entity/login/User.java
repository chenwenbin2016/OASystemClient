package com.oaclient.entity.login;

/**
 * 用户类
 */
public class User {
    /**
     * 编号
     */
    private long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
