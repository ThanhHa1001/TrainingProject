MySQL
----

1. JDBC connection

- Step1: Register JDBC driver

` Class.forName('com.mysql.cj.jdbc.Driver');`

- Step2: Open a connection

`Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");`

- Step3: Execute query

`Statement stmt = conn.createStatement()`