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

        //config.setPassword("1234"); // 암호화키
        config.setPassword(System.getenv("PASSWORD")); // 암호화키
       	System.out.println( System.getenv("PASSWORD") +":" + config.getPassword() );
        		
        		

        //System.out.println("==>"+environment.getProperty("JASYPT_PASSWORD"));
        //System.out.println( System.getenv("JASYPT_PASSWORD") );
        //config.setPassword(System.getProperty("JASYPT_PASSWORD"));


/*System.out.println( System.getenv("HISTSIZE") );
	    System.out.println( System.getenv("PASSWORD") );
	    	    System.out.println( System.getenv("pw") );
	System.out.println( System.getenv("PW_HOME") );
	System.out.println( System.getenv("PWD") );	    
       System.out.println( System.getenv("USER") );
	System.out.println( System.getenv("MAVEN_HOME") );
	   
	System.out.println( System.getenv("PATH"));
	*/    
        //config.setPassword(environment.getProperty("JASYPT_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
		System.out.println("===JasyptConfig실행===");
		//application.properties db항목 복호화 확인
		System.out.println(encryptor.decrypt("2YEQhh8Q/6OVznAhG2RznljBrg41TVB8tHFrCe8vguhIZ4wJJZkcPw=="));
		System.out.println(encryptor.decrypt("TpqCim0U4NzTd+idUr/UwNjxLg60L7qkBhc8oUVmqEJ2jxbbGX9Yt31XXtgnbesXM2CEho1JTbk="));
		System.out.println(encryptor.decrypt("SdIjETzmxlEh+9HrrK0tTw=="));
		System.out.println(encryptor.decrypt("Ztln23ltFGE+qlM5CeBQAUE+MeG5yTcn"));
       
        return encryptor;
    }
 
}


/*
spring.datasource.driver-class-name=ENC(MOawUNeMg3aJxdBm2B3p2XLnWzYyLqdJ+2O6XmR//A9Ry2iD3igWSw==)
spring.datasource.url=ENC(YM10+LmLKjfO5Q4TPlezbrlpS4+1NfOlbvMMz6nBf5iOC2weaxqfhXxFiZraQ/YJdkHakp8biYw=)
spring.datasource.username=ENC(7ooepbcFFEhIq9iYOZPFfA==)
spring.datasource.password=ENC(eMSXPHceqKPVnbiCVqTZZpP/SYCsCTgf)
*/







