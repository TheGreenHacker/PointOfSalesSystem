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

import java.io.File;
import java.util.Random;

class AddressGenerator {
    private static final AddressGenerator ourInstance = new AddressGenerator();
    private final Random random;

    private DeliveryAddress[] addresses;

    private int getIndex() {
        return random.nextInt(100);
    }

    static AddressGenerator getInstance() {
        return ourInstance;
    }

    private AddressGenerator() {
        final String DATAFILE = "src/main/resources/data/addresses.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper = new ObjectMapper();
        try {
            addresses = mapper.readValue(new File(DATAFILE), DeliveryAddress[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    DeliveryAddress getNextAddress() {
        return addresses[getIndex()];
    }
}
