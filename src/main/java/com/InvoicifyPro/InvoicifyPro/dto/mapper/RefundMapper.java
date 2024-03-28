package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RefundMapper {

    @Mappings(
            @Mapping(source = "accounting.id", target = "accountingId")
    )
    public RefundDTO refundToRefundDTO(Refund refund);

    public Refund refundDTOToRefund(RefundDTO dto);


}
