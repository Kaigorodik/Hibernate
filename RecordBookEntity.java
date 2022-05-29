package ru.javastudy.hibernate.dao;

import javax.persistence.*;

@Entity
@Table(name = "recordBook")

public class RecordBookEntity {
    private long recordBook_id;
    private int code;
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recordBook_id", nullable = false, insertable = true, updatable = true)
    public long getRecordBook_id() {
        return recordBook_id;
    }

    public void setRecordBook_id(long recordBook_id) {
        this.recordBook_id = recordBook_id;
    }

    @Basic
    @Column(name = "code", nullable = false, insertable = true, updatable = true)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //NOTE THIS!
    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private StudentEntity student;
    @OneToOne
    @JoinColumn(name = "recordBook_id")
    public StudentEntity getStudent() {return this.student;}

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordBookEntity that = (RecordBookEntity)o;

        if (recordBook_id != that.recordBook_id) return false;
        if (code != that.code) return false;
        if (version != that.version) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long result = recordBook_id;
        result = 31 * result + code;
        result = 31 * result + version;
        return (int) result;
    }

    @Override
    public String toString() {
        return "RecordBookEntity{" +
                "id=" + recordBook_id +
                ", code='" + code + '\'' +
                ", version=" + version +
                ", student=" + student +
                '}';
    }
}
