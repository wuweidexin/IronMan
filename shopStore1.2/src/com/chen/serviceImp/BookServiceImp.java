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
	//�����ǲ��Դ���
	public static void main(String[] arg)
	{
		BookServiceImp bsi = new BookServiceImp();

		//���һ����Ʒ
		//���Խ��ͨ��
		//		Book b = new Book();
		//		b.setAuthor("�Ź���");
		//		b.setBookID(1);
		//		b.setBookName("ׯ�ӵ�˼������");
		//		b.setBookSort("��ѧ");
		//		b.setCount(50);
		//		b.setPress("�廪");
		//		b.setVersion("��һ��");
		//		books.saveBook(b);

		//�޸�һ����Ʒ
		//���Գɹ����޸�ʱ�������book���������󶼵ø�ֵ��Ҫ��Ȼ�������������ȫ����Ϊ�յ����
		//		Book book = new Book();
		//		book.setId(2);
		//		book.setPress("������ѧ");
		//		book.setVersion("�ڶ���");
		//		bsi.updateBook(book);

		//����һ����Ʒ
		//���Գɹ�������Ҫע��id������ڷ������ָ��Ϊ�յ��쳣
//						Book book = new Book();
//						book = bsi.findOneBook("from Book where id =" + 1);
//						System.out.println(book.getBookName());

		//����һ���������Ʒ
		//���Գɹ�
		//		List<Book> list = new ArrayList<Book>();
		//		list = bsi.findList("from Book");
		//		for(int i = 0 ;i < list.size(); i ++)
		//		{
		//			Book  book = new Book();
		//			book = (Book)list.get(i);
		//			System.out.println("******");
		//			System.out.println("�����ǣ�" + book.getBookName());
		//		}

		//����ҳ�����Ʒ
		//���Գɹ�
		//		List<Book> list = new ArrayList<Book>();
		//		list = bsi.findWithPage(0, 2, "from Book");
		//		for(int i = 0 ;i < list.size(); i ++)
		//		{
		//			Book  book = new Book();
		//			book = (Book)list.get(i);
		//			System.out.println("******");
		//			System.out.println("�����ǣ�" + book.getBookName());
		//		}


		//ɾ��һ����Ʒ
		//���Գɹ�
		//bsi.deleteBook(1);


		//����һ�����ﳵ�е���Ʒ
		//���Գɹ������Ǳ���book��ȫ����shoppingCart�е�bookID�ĺţ�Ҫ��Ȼ���ֿ�ָ�����
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
//				System.out.println("���ݳ���");
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
