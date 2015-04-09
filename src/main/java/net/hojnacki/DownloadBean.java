package net.hojnacki;

import org.apache.commons.io.IOUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@ManagedBean
@NoneScoped
public class DownloadBean {

    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType("image/jpeg");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=downloadedFile.jpg");

        OutputStream output = ec.getResponseOutputStream();
        InputStream input = ec.getResourceAsStream("images/aFile.jpg");
        IOUtils.copy(input, output);
        output.flush();

        fc.responseComplete();
    }

}
