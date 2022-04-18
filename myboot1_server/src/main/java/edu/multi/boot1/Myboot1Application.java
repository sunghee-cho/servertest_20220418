package edu.multi.boot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import product.ProductController;
import product.ProductDAO;
import spring.mybatis.MemberDAO;
import spring.mybatis.MemberMybatisController;
import upload.UploadController;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = UploadController.class)
@ComponentScan(basePackageClasses = MemberMybatisController.class)
@ComponentScan(basePackageClasses = ProductController.class)
@MapperScan(basePackageClasses = ProductDAO.class)
@MapperScan(basePackageClasses = MemberDAO.class)
public class Myboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot1Application.class, args);
	}

}
