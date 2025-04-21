package kr.hhplus.be.server.infra.config;

import kr.hhplus.be.server.suppport.QueueTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final QueueTokenInterceptor queueTokenInterceptor;

  public WebMvcConfig(QueueTokenInterceptor queueTokenInterceptor) {
    this.queueTokenInterceptor = queueTokenInterceptor;
  }
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(queueTokenInterceptor)
        .addPathPatterns("/api/**")
        .excludePathPatterns("/api/v1/queue-tokens");
  }


}
