package org.example.example2.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShardingJdbcConfig {

    /**
     * 定义数据源
     */
    @Bean
    public DataSource getShardingDataSource() throws SQLException {
        // 数据源基本信息
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db_order?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("t2", dataSource);
        // 分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        // 其他配置
        Properties properties = new Properties();
        properties.put("sql.show","true");
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
    }

    /**
     * 分片规则
     */
    private TableRuleConfiguration getOrderTableRuleConfiguration() {
        // 指定 t_order 表的数据分布情况，配置数据节点
        TableRuleConfiguration result = new TableRuleConfiguration("t_order","t2.t_order_$->{1..2}");
        // 指定 t_order 表的分片策略，分片策略包括分片键和分片算法
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_$->{order_id%2+1}"));
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }

    /**
     * 定义主键生成策略
     */
    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        return new KeyGeneratorConfiguration("SNOWFLAKE","order_id");
    }
}

