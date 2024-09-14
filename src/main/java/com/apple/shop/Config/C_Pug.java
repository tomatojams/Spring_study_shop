package com.apple.shop.Config;

import de.neuland.pug4j.PugConfiguration;
import de.neuland.pug4j.spring.template.SpringTemplateLoader;
import de.neuland.pug4j.spring.view.PugViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class C_Pug {

  @Bean
  public SpringTemplateLoader templateLoader() {
    SpringTemplateLoader templateLoader = new SpringTemplateLoader();
    templateLoader.setTemplateLoaderPath("classpath:/templates");
    templateLoader.setEncoding("UTF-8");
    templateLoader.setSuffix(".pug");
    return templateLoader;
  }

  @Bean
  public PugConfiguration pugConfiguration() {
    PugConfiguration configuration = new PugConfiguration();
    configuration.setCaching(false);
    configuration.setTemplateLoader(templateLoader());
    return configuration;
  }

  @Bean
  public PugViewResolver viewResolver() {
    PugViewResolver viewResolver = new PugViewResolver();
    viewResolver.setConfiguration(pugConfiguration());
    return viewResolver;
  }
}
