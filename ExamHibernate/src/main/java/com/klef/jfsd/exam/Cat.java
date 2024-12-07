package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal
{
 @Column(name = "ccolor",length = 30)	
 private String color;
 @Column(name = "abreed",length = 30)
 private String breed;
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
}
