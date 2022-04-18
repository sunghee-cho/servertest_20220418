package spring.mybatis;


import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

//main 메소드 있으면 SPRING BOOT APP으로 실행 가능
//또는 main 메소드 있는 부트클래스가 실행시 같이 실행 가능
@Configuration
@EnableEncryptableProperties//application.properties의 항목 접근 
public class JasyptConfig {

	@Autowired
	Environment environment;
	
    @Bean("jasyptEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("1234"); // 암호화 키
        //config.setPassword(environment.getProperty("jasypt.encryptor.password"));
       System.out.println( System.getenv("JASYPT_PASSWORD") );
        //config.setPassword(environment.getProperty("JASYPT_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
		System.out.println("===JasyptConfig실행===");
		//application.properties db항목 복호화 확인
		System.out.println(encryptor.decrypt("MOawUNeMg3aJxdBm2B3p2XLnWzYyLqdJ+2O6XmR//A9Ry2iD3igWSw=="));
		System.out.println(encryptor.decrypt("YM10+LmLKjfO5Q4TPlezbrlpS4+1NfOlbvMMz6nBf5iOC2weaxqfhXxFiZraQ/YJdkHakp8biYw="));
		System.out.println(encryptor.decrypt("7ooepbcFFEhIq9iYOZPFfA=="));
		System.out.println(encryptor.decrypt("eMSXPHceqKPVnbiCVqTZZpP/SYCsCTgf"));
        return encryptor;
    }
 
}


/*
spring.datasource.driver-class-name=ENC(MOawUNeMg3aJxdBm2B3p2XLnWzYyLqdJ+2O6XmR//A9Ry2iD3igWSw==)
spring.datasource.url=ENC(YM10+LmLKjfO5Q4TPlezbrlpS4+1NfOlbvMMz6nBf5iOC2weaxqfhXxFiZraQ/YJdkHakp8biYw=)
spring.datasource.username=ENC(7ooepbcFFEhIq9iYOZPFfA==)
spring.datasource.password=ENC(eMSXPHceqKPVnbiCVqTZZpP/SYCsCTgf)
*/







