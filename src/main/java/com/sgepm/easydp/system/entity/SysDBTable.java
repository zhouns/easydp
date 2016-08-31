package com.sgepm.easydp.system.entity;

import javax.persistence.Table;

@Table
public class SysDBTable implements java.io.Serializable {
	
	private static final long serialVersionUID = -5732050615092488437L;
	
	private String table_catalog;
	private String table_name;
	private String table_type;
	private String engine;
	private String version;
	private String row_format;
	private String table_rows;
	private String avg_row_length;
	private String data_length;
	private String max_data_length;
	private String index_length;
	private String data_free;
	private String auto_increment;
	private String create_time;
	private String update_time;
	private String check_time;
	private String table_collation;
	private String checksum;
	private String create_options;
	private String table_comment;
	private String table_schema;
	
	public SysDBTable() {
		super();
	}

	public SysDBTable(String table_catalog, String table_name,
			String table_type, String engine, String version,
			String row_format, String table_rows, String avg_row_length,
			String data_length, String max_data_length, String index_length,
			String data_free, String auto_increment, String create_time,
			String update_time, String check_time, String table_collation,
			String checksum, String create_options, String table_comment,
			String table_schema) {
		super();
		this.table_catalog = table_catalog;
		this.table_name = table_name;
		this.table_type = table_type;
		this.engine = engine;
		this.version = version;
		this.row_format = row_format;
		this.table_rows = table_rows;
		this.avg_row_length = avg_row_length;
		this.data_length = data_length;
		this.max_data_length = max_data_length;
		this.index_length = index_length;
		this.data_free = data_free;
		this.auto_increment = auto_increment;
		this.create_time = create_time;
		this.update_time = update_time;
		this.check_time = check_time;
		this.table_collation = table_collation;
		this.checksum = checksum;
		this.create_options = create_options;
		this.table_comment = table_comment;
		this.table_schema = table_schema;
	}

	public String getTable_catalog() {
		return table_catalog;
	}

	public void setTable_catalog(String table_catalog) {
		this.table_catalog = table_catalog;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRow_format() {
		return row_format;
	}

	public void setRow_format(String row_format) {
		this.row_format = row_format;
	}

	public String getTable_rows() {
		return table_rows;
	}

	public void setTable_rows(String table_rows) {
		this.table_rows = table_rows;
	}

	public String getAvg_row_length() {
		return avg_row_length;
	}

	public void setAvg_row_length(String avg_row_length) {
		this.avg_row_length = avg_row_length;
	}

	public String getData_length() {
		return data_length;
	}

	public void setData_length(String data_length) {
		this.data_length = data_length;
	}

	public String getMax_data_length() {
		return max_data_length;
	}

	public void setMax_data_length(String max_data_length) {
		this.max_data_length = max_data_length;
	}

	public String getIndex_length() {
		return index_length;
	}

	public void setIndex_length(String index_length) {
		this.index_length = index_length;
	}

	public String getData_free() {
		return data_free;
	}

	public void setData_free(String data_free) {
		this.data_free = data_free;
	}

	public String getAuto_increment() {
		return auto_increment;
	}

	public void setAuto_increment(String auto_increment) {
		this.auto_increment = auto_increment;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getCheck_time() {
		return check_time;
	}

	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}

	public String getTable_collation() {
		return table_collation;
	}

	public void setTable_collation(String table_collation) {
		this.table_collation = table_collation;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getCreate_options() {
		return create_options;
	}

	public void setCreate_options(String create_options) {
		this.create_options = create_options;
	}

	public String getTable_comment() {
		return table_comment;
	}

	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}

	public String getTable_schema() {
		return table_schema;
	}

	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}
	
}
