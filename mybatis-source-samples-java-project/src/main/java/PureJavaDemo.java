import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.sample.Blog;
import org.mybatis.sample.BlogMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhaohaoren
 */
public class PureJavaDemo {


    public static void main(String[] args) throws IOException {
//        DataSource dataSource = getDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

// old
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectByPrimaryKey", 1);
//        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 下面就是拿到mapper
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            //todo SqlSession 提供了一些查询，但是接口是没法直接用的，这个接口方法，怎么最终调用到sqlsession上的？
            Blog blog = mapper.selectByPrimaryKey(1);


            System.out.println(blog.toString());
        }

    }


    public static DataSource getDataSource() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/db_mybatis_source_insight");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();
        return dataSource;
    }
}
