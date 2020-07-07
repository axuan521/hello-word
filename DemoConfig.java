package demo;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import demo2.MkglController;

public class DemoConfig extends JFinalConfig {
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
	
		PropKit.use("config.txt");
	
		me.setViewType(ViewType.JSP);
		me.setDevMode(PropKit.getBoolean("devMode", false));      
		me.setEncoding("UTF-8");
		me.setBaseUploadPath("upload");
		me.setBaseDownloadPath("D:/downLoadTest");

	    
	}

	@Override
	public void configRoute(Routes me) {
		

		me.add("/hello", HelloController.class,"/view");
		me.add("/hello1", MkglController.class,"/view");
		
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		
	}
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(
				PropKit.get("oracle.url"), 
				PropKit.get("oracle.username"), 
				PropKit.get("oracle.password").trim(),
				PropKit.get("oracle.driver").trim()   
				);
		
	}


	@Override
	public void configPlugin(Plugins me) {
	// ����C3p0���ݿ����ӳز��
				DruidPlugin druidPlugin = createDruidPlugin();
				me.add(druidPlugin);
				// ����ActiveRecord���
				ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
				arp.setDialect(new OracleDialect());// �������ݿⷽ��
				arp.setContainerFactory(new CaseInsensitiveContainerFactory());// ���Դ�Сд
				// ����ӳ���� MappingKit ���Զ����㶨
				_MappingKit.mapping(arp);
				me.add(arp);

		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 89, "/", 5);
	}
}
