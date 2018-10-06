package com.piotrek.login.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medicine_id")
    private long id;
    @NotEmpty(message = "*Please provide name of medicine")
    private String name;
    private String producer;
    @Min(1)
    @NotNull(message = "*Please provide price*")
    private double price;
    private boolean hasRecipe;
    private Date termOfValidaty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasRecipe() {
        return hasRecipe;
    }

    public void setHasRecipe(boolean hasRecipe) {
        this.hasRecipe = hasRecipe;
    }

    public Date getTermOfValidaty() {
        return termOfValidaty;
    }

    public void setTermOfValidaty(Date termOfValidaty) {
        this.termOfValidaty = termOfValidaty;
    }
}
