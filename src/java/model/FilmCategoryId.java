package model;
// Generated 07/06/2019 21:27:19 by Hibernate Tools 4.3.1



/**
 * FilmCategoryId generated by hbm2java
 */
public class FilmCategoryId  implements java.io.Serializable {


     private short filmId;
     private short categoryId;

    public FilmCategoryId() {
    }

    public FilmCategoryId(short filmId, short categoryId) {
       this.filmId = filmId;
       this.categoryId = categoryId;
    }
   
    public short getFilmId() {
        return this.filmId;
    }
    
    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }
    public short getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FilmCategoryId) ) return false;
		 FilmCategoryId castOther = ( FilmCategoryId ) other; 
         
		 return (this.getFilmId()==castOther.getFilmId())
 && (this.getCategoryId()==castOther.getCategoryId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFilmId();
         result = 37 * result + this.getCategoryId();
         return result;
   }   


}


