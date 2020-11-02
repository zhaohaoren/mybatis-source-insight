import top.zhaohaoren.mybatis.sample.Blog;

import java.sql.*;

/**
 * Demo of fetching data by JBDC
 *
 * @author zhaohaoren
 */
public class MyJdbcDemo {

    /**
     * JDBC driver name and database URL
     */
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/db_mybatis_source_insight";

    /**
     * Database credentials
     */
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tb_blog";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name
                long id = rs.getLong("id");
                String age = rs.getString("title");
                String author = rs.getString("author");
                String content = rs.getString("content");
                //Build PO
                Blog blog = new Blog();
                blog.setId(id);
                blog.setTitle(age);
                blog.setAuthor(author);
                blog.setContent(content);
                System.out.println(blog.toString());
            }
            rs.close();
        } catch (Exception e) {
            //Handle errors for JDBC
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                // do nothing
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
