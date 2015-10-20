package com.ncshop.service; 
 
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
 
 
import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TGoodstypeDAO; 
import com.ncshop.dao.TOrderDAO; 
import com.ncshop.dao.TSellerDAO; 
import com.ncshop.dao.TSellergoodsDAO; 
import com.ncshop.dao.TUserDAO; 
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
	private TSellergoodsDAO sellergoodsDao;
	@Autowired 
	private TGoodstypeDAO goodstypeDao;
	@Autowired 
	private TGoodstypeDAO goodtypeDao;
	@Autowired 
	private TGoodsDAO goodsDao;
	@Autowired 
	private TOrderDAO orderDao;
 
 
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
 
 
	@SuppressWarnings("unchecked")
	public String addGoodsType(String goodsTypeName) {
		// TODO Auto-generated method stub 
		TGoodstype type=new TGoodstype();
		type.setGoodsTypeName(goodsTypeName);
		List<TGoodstype> list=goodtypeDao.getHibernateTemplate().find("from TGoodstype where goodsTypeName='"+goodsTypeName+"'");
		if(list.size()>0){
			return "0";
		}else{
			goodtypeDao.save(type);
			return "1";
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


	public void downGoods(int goodsId,boolean isSale) {
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


	public void deleteGoods(TGoods goods) {
		// TODO Auto-generated method stub
		goodsDao.delete(goods);
	}


	@SuppressWarnings("unchecked")
	public List<TGoodstype> getAllGoodsType() {
		// TODO Auto-generated method stub
		List<TGoodstype> list=null;
		list=goodstypeDao.findAll();
		return list;
	}


	@SuppressWarnings("unchecked")
	public List<TSeller> getAllSeller() {
		// TODO Auto-generated method stub
		return sellerDao.findAll();
	}


	public void addSeller(TSeller seller) {
		// TODO Auto-generated method stub
		sellerDao.getHibernateTemplate().saveOrUpdate(seller);
	}

	public void updownSeller(int sellerId, boolean isValid) {
		// TODO Auto-generated method stub
		TSeller seller=sellerDao.findById(sellerId);
		if(seller.getIsValid()==true&&seller!=null){
			seller.setIsValid(false);
		}else{
			seller.setIsValid(true);			
		}
		sellerDao.getHibernateTemplate().update(seller);
	}

	public List<TOrder> findAllOrder() {
		// TODO Auto-generated method stub
		List<TOrder> list=orderDao.findAll();
		if(list.size()>1){
			return list;
		}else{
			return null;			
		}
	}

	public List<TUser> getUserById(int userId) {
		// TODO Auto-generated method stub
		List<TUser> list=new ArrayList<TUser>();
		list.add(userDao.findById(userId));
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
} 
