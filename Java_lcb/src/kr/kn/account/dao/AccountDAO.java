package kr.kn.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kn.account.model.vo.Category;
import kr.kn.account.model.vo.Item;
import kr.kn.account.model.vo.Type;

public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(@Param("ty_name")String type);

	boolean insertItem(@Param("item")Item item);
	
}
