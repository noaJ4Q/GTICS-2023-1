package com.example.clase.Entities.DB;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private int id;
    @Column(name = "ProductName", nullable = false, length = 40)
    private String productName;
    @Column(name = "SupplierID")
    private int supplierId;
    @Column(name = "CategoryID")
    private int categoryId;
    @Column(name = "QuantityPerUnit",length = 20)
    private String quantityPerUnit;
    @Column(name = "UnitPrice")
    private float unitPrice;
    @Column(name = "UnitsInStock")
    private int unitsInStock;
    @Column(name = "UnitsOnOrder")
    private int unitsOnOrder;
    @Column(name = "ReorderLevel", nullable = false)
    private int reorderLevel;
    @Column(name = "Discontinued")
    private int discontinued;
}
