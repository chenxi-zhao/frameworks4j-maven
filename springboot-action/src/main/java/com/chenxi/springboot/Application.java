package com.chenxi.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
//SpringBootApplication注解包含EnableAutoConfiguration和ComponentScan
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
//@EnableScheduling
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//
//    /**
//     * 注册DruidServlet
//     *
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean druidServletRegistrationBean() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 注册DruidFilter拦截
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean duridFilterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        Map<String, String> initParams = new HashMap<String, String>();
//        //设置忽略请求
//        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.setInitParameters(initParams);
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }

//    /**
//     * 配置DataSource
//     *
//     * @return
//     * @throws SQLException
//     */
//    @Bean
//    public DataSource druidDataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("qq123456");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test1");
//        druidDataSource.setMaxActive(100);
//        druidDataSource.setFilters("stat,wall");
//        druidDataSource.setInitialSize(10);
//        return druidDataSource;
//    }
}
