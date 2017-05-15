package org.example.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by palevo on 11.05.2017.
 */
@Entity
public class Person {
    @Column(length = 11)
    private Integer id;

    @NotNull
    @Length(min=1)
    @Column(length = 100)
    private String name1;

    @NotNull
    @Length(min=1)
    @Column(length = 100)
    private String name2;

    public Person(){

    }

    public Person(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
