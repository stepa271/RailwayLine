package ssb.config;



import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
{
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }


    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[0];
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        /*
        * Веб-конфигурации, где
        * определяются ViewResolver'ы
        * и тому подобное сюда
        * */
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }

}
