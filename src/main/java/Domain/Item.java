package Domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Item implements Serializable{

    private String name;
    @Id
    private String code;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) { this.amount = this.amount + amount;}

    public void subtractAmount(int amount){
        this.amount = this.amount - amount;
    }

    public Item(){}
    public Item(String name, String code, int amount){
        setName(name);
        setCode(code);
        setAmount(amount);
    }
}
