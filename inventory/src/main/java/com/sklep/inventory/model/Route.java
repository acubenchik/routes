package com.sklep.inventory.model;

import javax.persistence.Entity;

@Entity
public class Route extends AbstractRoute {

    public Route() {
    }

    private String length;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
