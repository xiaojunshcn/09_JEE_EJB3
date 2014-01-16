1)	Model 1模式核心是配置多个Servlet

2) MySql里建表：
	create table tb_user(
		Id int(4) not null primary key auto_increment,
		name varchar(50) not null,
		password varchar(50) not null
	);
	
	insert into tb_user(name, password) values('joe','xiao');
	
3) url:
	http://localhost:8080/Model1/login/login.jsp

4) servlet里的request.getParameter()参数是页面控件的name属性值:UserName。
	<input type="text" id="txtUserName" name="UserName"/>
	
5) 乱码解决方案：filter
	数据库建立为UTF-8格式 
	项目右键属性为UTF-8格式 
	所有页面申明为UTF-8 
	JDBC URL设为：UTF-8 
	jdbc:mysql://localhost:3306/joexiao?useUnicode=true&characterEncoding=UTF-8
	数据库Driver选择UTF-8格式 
	Tomcat编码改成UTF-8 
	在server.xml里面增加URIEncoding="UTF-8" 
	Xml代码  
	<Connector port="8080" maxHttpHeaderSize="8192" maxThreads="150" minSpareThreads="25" 
		maxSpareThreads="75" enableLookups="false" redirectPort="8443" acceptCount="100" 
		connectionTimeout="20000" disableUploadTimeout="true" URIEncoding="UTF-8" /> 
