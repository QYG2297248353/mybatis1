package com.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ms.pojo.Product;

public interface ProductMapper {
//	һ�Զ�
	@Select(" select * from product_ where cid = #{cid}")
	public List<Product> listByCategory(int cid);

//	���һ
	@Select(" select * from product_ ")
	@Results({
			@Result(property = "category", column = "cid", one = @One(select = "com.ms.mapper.CategoryMapper.get")) })
	public List<Product> list();

//	��Զ�
	@Select("select * from product_ where id = #{id}")
	public Product get(int id);
}
