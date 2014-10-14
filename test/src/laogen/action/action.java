package laogen.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import laogen.common.DBcon;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class action extends ActionSupport {

	private String name;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws Exception {// 实现查询功能
		Connection conn = DBcon.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		try {
			stmt = conn.createStatement();
			String sql1 = "select book.* from author, book where author.Name='"
					+ this.name + "' and author.AuthorID=book.AuthorID";
			rs1 = stmt.executeQuery(sql1);
			List<Book> list = new ArrayList<Book>();
			while (rs1.next()) {
				Book book = new Book();
				book.setISBN(rs1.getLong("ISBN"));
				book.setTitle(rs1.getString("Title"));
				book.setAuthorID(rs1.getInt("AuthorID"));
				book.setPublisher(rs1.getString("Publisher"));
				book.setPrice(rs1.getFloat("Price"));
				book.setPublishDate(rs1.getDate("PublishDate").toString());
				list.add(book);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("booklist", list);
			rs1.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "booklist";
	}

	public String del() throws Exception {
		String ISBN = ServletActionContext.getRequest().getParameter("ISBN");
		int AuthorID = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("AuthorID"));
		System.out.println(ISBN);
		long i = Long.parseLong(ISBN);
		Connection conn1 = DBcon.getConnection();
		Statement stmt1 = null;
		try {// 删除功能
			stmt1 = conn1.createStatement();
			String sql = "delete from book where ISBN=" + i;
			int a = stmt1.executeUpdate(sql);
			if (a == 0) {
				System.out.println("删除失败");
			}
			conn1.close();
			stmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {// 删除后刷新页面
			String sql2 = "select * from book where book.AuthorID=" + AuthorID;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "booklist";
	}

	public String query() throws Exception {// 实现信息展示功能
		HttpSession session = ServletActionContext.getRequest().getSession();
		long ISBN =Long.parseLong(ServletActionContext.getRequest()
				.getParameter("ISBN"));
		int AuthorID = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("AuthorID"));
		Connection conn1 = DBcon.getConnection();
		Statement stmt1 = null;
		try {
			stmt1 = conn1.createStatement();
			String sql1 = "select * from author where AuthorID =" + AuthorID;
			ResultSet rs1 = stmt1.executeQuery(sql1);
			List<Author> list = new ArrayList<Author>();
			while (rs1.next()) {
				Author author = new Author();
				author.setAuthorID(rs1.getInt("AuthorID"));
				author.setName(rs1.getString("Name"));
				author.setAge(rs1.getInt("Age"));
				author.setCountry(rs1.getString("Country"));
				list.add(author);
			}
			session.setAttribute("authorlist", list);
			conn1.close();
			rs1.close();
			stmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// 展示作者信息

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {
			String sql2 = "select * from book where book.ISBN=" + ISBN;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// 展示书籍信息
		return "query";
	}

	public String add() throws Exception {//添加书籍
		long ISBN = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("ISBN"));
		String Title = ServletActionContext.getRequest().getParameter("Title");
		long AuthorID = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("AuthorID"));
		String Publisher = ServletActionContext.getRequest().getParameter(
				"Publisher");
		String PublishDate = ServletActionContext.getRequest().getParameter(
				"PublishDate");
		float Price = Float.parseFloat(ServletActionContext.getRequest()
				.getParameter("Price"));

		Connection conn1 = DBcon.getConnection();
		Statement stmt1 = null;
		try {
			String sql1 = "select * from book where book.AuthorID=" + AuthorID;
			stmt1 = conn1.createStatement();
			ResultSet rs1 = null;
			rs1 = stmt1.executeQuery(sql1);
			if (!rs1.next()) {
				this.msg = "作者不存在！";
				Connection conn = DBcon.getConnection();
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
					String sql = "insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values('"
							+ ISBN
							+ "','"
							+ Title
							+ "','"
							+ AuthorID
							+ "','"
							+ Publisher
							+ "','"
							+ PublishDate
							+ "','"
							+ Price
							+ "')";
					int i = stmt.executeUpdate(sql);
					if (i == 0) {
						System.out.println("添加失败");
					} else {
						System.out.println("添加成功");
					}
					conn.close();
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "AddAuthor";
			} else {
				Connection conn = DBcon.getConnection();
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
					String sql = "insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values('"
							+ ISBN
							+ "','"
							+ Title
							+ "','"
							+ AuthorID
							+ "','"
							+ Publisher
							+ "','"
							+ PublishDate
							+ "','"
							+ Price
							+ "')";
					int i = stmt.executeUpdate(sql);
					if (i == 0) {
						System.out.println("添加失败");
					} else {
						System.out.println("添加成功");
					}
					conn.close();
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			rs1.close();
			conn1.close();
			stmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {//刷新页面
			String sql2 = "select * from book where book.AuthorID=" + AuthorID;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "booklist";
	}

	public String addauthor() throws Exception {//添加作者
		long AuthorID = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("AuthorID"));
		String Name = ServletActionContext.getRequest().getParameter("Name");
		long Age = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("Age"));
		String Country = ServletActionContext.getRequest().getParameter(
				"Country");

		Connection conn = DBcon.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "insert into Author(AuthorID,Name,Age,Country) values('"
					+ AuthorID
					+ "','"
					+ Name
					+ "','"
					+ Age
					+ "','"
					+ Country
					+ "')";
			int i = stmt.executeUpdate(sql);
			if (i == 0) {
				System.out.println("添加失败");
			} else {
				System.out.println("添加成功");
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {// 刷新页面
			String sql2 = "select * from Book where Book.AuthorID=" + AuthorID;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "booklist";
	}

	public String update() throws Exception {//更新书籍
		long ISBN = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("ISBN"));
		String AuthorID = ServletActionContext.getRequest().getParameter(
				"AuthorID");
		int i = Integer.parseInt(AuthorID);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Connection conn1 = DBcon.getConnection();
		Statement stmt1 = null;
		try {
			stmt1 = conn1.createStatement();
			String sql1 = "select * from author where AuthorID =" + i;
			ResultSet rs1 = stmt1.executeQuery(sql1);
			List<Author> list = new ArrayList<Author>();
			while (rs1.next()) {
				Author author = new Author();
				author.setAuthorID(rs1.getInt("AuthorID"));
				author.setName(rs1.getString("Name"));
				author.setAge(rs1.getInt("Age"));
				author.setCountry(rs1.getString("Country"));
				list.add(author);
			}

			session.setAttribute("authorlist", list);
			conn1.close();
			rs1.close();
			stmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// 展示作者信息

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {
			String sql2 = "select * from Book where Book.ISBN=" + ISBN;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//展示书籍信息
		return "update";
	}

	public String update1() throws Exception {//更新需要更新的信息
		long AuthorID = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("AuthorID"));
		String Name = ServletActionContext.getRequest().getParameter("Name");
		long Age = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("Age"));
		String Country = ServletActionContext.getRequest().getParameter(
				"Country");
		String Publisher = ServletActionContext.getRequest().getParameter(
				"Publisher");
		String PublishDate = ServletActionContext.getRequest().getParameter(
				"PublishDate");
		float Price = Float.parseFloat(ServletActionContext.getRequest()
				.getParameter("Price"));

		Connection conn = DBcon.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "update book set Publisher='" + Publisher
					+ "',PublishDate='" + PublishDate + "',Price='" + Price
					+ "' where AuthorID=" + AuthorID;
			//stmt.executeUpdate(sql);
			int i = stmt.executeUpdate(sql);
			if (i == 0) {
				System.out.println("修改失败");
			} else {
				System.out.println("修改成功");
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn1 = DBcon.getConnection();
		Statement stmt1 = null;
		try {
			stmt1 = conn1.createStatement();
			String sq2 = "update Author set Name='" + Name + "',Age='" + Age
					+ "',Country='" + Country + "' where AuthorID=" + AuthorID;
			int i = stmt1.executeUpdate(sq2);
			if (i == 0) {
				System.out.println("修改失败");
			} else {
				System.out.println("修改成功");
			}
			conn1.close();
			stmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn2 = DBcon.getConnection();
		Statement stmt2 = null;
		try {// 刷新页面
			String sql2 = "select * from book where book.AuthorID=" + AuthorID;
			stmt2 = conn2.createStatement();
			ResultSet rs2 = null;
			rs2 = stmt2.executeQuery(sql2);
			List<Book> list = new ArrayList<Book>();
			while (rs2.next()) {
				Book book = new Book();
				book.setISBN(rs2.getLong("ISBN"));
				book.setTitle(rs2.getString("Title"));
				book.setAuthorID(rs2.getInt("AuthorID"));
				book.setPublisher(rs2.getString("Publisher"));
				book.setPrice(rs2.getFloat("Price"));
				book.setPublishDate(rs2.getDate("PublishDate").toString());
				list.add(book);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("booklist", list);
			rs2.close();
			conn2.close();
			stmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "booklist";
	}

}