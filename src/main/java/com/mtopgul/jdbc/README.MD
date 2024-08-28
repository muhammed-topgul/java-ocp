### _JDBC_

---
### `Connecting to a Database`

JDBC içerisinde beş temel arayüz vardır.
1. **Driver**: Vertabanına bağlantı kurar.
2. **Connection**: Veritabanına komut gönderir.
3. **PreparedStatement**: SQL sorgusunu yürütür.
4. **CallableStatement**: Veriabanında bulunan _stored procedure_'leri yürütür.
5. **ResultSet**: Sorgu sonucunu okur.

### Building a JDBC URL

**Figure 15.3** The JDBC URL format

![img.png](../../../../resources/img/figure-15.3.png)

_jdbc:hsqldb:file:zoo_

Bağlantı URL'i üç parçdan oluşur:
1. Protocol ismi olarak _jdbc_ ile başlar.
2. Subprotocol ismi olarak _hsqldb_ gelir.
3. Son olarak subname gelir. Bu örnekte dosya sistemini kullanıldığını ve sonrasında veritabanı isminin (_zoo_) geldiği
   görülür.

Diğer örnekler:

_jdbc:postgresql:**//localhost/zoo**_
_jdbc:oracle:thin:**@123.123.123.123:1521:zoo**_
_jdbc:mysql:**//localhost:3306**_
_jdbc:mysql:**//localhost:3306/zoo?profileSQL=true**_

### Getting a Database Connection

_Connection_ oluşturabilmek için iki yol vardır: **DriverManager** ve **DataSource**. Ama _DriverManager_'i gerçek hayatta
yazdığımız kodlarda kullanmamalıyız. _DataSource_ _DriverManager_'dan çok daha yeteneklidir. Örneğin _connection pool_ 
oluşturabilir veya veritabanı bağlantı bilgilerini uygulama dışında saklayabilir.

```java
public static void main(String[] args) throws SQLException {
    try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
        System.out.println(connection);
    }
}
```

_Output:_
<pre>
org.hsqldb.jdbc.JDBCConnection@4524411f
</pre>

```java
public static void main(String[] args) throws SQLException {
    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zoo_db", "postgres", "postgres")) {
        System.out.println(connection);
    }
}
```
_Output:_
<pre>
org.postgresql.jdbc.PgConnection@52feb982
</pre>

---
### `Working with a PreparedStatement`

**Figure 15.4** Types of statements

![img.png](../../../../resources/img/figure-15.4.png)

SQL'i doğrudan _Statement_ ile çalıştırmak mümkün olsa da, bunu yapmamalısınız. _PreparedStatement_ aşağıda ki nedenlerden 
dolayı çok daha üstündür:

- **Performance**: Çoğu progra benzer sorguları birden fazla kez çalıştırabilir. _PreparedStatement_'i kullandığımızda, 
  veritabanı yazılımı genellikle sorguyu iyi çalıştırmak için bir plan tasarlar ve bunu hatırlar.
- **Security**: _PreparedStatement_'i doğru kullandığımızda bizi _SQL injection_'lara karşı korur. 
- **Readability**: String concat etmek okunabilirliği azaltır.
- **Future use**: Parametre almasa bile _PreparedStatement_ kullanmak daha iyidir.

_Statement_ sınavda yer almıyor.

### Obtaining a PreparedStatement

```java
try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo");
     PreparedStatement ps = connection.prepareStatement("SELECT * FROM exhibits")) {
    System.out.println(ps);
}
```

_Output:_
<pre>
org.hsqldb.jdbc.JDBCPreparedStatement@3bf7ca37[sql=[SELECT * FROM exhibits]]
</pre>

### Executing a PreparedStatement

**Modifying Data with _executeUpdate()_**

Insert, update ve delete işlemleri için kullanılır. Geriye **int** değer döner. Bu değer çalıştırılan sql komutu sonucunda
kaç adet satırın etkilendiği bilgisini döner.

```java
var insertSql = "INSERT INTO exhibits VALUES (10, 'Deer', 3)";
var updateSql = "UPDATE exhibits SET name = '' WHERE name = 'None'";
var deleteSql = "DELETE FROM exhibits WHERE id = 10";
try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
    try (var ps = connection.prepareStatement(insertSql)) {
        int affectedRows = ps.executeUpdate();
        System.out.printf("%d rows affected after insert.\n", affectedRows);
    }
    
    try (var ps = connection.prepareStatement(updateSql)) {
        int affectedRows = ps.executeUpdate();
        System.out.printf("%d rows affected after update.\n", affectedRows);
    }
    
    try (var ps = connection.prepareStatement(deleteSql)) {
        int affectedRows = ps.executeUpdate();
        System.out.printf("%d rows affected after delete.\n", affectedRows);
    }
}
```

_Output:_
<pre>
1 rows affected after insert.
0 rows affected after update.
1 rows affected after delete.
</pre>

**Reading Data with _executeQuery()_**

```java
var selectSql = "SELECT * FROM exhibits";

try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
    try (var ps = connection.prepareStatement(selectSql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println(id + " " + name);
        }
    }
}
```

_Output:_
<pre>
1 African Elephant
2 Zebra
</pre>

**Processing Data with _execute()_**

_executeUpdate()_ ve _executeQuery()_ methodlarının yapmış olduğu işlemleri yapabiliyor. Geriye **boolean** değer döner.
Eğer sonuç **true** ise _ResultSet_ elde edebilir, eğer **false** ise o zaman etkilenen satır sayısını alabiliriz.

```java
public static void main(String[] args) throws SQLException {
    var insertSql = "INSERT INTO exhibits VALUES (3, 'Deer', 3)";
    var selectSql = "SELECT * FROM exhibits";
    try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
        try (var ps = connection.prepareStatement(insertSql)) {
            execute(ps);
        }
        try (var ps = connection.prepareStatement(selectSql)) {
            execute(ps);
        }
    }
}

private static void execute(PreparedStatement ps) throws SQLException {
    boolean isResultSet = ps.execute();
    if (isResultSet) {
        try (ResultSet rs = ps.getResultSet()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(id + " " + name);
            }
        }
    } else {
        int affectedRows = ps.getUpdateCount();
        System.out.printf("%d rows affected.\n", affectedRows);
    }
}
```

_Output:_
<pre>
1 rows affected.
1 African Elephant
2 Zebra
3 Deer
</pre>

**Table 15.3** SQL runnable by the execute method

![img.png](../../../../resources/img/table-15.3.png)

**Table 15.4** Return types of execute methods

![img_1.png](../../../../resources/img/table-15.4.png)


### Working with Parameters