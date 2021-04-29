/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Blog {
    private int id;
    private String category;
    private String title;
    private Date timerelease;
    private String content;
    private String shortdes;
    private String image;

    public Blog() {
    }

    public Blog(int id, String category, String title, Date timerelease, String content, String shortdes, String image) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.timerelease = timerelease;
        this.content = content;
        this.shortdes = shortdes;
        this.image = image;
    }

    public String convertDate(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM dd, yyyy");
        String date=dateFormat.format(this.timerelease);
        return date;
    }
    public String getShortdes() {
        return shortdes;
    }

    public void setShortdes(String shortdes) {
        this.shortdes = shortdes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimerelease() {
        return timerelease;
    }

    public void setTimerelease(Date timerelease) {
        this.timerelease = timerelease;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id + "\t" + category + "\t" + title + "\t" + timerelease + "\t" + content + "\t" + shortdes + "\t" + image;
    }


    
}
