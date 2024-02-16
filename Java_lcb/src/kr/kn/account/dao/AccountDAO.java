package kr.kn.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kn.account.model.vo.Category;
import kr.kn.account.model.vo.Item;
import kr.kn.account.model.vo.Type;
import kr.kn.account.pagination.Criteria;

public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(@Param("ty_name")String type);

	boolean insertItem(@Param("item")Item item);

	List<Item> selectItemListByDate(@Param("it_date")String date);

	boolean updateItem(@Param("item")Item item);

	boolean deleteItem(@Param("it_num")int it_num);

	List<Item> selectItemListSearch(@Param("cri")Criteria cri);

}
