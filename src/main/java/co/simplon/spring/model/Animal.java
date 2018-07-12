package co.simplon.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Animal")
@NamedQueries({ @NamedQuery(name = "Animal.findAll", query = " SELECT a FROM Animal a ORDER BY a.name ") })
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "espece", nullable = false, length = 255)
	private String espece;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "age", nullable = false, length = 3)
	private int age;

	public Animal() {
	}

	public Animal(String espece, String name, int age) {
		this.espece = espece;
		this.name = name;
		this.age = age;
	}

	public Animal(Long id, String espece, String name, int age) {
		this.id = id;
		this.espece = espece;
		this.name = name;
		this.age = age;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

}
