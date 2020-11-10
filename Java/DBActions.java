package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.classes.Product;
import application.classes.Student;
import application.classes.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DBActions {

	// === STUDENT ===
	public static void addStudent(int id, String firstName, String lastName, int grade, String Name1, String Email1,
			String Name2, String Email2) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Student` (`studentId`, `firstName`, `lastName`, `grade`, `parent1Name`, `parent1Email`, `parent2Name`, `parent2Email`) "
				+ "VALUES ('" + id + "', '" + firstName + "', '" + lastName + "', '" + grade + "', '" + Name1 + "', '"
				+ Email1 + "', '" + Name2 + "', '" + Name2 + "')";
		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void updateStudent(int id, int studentId, String firstName, String lastName, int grade, String Name1, String Email1,
			String Name2, String Email2) throws ClassNotFoundException, SQLException {

		String sql = "update Student set firstName='" + firstName + "', lastName='" + lastName + "', grade=" + grade
				+ ", parent1Email='" + Email1 + "', parent2Email='" + Email2 + "', parent1Name='" + Name1
				+ "', parent2Name='" + Name2 + "', studentID='" + studentId + "' WHERE id="+id;
		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void updateGradesUp() throws ClassNotFoundException, SQLException {
		String sql = "update Student set grade=grade+1";

		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void updateGradesDown() throws ClassNotFoundException, SQLException {
		String sql = "update Student set grade=grade-1";

		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void deleteGraduates() throws ClassNotFoundException, SQLException {
		String sql = "delete from Student where grade=13";

		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static ObservableList<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		String sql = "select * from Student";
		try {
			ResultSet rsSet = DBBackground.dbExecute(sql);
			ObservableList<Student> StudentList = getStudentsObjects(rsSet);
			return StudentList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static ObservableList<Student> getStudentsObjects(ResultSet rsSet)
			throws ClassNotFoundException, SQLException {
		try {
			ObservableList<Student> StudentList = FXCollections.observableArrayList();
			while (rsSet.next()) {
				
				int grade = rsSet.getInt("grade");
				String l = Integer.toString(grade);
				
				//Creates string with value of Level x if necessary
				if(grade==8)
					l="Level I";
				else if(grade==9)
					l="Level II";
				else if(grade==10)
					l="Level III";
				else if(grade==11)
					l="Level IV";
				else if(grade==12)
					l="Level V";
				else if(grade==0)
					l="SK";
				else if(grade==-1)
					l="JK";
				else if(grade==-2)
					l="PK";
				
				Student s = new Student(rsSet.getInt("id"), rsSet.getInt("studentId"), rsSet.getString("firstName"), rsSet.getString("lastName"),
						rsSet.getInt("grade"), l, rsSet.getString("parent1Name"), rsSet.getString("parent1Email"),
						rsSet.getString("parent2Name"), rsSet.getString("parent2Email"));
				StudentList.add(s);
			}
			return StudentList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	// === TRANSACTION ===
	public static void addTransaction(String barcodeId, int studentId, String date, Double price)
			throws ClassNotFoundException, SQLException {
		String sql = "insert into Transactions(date,studentId,barcodeId,price) values('" + date + "'," + studentId
				+ ",'" + barcodeId + "'," + price + ")";
		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static ObservableList<Transaction> getAllTransactions() throws ClassNotFoundException, SQLException {
		String sql = "select * from Transactions";
		try {
			ResultSet rsSet = DBBackground.dbExecute(sql);
			ObservableList<Transaction> TransactionList = getTransactionsObjects(rsSet);
			return TransactionList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static ObservableList<Transaction> getTransactionsObjects(ResultSet rsSet)
			throws ClassNotFoundException, SQLException {
		try {
			ObservableList<Transaction> TransactionList = FXCollections.observableArrayList();
			while (rsSet.next()) {
				Transaction t = new Transaction(rsSet.getInt("id"), 
						rsSet.getInt("studentId"), rsSet.getString("date"), rsSet.getDouble("price"));
				TransactionList.add(t);
			}
			return TransactionList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}


	// === PRODUCT ===
	public static void addProduct(String barcodeId, String productName, double price, double discount)
			throws ClassNotFoundException, SQLException {

		String sql = "insert into Product(barcodeId, productName, price, discount) values('" + barcodeId + "','"
				+ productName + "'," + price + ",'" + discount + "')";
		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void updateProduct(int id, String barcodeId, String productName, double price, double discount)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE `Product` SET `barcodeId` = '" + barcodeId + "', `productName` = '" + productName
				+ "', `price` = '" + price + "',`discount` = '" + discount + "' WHERE `Product`.`id` = '" + id + "'";
		try {
			DBBackground.dbExecuteQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static Product getProductByBarcodeId(String barcodeId) throws ClassNotFoundException, SQLException {
		String sql = "select * from Product where barcodeId='" + barcodeId + "'";
		try {
			ResultSet rsSet = DBBackground.dbExecute(sql);
			ObservableList<Product> list = getProductsObjects(rsSet);
			return list.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static ObservableList<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		String sql = "select * from Product";
		try {
			ResultSet rsSet = DBBackground.dbExecute(sql);
			ObservableList<Product> ProductList = getProductsObjects(rsSet);
			return ProductList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static ObservableList<Product> getProductsObjects(ResultSet rsSet)
			throws ClassNotFoundException, SQLException {
		try {
			ObservableList<Product> ProductList = FXCollections.observableArrayList();
			while (rsSet.next()) {
				Product p = new Product(rsSet.getInt("id"), rsSet.getString("barcodeId"),
						rsSet.getString("productName"), rsSet.getDouble("price"), rsSet.getDouble("discount"));
				ProductList.add(p);
			}
			return ProductList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
