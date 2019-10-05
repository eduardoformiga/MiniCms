package br.com.eduardoformiga.minicms.model;

import br.com.eduardoformiga.minicms.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(Include.NON_NULL)
	private Long id;

    @Column
	@NotBlank
    @JsonInclude(Include.NON_NULL)
	private String name;

    @Column
    @Enumerated
    @JsonInclude(Include.NON_NULL)
    private Gender gender;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(Include.NON_NULL)
    private LocalDate birthday;

    @Transient
    @JsonInclude(Include.NON_NULL)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonInclude(Include.NON_NULL)
    private City city;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return DateUtils.calculateAge(birthday);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}