package net.hojnacki;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@NoneScoped
public class ClockBean {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public String getCurrentTime() {
        return format.format(new Date());
    }
}
