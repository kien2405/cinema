package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.BillFoodDTO;
import com.example.ThucTapLTS.dto.FoodDTO;
import com.example.ThucTapLTS.entity.BillEntity;
import com.example.ThucTapLTS.entity.BillFoodEntity;
import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.FoodEntity;
import com.example.ThucTapLTS.repository.BillRepository;
import com.example.ThucTapLTS.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BillFoodMapper {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private FoodRepository foodRepository;

    public BillFoodDTO toDTO (BillFoodEntity billFoodEntity){
        BillFoodDTO billFoodDTO = new BillFoodDTO();
        billFoodDTO.setQuantity(billFoodEntity.getQuantity());
        billFoodDTO.setBillId(billFoodEntity.getBillEntity().getId());
        billFoodDTO.setFoodId(billFoodEntity.getFoodEntity().getId());
        return billFoodDTO;
    }

    public BillFoodEntity toEntity (BillFoodDTO billFoodDTO){
        BillFoodEntity billFoodEntity = new BillFoodEntity();
        billFoodEntity.setQuantity(billFoodDTO.getQuantity());
        try {
            Optional<BillEntity> billEntityOptional = billRepository.findById(billFoodDTO.getBillId());
            BillEntity billEntity = new BillEntity();
            if (billEntityOptional.isPresent()) {
                billEntity = billEntityOptional.get();
            }
            billFoodEntity.setBillEntity(billEntity);
        } catch (Exception ex) {
        }
        try {
            Optional<FoodEntity> foodEntityOptional = foodRepository.findById(billFoodDTO.getFoodId());
            FoodEntity foodEntity = new FoodEntity();
            if (foodEntityOptional.isPresent()) {
                foodEntity = foodEntityOptional.get();
            }
            billFoodEntity.setFoodEntity(foodEntity);
        } catch (Exception ex) {

        }
        return billFoodEntity;
    }

    public List<BillFoodDTO> toDTOList (List<BillFoodEntity> billFoodEntityList){
        List<BillFoodDTO> billFoodDTOList = new ArrayList<>();
        for (BillFoodEntity data : billFoodEntityList) {
            BillFoodDTO billFoodDTO = new BillFoodDTO();
            billFoodDTO.setQuantity(data.getQuantity());
            billFoodDTO.setBillId(data.getBillEntity().getId());
            billFoodDTO.setFoodId(data.getFoodEntity().getId());
            billFoodDTOList.add(billFoodDTO);
        }
        return billFoodDTOList;
    }

    public List<BillFoodEntity> toEntityList (List<BillFoodDTO> billFoodDTOList){
        List<BillFoodEntity> billFoodEntityList = new ArrayList<>();
        for (BillFoodDTO data : billFoodDTOList) {
            BillFoodEntity billFoodEntity = new BillFoodEntity();
            billFoodEntity.setQuantity(data.getQuantity());
            try {
                Optional<BillEntity> billEntityOptional = billRepository.findById(data.getBillId());
                BillEntity billEntity = new BillEntity();
                if (billEntityOptional.isPresent()) {
                    billEntity = billEntityOptional.get();
                }
                billFoodEntity.setBillEntity(billEntity);
            } catch (Exception ex) {
            }
            try {
                Optional<FoodEntity> foodEntityOptional = foodRepository.findById(data.getFoodId());
                FoodEntity foodEntity = new FoodEntity();
                if (foodEntityOptional.isPresent()) {
                    foodEntity = foodEntityOptional.get();
                }
                billFoodEntity.setFoodEntity(foodEntity);
            } catch (Exception ex) {

            }
            billFoodEntityList.add(billFoodEntity);
        }
        return billFoodEntityList;
    }
}
