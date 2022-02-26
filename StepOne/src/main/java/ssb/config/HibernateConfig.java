package ssb.config;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ssb")
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties") //подключение файла свойств, который мы недавно создавал
public class HibernateConfig {
    private Environment environment;

    @Autowired
    //для того, чтобы получить свойства из property файла
    public void setEnvironment(Environment environment){
        this.environment=environment;
    }

    private Properties hibernateProperties() {
        //этот метод нужен чтобы представить свойства Hibernate в виде объекта Properties
        Properties properties= new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialec"));
        properties.put("hibernate.snow_sql", environment.getRequiredProperty("hibernate.snow_sql"));
        return properties;
    }
    @Bean
    public  DataSource dataSource(){
        /*используется для создания соединения с БД.
        Это альтернатива DriverManager
        преимуществ является возможность создания
        пула соединений Database Connection Pool (DBCP)
        */
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        /*
        * для создания сессий, с помощью которых
        * осуществляются операции с объектами-сущностями.
        * Здесь мы устанавливаем источник данных, свойства
        * Hibernate и в каком пакете нужно искать классы-сущности.
        */
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ssb.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        //для настройки менеджера транзакций
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
