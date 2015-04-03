package net.hojnacki;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Bean {
    private String text = "Hello World!";

    @PostConstruct
    public void initialize() {
        System.out.println("Bean was constructed");
    }

    public String getText() {
        return text;
    }
}