package codythefennec;

import java.io.InputStream;
import java.util.ArrayList;
import java.io.File;

public class ApplicationManager {
    // array list of app objects
    private ArrayList<App> applicationList;

    public ApplicationManager() {
        // create an empty list on runtime, store somewhere?
        applicationList = new ArrayList<App>();
    }

    public ArrayList<App> getApplicationList() {
        return applicationList;
    }

    // TODO store on local machine
    // save current "application list"
    public void saveApplicationList() {

    }

    public boolean loadApplicationList() {
        // success?
        if (true) {
            return true;
        }

        // load operation failed
        return false;
    }

    // wipe current machine to a clean state, clean user_data
    public void wipeLocalMachine() {
        final InputStream inStream;

        // remove saved_apps stored in userdata
        inStream = this.getClass().getResourceAsStream("/user_data/saved_apps");

        // wipe arraylist
        applicationList.clear();

        // TODO reset to a point
    }

    // TODO save and fetch on runtime on edit
    public static void main (String args[]) {
        ApplicationManager appman = new ApplicationManager();
        appman.wipeLocalMachine();
    }
}
