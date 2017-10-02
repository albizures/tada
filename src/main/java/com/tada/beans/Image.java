package com.tada.beans;

public class Image {
    private int idImage;
    private String url;

    public Image () {
    }
    
    public Image(int idImage, String url) {
        this.idImage = idImage;
        this.url = url;
    }
    
    public Image(String url) {
        this.url = url;
    }
    
    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" + "idImage=" + idImage + ", url=" + url + '}';
    }
    
}
