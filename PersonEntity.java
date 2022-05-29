package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {
    private long person_id;
    private int passportSeries;
    private int passportNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //generated DataBase auto_increment when insert value
    @Column(name = "person_id", nullable = false, insertable = true, updatable = true)
    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    @Basic
    @Column(name = "passportNumber", nullable = false, insertable = true, updatable = true)
    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "passportSeries", nullable = false, insertable = true, updatable = true)
    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middle_name", nullable = false, insertable = true, updatable = true, length = 40)
    public String getMiddleName() {return middleName;}

    public void setMiddleNameName(String middleName) {this.middleName = middleName;}


    //NOTE THIS!
    @Version  //используем механизм оптимистичной блокировки.
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /*
     * EXAMPLE One To Many
     */
    private Set<StudentEntity> student = new HashSet<StudentEntity>();
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<StudentEntity> getStudent() {
        return this.student;
    }

    public void setStudent(Set<StudentEntity> student) {
        this.student = student;
    }

    public void addStudent(StudentEntity student) {
        student.setPerson(this);
        getStudent().add(student);
    }

    public void removeStudent(StudentEntity student) {
        getStudent().remove(student);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (person_id != that.person_id) return false;
        if (version != that.version) return false;
        if (getPassportSeries() != that.passportSeries) return false;
        if (passportNumber != that.passportNumber) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName .equals(that.middleName ) : that.middleName  != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long result = person_id;
        result = 31 * result + passportSeries;
        result = 31 * result + passportNumber;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + version;
        return (int) result;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + person_id +
                "passportSeries=" + passportSeries +
                "passportNumber=" + passportNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName=" + middleName +
                ", version=" + version +
                '}';
    }
}
