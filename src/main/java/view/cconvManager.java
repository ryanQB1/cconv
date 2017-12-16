package view;

import controller.ccontroller;
import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.CurrencyException;

@Named("cconvManager")
@SessionScoped
public class cconvManager implements Serializable {

    @EJB
    private ccontroller contr;
    private double fromm;
    private double tom;
    private String fromc;
    private String toc;
    private Exception cexc;

    private HashMap<String, String> hm;
    
    @PostConstruct
    public void init(){
        hm = contr.createCurrencies();
    }

    public void convert() {
        try {
            tom = contr.getConv(fromc, toc, fromm);
        } catch (CurrencyException ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception e) {
        e.printStackTrace(System.err);
        cexc = e;
    }

    public Exception getException() {
        return cexc;
    }

    public boolean getSuccess() {
        return cexc == null;
    }

    public void setFromm(double fromm) {
        this.fromm = fromm;
    }

    public double getFromm() {
        return fromm;
    }

    public void setTom(double tomm) {
        this.tom = tomm;
    }

    public double getTom() {
        return tom;
    }

    public void setFromc(String fromc) {
        this.fromc = fromc;
    }

    public String getFromc() {
        return fromc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    public String getToc() {
        return toc;
    }

    public HashMap<String, String> getHm() {
        return hm;
    }

    public void setHm() {
    }
}
