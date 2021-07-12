package com.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ms.pojo.Category;

public interface CategoryMapper {
//	CRUD
	@Insert(" insert into category_ ( name ) values (#{name}) ") 
    public int addCRUD(Category category); 
        
    @Delete(" delete from category_ where id= #{id} ") 
    public void deleteCRUD(int id); 
        
    @Select("select * from category_ where id= #{id} ") 
    public Category getCRUD(int id); 
      
    @Update("update category_ set name=#{name} where id=#{id} ") 
    public int updateCRUD(Category category);  
        
    @Select(" select * from category_ ") 
    public List<Category> listCRUD(); 
    
//  一对多
    @Select(" select * from category_ ")
    @Results({ 
                @Result(property = "id", column = "id"),
                @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.ms.mapper.ProductMapper.listByCategory") )
            })
    public List<Category> listOTM();
//  多对一
    @Select(" select * from category_ where id = #{id}")
    public Category getMTO(int id);
    
//  动态SQL->CRUD
    @InsertProvider(type=CategoryDynaSqlProvider.class,method="add") 
    public int add(Category category); 
        
    @DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
    public void delete(int id); 
        
    @SelectProvider(type=CategoryDynaSqlProvider.class,method="get") 
    public Category get(int id); 
      
    @UpdateProvider(type=CategoryDynaSqlProvider.class,method="update") 
    public int update(Category category);  
        
    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")     
    public List<Category> list(); 
}
