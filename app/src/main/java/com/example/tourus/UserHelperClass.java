package com.example.tourus;

public class UserHelperClass {

    private static String name, genre, email, bio,  phone, price;

    public UserHelperClass(){
    }

    public UserHelperClass(String name, String genre, String email, String bio, String phone, String price) {
        this.name = name;
        this.genre = genre;
        this.email = email;
        this.bio = bio;
        this.phone = phone;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
