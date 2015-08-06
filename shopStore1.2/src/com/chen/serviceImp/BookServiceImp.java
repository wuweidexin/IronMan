package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Book;
import com.chen.entity.Customer;
import com.chen.entity.Order;
import com.chen.entity.ShoppingCart;
import com.chen.service.BookService;
import com.chen.service.ShoppingCartService;

public class BookServiceImp implements BookService{
	BaseDao dao = new BaseDaoImp();

	public void saveBook(Book book) {

		dao.saveObject(book);
	}

	public void updateBook(Book book) {

		dao.updateObject(book);
	}

	public void deleteBook(int id) {
		Book book = new Book();
		book = (Book)dao.findObject("from Book where id="+ id);
		dao.deleteObject(book);

	}

	public Book findOneBook(String HQL) {
		Book book = new Book();
		book = (Book)dao.findObject(HQL);
		return book;
	}

	public List findWithPage(int startRow, int pageSize,String HQL) {
		List<Book> list = new ArrayList<Book>();
		list = dao.findWithPage(startRow,pageSize,HQL);
		return list;
	}

	public List findList(String HQL) {
		List<Book> list = new ArrayList<Book>();
		list = dao.findList(HQL);
		return list;
	}

	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	//下面是测试代码
	public static void main(String[] arg)
	{
		BookServiceImp bsi = new BookServiceImp();

		//添加一个商品
		//测试结果通过
		//		Book b = new Book();
		//		b.setAuthor("张国荣");
		//		b.setBookID(1);
		//		b.setBookName("庄子的思想世界");
		//		b.setBookSort("文学");
		//		b.setCount(50);
		//		b.setPress("清华");
		//		b.setVersion("第一版");
		//		books.saveBook(b);

		//修改一个商品
		//测试成功，修改时候必须是book的整个对象都得赋值，要不然会出现其他属性全部置为空的情况
		//		Book book = new Book();
		//		book.setId(2);
		//		book.setPress("北京大学");
		//		book.setVersion("第二版");
		//		bsi.updateBook(book);

		//查找一个商品
		//测试成功，这里要注意id必须存在否则出现指针为空的异常
//						Book book = new Book();
//						book = bsi.findOneBook("from Book where id =" + 1);
//						System.out.println(book.getBookName());

		//查找一个链表的商品
		//测试成功
		//		List<Book> list = new ArrayList<Book>();
		//		list = bsi.findList("from Book");
		//		for(int i = 0 ;i < list.size(); i ++)
		//		{
		//			Book  book = new Book();
		//			book = (Book)list.get(i);
		//			System.out.println("******");
		//			System.out.println("书名是：" + book.getBookName());
		//		}

		//查找页码的商品
		//测试成功
		//		List<Book> list = new ArrayList<Book>();
		//		list = bsi.findWithPage(0, 2, "from Book");
		//		for(int i = 0 ;i < list.size(); i ++)
		//		{
		//			Book  book = new Book();
		//			book = (Book)list.get(i);
		//			System.out.println("******");
		//			System.out.println("书名是：" + book.getBookName());
		//		}


		//删除一个商品
		//测试成功
		//bsi.deleteBook(1);


		//查找一个购物车中的商品
		//测试成功，但是必须book中全部有shoppingCart中的bookID的号，要不然出现空指针错误
//		ShoppingCartService shoppingCartService = new ShoppingCartServiceImp();
//
//		List li = shoppingCartService.findWithPage(0, 3, "from ShoppingCart");
//
//		for(int i = 0; i < li.size(); i ++)
//		{
//			ShoppingCart shoppingCart = new ShoppingCart();
//			Book b = new Book();
//			shoppingCart = (ShoppingCart)li.get(i);
//			b = bsi.findOneBook("from Book where bookID = " + shoppingCart.getBookID());
//			if(b == null)
//			{
//				System.out.println("数据出错");
//				return;
//			}
//			else
//			{
//				System.out.println(b.getBookName());
//			}
//		}

	}


	public void updateWithQuery(String HQL) {
		dao.updateWithQuery(HQL);
		
	}
}
