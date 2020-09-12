import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

public class DbHelper {
    private static JdbcTemplate template;

    static {
        try {
            Properties config = new Properties();
            config.load(DbHelper.class.getResourceAsStream("jdbcConfig.properties"));
            Class.forName(config.getProperty("driver"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(config);
            template = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return template.query(sql, rowMapper);
    }

    public static <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) throws DataAccessException {
        return template.query(sql, rowMapper, args);
    }

    /*
     * 不能调用spring jdbc提供的queryForObject方法，没有结果会抛出异常，下面是我修改好的
     * */
    public static <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        List<T> query = DbHelper.query(sql, rowMapper);
        if (query != null && query.size() > 0)
            return query.get(0);
        return null;
    }

    public static <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) throws DataAccessException {
        List<T> query = DbHelper.query(sql, rowMapper, args);
        if (query != null && query.size() > 0)
            return query.get(0);
        return null;
    }

    /*
    这个是上课选错的方法
    public static <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
        return template.queryForObject(sql, requiredType);
    }
    */

    public static int update(final String sql) throws DataAccessException {
        return template.update(sql);
    }
}
