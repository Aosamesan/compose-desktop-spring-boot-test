package me.aosamesan.app.config

import me.aosamesan.app.pages.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader


@Configuration
class AppConfig {
    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Autowired
    lateinit var resourceLoader: ResourceLoader

    @Bean
    fun pages(): List<Page> {
        return applicationContext.getBeansOfType<Page>().values.sortedWith(Page::compare)
    }
}