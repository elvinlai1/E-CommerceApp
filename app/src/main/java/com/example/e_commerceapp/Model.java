package com.example.e_commerceapp;

import java.util.Comparator;

public class Model {

    private String title,description;
    private int img;
    String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String title) {
        this.price = price;
    }

    public static final Comparator<Model> By_TITLE_ASCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };
    public static final Comparator<Model> By_TITLE_DESCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    };


}

