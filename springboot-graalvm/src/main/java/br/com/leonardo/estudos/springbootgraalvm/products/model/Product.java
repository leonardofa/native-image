package br.com.leonardo.estudos.springbootgraalvm.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document(collection = "products")
@Entity
@Data
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
