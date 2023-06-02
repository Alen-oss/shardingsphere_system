package org.example.example4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 排除DataSourceAutoConfiguration，即取消DataSource的自动配置
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Example4Application {
    public static void main(String[] args) {
        SpringApplication.run(Example4Application.class, args);
    }
}
