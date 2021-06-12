package com.company.Morticia.computer.profile;

public class Profile {
    public String username;
    public String password;
    public boolean root;

    public final int privilege;

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
