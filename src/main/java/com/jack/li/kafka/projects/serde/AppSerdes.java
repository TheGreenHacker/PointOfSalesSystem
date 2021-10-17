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

package com.jack.li.kafka.projects.serde;

import com.jack.li.kafka.projects.types.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class AppSerdes extends Serdes {
    /* POSInvoice */
    static public final class PosInvoiceSerde extends WrapperSerde<POSInvoice> {
        public PosInvoiceSerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<POSInvoice> PosInvoice() {
        PosInvoiceSerde serde =  new PosInvoiceSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, POSInvoice.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    /* DeliveryAddress */
    static public final class DeliveryAddressSerde extends WrapperSerde<DeliveryAddress> {
        public DeliveryAddressSerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<DeliveryAddress> DeliveryAddress() {
        DeliveryAddressSerde serde =  new DeliveryAddressSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, DeliveryAddress.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    /* Invoice */
    static public final class InvoiceSerde extends WrapperSerde<Invoice> {
        public InvoiceSerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<Invoice> Invoice() {
        InvoiceSerde serde =  new InvoiceSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, Invoice.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    /* LineItem */
    static public final class LineItemSerde extends WrapperSerde<LineItem> {
        public LineItemSerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<LineItem> LineItem() {
        LineItemSerde serde =  new LineItemSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, Invoice.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    /* Loyalty */
    static public final class LoyaltySerde extends WrapperSerde<Loyalty> {
        public LoyaltySerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<Loyalty> Loyalty() {
        LoyaltySerde serde =  new LoyaltySerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, Invoice.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    /* HadoopRecord */
    static public final class HadoopRecordSerde extends WrapperSerde<HadoopRecord> {
        public HadoopRecordSerde() {
            super(new JSONSerializer<>(), new JSONDeserializer<>());
        }
    }

    static public Serde<HadoopRecord> HadoopRecord() {
        HadoopRecordSerde serde =  new HadoopRecordSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JSONDeserializer.VALUE_CLASS_NAME_CONFIG, Invoice.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }
}
