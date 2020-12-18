package com.ds.novlag.data;

public class MyListData {

    private int imgId;
    private String titre;
    private String description;

    public MyListData(int imgId, String titre, String description) {
        this.imgId = imgId;
        this.titre = titre;
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
