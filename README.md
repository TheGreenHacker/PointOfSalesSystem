# PointOfSalesSystem
Data streaming and analytics project for a fictional company to help manage its customer, services, and inventory data using Java Kafka Client & Streams APIs. 

### Environment SetUp
Must have Apache Kafka installed, with the environment $KAFKA_HOME set to the directory where it resides on the file system. The scripts directory contains configuration to set up the local Kafka cluster with 3 server nodes managed by Zookeeper as well as some scripts linked to useful scripts of $KAFKA_HOME for debugging purposes. 

### Kafka Topics
The following topics are used and created with 3 partitions and replica factor of 3:
* pos: All Point of Sales Invoices 
* valid-pos: Validated Invoices
* shipment: Invoices for delivery orders
* loyalty: Loyalty events for rewarding purchases by Prime customers
* hadoop: Flattened, JSON analytics records with customers' personal info masked 

### Key Classes and Folders (src/main/java/com/jack/li/kafka/projects)
* POSGenerator: Sends randomly generated invoices to the "pos" topic using Producer API. The keys are the store ID and the values are the invoice JSON objects.
* POSValidator: Streams data from "pos" topic and filters out invalidated invoices, which are invoices where the delivery type is "HOME-DELIVERY" but missing the customer's contact number. Writes valid invoices to "valid-pos".
* POSServices: Streams data from "valid-pos" topic and perform some transformations/filtering on the data to send them to appropriate service topics, which are shipment, loyalty, and hadoop. 
* serde/AppSerdes: Customer serializers and de-serializers for project data structures to be used when producing/consuming data.
* datagenerator: Classes to help generate random invoice data. 
* types: Auto-generated POJO's from data schema

### Data resources (src/main/resources)
* data: Folder with starter random JSON data for generated POS Invoices
* schema: JSON files specifying schema of project data structures to be converted to POJO's
