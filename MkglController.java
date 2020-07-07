package demo2;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.jsr356.annotations.Param;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.template.expr.ast.Map;
import com.jfinal.template.source.StringSource;
import com.jfinal.upload.UploadFile;

import demo.User_T;
import demo.User_T_L;
import util.DateUtil;


public class MkglController extends Controller {
	MkglService mkglService = MkglService.me;
	public void index() {
		String nodeId = getPara("shijian"); 	
		System.out.println(nodeId);
		//setAttr("mkPage", mkglService.paginate()) ;
		//List<User_T> list=mkglService.paginate();
		List<User_T_L> list=mkglService.paginate();
		setSessionAttr("mkPage", list);
		System.out.println(list.toString());
		System.out.println("111111");
		render("Table.jsp") ;                      
	} 
	@ActionKey("/delete")
	public void delete() {
		System.out.println("dddd");
		System.out.println(getPara("deleteNodeId"));
		int i=Integer.parseInt(getPara("deleteNodeId"));
		//mkglService.deleteById(getPara("deleteNodeId"));
		mkglService.del(i);
		//redirect("/hello1/");
		List<User_T_L> list=mkglService.paginate();
		System.out.println(list.toString());
		setSessionAttr("mkPage", list);
		render("Table.jsp") ;
	}
	@ActionKey("/res2")
	public void res2() {
	

		//getFile("file").getFile().renameTo(new File("D:\\jfinal_download\\123456.jpg"));
		//UploadFile file=getFile("doc-form-file2","a",100*1024*1024,"utf-8");
		//File delfile = new File(file.getUploadPath()+"\\"+file.getFileName());
		System.out.println("dddddd");
	//	if(file.getFileName() == null || "".equals(file.getFileName()))
	//	{
			System.out.println("llll"); 
	//	}
	//	System.out.println("dddddd");
		
		//DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String shiyou = getPara("shiyou1");
		String jine = getPara("jine1");
		String yanshou = getPara("yanshou1");
		String shijian=getPara("shijian1");
		String id=getPara("id1");
		Integer id2=Integer.parseInt(id);
	//	String dizhi=file.getFileName();
	//	 Date d = null; 
	 //    try {
	//		d=format1.parse(data);
	//	} catch (ParseException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		//}
	//Integer gid=Integer.parseInt(g);
		System.out.println(id);
		System.out.println("页面传递的参数:username=" + shiyou + " yanshou=" + yanshou );
	    boolean b=mkglService.updateU(shiyou, jine, yanshou,shijian,id2);
	    if(b) {
	    	//index();
	    	List<User_T_L> list=mkglService.paginate();
			setSessionAttr("mkPage", list);
			render("Table.jsp") ;
	    	//renderText("1111");
	    }else {
	    	renderText("000");
	    }
	    //render("hello.jsp");
	}
	@ActionKey("/search")
	public void search(){
		
		String name= getPara("FUNCTIONNAME");
		System.out.println(name);
		List<User_T_L> list=mkglService.selectA(name);
		setSessionAttr("mkPage", list);
    	render("Table.jsp");
	}
	
	/**
	 * ���ɱ����ļ������·��
	 * @param moduleId
	 * @param tObjId
	 * path = moduleId/tobjId/201805311410
	 */
	private String productPath(String moduleId, String tObjId) {
		StringBuilder sb = new StringBuilder();
		sb.append(moduleId);
		sb.append(File.separator);
		sb.append(tObjId);
		sb.append(File.separator);
		sb.append(DateUtil.getDateTimeFormatNo(new Date()));
		sb.append(File.separator);
		return sb.toString();
	}
	@ActionKey("/res4")
	public void res4() {
		
	}
	@ActionKey("/res3")
	public void res3() throws ParseException {

		
		//getFile("file").getFile().renameTo(new File("D:\\jfinal_download\\123456.jpg"));
		//UploadFile file=getFile("doc-form-file","a",100*1024*1024,"utf-8");
		//File delfile = new File(file.getUploadPath()+"\\"+file.getFileName());
		System.out.println("dddddd");
		//System.out.println(file.getFileName()); 
	
		String shiyou = getPara("shiyou");
		String jine = getPara("jine");
		String yanshou = getPara("yanshou");
		String shijian=getPara("shijian");
		String id=getPara("id");
		System.out.println("zheshi"+id);
		Integer id2=Integer.parseInt(id);
System.out.println(shiyou +jine +yanshou+ shijian+id2);
		//String dizhi=file.getFileName();
		 //Date d = null; 
	     //	Integer gid=Integer.parseInt(g);
		int m=1;
		System.out.println(shijian);
	//	System.out.println("页面传递的参数:username=" + username + " password=" + password +g);
	    boolean b=mkglService.insertU(shiyou, jine,  yanshou,shijian,id2);
	    if(b) {
	    	List<User_T_L> list=mkglService.paginate();
			setSessionAttr("mkPage", list);
			render("Table.jsp") ;
	    	//renderText("11110000");
	    }else {
	    	renderText("000");
	    }
	    //render("hello.jsp");
	}
	
//	public void expExcel(){
//		   
//	    int  length=5; // �еĸ�����
//	    String title="EXCELģ��";
//		String xhFlag="1";//0:û����ţ�1�������
//		
//	    Object[] obj1=new Object[]{length,title}; //�ļ�������ͷ������
//	    Object[] obj2=new Object[]{"��1","��2","��3","��4","��5" };//EXCEL��ͷ������
//	    Object[] obj3=new Object[]{"user_id","user_gh","sap_person_name" ,"user_sfz"};//�������
//	    //�����
//	    List<User_T> excelList = userService.getPerson();
//	    
//	    OutputStream fos=null;
//		HttpServletResponse response=super.getResponse();						
//		try{
//			String filenamedisplay = "123.xls";
//			filenamedisplay = URLEncoder.encode(filenamedisplay,"UTF-8");
//			response.reset();
//			response.setContentType("application/x-msdownload");
//			response.addHeader("Content-Disposition","attachment;filename=" + filenamedisplay);
//			fos = response.getOutputStream();					
//			ExpExcel expExcel=new ExpExcel();
//			expExcel.expExcel(obj1,obj2,obj3,excelList,xhFlag,fos);
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			try{ if(fos!=null) {fos.close();} }catch(Exception e){}
//		}
//		renderNull();
//		} 
}
