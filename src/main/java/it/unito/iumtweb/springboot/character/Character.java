package it.unito.iumtweb.springboot.character;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDate dob;

    @Transient
    int age;

    public int getAge() {
            LocalDate currentDate = LocalDate.now();
            if (dob != null) {
                return Period.between(dob, currentDate).getYears();
            } else {
                return 0; // Or handle the case where DOB is null
            }
        }
    /**
     * No-argument constructor this is necessary otherwise many methods will not work
      */

        public Character() {
            // Default constructor required by JPA
        }

    /**
     *  constructor this is necessary otherwise many methods will not work
      */
    public Character(String name, String surname, LocalDate dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.age = getAge();
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
