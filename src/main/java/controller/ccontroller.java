package controller;

import integration.cconvDAO;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.CurrencyException;
import model.currencyF;
import model.currencyT;

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ccontroller {

    @EJB
    cconvDAO cconvDB;

    public HashMap<String, String> createCurrencies() {
        HashMap<String, String> listofc = new HashMap<>();
        try {
            currencyF temp = cconvDB.findCurrency("EUR");
        } catch (CurrencyException ex) {
            currencyF newcurr = cconvDB.newCurrency("EUR");
            newcurr.addCurrencyT("SEK", 9.938);
            newcurr.addCurrencyT("GBP", 0.878);
            newcurr.addCurrencyT("USD", 1.180);
            newcurr.addCurrencyT("EUR", 1);
        }
        finally{
            listofc.put("EUR", "EUR");
        }
        try {
            currencyF temp = cconvDB.findCurrency("SEK");
        } catch (CurrencyException ex) {
            currencyF newcurr = cconvDB.newCurrency("SEK");
            newcurr.addCurrencyT("EUR", 0.100);
            newcurr.addCurrencyT("GBP", 0.088);
            newcurr.addCurrencyT("USD", 0.118);
            newcurr.addCurrencyT("SEK", 1);
        }
        finally{
            listofc.put("SEK", "SEK");
        }
        try {
            currencyF temp = cconvDB.findCurrency("GBP");
        } catch (CurrencyException ex) {
            currencyF newcurr = cconvDB.newCurrency("GBP");
            newcurr.addCurrencyT("SEK", 11.318);
            newcurr.addCurrencyT("EUR", 1.139);
            newcurr.addCurrencyT("USD", 1.344);
            newcurr.addCurrencyT("GBP", 1);
        }
        finally{
            listofc.put("GBP", "GBP");
        }
        try {
            currencyF temp = cconvDB.findCurrency("USD");
        } catch (CurrencyException ex) {
            currencyF newcurr = cconvDB.newCurrency("USD");
            newcurr.addCurrencyT("SEK", 8.428);
            newcurr.addCurrencyT("EUR", 0.848);
            newcurr.addCurrencyT("GBP", 0.744);
            newcurr.addCurrencyT("USD", 1);
        }
        finally{
            listofc.put("USD", "USD");
        }
        return listofc;
    }

    public double getConv(String from, String to, double conv) throws CurrencyException {
        if (from == null) {
            throw new CurrencyException("From Currency was empty, set up the database first!");
        }
        currencyF fromcurr = cconvDB.findCurrency(from);
        for (currencyT tocurr : fromcurr.getConvRates()) {
            if (tocurr.getCurrencyName().equals(to)) {
                return conv * tocurr.getConvRate();
            }
        }
        throw new CurrencyException("Currency " + to + " not found");
    }
}
