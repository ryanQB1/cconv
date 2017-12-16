package integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CurrencyException;
import model.currencyF;


@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class cconvDAO {
    
    @PersistenceContext(unitName = "cconvpu")
    private EntityManager em;
    
    public currencyF findCurrency(String currencyName) throws CurrencyException{
        currencyF curr = em.find(currencyF.class, currencyName);
        if(curr ==  null){
            throw new CurrencyException("No currency with name " + currencyName);
        }
        return curr;
    }
    
    public currencyF newCurrency(String name) {
        currencyF curr = new currencyF(name);
        em.persist(curr);
        return curr;
    }
}
