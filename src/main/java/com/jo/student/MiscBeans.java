package com.jo.student;

import com.jo.student.Repo.CourseRepo;
import com.jo.student.Model.Course;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
class MiscBeans {

    private static final Logger log = LoggerFactory.getLogger(MiscBeans.class);

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.UK);
        return sessionLocaleResolver;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*   @Bean
//    return args -> {

            courseRepo.save(new Course(151L, 151, "Software Engineering", 1700f,100 ));
            courseRepo.save(new Course(161L, 152, "Advanced Software Engineering", 1900f,150 ));
            courseRepo.save(new Course(171L, 153, "Software And Systems",1600f,120 ));
            courseRepo.save(new Course(181L, 154, "Artificial Intelligence", 1800f,200 ));
            courseRepo.save(new Course(191L, 155, "Project Management", 1500f,100 ));
            courseRepo.save(new Course(201L, 156, "International Hospitality Management", 1600f,100 ));
            courseRepo.save(new Course(211L, 157, "Business Law", 1800f,100 ));
            courseRepo.save(new Course(221L, 158, "Economics", 1700f,150 ));
            courseRepo.save(new Course(231L, 159, "Business Administration", 1600f,150 ));
            courseRepo.save(new Course(241L, 160, "Event Management", 1800f,150 ));


        };
        } */
    }