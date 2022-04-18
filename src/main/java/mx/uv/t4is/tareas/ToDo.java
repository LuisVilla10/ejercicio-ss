package mx.uv.t4is.tareas;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tarea;
    private String status;

    public String getTarea() {
        return tarea;
    }
    public String getStatus() {
        return status;
    }
    public Integer getId() {
        return id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
