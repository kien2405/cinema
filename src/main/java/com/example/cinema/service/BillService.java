package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.repository.BillFoodRepository;
import com.example.ThucTapLTS.repository.BillRepository;
import com.example.ThucTapLTS.repository.BillTicketRepository;
import com.example.ThucTapLTS.service.imp.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillService implements BillServiceImp {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillFoodRepository billFoodRepository;

    @Autowired
    private BillTicketRepository billTicketRepository;

    @Override
    public void addBill(BillEntity billEntity) {
        double allPriceFood = 0;
        double allPriceTicket = 0;
        billRepository.save(billEntity);
        for (BillTicketEntity billTicketEntity : billEntity.getBillTicketEntityList()) {
            billTicketEntity.setBillEntity(billEntity);
            billTicketRepository.save(billTicketEntity);
            allPriceTicket += billTicketEntity.getTicketEntity().getPriceTicket() * billTicketEntity.getQuantity();
        }
        for (BillFoodEntity billFoodEntity : billEntity.getBillFoodEntityList()) {
            billFoodEntity.setBillEntity(billEntity);
            billFoodRepository.save(billFoodEntity);
            allPriceFood += billFoodEntity.getFoodEntity().getPrice() * billFoodEntity.getQuantity();
        }
        double totalMoney = ((allPriceTicket + allPriceFood) * (100 - billEntity.getPromotionEntity().getPercent())) / 100;
        billEntity.setTotalMoney(totalMoney);
        billEntity.setCreateTime(LocalDateTime.now());
        billRepository.save(billEntity);
    }
}
