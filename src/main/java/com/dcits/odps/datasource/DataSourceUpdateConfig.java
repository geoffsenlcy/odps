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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
@Configuration
@MapperScan(basePackages = "com.dcits.odps.mapper.update", sqlSessionTemplateRef  = "updateSqlSessionTemplate" )
public class DataSourceUpdateConfig {

	    @Bean(name = "updateDataSource")
	    @ConfigurationProperties(prefix = "spring.datasource1")
	    public DataSource testDataSource() {
	        return DataSourceBuilder.create().build();
	    }

	    @Bean(name = "updateSqlSessionFactory")
	    public SqlSessionFactory testSqlSessionFactory(@Qualifier("updateDataSource") DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(dataSource);
	        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/update/*.xml"));
	        return bean.getObject();
	    }

	    @Bean(name = "updateTransactionManager")
	    public DataSourceTransactionManager testTransactionManager(@Qualifier("updateDataSource") DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }

	    @Bean(name = "updateSqlSessionTemplate")
	    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("updateSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	    	SqlSessionTemplate tmp = new SqlSessionTemplate(sqlSessionFactory);
	    	tmp.getConfiguration().setMapUnderscoreToCamelCase(true);
	    	return tmp;
	    }
}
