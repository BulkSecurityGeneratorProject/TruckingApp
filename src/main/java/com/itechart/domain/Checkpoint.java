package com.itechart.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author blink7
 * @version 1.0
 * @since 2017-11-15
 */
@Entity
@Table(name = "checkpoints")
public class Checkpoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcheckpoints")
    private int id;

    @Column(name = "checkpoint_name")
    private String name;

    @Column(name = "checkpoint_lat")
    private String lat;

    @Column(name = "checkpoint_lng")
    private String lng;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Checkpoint that = (Checkpoint) o;

        return name.equals(that.name) && lat.equals(that.lat) && lng.equals(that.lng);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lat.hashCode();
        result = 31 * result + lng.hashCode();
        return result;
    }
}
