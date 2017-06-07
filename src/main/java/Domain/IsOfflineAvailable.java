package Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class IsOfflineAvailable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean offlineAvailable;

    public IsOfflineAvailable(){}

    public void toggle(boolean isOfflineAvailable) {
        this.offlineAvailable = isOfflineAvailable;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }
}
