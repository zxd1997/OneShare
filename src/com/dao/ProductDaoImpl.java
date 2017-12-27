package com.dao;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.beans.Product;
@Repository
@Scope("prototype")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void addProduct(Product product) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		session.save(product);
	}
	@Transactional
	@Override
	public void deleteProduct(Product product) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.delete(product);
			session.flush();
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public void updateProduct(Product product) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.update(product);
			session.flush();
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public List<Product> selectProduct() {
		// TODO 自动生成的方法存根
		List<Product> product = new ArrayList<Product>();
		Session session = sessionFactory.openSession();
		List list = (List)session.createQuery("From Product").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product u = (Product) iterator.next();
			product.add(u);
		}
		session.close();
		return product;
	}
	@Transactional
	@Override
	public Product getProductById(int id) {
		// TODO 自动生成的方法存根		
		Session session = sessionFactory.openSession();
		return session.get(Product.class, id);
	}
	@Transactional
	@Override
	public Product getProductByName(String name) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		List product = (List)session.createQuery("From Product p where p.name=:name").setString("name", name).list();
		if (product.size()>0) 
			for (Iterator iterator = product.iterator();iterator.hasNext();) 
				{
					Product p=(Product) iterator.next();session.close();
					return p;
				}session.close();
		return null;
	}
	@Override
	public List<Product> getProductByUser(int id) {
		// TODO 自动生成的方法存根
		List<Product> product = new ArrayList<Product>();
		Session session = sessionFactory.openSession();
		List list =  (List)session.createQuery("From Product p where p.userId=:userId").setInteger("userId", id).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product u = (Product) iterator.next();
			product.add(u);
		}
		return product;
	}
	private Set products=new HashSet();
	private String querySentence;

	
	public void setQuerySentence(String querySentence){
		this.querySentence=querySentence;
	}
	public Set getProducts(){
		return this.products;
	}
	public Set separateSentence() throws IOException{	
	Set segments=new HashSet();
	Analyzer anal=new IKAnalyzer(true);		
	StringReader reader=new StringReader(this.querySentence);
	//分词
	TokenStream ts=anal.tokenStream("", reader);
	CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
	//遍历分词数据
	while(ts.incrementToken()){
		segments.add(term.toString());
	}
	reader.close();
	anal.close();
	return segments;
	}
	public void startQuery(){
		Set segments = null;
		try {
			segments = separateSentence();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Iterator it=segments.iterator();
		while(it.hasNext()){
			String seg=(String)it.next();
			query(seg);
		}
	}
	public void query(String seg){
		Session session=sessionFactory.openSession();
		Transaction ts=null;
		try{
			ts=session.beginTransaction();
			String strSQL="from Product as s where s.name like :name";
			Query query = session.createQuery(strSQL);
			query.setString("name", "%" + seg + "%");
			query.setMaxResults(10);
			List list=query.list();
			ts.commit();
			Iterator iterator=list.iterator();
			while(iterator.hasNext()){
				Product pt=(Product)iterator.next();
				if(!hasThisProduct(pt))
				this.products.add(pt);
			}
		}catch(Exception e){
			if(ts!=null)
				ts.rollback();
			e.printStackTrace();
		}
		session.close();
	}
	public boolean hasThisProduct(Product product)
	{
		Iterator it=this.products.iterator();
		while(it.hasNext()){
			Product pd=(Product)it.next();
			if(pd.getId()==product.getId())
				return true;
		}
		return false;
	}
	@Override
	public List<Product> getProductByType(String type) {
		// TODO 自动生成的方法存根
		List<Product> product = new ArrayList<Product>();
		Session session = sessionFactory.openSession();
		List list =  (List)session.createQuery("From Product p where p.type=:type").setString("type", type).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product u = (Product) iterator.next();
			product.add(u);
		}
		return product;
	}
}
