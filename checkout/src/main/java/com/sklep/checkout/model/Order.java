package com.sklep.checkout.model;

public class Order {

    private long _routeId;
    private String email;
    private String phone;
    private String name;
    private String notes;
    private String date;

    public long getRouteId() {
        return _routeId;
    }

    public void setRouteId(long _routeId) {
        this._routeId = _routeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
