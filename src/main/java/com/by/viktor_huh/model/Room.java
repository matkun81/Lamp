package com.by.viktor_huh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean light;

    public Room() {
        this.light = true;
    }

    public Room(boolean light) {
        this.light = light;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", light=" + light +
                '}';
    }
}
