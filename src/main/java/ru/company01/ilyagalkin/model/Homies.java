package ru.company01.ilyagalkin.model;

import javax.persistence.*;

@Entity
@Table(name = "homies")
public class Homies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "type", length = 20)
	private String type;

	@Column(name = "\"birthDate\"", length = 80)
	private String birthDate;

	@Column(name = "gender", length = 20)
	private String gender;

	@Column(name = "name", nullable = false, length = 100)
	private String name;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	   public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String email) {
		this.gender = gender;
	}


    public String getName() {
		return name;
	}

	public void setName(String email) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "Homies{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}