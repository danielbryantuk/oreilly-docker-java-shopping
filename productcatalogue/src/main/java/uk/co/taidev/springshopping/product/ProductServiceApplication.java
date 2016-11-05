package uk.co.taidev.springshopping.product;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.taidev.springshopping.product.configuration.ProductServiceConfiguration;
import uk.co.taidev.springshopping.product.healthchecks.BasicHealthCheck;
import uk.co.taidev.springshopping.product.model.Product;
import uk.co.taidev.springshopping.product.resources.ProductResource;

public class ProductServiceApplication extends Application<ProductServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ProductServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "product-list-service";
    }

    private final HibernateBundle<ProductServiceConfiguration> hibernateBundle
            = new HibernateBundle<ProductServiceConfiguration>(
            Product.class
    ) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                ProductServiceConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };

    @Override
    public void initialize(Bootstrap<ProductServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ProductServiceConfiguration config,
                    Environment environment) {
        final BasicHealthCheck healthCheck = new BasicHealthCheck(config.getVersion());
        environment.healthChecks().register("template", healthCheck);

        Injector injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(ProductResource.class));
    }
}