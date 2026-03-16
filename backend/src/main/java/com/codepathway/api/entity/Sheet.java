package com.codepathway.api.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sheets")
public class Sheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String slug;
    private String description;
    private String difficulty;
    private boolean premium;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList<>();

    public Sheet() {}
    public Sheet(String title, String slug, String description, String difficulty, boolean premium) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.difficulty = difficulty;
        this.premium = premium;
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
    public boolean isPremium() {return premium;}
    public void setPremium(boolean premium) {this.premium = premium;}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
    public List<Topic> getTopics() {return topics;}
    public void setTopics(List<Topic> topics) {this.topics = topics;}
}
