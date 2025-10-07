package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Course {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String detail;

    public Course (int id, String name, String detail){
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public void setId (int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }

    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return name;
    }

    public void setDetail (String detail){
        this.detail = detail;
    }
    public String getDetail(){
        return detail;
    }

    public Course (){
    }

}
