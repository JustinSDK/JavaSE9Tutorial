package cc.openhome;

import static java.lang.System.out;

public class Exercise {

    public static void main(String[] args) throws Exception {
        SimpleConnectionPoolDataSource dataSource = new SimpleConnectionPoolDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(
                "CREATE TABLE messages (" + 
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL," +
                    "name TEXT NOT NULL," + 
                    "email TEXT NOT NULL," + 
                    "msg TEXT NOT NULL)"
        );
        
        jdbcTemplate.update(
                "INSERT INTO messages(name, email, msg) VALUES (?,?,?)",
                "測試員", "tester@openhome.cc", "這是一個測試留言");
        
        jdbcTemplate.queryForList("SELECT * FROM messages")
                    .forEach(message -> {
                        out.printf("%d\t%s\t%s\t%s%n", 
                                message.get("id"), 
                                message.get("name"), 
                                message.get("email"), 
                                message.get("msg"));
                    });
    }
}
