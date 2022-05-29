package ru.javastudy.hibernate.dao;

import javax.persistence.*;

@Entity
@Table(name = "student")

public class StudentEntity {
    private static long person_id;
    private long id;
    private long recordBook_id;
    private String group;
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "person_id", nullable = false, insertable = true, updatable = true)
    public static long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    @Basic
    @Column(name = "recordBook_id", nullable = false, insertable = true, updatable = true)
    public long getRecordBook_id() {
        return recordBook_id;
    }

    public void setRecordBook_id(long recordBook_id) {
        this.recordBook_id = recordBook_id;
    }

    @Basic
    @Column(name = "group", nullable = false, insertable = true, updatable = true, length = 12)
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {this.group = group;}

    //NOTE THIS!
    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    /*
     * EXAMPLE Many To One
     */
    @ManyToOne
    private PersonEntity person;
    @JoinColumn(name = "person_id")

    public PersonEntity getPerson() {return this.person;}

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
    /*
     * EXAMPLE One To One
     */
    @OneToOne
    private RecordBookEntity recordBook;
    @JoinColumn(name = "recordBook_id")
    public RecordBookEntity getRecordBook() {return this.recordBook;}

    public void setRecordBook(RecordBookEntity recordBook) {
        this.recordBook = recordBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity)o;

        if (id != that.id) return false;
        if (person_id != that.person_id) return false;
        if (recordBook_id != that.recordBook_id) return false;
        if (version != that.version) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + person_id;
        result = 31 * result + recordBook_id;
        result = 31 * result + version;
        return (int) result;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", person_id: " + getPerson().getPerson_id() +
                ", recordBook_id='" + getRecordBook().getRecordBook_id() + '\'' +
                ", telNumber='" + group + '\'' +
                ", version=" + version +
                ", person=" + person +
                '}';
    }

}
