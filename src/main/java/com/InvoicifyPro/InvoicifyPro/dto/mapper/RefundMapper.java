package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Refund;
import jakarta.persistence.Id;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RefundMapper {

    @Mappings(
            @Mapping(source = "clients", target = "clientsId", qualifiedByName = "idList")
    )
    public RefundDTO refundToDTO(Refund refund);

    public Refund refundDTOToRefund(RefundDTO dto);

    @Named("idList")
    default List<Long> idList(List<? extends Identifiable> identifiableEntities){
        if(identifiableEntities == null){
            return null;
        }

        return identifiableEntities.stream().map(Identifiable :: getId).collect(Collectors.toList());

    };


}
