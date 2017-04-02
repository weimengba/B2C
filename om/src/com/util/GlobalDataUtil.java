package com.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 通用全局对象帮助类
 * 
 * @author Administrator
 * 
 */
public class GlobalDataUtil {

	@Resource
	BasicDataSource dataSource;
	Map<String, String> tableMap = new HashMap<String, String>();
	Map<String, String> columnMap = new HashMap<String, String>();

	/**
	 * 获取表名映射
	 * 
	 * @param tableName
	 * @return
	 */
	public String getTableMapName(String tableName) {
		return tableMap.get(tableName.toLowerCase());
	}

	/**
	 * 获取列名映射
	 * 
	 * @param columnName
	 * @return
	 */
	public String getColumnMapName(String columnName) {
		return columnMap.get(columnName.toLowerCase());
	}

	/**
	 * 通过MetaData获取所有的表名的映射和列的映射。
	 */
	public void init() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			DatabaseMetaData dbMeta = conn.getMetaData();
			ResultSet rs = dbMeta.getCatalogs();// Mysql

			// ResultSet rs = dbMeta.getSchemas();//oracle

			ResultSetMetaData rsMeta = rs.getMetaData();
			int column = rsMeta.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= column; i++) {
					System.out.print(rsMeta.getColumnLabel(i) + ":"
							+ rs.getObject(i) + "\t");
				}
			}
			rs = dbMeta.getTables("om", null, null, new String[] { "table" });
			rsMeta = rs.getMetaData();
			column = rsMeta.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= column; i++) {
					System.out.print(rsMeta.getColumnLabel(i) + ":"
							+ rs.getObject(i) + "\t");
				}
				String tableName = rs.getString("TABLE_NAME");
				tableMap.put(tableName.replace("om_", "").replace("_", ""),
						tableName);
				System.out.println();

				System.out.println("列：");
				ResultSet rsColumn = dbMeta.getColumns("om", null, tableName,
						null);
				ResultSetMetaData columnMeta = rsColumn.getMetaData();
				int col_column = columnMeta.getColumnCount();
				while (rsColumn.next()) {
					for (int i = 1; i <= col_column; i++) {
						System.out.print(columnMeta.getColumnLabel(i) + ":"
								+ rsColumn.getObject(i) + "\t");
					}
					System.out.println();
					String column_name = rsColumn.getString("COLUMN_NAME");
					columnMap.put(column_name.replace("_", ""), column_name);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
