package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountingMapper {
    @Mappings({
            @Mapping(target = "expenseIds", source = "expenses", qualifiedByName = "idList"),
            @Mapping(target = "revenueIds", source = "revenues", qualifiedByName = "idList"),
            @Mapping(target = "refundIds", source = "refunds", qualifiedByName = "idList")
    })
    AccountingDTO accountingToAccountingDTO(Accounting accounting);

    Accounting accountingDTOToAccounting(AccountingDTO dto);

    @Named("idList")
    default List<Long> idList(List<? extends Identifiable> identifiableEntities) {
        if (identifiableEntities == null) {
            return null;
        }
        return identifiableEntities.stream()
                .map(Identifiable::getId)
                .collect(Collectors.toList());
    }
}
