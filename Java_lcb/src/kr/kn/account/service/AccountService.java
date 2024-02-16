package kr.kn.account.service;

import java.util.List;

import kr.kn.account.model.vo.Category;
import kr.kn.account.model.vo.Item;
import kr.kn.account.model.vo.Type;
import kr.kn.account.pagination.Criteria;

public interface AccountService {

	List<Category> getCategoryList(String type);

	List<Type> getTypeList();

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	boolean updateItem(Item item);

	boolean deleteItem(int it_num);

	List<Item> getItemListByDate(Criteria cri);

}
