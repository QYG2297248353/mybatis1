package com.ms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ms.mapper.OrderMapper;
import com.ms.pojo.Order;
import com.ms.pojo.OrderItem;

public class manyToMany {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();

		listOrder(session);

		session.commit();
		session.close();

	}

	private static void listOrder(SqlSession session) {
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		List<Order> os = mapper.list();
		for (Order o : os) {
			System.out.println(o.getCode());
			List<OrderItem> ois = o.getOrderItems();
			if (null != ois) {
				for (OrderItem oi : ois) {
					System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(),
							oi.getNumber());
				}
			}

		}
	}
}
