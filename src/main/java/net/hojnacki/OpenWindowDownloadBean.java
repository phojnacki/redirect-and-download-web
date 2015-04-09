package net.hojnacki;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;

@ManagedBean
public class OpenWindowDownloadBean {

    @ManagedProperty(value = "#{downloadBean}")
    public DownloadBean downloadBean;

    @ManagedProperty(value = "#{clockBean}")
    public ClockBean clockBean;

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
        return "downloadWindowBased?faces-redirect=true&includeViewParams=true";
    }
}