<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>NchuPandas</groupId>
	<artifactId>NcShops</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>NcShops</name>
	<url>http://maven.apache.org</url>
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<springversion>3.1.1.RELEASE</springversion>
		<junitversion>3.8.1</junitversion>
	</properties>

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.service.SellerService;
import com.ncshop.service.UserService;
import com.ncshop.util.TargetStrategy;
=======
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junitversion}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>me.chanjar</groupId>
			<artifactId>weixin-java-mp</artifactId>
			<version>1.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-asm</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aspects</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-expression</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jms</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-oxm</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${springversion}</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.1</version>
		</dependency>

		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.4</version>
		</dependency>
>>>>>>> 8f87f014cf8b91767985ac46f8da4bc3a9d38214

		<dependency>
			<groupId>commons-pool</groupId>
			<artifactId>commons-pool</artifactId>
			<version>1.3</version>
		</dependency>

		<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.1</version>
		</dependency>

<<<<<<< HEAD
	/**
	 * 查找某店铺订单
	 * 
	 * @param OpenId
	 *            微信号标识
	 * @param orderState
	 *            订单状态
	 * @throws Exception
	 */
	@RequestMapping("/findSellerOrders")
	public void findSellerOrders(HttpServletResponse response, int OpenId,
			int orderState) throws Exception {
		if (OpenId + "" == "" || orderState + "" == "") {
			return;
		}
		// 调用service查找 数据库
		List<TOrder> orderList = sellerService.findSellerOrder(OpenId,
				orderState);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("添加商品成功!");
	}

	/**
	 * 添加店铺商品
	 * 
	 * @param sellerId
	 *            卖家唯一标识
	 * @param goods
	 *            新商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(HttpServletResponse response, int sellerId,
			int goodsTypeId, TGoods goods) throws Exception {
		if (sellerId + "" == "" || goodsTypeId + "" == "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.addGoods(sellerId, goodsTypeId, goods);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("添加商品成功!");
	}

	/**
	 * 添加商品类型
	 * 
	 * @param goodsType
	 *            商品类型对象
	 * @throws Exception
	 */
	@RequestMapping("/addGoodsType")
	public void addGoodsType(HttpServletResponse response, TGoodstype goodsType)
			throws Exception {
		String goodsTypeName = goodsType.getGoodsTypeName();
		if (goodsTypeName == null || goodsTypeName == "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.addGoodsType(goodsType);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("添加商品类型成功!");
	}
}
=======
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>3.6.10.Final</version>
		</dependency>
		<!-- 添加javassist -->
		<dependency>
			<groupId>javassist</groupId>
			<artifactId>javassist</artifactId>
			<version>3.12.0.GA</version>
		</dependency>
		<!-- mysql数据库的驱动包 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.6</version>
		</dependency>

		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>1.9.11</version>
		</dependency>

		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.0</version>
		</dependency>

	</dependencies>

	<build>
		<finalName>ncshops</finalName>
	</build>
</project>
>>>>>>> 8f87f014cf8b91767985ac46f8da4bc3a9d38214
