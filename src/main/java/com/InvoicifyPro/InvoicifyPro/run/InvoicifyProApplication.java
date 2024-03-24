package com.InvoicifyPro.InvoicifyPro.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.InvoicifyPro.InvoicifyPro.repositories")
@ComponentScan({"com.InvoicifyPro.InvoicifyPro.controller", "com.InvoicifyPro.InvoicifyPro.service", "com.InvoicifyPro.InvoicifyPro.dto.dtoEntite", "com.InvoicifyPro.InvoicifyPro.dto.mapper", "com.InvoicifyPro.InvoicifyPro.event"})
@EntityScan(basePackages = {"com.InvoicifyPro.InvoicifyPro.entity"})
public class InvoicifyProApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoicifyProApplication.class, args);
    }

}
