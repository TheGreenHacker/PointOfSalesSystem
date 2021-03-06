/*
 * THIS FILE WAS MODIFIED FROM ITS ORIGINAL VERSION BY Jack Li
 * FOR Point of Sale System. THE ORIGINAL LICENSE IS STATED BELOW.

 * Copyright (c) 2018. Prashant Kumar Pandey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.jack.li.kafka.projects.datagenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.li.kafka.projects.types.DeliveryAddress;
import com.jack.li.kafka.projects.types.LineItem;
import com.jack.li.kafka.projects.types.POSInvoice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceGenerator {
    private static InvoiceGenerator ourInstance = new InvoiceGenerator();
    private final Random invoiceIndex;
    private final Random invoiceNumber;
    private final Random numberOfItems;
    private final POSInvoice[] invoices;


    public static InvoiceGenerator getInstance() {
        return ourInstance;
    }

    private InvoiceGenerator() {
        String DATAFILE = "src/main/resources/data/invoices.json";
        ObjectMapper mapper;
        invoiceIndex = new Random();
        invoiceNumber = new Random();
        numberOfItems = new Random();
        mapper = new ObjectMapper();
        try {
            invoices = mapper.readValue(new File(DATAFILE), POSInvoice[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return invoiceIndex.nextInt(100);
    }

    private int getNewInvoiceNumber() {
        return invoiceNumber.nextInt(99999999) + 99999;
    }

    private int getNoOfItems() {
        return numberOfItems.nextInt(4) + 1;
    }

    public POSInvoice getNextInvoice() {
        POSInvoice invoice = invoices[getIndex()];
        invoice.setInvoiceNumber(getNewInvoiceNumber());
        invoice.setCreatedTime(System.currentTimeMillis());
        if ("HOME-DELIVERY".equalsIgnoreCase(invoice.getDeliveryType())) {
            DeliveryAddress deliveryAddress = AddressGenerator.getInstance().getNextAddress();
            invoice.setDeliveryAddress(deliveryAddress);
        }
        int itemCount = getNoOfItems();
        Double totalAmount = 0.0;
        List<LineItem> items = new ArrayList<>();
        ProductGenerator productGenerator = ProductGenerator.getInstance();
        for (int i = 0; i < itemCount; i++) {
            LineItem item = productGenerator.getNextProduct();
            totalAmount = totalAmount + item.getTotalValue();
            items.add(item);
        }
        invoice.setNumberOfItems(itemCount);
        invoice.setInvoiceLineItems(items);
        invoice.setTotalAmount(totalAmount);
        invoice.setTaxableAmount(totalAmount);
        invoice.setCGST(totalAmount * 0.025);
        invoice.setSGCT(totalAmount * 0.025);
        invoice.setCESS(totalAmount * 0.00125);
        return invoice;
    }
}

