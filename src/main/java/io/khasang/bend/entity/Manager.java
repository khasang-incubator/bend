package io.khasang.bend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manager_id")
    private long id;
    private String publicContacts;
    private String contactTime;
    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicContacts() {
        return publicContacts;
    }

    public void setPublicContacts(String publicContacts) {
        this.publicContacts = publicContacts;
    }

    public String getContactTime() {
        return contactTime;
    }

    public void setContactTime(String contactTime) {
        this.contactTime = contactTime;
    }
}