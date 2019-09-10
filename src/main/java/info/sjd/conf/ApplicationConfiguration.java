package info.sjd.conf;

import info.sjd.dao.*;
import info.sjd.service.impl.CartServiceImpl;
import info.sjd.service.impl.OrderServiceImpl;
import info.sjd.service.impl.ProductServiceImpl;
import info.sjd.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aleksandr Beryozkin
 */

@Configuration
public class ApplicationConfiguration {

    @Bean
    public HibernateFactory hibernateFactory() {
        return new HibernateFactory();
    }

    @Bean
    public CartDAO cartDAO() {
        return new CartDAO();
    }

    @Bean
    public CartServiceImpl cartServiceImpl() {
        return new CartServiceImpl();
    }

    @Bean
    public OrderDAO orderDAO() {
        return new OrderDAO();
    }

    @Bean
    public OrderServiceImpl orderServiceImpl() {
        return new OrderServiceImpl();
    }

    @Bean
    public ProductDAO productDAO() {
        return new ProductDAO();
    }

    @Bean
    public ProductServiceImpl productServiceImpl() {
        return new ProductServiceImpl();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAO();
    }

    @Bean
    public UserServiceImpl userServiceImpl() {
        return new UserServiceImpl();
    }
}
