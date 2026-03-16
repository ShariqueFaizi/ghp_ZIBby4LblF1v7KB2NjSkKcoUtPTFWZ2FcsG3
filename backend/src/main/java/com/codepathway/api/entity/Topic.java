package com.codepathway.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String slug;
    @Column(length = 1500)
    private String description;
    private String difficulty;
    private int orderIndex;
    @ManyToOne
    @JoinColumn(name = "sheet_id")
    private Sheet sheet;
    public Topic() {}
    public Topic(String title, String slug, String description, String difficulty, int orderIndex) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.difficulty = difficulty;
        this.orderIndex = orderIndex;
    }
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
    public int getOrderIndex() {return orderIndex;}
    public void setOrderIndex(int orderIndex) {this.orderIndex = orderIndex;}
    public Sheet getSheet() {return sheet;}
    public void setSheet(Sheet sheet) {this.sheet = sheet;}
}
