package com.codepathway.api.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String slug;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Sheet> sheets = new ArrayList<>();

    public Category() {}
    public Category(String name, String description, String slug) {this.name = name; this.description = description; this.slug = slug;}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSlug() {return slug;}
    public void setSlug(String slug) {this.slug = slug;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public List<Sheet> getSheets() {return sheets;}
    public void setSheets(List<Sheet> sheets) {this.sheets = sheets;}
}
