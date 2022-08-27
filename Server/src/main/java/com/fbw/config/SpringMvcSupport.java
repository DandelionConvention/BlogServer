package com.fbw.config;

import com.fbw.intercepter.CrossIntercepter;
import com.fbw.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcSupport implements WebMvcConfigurer {

    @Autowired
    private CrossIntercepter crossIntercepter;

    @Autowired
    private LoginIntercepter loginIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(crossIntercepter).addPathPatterns("/user/*","/user/*/*","/user","/**");
        //这里接收的是任意多个参数，可以使用通配符
        // /**拦截所有
        registry.addInterceptor(loginIntercepter).addPathPatterns("/article/*","/user/info");

    }

    @Value("${images.filePath}")
    private String imagsPath;

    /**
     * 配置虚拟路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //文件磁盘图片url 映射 ，一下位windows下的
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
//        registry.addResourceHandler("/static/images/**").addResourceLocations("file:E:\\images\\");  // 图片映射
        registry.addResourceHandler("/static/images/**").addResourceLocations("file:"+imagsPath);

    }

}
