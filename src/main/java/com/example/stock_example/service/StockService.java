package com.example.stock_example.service;

import com.example.stock_example.domain.Stock;
import com.example.stock_example.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public void decrease(Long stockId, Long quantity) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("not found Entity"));

        stock.decrease(quantity);
    }
}
