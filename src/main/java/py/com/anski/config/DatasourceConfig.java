package py.com.anski.config;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * @author anski
 *
 */

//@Configuration
public class DatasourceConfig {

	@Bean
	  public DataSource dataSource() throws URISyntaxException {
	      URI dbUri = new URI(System.getenv("DATABASE_URL"));

	      String username = dbUri.getUserInfo().split(":")[0];
	      String password = dbUri.getUserInfo().split(":")[1];
	      String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
	      String driver = System.getenv("JDBC_DATABASE_DRIVER_CLASS_NAME");
	      
	      DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	      dataSourceBuilder.driverClassName(driver);
	      dataSourceBuilder.url(dbUrl);
	      dataSourceBuilder.username(username);
	      dataSourceBuilder.password(password);
	      return dataSourceBuilder.build();
	  }
}
