package com.yzyy;

import com.yzyy.bean.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbdemoApplication {

	private static Logger logger = LoggerFactory.getLogger(SbdemoApplication.class);

	@Value("{book.author}")
	private String bookAuthor;

	@Value("${book.name}")
	private String bookName;

	@Value("${book.pinyin}")
	private String bookPinYin;

	@Autowired
	private Book bookBean;

	public static void main(String[] args) {
		SpringApplication.run(SbdemoApplication.class, args);
	}

	@RequestMapping(value = "/bookList", produces = "text/plain;charset=UTF-8")
	public String bookList(){
		return "Hello Yzyy! The BookName is "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin;	}

	@RequestMapping("/bookInfo")
	public String book() {
		logger.debug("BookInfo get");
		return "Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book price is "+bookBean.getPrice();
	}

}
