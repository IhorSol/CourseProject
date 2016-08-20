package kursovik.ProgramUtils;

import kursovik.customer.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Ihor Solohub.
 */
@Configuration
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcURL;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${hibernate.dialect}")
    private String sqlDialect;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory
            (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaProperties(additionalProperties());
        entityManagerFactory.setPackagesToScan("kursovik");
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager (EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setDatabasePlatform(sqlDialect);

        return adapter;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(jdbcURL);
        ds.setUsername(jdbcUsername);
        ds.setPassword(jdbcPassword);
        return ds;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/src/main/webapp/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    /*------- Added user services from security project -------*/
    @Bean
    public UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }
}
