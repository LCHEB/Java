package kr.kn.account.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kn.account.dao.AccountDAO;
import kr.kn.account.model.vo.Category;
import kr.kn.account.model.vo.Item;
import kr.kn.account.model.vo.Type;
import kr.kn.account.pagination.Criteria;

public class AccountServiceImp implements AccountService {
	
	private AccountDAO accountDao;
	
	public AccountServiceImp() {
		String resource = "kr/kn/account/config/mybatis-config.xml";
		//DAO클래스명 xxxDao;
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			accountDao = session.getMapper(AccountDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Category> getCategoryList(String type) {
		if(type == null) {
			return null;
		}
		return accountDao.selectCategoryList(type);
	}


	@Override
	public List<Type> getTypeList() {
		return accountDao.selectTypeList();
	}


	@Override
	public boolean insertItem(Item item) {
		if(item == null || item.getIt_ty_name() == null) {
			return false;
		}
		if(!checkCategoryNum(item.getIt_ty_name(), item.getIt_ca_num())) {
			return false;
		}
		return accountDao.insertItem(item);
	}


	@Override
	public List<Item> getItemListByDate(String date) {
		//날짜가 없는 경우
		if(date == null) {
			return null;
		}
		
		return accountDao.selectItemListByDate(date);
	}


	@Override
	public boolean updateItem(Item item) {
		if(item == null || item.getIt_ty_name() == null) {
			return false;
		}
		if(!checkCategoryNum(item.getIt_ty_name(), item.getIt_ca_num())) {
			return false;
		}
		return accountDao.updateItem(item);
	}
	private boolean checkCategoryNum(String ty_name, int ca_num) {
		//type과 일치하지 않은 카테고리 체크
		List<Category> categoryList = accountDao.selectCategoryList(ty_name);
		return categoryList.contains(new Category(ca_num));
	}


	@Override
	public boolean deleteItem(int it_num) {
		return accountDao.deleteItem(it_num);
	}


	@Override
	public List<Item> getItemListByDate(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return accountDao.selectItemListSearch(cri);
	}
}
