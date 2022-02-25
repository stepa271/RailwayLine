package ssb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="ssb")
public class WebConfig {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        // прописание префикса = приставки перед адресом траницы в структцре WEB
        viewResolver.setPrefix("/WEB-INF/pages/");
        // и добавление суфикса. т.е. наше расширение файла, для браузера
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
