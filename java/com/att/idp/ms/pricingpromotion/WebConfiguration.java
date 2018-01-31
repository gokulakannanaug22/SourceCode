package com.att.idp.ms.pricingpromotion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class WebConfiguration.
 */
@Configuration
public class WebConfiguration {

	/**
	 * Forward to index.
	 *
	 * @return the web mvc configurer adapter
	 */
	@Bean
	public WebMvcConfigurerAdapter forwardToIndex() {
		return new WebMvcConfigurerAdapter() {
			/**
			 *  addViewControllers 
			 */
			@Override
			public void addViewControllers(final ViewControllerRegistry registry) {
				registry.addViewController("/swagger").setViewName(
						"redirect:/swagger/index.html");
				registry.addViewController("/swagger/").setViewName(
						"redirect:/swagger/index.html");
                registry.addViewController("/docs").setViewName(
                        "redirect:/docs/html/index.html");
                registry.addViewController("/docs/").setViewName(
                         "redirect:/docs/html/index.html");
			}
		};
	}
}