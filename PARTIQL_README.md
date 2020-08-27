# QLDB example explanation

## Partiql examples

[partiql-reference](https://docs.aws.amazon.com/qldb/latest/developerguide/ql-reference.html)

### Table

```bash
CREATE TABLE tableName
```

[working create](https://docs.aws.amazon.com/qldb/latest/developerguide/working.create.html)

### Index

"The best practice is to run queries that filter on a document id or an indexed field."

```bash
CREATE INDEX ON tableName (indexAttribute)
```

### Insert

```bash
INSERT INTO tableName VALUE {'name': "John Doe", 'age': 38}
```

### Update

[update](https://docs.aws.amazon.com/qldb/latest/developerguide/ql-reference.update.html)

```bash
UPDATE Person AS p
SET p = {
    'FirstName' : 'Rosemarie',
    'LastName' : 'Holloway',
    'DOB' : `1977-06-18T`,
    'GovId' : 'LEWISR261LL',
    'GovIdType' : 'Driver License',
    'Address' : '4637 Melrose Street, Ellensburg, WA, 98926'
}
WHERE p.FirstName = 'Rosemarie' AND p.LastName = 'Holloway'
```

### Drop Undrop

[manage tables](https://docs.aws.amazon.com/qldb/latest/developerguide/working.manage-tables.html)

```bash
DROP TABLE tableName
UNDROP TABLE tableId
```

### Select

[select](https://docs.aws.amazon.com/qldb/latest/developerguide/ql-reference.select.html)

```bash
SELECT * FROM Vehicle
```

```bash
SELECT *
FROM DriversLicense AS d
INNER JOIN Person AS p
BY pid
ON d.PersonId = pid
WHERE pid = 'documentId'
```
