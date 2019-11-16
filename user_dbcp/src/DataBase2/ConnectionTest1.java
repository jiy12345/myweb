package DataBase2;

import java.sql.Connection;
import static DataBase2.JDBCUtil.*;

public class ConnectionTest1 {
	public static void main(String[] args) {
		Connection con  = getConnection();
		if(con!=null)
			System.out.println("연결되었습니다!");
	}
}
