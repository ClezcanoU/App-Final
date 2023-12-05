
package Modelo.interfaz;

import javax.swing.Icon;


public class ModelName {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Icon getProfile() {
        return profile;
    }

    public void setProfile(Icon profile) {
        this.profile = profile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ModelName(String firstName, Icon profile, String path) {
        this.firstName = firstName;
        this.profile = profile;
        this.path = path;
    }

    public ModelName(String firstName, Icon profile) {
        this.firstName = firstName;
        this.profile = profile;
    }

    
    public ModelName() {
    }

    private String firstName;
    private Icon profile;
    private String path;

    @Override
    public String toString() {
        return firstName;
    }
}
