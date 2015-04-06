package net.hojnacki;

import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@ViewScoped
public class DownloadBean {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private boolean readyForDownload = false;
    private String lastDownloadTime;

    @PostConstruct
    public void initialize() {
        System.out.println("DownloadBean was constructed");
    }

    public void redirectWithDownload() {
        update();
        readyForDownload = true;
    }

    public boolean isReadyForDownload() {
        return readyForDownload;
    }

    public String getLastDownloadTime() {
        return lastDownloadTime;
    }

    public void download() throws IOException {
        readyForDownload = false;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType("image/jpeg");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=downloadedFile.jpg");

        OutputStream output = ec.getResponseOutputStream();
        InputStream input = ec.getResourceAsStream("images/aFile.jpg");
        IOUtils.copy(input, output);

        fc.responseComplete();
    }

    public void update() {
        lastDownloadTime = format.format(new Date());
    }
}