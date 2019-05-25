package model;
// Generated 27/04/2019 21:52:51 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * FilmCategory generated by hbm2java
 */
public class FilmCategory  implements java.io.Serializable {


     private FilmCategoryId id;
     private Category category;
     private Film film;
     private Date lastUpdate;

    public FilmCategory() {
    }

    public FilmCategory(FilmCategoryId id, Category category, Film film, Date lastUpdate) {
       this.id = id;
       this.category = category;
       this.film = film;
       this.lastUpdate = lastUpdate;
    }
   
    public FilmCategoryId getId() {
        return this.id;
    }
    
    public void setId(FilmCategoryId id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Film getFilm() {
        return this.film;
    }
    
    public void setFilm(Film film) {
        this.film = film;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


