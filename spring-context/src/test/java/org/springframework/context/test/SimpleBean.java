package org.springframework.context.test;

/**
 * @author junxchen
 * @date 2020-06-10
 */

public class SimpleBean {

    public SimpleBean() {

    }

    public SimpleBean(String name) {
        this.name = name;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
