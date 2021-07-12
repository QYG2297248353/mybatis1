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
import com.ms.pojo.Product;

public class oneToManyTest {
	public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
 
        listAll(mapper);
              
        session.commit();
        session.close();
   
    }
  
    private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.listOTM();
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p.getName());
            }
        }
    }
}
