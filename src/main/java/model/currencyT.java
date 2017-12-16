package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="currencyT")
public class currencyT implements Serializable{
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long currId;
    
    @Column(name = "currencyNameT", nullable = false)
    String currencyNameT;
    
    @Column(name = "convRate", nullable = false)
    double convRate;
    
    public currencyT(){
    }
    
    public currencyT(String currencyNameT, double convRate){
        this.currencyNameT=currencyNameT;
        this.convRate=convRate;
    }
    
    public double getConvRate(){
        return convRate;
    }
    
    public String getCurrencyName(){
        return currencyNameT;
    }
    
}
