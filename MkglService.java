package demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.template.expr.ast.Id;
import com.jfinal.upload.UploadFile;

import demo.UUIDUtil;
import demo.User_T;
import demo.User_T_L;



public class MkglService {

	public static final MkglService me = new MkglService(); 
	
	/**
	 * 
	 * 			http://www.jfinal.com/doc/5-13
	 */ 
	private User_T dao = new User_T().dao(); 
	private User_T_L dao2 = new User_T_L().dao(); 
	public List<User_T_L> paginate() { 
		//String sql="select * from user_t ";
		//List<User_T> findAll = dao.findAll();
		//System.out.println(findAll.toString());
		return dao2.findAll();


	}
	public List<User_T_L> selectA(String key) {
		String sql="select * from user_t_l where shijian like '%"+key+"%'";
		System.out.println("skhfkj");
		List<User_T_L> likelist=dao2.find(sql);
		return likelist;
	}
	public void deleteById(String id) {
		dao.deleteById(id);
	}
	/*@Before(Tx.class)*/
	public void saveFiles(List<UploadFile> files, String moduleId, String tObjId, String filePath, String userId,String proFileType) {
		for(UploadFile tmpFile : files){
			save(moduleId, tObjId, tmpFile.getFileName(), filePath, userId,proFileType);
		}
	}
	
	private void save(String moduleId,String tObjId,String realName,String filePath,String userId,String proFileType){
		String uuId = UUIDUtil.getUUID();
		String file_name = moduleId + "-" + uuId + realName.substring(realName.lastIndexOf("."));
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into t_com_file (FILE_ID,FILE_TITLE,FILE_URL,FILE_DATE,FILE_USERID,FILE_MODULEID,FILE_NAME,TABLE_OBJID,FILE_TYPE) values(?,?,?,?,?,?,?,?,?) ");
		Db.update(sb.toString(), new Object[]{uuId,realName,filePath,new Date(),userId,moduleId,file_name,tObjId,proFileType});
	}
	public boolean insertU(String shiyou,String jine,String yanshou,String shijian,Integer id){
		//String uuid=UUIDUtil.getUUID();
		String sql="insert into user_t_l values(?,?,?,?,?)";
		int i=Db.update(sql,new Object[]{shiyou,jine,yanshou,shijian,id});
		return i==1?true:false;
	}
	public void del(Integer id){
		//String uuid=UUIDUtil.getUUID();
		String sq="";
		sq="delete from user_t_l f where f.id='"+id+"' "; 
		Db.delete(sq);
		System.out.println("1111");
		

}
	public boolean updateU(String shiyou,String jine,String yanshou,String shijian,Integer id){
		//String uuid=UUIDUtil.getUUID();
	
		String sq="";
		System.out.println("tttttt");
		sq="delete from user_t_l f where  f.id='"+id+" '"; 
		Db.delete(sq);
		System.out.println("11115555");
		String sql="insert into user_t_l values(?,?,?,?,?)";
		int i=Db.update(sql,new Object[]{shiyou,jine,yanshou,shijian,id});
		System.out.println("11112225555");
		return i==1?true:false;
}
	public void fileChannelCopy(File s, File t) {

        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//

            out = fo.getChannel();//

            in.transferTo(0, in.size(), out);// 

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                fi.close();

                in.close();

                fo.close();

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
	

}
