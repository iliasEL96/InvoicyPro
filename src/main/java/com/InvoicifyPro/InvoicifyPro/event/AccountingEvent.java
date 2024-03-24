package com.InvoicifyPro.InvoicifyPro.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class AccountingEvent<T> {

    private LocalDate date;
    private T entity;

    public AccountingEvent(LocalDate date, T entity) {
        this.date = date;
        this.entity = entity;
    }
}
