
import java.sql.Connection;
import java.sql.DriverManager;


//������ݿ����ӺͲ����࣬JDBC-SQLSever
public class Database {
		//ʵ��������ݿ�ʵ��
		Connection con=null;
		Connection mConnection;
		
		public Database()
			{
			try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					//���������ַ�ʹ��sa�˺ź�����
					String connectionUrl = "jdbc:sqlserver://localhost;user=sa;password=1234567;";
					//ʹ�������ַ�����
					con = DriverManager.getConnection(connectionUrl);
			}
			catch(Exception e)
			{
				//��ӡ�e�`��Ϣ
				e.printStackTrace();
			}
			}			
}


