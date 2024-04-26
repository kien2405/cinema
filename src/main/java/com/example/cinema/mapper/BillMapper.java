package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.BillDTO;
import com.example.ThucTapLTS.dto.BillFoodDTO;
import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class BillMapper {
    @Autowired
    private BillStatusRepository billStatusRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillTicketMapper billTicketMapper;

    @Autowired
    private BillFoodMapper billFoodMapper;

    public BillDTO toDTO (BillEntity billEntity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BillDTO billDTO = new BillDTO();
        billDTO.setName(billEntity.getName());
        billDTO.setTotalMoney(billEntity.getTotalMoney());
        billDTO.setTradingCode(billEntity.getTradingCode());
        if (billEntity.getCreateTime() != null) {
            billDTO.setCreateTime(billEntity.getCreateTime().format(formatter));
        }
        if (billEntity.getUpdateTime() != null) {
            billDTO.setUpdateTime(billEntity.getCreateTime().format(formatter));
        }
        billDTO.setActive(billEntity.isActive());
        billDTO.setBillStatusId(billEntity.getBillStatusEntity().getId());
        billDTO.setPromotionId(billEntity.getPromotionEntity().getId());
        billDTO.setCustomerId(billEntity.getUserEntity().getId());
        BillFoodMapper billFoodMapper = new BillFoodMapper();
        billDTO.setBillFoodDTOList(billFoodMapper.toDTOList(billEntity.getBillFoodEntityList()));
        BillTicketMapper billTicketMapper = new BillTicketMapper();
        billDTO.setBillTicketDTOList(billTicketMapper.toDTOList(billEntity.getBillTicketEntityList()));
        return billDTO;
    }

    public BillEntity toEntity (BillDTO billDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BillEntity billEntity = new BillEntity();
        billEntity.setName(billDTO.getName());
        billEntity.setTotalMoney(billDTO.getTotalMoney());
        billEntity.setTradingCode(billDTO.getTradingCode());
        if (billDTO.getCreateTime() != null) {
            LocalDateTime date = LocalDateTime.parse(billDTO.getCreateTime(), formatter);
            billEntity.setCreateTime(date);
        }
        if (billDTO.getUpdateTime() != null) {
            LocalDateTime date = LocalDateTime.parse(billDTO.getUpdateTime(), formatter);
            billEntity.setUpdateTime(date);
        }
        billEntity.setActive(billDTO.isActive());
        Optional<BillStatusEntity> billStatusEntityOptional = billStatusRepository.findById(billDTO.getBillStatusId());
        BillStatusEntity billStatusEntity = new BillStatusEntity();
        if (billStatusEntityOptional.isPresent()) {
            billStatusEntity = billStatusEntityOptional.get();
        }
        billEntity.setBillStatusEntity(billStatusEntity);

        Optional<PromotionEntity> promotionEntityOptional = promotionRepository.findById(billDTO.getPromotionId());
        PromotionEntity promotionEntity = new PromotionEntity();
        if (promotionEntityOptional.isPresent()) {
            promotionEntity = promotionEntityOptional.get();
        }
        billEntity.setPromotionEntity(promotionEntity);

        Optional<UserEntity> userEntityOptional = userRepository.findById(billDTO.getCustomerId());
        UserEntity userEntity = new UserEntity();
        if (userEntityOptional.isPresent()) {
            userEntity = userEntityOptional.get();
        }
        billEntity.setUserEntity(userEntity);
        try {
            billEntity.setBillFoodEntityList(billFoodMapper.toEntityList(billDTO.getBillFoodDTOList()));
        } catch (Exception e) {

        }
        try {
            billEntity.setBillTicketEntityList(billTicketMapper.toEntityList(billDTO.getBillTicketDTOList()));
        } catch (Exception e) {

        }
        return billEntity;
    }
}
