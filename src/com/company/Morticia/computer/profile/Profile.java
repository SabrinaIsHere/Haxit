package com.company.Morticia.computer.profile;

/**
 * This class is to serve as a profile to computers. In the same way that you must log in to your computer via a profile, these serve to differentiate users and their respective ability to execute commands.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Profile {
    public String username;
    public String password;
    public boolean root;

    public final int privilege;

    /**
     * The constructor to the Profile object takes several parameters in the service of instancing the object.
     *
     * @param username This is the username of the profile being created
     * @param password This is the password of the profile being created
     * @param root This determines whether this profile is root and has admin privileges. Set wisely.
     */
    public Profile(String username, String password, boolean root) {
        this.username = username;
        this.password = password;
        this.root = root;
        if (root) {
            privilege = 1;
        } else {
            privilege = 0;
        }
    }
}
