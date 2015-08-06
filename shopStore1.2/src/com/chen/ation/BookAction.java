package com.chen.ation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Book;
import com.chen.entity.Customer;
import com.chen.entity.ShoppingCart;
import com.chen.service.BookService;
import com.chen.service.CustomerService;
import com.chen.service.ShoppingCartService;
import com.chen.serviceImp.BookServiceImp;
import com.chen.serviceImp.CustomerServiceImp;
import com.chen.serviceImp.ShoppingCartServiceImp;

public class BookAction {
	CustomerService cs = new CustomerServiceImp();
	BookService bs = new BookServiceImp();
	ShoppingCartService  s_c_service = new ShoppingCartServiceImp();
	CustomerService cust = new CustomerServiceImp();
	java.util.Date date=new java.util.Date();

	public String listBook()
	{
		//这个方法是在right.jsp的页面中显示图书效果的页面
		Book book = new Book();
		String HQL = "from Book";
		List list = new ArrayList();
		list = bs.findWithPage(1, 2, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "bookList";
	}
	
	

	
	
	public String addInCart()
	{
//		
		double sum = 0;
		int count;
		Customer customer;
		ShoppingCart shopc;
		Book b ;
		boolean haveBook = false;//代表购物车中没有相同的书
		Book book = new Book();
		
		Set<Book> set ;//这个set用来存储刚加进来的book
		List<Book> li = (List<Book>)ServletActionContext.getRequest().getSession().getAttribute("li");
		if(li == null)
		{
		  li = new ArrayList<Book>();
		  ServletActionContext.getRequest().getSession().setAttribute("li",li);
		}
		Iterator ita ;
		
		int b_id = Integer.parseInt(ServletActionContext.getRequest().getParameter("b_Id"));
	
		customer =(Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		book = bs.findOneBook("from Book where id=" + b_id);

		count = book.getCount() - 1;
		shopc = customer.getShoppingCart();
		if(shopc.getBook() != null)
		{
			set = shopc.getBook(); 
			ita = set.iterator();
			while(ita.hasNext())
			{
				b = (Book)ita.next();
				if(b.getId() == b_id)
				{
					haveBook = true;
					break;
				}
			}
			
			if(!haveBook)
			{
				
				book.setCount(count);
				
				bs.updateBook(book);
				
				while(ita.hasNext())
				{
					b = (Book)ita.next();
					li.add(b);
					sum += b.getPrice();
				}
				set.add(book);
				sum += book.getPrice();
				li.add(book);
				shopc.setTotalPrice(sum);
				s_c_service.updateOneRecord(shopc);
//			
				ServletActionContext.getRequest().getSession().setAttribute("sum", sum);
				haveBook = false;
				return "addInCart";
			}else
			{
				haveBook = false;
				return "HaveBook";
			}
			 
		}else
		{
			return "addInCart";
		}
		
		
//		//购物车中没有相同id的书，进行下面代码
	
//		
		
	}
	
	public void show()
	{
		//此方法为显示购物车商品
		//测试成功
		Customer customer = new Customer();
		customer = cust.findOneCustomer("from Customer where id=" + 1);
		Set<Book> set = new HashSet<Book>();
	 	set = customer.getShoppingCart().getBook();
	 	Iterator ita = set.iterator();
	 	double sum = 0;
		while(ita.hasNext())
		{
			Book b = (Book)ita.next();
		
			sum = sum + b.getPrice();
		}
		System.out.println(sum);
	}
	
	
	
	
	//书的后台处理
	public String loadBookSet()
	{
		int action =Integer.parseInt(ServletActionContext.getRequest().getParameter("action"));
		
		
		if(action == 0)
		{
			String HQL = "from Book";
			sendList(HQL);
			return "loadBookSet";
		}
		else if(action == 1)
		{
			int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
			Book b = bs.findOneBook("from Book where id="+ id);
			ServletActionContext.getRequest().getSession().setAttribute("book", b);
			String HQL = "from Book";
			sendList(HQL);
			return "updateBook";
		}else if(action == 2)
		{
			int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
			bs.deleteBook(id);
			String HQL = "from Book";
			sendList(HQL);
			return "loadBookSet";
		}else if(action == 3)
		{
			String HQL = "from Book where bookSort = 'literature'";
			sendList(HQL);
			return "loadBookSet";
		}else if(action == 4)
		{
			String HQL = "from Book where bookSort = 'economy'";
			sendList(HQL);
			return "loadBookSet";
		}else if(action == 5)
		{
			String HQL = "from Book where bookSort = 'science'";
			sendList(HQL);
			return "loadBookSet";
		}else if(action ==  6)
		{
			String HQL = "from Book where bookSort = 'education'";
			sendList(HQL);
			return "loadBookSet";
		}else if(action == 7)
		{
			Book b = new Book();
			String bID = "BX" + (date.getYear()+1900) + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds();
			b.setBookID(bID);
			ServletActionContext.getRequest().getSession().setAttribute("book", b);
			return "saveBook";
		}else
		{
			return null;
		}
	}
	
	public void sendList(String HQL)
	{
		List<Book> list = new ArrayList<Book>();
		list = findGoods(0, 10, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
	}
	public String updateBook() {
		
		Book book = (Book)ServletActionContext.getRequest().getSession().getAttribute("book");
		String bookID = ServletActionContext.getRequest().getParameter("bookID");
		String bookName = ServletActionContext.getRequest().getParameter("bookName");
		String author = ServletActionContext.getRequest().getParameter("author");
		String press = ServletActionContext.getRequest().getParameter("press");
		String version = ServletActionContext.getRequest().getParameter("version");
		int count = Integer.parseInt(ServletActionContext.getRequest().getParameter("count"));
		String bookSort = ServletActionContext.getRequest().getParameter("bookSort");
		double price = Double.valueOf(ServletActionContext.getRequest().getParameter("price"));
		
		book.setBookID(bookID);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPress(press);
		book.setVersion(version);
		book.setCount(count);
		book.setBookSort(bookSort);
		book.setPrice(price);
		bs.updateBook(book);
		
		return "updateSuccess";
	}
	public String saveBook()
	{
		Book book = (Book)ServletActionContext.getRequest().getSession().getAttribute("book");
		
		String bookName = ServletActionContext.getRequest().getParameter("bookName");
		String author = ServletActionContext.getRequest().getParameter("author");
		String press = ServletActionContext.getRequest().getParameter("press");
		String version = ServletActionContext.getRequest().getParameter("version");
		int count = Integer.parseInt(ServletActionContext.getRequest().getParameter("count"));
		String bookSort = ServletActionContext.getRequest().getParameter("bookSort");
		int price = Integer.parseInt(ServletActionContext.getRequest().getParameter("price"));
		
	
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPress(press);
		book.setVersion(version);
		book.setCount(count);
		book.setBookSort(bookSort);
		book.setPrice(price);
		bs.saveBook(book);
		return "loadBookSet";
	}

	public List findGoods(int row, int pageSize, String HQL)
	{
		List<Book> list = bs.findWithPage(row, pageSize, HQL);
		return list;
	}
	public static void main(String[] args) {
		BookAction b = new BookAction();
		b.addInCart();
	}
	
	
	
}
