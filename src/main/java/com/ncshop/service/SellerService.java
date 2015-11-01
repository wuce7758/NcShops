package com.ncshop.service; 
 
 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import com.ncshop.dao.TAddressDAO;
import com.ncshop.dao.TAdsDAO;
import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TGoodstypeDAO; 
import com.ncshop.dao.TOrderDAO; 
import com.ncshop.dao.TSellerDAO; 
import com.ncshop.dao.TSellergoodsDAO; 
import com.ncshop.dao.TUserDAO; 
import com.ncshop.domain.TAddress;
import com.ncshop.domain.TAds;
import com.ncshop.domain.TGoods; 
import com.ncshop.domain.TGoodstype; 
import com.ncshop.domain.TOrder; 
import com.ncshop.domain.TSeller; 
import com.ncshop.domain.TSellergoods; 
import com.ncshop.domain.TUser; 
 
 
@Service
public class SellerService { 
	@Autowired 
	private TUserDAO userDao;
	@Autowired 
	private TSellerDAO sellerDao;
	@Autowired
	private TAdsDAO adsDao;
	@Autowired 
	private TSellergoodsDAO sellergoodsDao;
	@Autowired 
	private TGoodstypeDAO goodstypeDao;
	@Autowired 
	private TGoodstypeDAO goodtypeDao;
	@Autowired 
	private TGoodsDAO goodsDao;
	@Autowired 
	private TOrderDAO orderDao;
	@Autowired 
	private TAddressDAO addressDao;
 
 
	@SuppressWarnings("unchecked")
	public List<TOrder> findSellerOrder(int sellerId, int orderState) {
		// TODO Auto-generated method stub 
		List<TOrder> list=null;
		Object[] params={sellerId,orderState};
		list=orderDao.getHibernateTemplate().find("from TOrder where sellerId=? and orderState=?",params );
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TGoods> findAllGoods() {
		// TODO Auto-generated method stub 
		List<TGoods> list=orderDao.getHibernateTemplate().find("from TGoods");
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
 
 
 
 
 
 
 
 
	public void limitUser(int userId) {
		// TODO Auto-generated method stub 
		TUser user=userDao.findById(userId);
		if(user.getUserState()==true){
			user.setUserState(false);
		}else{ 
			user.setUserState(true);
		} 
		 
	} 
 
 
 
	public TOrder changeOrderState(int orderId, int orderState) {
		// TODO Auto-generated method stub 
		TOrder order=orderDao.findById(orderId);
		if(order==null){
			return null;
		}else{
			order.setOrderState(orderState);
			orderDao.getHibernateTemplate().update(order);			
			return order;
		}
	}
	
	public TSeller sellerLogin(String sellerName, String sellerPhone) {
		// TODO Auto-generated method stub
		Object[] params={sellerName};
		TSeller seller=(TSeller) sellerDao.getHibernateTemplate().find("from TSeller where sellerName=?",params).get(0);
		if(seller.getSellerPhone()==sellerPhone){
			return seller; 
		}else{
			return null;			
		}
	}








	@SuppressWarnings("unchecked")
	public List<TGoodstype> getAllGoodsType() {
		// TODO Auto-generated method stub
		List<TGoodstype> list=null;
		list=goodstypeDao.findAll();
		return list;
	}


	@SuppressWarnings("unchecked")
	public List<TSeller> getAllSellerByState() {
		// TODO Auto-generated method stub
		List<TSeller> list=null;
		list=sellerDao.getHibernateTemplate().find("from TSeller t where  t.isValid=?",true);
		if(list.size()>0){
			return list;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<TSeller> getAllSeller() {
		// TODO Auto-generated method stub
		List<TSeller> list=null;
		list=sellerDao.getHibernateTemplate().find("from TSeller");
		if(list.size()>0){
			return list;
		}
		return null;
	}


	public void addSeller(TSeller seller) {
		try {
			sellerDao.getHibernateTemplate().save(seller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//添加商品类型
	public String addGoodsType(TGoodstype goodsType) {
		try {
			goodstypeDao.getHibernateTemplate().save(goodsType);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
	//添加商品
	public void addGoods(int sellerId,int goodsTypeId,TGoods goods) {
		// TODO Auto-generated method stub 
		TSeller seller=sellerDao.findById(sellerId);
		TGoodstype goodsType= new TGoodstype();
		goodsType.setGoodsTypeId(goodsTypeId);
		TSellergoods sellergoods=new TSellergoods();
		goods.setTGoodstype(goodsType);
		sellergoods.setTGoods(goods);
		sellergoods.setSeller(seller);
		goodsDao.save(goods);
		sellergoodsDao.save(sellergoods);
	}
	//添加广告
	public void addAds(TAds ads) {
		try {
			sellerDao.getHibernateTemplate().save(ads);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSeller(TSeller seller) {
		try {
			sellerDao.getHibernateTemplate().delete(seller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGoods(TGoods goods) {
		// TODO Auto-generated method stub
		goodsDao.delete(goods);
	}
	//修改卖家
	public void updateSeller(TSeller seller) {
		try {
			sellerDao.getHibernateTemplate().saveOrUpdate(seller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//修改广告
	public void updateAds(TAds ads) {
		try {
			adsDao.getHibernateTemplate().saveOrUpdate(ads);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改商品类型
	public void updateGoodsType(TGoodstype goodsType) {
		try {
			goodstypeDao.getHibernateTemplate().saveOrUpdate(goodsType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//修改商品信息 
	public void updateGoods(int goodsTypeId, TGoods goods) {
		// TODO Auto-generated method stub 
		TGoodstype goodsType=goodstypeDao.findById(goodsTypeId);
		TGoods gs=goodsDao.findById(goods.getGoodsId());
		gs.setGoodsMsg(goods.getGoodsMsg());
		gs.setGoodsName(goods.getGoodsName());
		gs.setGoodsPic(goods.getGoodsPic());
		gs.setGoodsPrice(goods.getGoodsPrice());
		gs.setTGoodstype(goodsType);
		goodsDao.merge(gs);
	}
	//上下架卖家
	public void updownSeller(int sellerId, boolean isValid) {
		TSeller seller=sellerDao.findById(sellerId);
		if(seller.getIsValid()==true&&seller!=null){
			seller.setIsValid(false);
		}else{
			seller.setIsValid(true);			
		}
		sellerDao.getHibernateTemplate().update(seller);
	}
	//上下架广告
	public void updownAds(int adsId, boolean isValid) {
		TAds ads=adsDao.findById(adsId);
		if(ads.getIsValid()==true&&ads!=null){
			ads.setIsValid(false);
		}else{
			ads.setIsValid(true);			
		}
		sellerDao.getHibernateTemplate().update(ads);
	}
	
	public void updownGoodsType(int goodsTypeId, boolean isValid) {
		TGoodstype goodsType=goodstypeDao.getHibernateTemplate().get(TGoodstype.class, goodsTypeId);
		if(goodsType.getIsValid()==true&&goodsType!=null){
			goodsType.setIsValid(false);
		}else{
			goodsType.setIsValid(true);			
		}
		goodstypeDao.getHibernateTemplate().update(goodsType);
	}
	
	//上下架商品
	public void updownGoods(int goodsId,boolean isSale) {
		// TODO Auto-generated method stub
		List<TSellergoods> sellergoodsList=sellergoodsDao.getHibernateTemplate().find("from TSellergoods where goodsId="+goodsId);
		TSellergoods sellergoods=null;
		if(sellergoodsList.size()>0){
			sellergoods=sellergoodsList.get(0);			
		}
		if(sellergoods.getIsSale()==true&&sellergoods!=null){
			sellergoods.setIsSale(false);
		}else{
			sellergoods.setIsSale(true);			
		}
		sellergoodsDao.getHibernateTemplate().update(sellergoods);
	}
	
	public List<TOrder> findAllOrder() {
		List<TOrder> list=orderDao.findAll();
		if(list.size()>0){
			return list;
		}else{
			return null;			
		}
	}

	public List<TUser> getUserById(int userId) {
		// TODO Auto-generated method stub
		List<TUser> list=new ArrayList<TUser>();
		TUser findById = userDao.findById(userId);
		Object[] objs={userId,true}; 
		List<TAddress> find = addressDao.getHibernateTemplate().find("from TAddress where userId=? and isDefault=?",objs);
		Set<TAddress> set=new HashSet<TAddress>();
		set.add(find.get(0));
		findById.setTAddresses(set);
		list.add(findById);
		if(list.size()>0){
			return list;			
		}else{
			return null;
		}
	}

	public List<TSeller> getSellerById(int sellerId) {
		// TODO Auto-generated method stub
		List<TSeller> list=new ArrayList<TSeller>();
		list.add(sellerDao.findById(sellerId));
		if(list.size()>0){
			return list;			
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TAds> getAllAds() {
		// TODO Auto-generated method stub
		List<TAds> list=null;
		list=adsDao.getHibernateTemplate().find("from TAds order by adsTime desc");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TGoodstype> findAllGoodsType() {
		// TODO Auto-generated method stub
		List<TGoodstype> list=null;
		list=adsDao.getHibernateTemplate().find("from TGoodstype");
		return list;
	}
} 
