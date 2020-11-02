import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import top.zhaohaoren.mybatis.sample.Blog;
import top.zhaohaoren.mybatis.sample.BlogMapper;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author zhaohaoren
 */
public class PureJavaDemo {


    public static void main(String[] args) {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

// old
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectByPrimaryKey", 1);
//        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
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
