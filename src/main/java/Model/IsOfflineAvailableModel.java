package Model;

/**
 * Created by Lars on 4-4-2017.
 */
public class IsOfflineAvailableModel {
    public boolean offlineAvailable;

    public void toggle() {
        if (offlineAvailable) {
            offlineAvailable = false;
        }
        else {
            offlineAvailable = true;
        }

    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }
}