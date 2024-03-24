package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Revenue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RevenueMapper {

    @Mapping(source = "orderDetails.id" , target = "orderId")
    @Mapping(source = "accounting.id" , target = "accountingId")
    public RevenueDTO revenueToRevenueDTO(Revenue revenue);

    public Revenue revenueDTOToRevenu (RevenueDTO dto);


}
