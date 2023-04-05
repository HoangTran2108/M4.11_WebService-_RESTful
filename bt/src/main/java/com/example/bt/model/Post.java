package com.example.bt.model;

import javax.persistence.*;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    private String pName;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    public Post() {
    }

    public Post(Long pId, String pName, Category category) {
        this.pId = pId;
        this.pName = pName;
        this.category = category;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
