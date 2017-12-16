package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="currencyF")
public class currencyF implements Serializable {
    
    @Id
    @Column(name = "id", nullable = false)
    String Id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "convs")
    private List<currencyT> convs;
    
    public currencyF(){
    }
    
    public currencyF(String currencyName){
        this.Id=currencyName;
        this.convs= new ArrayList<>();
    }
    
    public String getId(){
        return Id;
    }
    
    public List<currencyT> getConvRates(){
        return convs;
    }
    
    public void addCurrencyT(String name, double conv){
        convs.add(new currencyT(name, conv));
    }
}
