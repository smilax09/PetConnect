package com.example.petconnect;

public class Pet {
    private String petImage; // Resource ID for the pet's image
    private String name;
    private String gender;
    private String breed;

    private String vaccination;
    private String allergies;
    private String location;

    private String about;

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Pet() {
    }

    public Pet(String petImage, String name, String gender, String breed, String vaccination, String allergies, String location, String about) {
        this.petImage = petImage;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.vaccination = vaccination;
        this.allergies = allergies;
        this.location = location;
        this.about = about;
    }

    public Pet(String petImage, String name, String gender, String breed) {
        this.petImage = petImage;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
    }

    public String getPetImage() {
        return petImage;
    }

    public void setPetImage(String petImage) {
        this.petImage = petImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
