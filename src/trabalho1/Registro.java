/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author ice
 */
class Registro {

    protected  int id;
    private String user;
    private float rating;
    private String comment;
    private String ID;
    private String name;

    public Registro() {
    }

    public Registro(int id) {
        this.id = id;
    }
    
    
    public Registro(int id, String user, float rating, String comment, String ID, String name) {
        this.id = id;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        this.ID = ID;
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public String getID() {
        return ID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getUser() {
        return user;
    }
    
}