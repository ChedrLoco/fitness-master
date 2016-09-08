package com.chyld.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "positions")
@Data
public class Position implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;


    private float latitude;

    private float longitude;

    private float altitude;
    @CreationTimestamp
    @Column(nullable=false)
    private Timestamp current;

    @ManyToOne
    @JoinColumn(name="run_id")
    private Run run;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public Timestamp getCurrent() {
        return current;
    }

    public void setCurrent(Timestamp current) {
        this.current = current;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    @Override
    public String toString() {
        return "Poooooooosition";
    }
}
