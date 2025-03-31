package br.com.leonardo.estudos.springbootgraalvm.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    private UUID id;
    @NotNull
    @Column
    private String sku;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private BigDecimal price;
    @NotNull
    @Column
    private String currencyCode;
    @NotNull
    @Column
    private int stock;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }


}
