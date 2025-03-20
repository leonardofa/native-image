package br.com.leonardo.estudos.springbootgraalvm.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
}
