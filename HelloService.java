package demo;



import java.util.Date;

import com.jfinal.plugin.activerecord.Db;

public class HelloService {
public static final HelloService me = new HelloService();
	
	private User_T dao = new User_T().dao();
	
	public User_T selectByUandP(String username,String password) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("select * from user_t where name = ? and pwd = ?");
	    System.out.println("Service�Ĳ�����username=" + username + " password=" + password );
	    return dao.findFirst(sb.toString(), new Object[]{username,password});
	}
	
	public boolean insertU(String name,String pwd,Integer gid,Date data,String sex){
		//String uuid=UUIDUtil.getUUID();
		String sql="insert into user_t values(?,?,?,?,?)";
		int i=Db.update(sql,new Object[]{name,pwd,gid,data,sex});
		return i==1?true:false;
	}
	
	
}
