package generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

	@Test
	public void generateCode() {
		String packageName = "com.susoft";
		boolean serviceNameStartWithI = false;// user -> UserService, 设置成true: user -> IUserService
		generateByTables(serviceNameStartWithI, packageName, false, "t_user","t_role");
	}

	private void generateByTables(boolean serviceNameStartWithI, String packageName, boolean entityOnly,
								  String... tableNames) {
		AutoGenerator autoGenerator = new AutoGenerator();
		GlobalConfig config = new GlobalConfig();
		String dbUrl = "jdbc:mysql://localhost:3306/book";
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL).setUrl(dbUrl).setUsername("root").setPassword("root")
				.setDriverName("com.mysql.jdbc.Driver");
		StrategyConfig strategyConfig = new StrategyConfig();
		List<TableFill> tableFillList = new ArrayList<>();
		// 公共字段
		tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
		tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
//		.setDbColumnUnderline(true)
		strategyConfig.setCapitalMode(true).setEntityLombokModel(false)
				// 逻辑删除字段
				.setLogicDeleteFieldName("delete_flag")
				.setTableFillList(tableFillList)
				.setNaming(NamingStrategy.underline_to_camel)
//				.setSuperMapperClass("com.jeeyeah.cube.data.mybatis.mapper.MapperSupported")
				.setTablePrefix("t_")
				.setInclude(tableNames);// 修改替换成你需要的表名，多个表名传数组
		config.setActiveRecord(true).setAuthor("forrest")
				.setOutputDir(
						"C:\\Users\\hp"
								+ "\\parentSoft\\mapper\\src\\main\\java")
				.setFileOverride(true);
		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}
		//自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
			}
		};
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		if(!entityOnly) {
			focList.add(new FileOutConfig("mapper.xml.vm") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					return "C:\\Users\\hp\\parentSoft\\mapper\\src\\main\\resources\\mapper\\" + tableInfo.getEntityName() + "Mapper.xml";
				}
			});
			cfg.setFileOutConfigList(focList);
		}

		TemplateConfig tc = new TemplateConfig();
		tc.setXml(null);
		tc.setController(null);
		tc.setService(null);
		tc.setServiceImpl(null);
		if (entityOnly) {
			tc.setMapper(null);
		} else {
			tc.setService("service.java.vm");
			tc.setServiceImpl("serviceImpl.java.vm");
			tc.setMapper("mapper.java.vm");
		}
		tc.setEntity("entity.java.vm");
		autoGenerator.setGlobalConfig(config).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
				.setTemplate(tc)
				.setCfg(cfg)
				.setPackageInfo(new PackageConfig().setParent(packageName).setController(null).setEntity("entity"))
				.execute();

	}

}
