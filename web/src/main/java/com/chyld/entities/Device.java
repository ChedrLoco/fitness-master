package com.chyld.entities;

import com.chyld.enums.CategoryEnum;
import com.chyld.enums.ProductEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "devices")
@Data
public class Device {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;

    @Column(name="serial_number", nullable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Fitbit', 'Surge')")
    private ProductEnum product;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Running', 'Swimming', 'Biking')")
    private CategoryEnum category;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private List<Run> runs;


    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ProductEnum getProduct() {
        return product;
    }

    public void setProduct(ProductEnum product) {
        this.product = product;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Deeeeeeeevice";
    }
}
