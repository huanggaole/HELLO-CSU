

import java.sql.CallableStatement;


public class LoginService extends Database{
   
	//锟节硷拷锟斤拷锟斤拷锟斤拷锟斤拷WebService锟斤拷,锟斤拷锟斤拷public锟斤拷锟斤拷锟斤拷锟斤拷锟轿拷锟斤拷锟斤拷锟较碉拷械锟揭辉�锟结供指锟斤拷锟侥癸拷锟斤拷
	//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絧ublic锟斤拷锟斤拷锟侥癸拷锟斤拷:锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟街わ拷锟较拷晒锟斤拷锟�锟斤拷锟斤拷锟矫伙拷User锟斤拷息
	public User Login(int userID,String password)
	{    
		try{
			  User user=null;
			  //锟斤拷锟斤拷锟斤拷菘锟斤拷械拇娲拷锟斤拷dbo.login
			  CallableStatement cstmt = con.prepareCall("{? = call dbo.Login(?,?)}");
			  //锟斤拷锟矫凤拷锟斤拷锟斤拷锟酵ｏ拷一锟斤拷锟斤拷娲拷锟教凤拷锟斤拷值锟斤拷同
		      cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		      //锟斤拷锟矫达拷锟斤拷锟斤拷锟斤拷锟芥储锟斤拷锟斤拷锟酵�
		      cstmt.setInt(2, userID);
		      cstmt.setString(3,password);
		      cstmt.execute();//执锟叫存储锟斤拷锟�
		      System.out.println("RETURN STATUS: " + cstmt.getInt(1));
		      //锟斤拷荽娲拷锟斤拷锟斤拷锟斤拷锟截斤拷锟饺凤拷锟経ser锟角凤拷锟斤拷冢锟斤拷锟斤拷锟截凤拷锟斤拷锟斤拷撇锟斤拷锟斤拷锟斤拷锟斤拷疲锟斤拷锟斤拷锟斤拷圆锟角�
		      //锟斤拷锟斤拷锟斤拷锟接斤拷锟斤拷WebService锟斤拷
		      if(cstmt.getInt(1)==1){
		    	  user.setUserID(userID);		    	
		      }
		      else{
		    	  user.setUserID(0);		    	  
		      }		    	  
		      cstmt.close();
		      return user;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}     
	}
}
