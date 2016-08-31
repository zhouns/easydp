package com.sgepm.easydp.system.flt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import com.sgepm.easydp.system.entity.SysDBTableColumn;

public class JavaBeanGenerator extends IBaseGenerator {

	private static final String TAB = "\t";
	private static final String LIN = "\r\n";
	private static Map<String, String> typeMap;
	
	private String schema;
	private String tbName;
	private String protertys;
	private String constructor_key;
	private String constructor_full;
	private String getterAndSetter;
	
	private List<SysDBTableColumn> tableInfo;
	static {
		typeMap = new HashMap<String, String>();
		typeMap.put("text", "String");
		typeMap.put("char", "String");
		typeMap.put("varchar", "String");
		typeMap.put("tinyint", "Short");
		typeMap.put("int", "Integer");
		typeMap.put("bigint", "Long");
		typeMap.put("decimal", "Double");
		typeMap.put("double", "Double");
		typeMap.put("float", "Float");
		typeMap.put("timestamp", "Date");
		typeMap.put("datetime", "Date");
		typeMap.put("date", "Date");
	}
	
	public JavaBeanGenerator(String schema, String tbName, String moudel,
			String menu, List<SysDBTableColumn> tableInfo) {
		this.menu = menu;
		this.moudel = moudel;
		this.schema = schema;
		this.tbName = tbName;
		this.tableInfo = tableInfo;
		this.entity = genTableName(tbName);
		this.protertys = genPropertys();
		this.constructor_key = genKeyConstructor();
		this.constructor_full = genFullConstructor();
		this.getterAndSetter = genGetterAndSetter();
	}
	
