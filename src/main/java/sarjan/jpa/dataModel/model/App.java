package sarjan.jpa.dataModel.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Sarjan Kabir
 */
@NamedQueries({
        @NamedQuery(
                name = "App.findAppsById",
                query = "SELECT h FROM App h  WHERE h.id = :id"
        ),
        @NamedQuery(
                name = "App.findAppsByName",
                query = "SELECT h FROM App h  WHERE  h.name LIKE CONCAT('%', :name, '%') order by h.name asc"
        )
})
@Entity
public class App {

    public enum Status {
        PENDING,DECLINED,ACCEPTED,INVITED;
    }
    @Id
    @GeneratedValue
    private Long id;

//name must be unique
    @Column(unique=true)
    private String name;

    @Column
    private String email;

    @Column
    private String gender;


    @Column
    private Integer age;

    @Column
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdWhen;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(Date createdWhen) {
        this.createdWhen = createdWhen;
    }

    public Status getPendingStatus() {
        return Status.PENDING;
    }
    public Status getDeclinedStatus() {
        return Status.DECLINED;
    }
    public Status getAcceptedStatus() {
        return Status.ACCEPTED;
    }
    public Status getInvitedStatus() {
        return Status.INVITED;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof App)) return false;
        App app = (App) o;
        return Objects.equals(id, app.id) &&
                Objects.equals(name, app.name) &&
                Objects.equals(email, app.email) &&
                Objects.equals(gender, app.gender) &&
                Objects.equals(age, app.age) &&
                Objects.equals(password, app.password) &&
                Objects.equals(createdWhen, app.createdWhen) &&
                status == app.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, gender, age, password, createdWhen, status);
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
