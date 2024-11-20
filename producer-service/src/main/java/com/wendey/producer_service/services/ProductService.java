package com.wendey.producer_service.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import dtos.ProductDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static constants.RabbitMQConstants.RK_PRODUCT_LOG;
import static constants.RabbitMQConstants.EXG_NAME_MARKETPLACE;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto){
        log.info("Sending a message to exchange "+ dto.toString());
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, dto);

    }

    
}
