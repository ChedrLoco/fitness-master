package com.chyld.entities;

import com.chyld.enums.ExerciseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "runs")
@Data
public class Run {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;
    @CreationTimestamp
    @Column(name="start_time", nullable = false)
    private Date startTime;
    @Column(name="stop_time", nullable = true)
    private Date stopTime;

    @ManyToOne
    @JoinColumn(name="device_id")
    private Device device;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "run")
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
