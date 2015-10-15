package com.ncshop.service; 
 
 
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
 
 
	public void addGoods(int sellerId,int goodsTypeId,TGoods goods) {
		// TODO Auto-generated method stub 
		TSeller seller=sellerDao.findById(sellerId);
		TGoodstype goodsType=goodstypeDao.findById(goodsTypeId);
		TSellergoods sellergoods=new TSellergoods();
		goods.setTGoodstype(goodsType);
		sellergoods.setTGoods(goods);
		sellergoods.setSeller(seller);
		goodsDao.save(goods);
		sellergoodsDao.save(sellergoods);
	} 
 
 
	public void addGoodsType(TGoodstype goodsType) {
		// TODO Auto-generated method stub 
		goodtypeDao.save(goodsType);
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
		goodsDao.save(gs);
	} 
 
 
	public TOrder changeOrderState(int orderId, int orderState) {
		// TODO Auto-generated method stub 
		TOrder order=orderDao.findById(orderId);
		order.setOrderState(orderState);
		orderDao.save(order);
		return order;
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
		TGoods goods=goodsDao.findById(goodsId);
		TSellergoods example=new TSellergoods();
		example.setTGoods(goods);
		List<TSellergoods> sellergoodsList=sellergoodsDao.getHibernateTemplate().findByExample(example);
		TSellergoods sellergoods=null;
		if(sellergoodsList.size()>0){
			sellergoods=sellergoodsList.get(0);			
		}
		if(sellergoods.getIsSale()==true&&sellergoods!=null){
			sellergoods.setIsSale(false);
		}else{
			sellergoods.setIsSale(true);			
		}
	}


	public void deleteGoods(TGoods goods) {
		// TODO Auto-generated method stub
		goodsDao.delete(goods);
	}


	@SuppressWarnings("unchecked")
	public List<TGoodstype> getAllGoodsType() {
		// TODO Auto-generated method stub
		return goodstypeDao.findAll();
	}


	@SuppressWarnings("unchecked")
	public List<TSeller> getAllSeller() {
		// TODO Auto-generated method stub
		return sellerDao.findAll();
	}


	public void addSeller(TSeller seller) {
		// TODO Auto-generated method stub
		sellerDao.merge(seller);
	}
} 