	private String genGetterAndSetter() {
		StringBuffer function_buffer = new StringBuffer();
		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			function_buffer.append(genGetter(column)).append(genSetter(column));
		}
		return function_buffer.toString();
	}
	
	private String genAnnotation(SysDBTableColumn column) {
		StringBuffer annotation_buffer = new StringBuffer();
		annotation_buffer.append(TAB);
		
		// 主键约束
		if (column.getIsKey() != null && column.getIsKey().equals("PRI")) {
			annotation_buffer.append("@Id").append(LIN).append(TAB);
		}
		
		// 属性名称
		annotation_buffer.append("@Column(name=\"")
			.append(column.getField()).append("\"");
		
		// 唯一约束
		if ((column.getIsKey() != null && column.getIsKey().equals("PRI"))
				|| (column.getIsKey() != null && column.getIsKey().equals("UNI"))) {
			annotation_buffer.append(", unique=true");
		}
		
		// 非空约束
		if (column.getNullable().equals("NO")) {
			annotation_buffer.append(", nullable=false");
		}
		
		String columnType = column.getType();
		String typeName = columnType.split("\\(")[0];
		
		// 字段长度
		if (typeName.equals("char") || typeName.equals("varchar")) {
			String length = columnType.split("\\(")[1].replace(")", "");
			annotation_buffer.append(", length=").append(length);
		}
		
		// int类型
		if (typeName.equals("tinyint") || 
				typeName.equals("int") || typeName.equals("bigint")) {
			String precision = columnType.split("\\(")[1].replace(")", "");
			annotation_buffer.append(", precision=").append(precision).append(", scale=0");
		}
		
		// decimal类型
		if (typeName.equals("decimal") || typeName.equals("double") || typeName.equals("float")) {
			String length = columnType.split("\\(")[1].replace(")", "");
			annotation_buffer.append(", precision=")
					.append(length.split(",")[0]).append(", scale=")
					.append(length.split(",")[1]);
		}
		annotation_buffer.append(")");
		return annotation_buffer.toString();
	}
	
	private String genGetter(SysDBTableColumn column) {
		String columnType = column.getType();
		String typeName = columnType.split("\\(")[0];
		String property = column.getField();
		property = getPropertyName(property);
		String upperCaseProperty = property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
		
		StringBuffer getter_buffer = new StringBuffer();
		getter_buffer.append(genAnnotation(column)).append(LIN).append(TAB)
				.append("public ").append(getPropertyTypeName(typeName))
				.append(" ").append("get").append(upperCaseProperty)
				.append("() {").append(LIN).append(TAB).append(TAB)
				.append("return ").append(property).append(";").append(LIN)
				.append(TAB).append("}").append(LIN).append(LIN);
		return getter_buffer.toString();
	}
	
	private String genSetter(SysDBTableColumn column) {
		String columnType = column.getType();
		String typeName = columnType.split("\\(")[0];
		String property = column.getField();
		property = getPropertyName(property);
		String upperCaseProperty = property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
		StringBuffer setter_buffer = new StringBuffer();
		setter_buffer.append(TAB)
				.append("public void ").append("set").append(upperCaseProperty)
				.append("(").append(getPropertyTypeName(typeName)).append(" ")
				.append(property).append(") {").append(LIN).append(TAB)
				.append(TAB).append("this.").append(property).append(" = ")
				.append(property).append(";").append(LIN)
				.append(TAB).append("}").append(LIN).append(LIN);
		return setter_buffer.toString();
	}

	public String genTableName(String tbName) {
		if (tbName.contains("_")) {
			StringBuffer names = new StringBuffer();
			String arrayName[] = tbName.split("_");
			names.append(arrayName[0]);
			for (int i = 1; i < arrayName.length; i++) {
				String arri = arrayName[i];
				String tmp = arri.substring(0, 1).toUpperCase()
						+ arri.substring(1, arri.length());
				names.append(tmp);
			}
			tbName = names.toString();
		}
		tbName = tbName.substring(0, 1).toUpperCase() + tbName.substring(1);
		return tbName;
	}
	
	private String genKeyConstructor() {
		StringBuffer constructor_key_buffer = new StringBuffer();
		constructor_key_buffer.append(TAB).append("public ").append(entity)
				.append("(");

		boolean hasKey = false;
		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			if (column.getIsKey() != null && column.getIsKey().equals("PRI")) {
				if (hasKey) {
					constructor_key_buffer.append(", ");
				}

				constructor_key_buffer
						.append(getPropertyTypeName(column.getType())).append(" ")
						.append(getPropertyName(column.getField()));
				hasKey = true;
			}

		}
		constructor_key_buffer.append(") {").append(LIN).append(TAB)
				.append(TAB);

		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			if (column.getIsKey() != null && column.getIsKey().equals("PRI")) {
				constructor_key_buffer.append("this.")
						.append(getPropertyName(column.getField()))
						.append(" = ")
						.append(getPropertyName(column.getField())).append(";")
						.append(LIN);
			}
		}

		constructor_key_buffer.append(TAB).append("}");
		return constructor_key_buffer.toString();
	}
	
	private String genFullConstructor() {
		StringBuffer constructor_full_buffer = new StringBuffer();
		constructor_full_buffer.append(TAB).append("public ").append(entity)
				.append("(");

		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			if (i > 0) {
				constructor_full_buffer.append(", ");
			}
			constructor_full_buffer
					.append(getPropertyTypeName(column.getType())).append(" ")
					.append(getPropertyName(column.getField()));
		}
		constructor_full_buffer.append(") {").append(LIN);

		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			constructor_full_buffer.append(TAB).append(TAB).append("this.")
					.append(getPropertyName(column.getField())).append(" = ")
					.append(getPropertyName(column.getField())).append(";")
					.append(LIN);
		}

		constructor_full_buffer.append(TAB).append("}");
		return constructor_full_buffer.toString();
	}
	
	private String genPropertys() {
		StringBuffer protertys_buffer = new StringBuffer();
		for (int i = 0; i < tableInfo.size(); i++) {
			SysDBTableColumn column = tableInfo.get(i);
			protertys_buffer.append(getPropertyLine(column)).append(LIN);
		}
		return protertys_buffer.toString();
	}
	
	private StringBuffer getPropertyLine(SysDBTableColumn column) {
		StringBuffer propertyLine = new StringBuffer();
		propertyLine.append(TAB)
					.append("private ")
					.append(getPropertyTypeName(column.getType()))
					.append(" ")
					.append(getPropertyName(column.getField()))
					.append(";");
		return propertyLine;
	}

	private String getPropertyTypeName(String columnType) {
		String typeName = columnType.split("\\(")[0];
		StringTokenizer st = new StringTokenizer(typeName);
		return typeMap.get(st.nextToken());
	}
	
	private String getPropertyName(String columnName) {
		if (columnName.contains("_")) {
			StringBuffer names = new StringBuffer();
			String arrayName[] = columnName.split("_");
			names.append(arrayName[0]);
			for (int i = 1; i < arrayName.length; i++) {
				String arri = arrayName[i];
				String tmp = arri.substring(0, 1).toUpperCase()
						+ arri.substring(1, arri.length());
				names.append(tmp);
			}
			columnName = names.toString();
		}
		return columnName;
	}
	
	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTbName() {
		return tbName;
	}

	public void setTbName(String tbName) {
		this.tbName = tbName;
	}

	public String getProtertys() {
		return protertys;
	}

	public void setProtertys(String protertys) {
		this.protertys = protertys;
	}

	public String getConstructor_key() {
		return constructor_key;
	}

	public void setConstructor_key(String constructor_key) {
		this.constructor_key = constructor_key;
	}

	public String getConstructor_full() {
		return constructor_full;
	}

	public void setConstructor_full(String constructor_full) {
		this.constructor_full = constructor_full;
	}

	public String getGetterAndSetter() {
		return getterAndSetter;
	}

	public void setGetterAndSetter(String getterAndSetter) {
		this.getterAndSetter = getterAndSetter;
	}
	
	public String createJavaBean() {
		String absGenPath = getAbsRootPkgPath() + "/" + moudel + "/entity/" + entity + ".java";
		FreemarkEngine.write("common/entity.flt", absGenPath, this);
		return entity;
	}
	
}