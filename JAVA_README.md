# Java examples

[java-tutorial](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.tutorial.html)

## Create ledger

[create ledger](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.step-1.html)

```java
    /**
     * Create a new ledger with the specified ledger name.
     *
     * @param ledgerName Name of the ledger to be created.
     * @return {@link CreateLedgerResult} from QLDB.
     */
    public static CreateLedgerResult create(final String ledgerName) {
        log.info("Let's create the ledger with name: {}...", ledgerName);
        CreateLedgerRequest request = new CreateLedgerRequest()
                .withName(ledgerName)
                .withPermissionsMode(PermissionsMode.ALLOW_ALL);
        CreateLedgerResult result = client.createLedger(request);
        log.info("Success. Ledger state: {}.", result.getState());
        return result;
    }
```

## Create table

[create table](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.step-3.html)

```java
    /**
     * Registrations, vehicles, owners, and licenses tables being created in a single transaction.
     *
     * @param txn
     *              The {@link TransactionExecutor} for lambda execute.
     * @param tableName
     *              Name of the table to be created.
     * @return the number of tables created.
     */
    public static int createTable(final TransactionExecutor txn, final String tableName) {
        log.info("Creating the '{}' table...", tableName);
        final String createTable = String.format("CREATE TABLE %s", tableName);
        final Result result = txn.execute(createTable);
        log.info("{} table created successfully.", tableName);
        return SampleData.toIonValues(result).size();
    }
```

## Create index

[create index](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.step-3.html)

```java
    /**
     * In this example, create indexes for registrations and vehicles tables.
     *
     * @param txn
     *              The {@link TransactionExecutor} for lambda execute.
     * @param tableName
     *              Name of the table to be created.
     * @param indexAttribute
     *              The index attribute to use.
     * @return the number of tables created.
     */
    public static int createIndex(final TransactionExecutor txn, final String tableName, final String indexAttribute) {
        log.info("Creating an index on {}...", indexAttribute);
        final String createIndex = String.format("CREATE INDEX ON %s (%s)", tableName, indexAttribute);
        final Result r = txn.execute(createIndex);
        return SampleData.toIonValues(r).size();
    }
```

## Update table

[update table](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.step-5.html)

```java
    /**
     * Update the primary owner for a vehicle registration with the given documentId.
     *
     * @param txn
     *              The {@link TransactionExecutor} for lambda execute.
     * @param vin
     *              Unique VIN for a vehicle.
     * @param documentId
     *              New PersonId for the primary owner.
     * @throws IllegalStateException if no vehicle registration was found using the given document ID and VIN, or if failed
     * to convert parameters into {@link IonValue}.
     */
    public static void updateVehicleRegistration(final TransactionExecutor txn, final String vin, final String documentId) {
        try {
            log.info("Updating primary owner for vehicle with Vin: {}...", vin);
            final String query = "UPDATE VehicleRegistration AS v SET v.Owners.PrimaryOwner = ? WHERE v.VIN = ?";

            final List<IonValue> parameters = new ArrayList<>();
            parameters.add(Constants.MAPPER.writeValueAsIonValue(new Owner(documentId)));
            parameters.add(Constants.MAPPER.writeValueAsIonValue(vin));

            Result result = txn.execute(query, parameters);
            ScanTable.printDocuments(result);
            if (result.isEmpty()) {
                throw new IllegalStateException("Unable to transfer vehicle, could not find registration.");
            } else {
                log.info("Successfully transferred vehicle with VIN '{}' to new owner.", vin);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        }
    }
```

## Query table

[select](https://docs.aws.amazon.com/qldb/latest/developerguide/getting-started.java.step-4.html)

```java
    /**
     * Scan the table with the given {@code tableName} for all documents.
     *
     * @param txn
     *              The {@link TransactionExecutor} for lambda execute.
     * @param tableName
     *              Name of the table to scan.
     * @return a list of documents in {@link IonStruct} .
     */
    public static List<IonStruct> scanTableForDocuments(final TransactionExecutor txn, final String tableName) {
        log.info("Scanning '{}'...", tableName);
        final String scanTable = String.format("SELECT * FROM %s", tableName);
        List<IonStruct> documents = toIonStructs(txn.execute(scanTable));
        log.info("Scan successful!");
        printDocuments(documents);
        return documents;
    }
```
