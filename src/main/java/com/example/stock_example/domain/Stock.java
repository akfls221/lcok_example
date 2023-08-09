package com.example.stock_example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;

@Getter
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;

    public Stock(Long id, Long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Stock() {
    }

    public void decrease(Long quantity) {
        if (this.quantity  - quantity < 0) {
            throw new IllegalArgumentException("재고는 0이될 수  없습니다.");
        }

        this.quantity -= quantity;
    }
}

