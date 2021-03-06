package net.hojnacki;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;

@ManagedBean
public class OpenWindowDownloadBean {

    @ManagedProperty(value = "#{downloadBean}")
    private DownloadBean downloadBean;

    @ManagedProperty(value = "#{clockBean}")
    private ClockBean clockBean;

    private String lastDownloadTime = "none";

    public String getLastDownloadTime() {
        return lastDownloadTime;
    }

    public void setLastDownloadTime(String lastDownloadTime) {
        this.lastDownloadTime = lastDownloadTime;
    }

    public void download() throws IOException {
        downloadBean.download();
    }

    public String update() {
        lastDownloadTime = clockBean.getCurrentTime();
        return "openWindowBased?faces-redirect=true&includeViewParams=true";
    }

    public void setDownloadBean(DownloadBean downloadBean) {
        this.downloadBean = downloadBean;
    }

    public void setClockBean(ClockBean clockBean) {
        this.clockBean = clockBean;
    }
}