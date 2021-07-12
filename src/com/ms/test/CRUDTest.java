package com.ms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ms.mapper.CategoryMapper;
import com.ms.pojo.Category;

public class CRUDTest {
	private static void update(CategoryMapper mapper) {
		Category c = mapper.get(1);
		c.setName("修改了的Category名稱");
		mapper.updateCRUD(c);
		listAll(mapper);
	}

	private static void get(CategoryMapper mapper) {
		Category c = mapper.getCRUD(1);
		System.out.println(c.getName());
	}

	private static void delete(CategoryMapper mapper) {
		mapper.deleteCRUD(2);
		listAll(mapper);
	}

	private static void add(CategoryMapper mapper) {
		Category c = new Category();
		c.setName("新增加的Category");
		mapper.addCRUD(c);
		listAll(mapper);
	}

	private static void listAll(CategoryMapper mapper) {
		List<Category> cs = mapper.listCRUD();
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

//        add(mapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
		listAll(mapper);

		session.commit();
		session.close();
	}

}
