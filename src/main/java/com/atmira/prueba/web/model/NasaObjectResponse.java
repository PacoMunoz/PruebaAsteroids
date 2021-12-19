package com.atmira.prueba.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class NasaObjectResponse {
    private Links links;
    private Integer element_count;
    private List near_earth_objects;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getElement_count() {
        return element_count;
    }

    public void setElement_count(Integer element_count) {
        this.element_count = element_count;
    }

    public List getNear_earth_objects() {
        return near_earth_objects;
    }

    public void setNear_earth_objects(List near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
}
