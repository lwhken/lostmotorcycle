package com.lostmotorcycle.lookup.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
public class DBConfig {

	private static final String JPA_PROPS_PREFIX = "motorcycle.jpa";
	private static final String DATASOURCE_PROPS_PREFIX = "motorcycle.datasource";
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(schedulerDataSource());
		em.setPackagesToScan("com.lostmotorcycle.lookup");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProps = this.jpaProperties();
		if(jpaProps.getProperty("hibernate.hbm2ddl.auto") == null){
			log.debug("{}.hibernate.hbm2ddl.auto is not set", JPA_PROPS_PREFIX);
		}
		em.setJpaProperties(jpaProps);

		return em;
	}

	@Primary
	@Bean
	@ConfigurationProperties(DATASOURCE_PROPS_PREFIX)
	protected DataSourceProperties schedulerDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource schedulerDataSource(){
		return this.schedulerDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	@ConfigurationProperties(JPA_PROPS_PREFIX)
	protected Properties jpaProperties() {
		return new Properties();
	}
}
