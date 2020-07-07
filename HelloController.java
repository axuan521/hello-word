package demo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.security.sasl.SaslClientFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.template.expr.ast.Map;
import com.jfinal.upload.UploadFile;

import demo2.MkglService;

public class HelloController extends Controller {
	HelloService service = HelloService.me ;
	private final String UPLOAD_PATH="D:\\downLoadTest";
	File tempPathFile;
	public void index() {
	       render("hello.html");
		//render("Table.jsp");
	    }
	
	@ActionKey("/login")
		public void login() {
			//��ȡ�û�������
		MkglService mkglService = MkglService.me;
			String username = getPara("username");
			String password = getPara("password");
			System.out.println("ҳ�洫�ݵĲ�����username=" + username + " password=" + password );
		    User_T user_T = service.selectByUandP(username, password);
		    if(user_T !=null) {
		    	//subFile2();
		    	List<User_T_L> list=mkglService.paginate();
				setSessionAttr("mkPage", list);
		    	render("Table.jsp");
				//render("UpLoad.html");
		    }else {
		    	renderText("file");
		    }
		    //render("hello.jsp");
		}
	@ActionKey("/findRes")
	public void findRes() {
		render("Res.html");
	}
	@ActionKey("/res")
	public void res() {
		//��ȡ�û�������
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String username = getPara("username");
		String password = getPara("password");
		String sex = getPara("sex");
		String g=getPara("gid");
		String data=getPara("date");
		 Date d = null; 
	     try {
			d=format1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer gid=Integer.parseInt(g);
		System.out.println(data);
		System.out.println("ҳ�洫�ݵĲ�����username=" + username + " password=" + password +g);
	    boolean b=service.insertU(username, password, gid,d,sex);
	    if(b) {
	    	
	    	renderText("1111");
	    }else {
	    	renderText("000");
	    }
	    //render("hello.jsp");
	}
	
	@ActionKey("/upload")
	public void upload(){
		UploadFile file=getFile("file");
		File fil=file.getFile();
		fil.renameTo(new File("ddd"));
	}
	@ActionKey("/downLoadTest")
	public void downLoadTest(){
		String the_path=PathKit.getWebRootPath()+"\\upload\\as.txt";
		String path=getSession().getServletContext().getRealPath("dpwnLoadTest");
		File file=new File(path+"/a.txt");
		String file2="C:/Users/admin/Desktop/config.txt";
		System.out.println(path);
		System.out.println(the_path);
		System.out.println(file.exists());
		renderFile(new File(file2));
		/*if(file2.exists()){
			
		}
		else{
			renderJson("�ļ�������");
		}*/
		
	}
	
	
		
	@ActionKey("/subfile")
	public void subFile() throws Exception{
		System.out.println("1111111111111");
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096); // ���û�������С��������4kb
			factory.setRepository(tempPathFile);// ���û�����Ŀ¼

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); // ��������ļ��ߴ磬������4MB

			List<FileItem> items = upload.parseRequest(this.getRequest());// �õ����е��ļ�
			Iterator<FileItem> i = items.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();  
                String fileName = fi.getName();
                if (fileName != null) {  
                    File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // ����ļ�����������
                    File savedFile = new File(UPLOAD_PATH, fullFile.getName());  
                    fi.write(savedFile);
                }
			}
			System.out.print("upload succeed"); 
			renderText("SUCCESS");
		} catch (Exception e) {
			System.out.println("upload failed");
			renderText("FAIL");
			e.printStackTrace();
		}

	}
	@ActionKey("/subFile2")
	public void subFile2() {
		System.out.println("1111111111111");
		File file = new File(UPLOAD_PATH);
		File [] array = file.listFiles();
		List<String> fileList = new ArrayList<String>();
		for(int i = 0;i<array.length;i++){
			if(array[i].isFile()){
				fileList.add(array[i].getName());
			}else if(array[i].isDirectory()){
				getFile(array[i].getPath());
			}
		}
		HttpSession session = this.getSession();
		session.setAttribute("fileList", fileList);
		System.out.println(fileList);
	}
	

   
}
