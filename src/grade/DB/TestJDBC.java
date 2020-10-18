package grade.DB;//同一个文件夹下，有利于其他类的调用
//纯代码连接数据库
//import java.sql.*;
import java.sql.Connection;	//导入sql数据库连接包，创建连接数据库对象需要的包
//import grade.VIEW.LOGIN;
import java.sql.DriverManager;		//导入sql数据库驱动包，数据库的连接需要驱动的支持
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;		

//测试java database connection
/**
 * this is jdbc connect database
 * now, using oracle db ,user and password needed change
 * @author nwx
 *
 */
public class TestJDBC {
  Connection con ;				//声明连接数据库对象
  String user = "ni" ;			//连接的用户
  String password = "ni" ;		//连接的用户密码
  String className = "oracle.jdbc.driver.OracleDriver" ;		//oracle驱动类型
  //String url = "jdbc:oracle:thin:@192.168.1.101:1521:nwx" ;		//本机IPv4,IPv4必须在连接网才有，定位数据库和端口
  String url = "jdbc:oracle:thin:@localhost:1521:orcl" ;		//本机定位数据库和端口
  
  public TestJDBC(){
	  this.ConnectOracle();					//对象调用连接oracle方法步骤一(加载驱动)
	  this.getCon();							//对象调用连接oracle方法步骤二(连接数据库)
	  this.closed();							
	  //对象关闭(可要可不要，关闭相当于释放资源，相当于我之前我买了一个永久的VIP,那么我可以忽略以后的所有加入VIP的活动
  }
  
  //加载驱动程序
  public void ConnectOracle() {
  	//异常捕获
         try {
               Class. forName(className);
               //JOptionPane.showMessageDialog(null,"恭喜加载数据库驱动成功");
               //System. out.println("加载数据库驱动成功！" );
        } catch (ClassNotFoundException e ) {
        		//JOptionPane.showMessageDialog(null,"加载数据库驱动失败，继续努力吧");
               // System. out.println("加载数据库驱动失败！" );
                e.printStackTrace();
        }
 }

  //创建数据库连接 
  public Connection getCon() {
  	//异常捕获
         try {
                con = DriverManager. getConnection(url, user, password);
                //  JOptionPane.showMessageDialog(null,"恭喜创建数据库连接成功");
                // JOptionPane.showMessageDialog(null,"请进行登录操作");
                //  System. out.println("创建数据库连接成功！" );
                // con.close();
                // new LOGIN();
        } catch (SQLException e ) {
               System. out.print(con );
               JOptionPane.showMessageDialog(null,"创建数据库连接失败，请继续努力");
                con = null;
                e.printStackTrace();
        
        }
         return con ;//返回已连接数据库的对象
 }

  //关闭
  public void closed() {
  	//异常捕获
         try {
                if (con != null) {		//if对象不为空是真的
                      con.close();		//关闭连接数据库对象
               }
        } catch (SQLException e ) {
              // System. out.println("关闭con对象失败！" );
                e.printStackTrace();		
        }
 }
}

//可以在连接数据库的代码两种插入一些增删改查的方法代码，以便视图代码中可以调用
 /* 
  	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;//创建连接数据库对象
//1.查询
		public ResultSet queryExectue(String sql,String []paras)
		{
			try {
							
				//1.加载驱动
				Class.forName(className); 
				//2.得到链接	
				ct=DriverManager.getConnection(url,user,password);
				//3.创建ps
				ps=ct.prepareStatement(sql);
			    //给ps的问号赋值
				for(int i=0;i<paras.length;i++)
				{
					ps.setString(i+1, paras[i]);
				}
							
				rs=ps.executeQuery();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					//关闭资源???
										
				}
				return rs;								
				}
						
	//把对数据库的增  删	改，改写一个函数
	public boolean exeUpdate(String sql,String[]paras)
	{
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();		
		}
		return b;
	}
	//得到结果集，rs
	public ResultSet query(String sql,String paras)
	{
		try {
			ps=ct.prepareStatement(sql);
			int i=0;
			ps.setString(i+1,paras);
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}*/