package com.codepathway.api.dto;

public class SheetDto {
    private Long id;
    private String title;
    private String slug;
    private String description;
    private String difficulty;
    private boolean premium;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getSlug() {return slug;}
    public void setSlug(String slug) {this.slug = slug;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getDifficulty() {return difficulty;}
    public void setDifficulty(String difficulty) {this.difficulty = difficulty;}
    public boolean isPremium() {return premium;}
    public void setPremium(boolean premium) {this.premium = premium;}
}
