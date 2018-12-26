package com.dcits.odps.datasource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
@Configuration
@MapperScan(basePackages = "com.dcits.odps.mapper.query", sqlSessionTemplateRef  = "querySqlSessionTemplate")
public class DataSourceQueryConfig {

	@Bean(name = "queryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "querySqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("queryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/query/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "queryTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("queryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "querySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("querySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    	SqlSessionTemplate tmp = new SqlSessionTemplate(sqlSessionFactory);
    	tmp.getConfiguration().setMapUnderscoreToCamelCase(true);
    	return tmp;
    }
}
