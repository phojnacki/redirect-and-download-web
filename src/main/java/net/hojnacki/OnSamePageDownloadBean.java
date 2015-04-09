package net.hojnacki;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;

@ManagedBean
public class OnSamePageDownloadBean {

    @ManagedProperty(value = "#{downloadBean}")
    private DownloadBean downloadBean;

    @ManagedProperty(value = "#{clockBean}")
    private ClockBean clockBean;

    private String lastDownloadTime = "none";

    private boolean readyForDownload = false;

    public String redirectWithDownload() {
        lastDownloadTime = clockBean.getCurrentTime();
        readyForDownload = true;
        return "samePageBased?faces-redirect=true&includeViewParams=true";
    }

    public boolean isReadyForDownload() {
        return readyForDownload;
    }

    public String getLastDownloadTime() {
        return lastDownloadTime;
    }

    public void setLastDownloadTime(String lastDownloadTime) {
        this.lastDownloadTime = lastDownloadTime;
    }

    public void setReadyForDownload(boolean readyForDownload) {
        this.readyForDownload = readyForDownload;
    }

    public void download() throws IOException {
        downloadBean.download();
    }

    public void setDownloadBean(DownloadBean downloadBean) {
        this.downloadBean = downloadBean;
    }

    public void setClockBean(ClockBean clockBean) {
        this.clockBean = clockBean;
    }
}