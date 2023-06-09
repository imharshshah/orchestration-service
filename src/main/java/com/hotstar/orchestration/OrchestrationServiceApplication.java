package com.hotstar.orchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.sql.*;

@SpringBootApplication
public class OrchestrationServiceApplication {

	public static void main(String[] args) throws SQLException{
		//DbToJsonPayments();
		//DbToJsonSubsciptions();
		SpringApplication.run(OrchestrationServiceApplication.class, args);
		
	}

// 	private static void DbToJsonPayments() throws SQLException {
// 		String url = "jdbc:mysql://hspay-payment-service-rds-aur-cls-qa-ind-ap-south-1.cluster-cn2w2llmy7rq.ap-south-1.rds.amazonaws.com/payments";
// 		String username = "root";
// 		String password = "rdsPayQaPassword";

// 		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
// 		try (Connection conn = DriverManager.getConnection(url, username, password)) {
// 			DatabaseMetaData metadata = conn.getMetaData();

// 			String[] types = {"TABLE"};
// 			ResultSet tableResultSet = metadata.getTables(null, null, "%", types);

// 			JSONArray schemaArray = new JSONArray();

// 			while (tableResultSet.next()) {
// 				String tableName = tableResultSet.getString("TABLE_NAME");
// 				ResultSet columnResultSet = metadata.getColumns(null, null, tableName, null);

// 				JSONObject table = new JSONObject();
// 				table.put("table_name",tableName);

// 				JSONArray columnsArray = new JSONArray();
// 				while (columnResultSet.next()) {
// 					String columnName = columnResultSet.getString("COLUMN_NAME");
// 					String columnType = columnResultSet.getString("TYPE_NAME");
// 					int columnSize = columnResultSet.getInt("COLUMN_SIZE");

// 					JSONObject column = new JSONObject();
// 					column.put("name",columnName);
// 					column.put("type", columnType);
// 					column.put("size", columnSize);

// 					columnsArray.add(column);
// 					table.put("columns", columnsArray);
// 				}

// 				ResultSet fkResultSet = metadata.getImportedKeys(null, null, tableName);

// 				JSONArray fks = new JSONArray();
// 				while (fkResultSet.next()) {
// 					String pkTableName = fkResultSet.getString("PKTABLE_NAME");
// 					String pkColumnName = fkResultSet.getString("PKCOLUMN_NAME");
// 					String fkColumnName = fkResultSet.getString("FKCOLUMN_NAME");

// 					JSONObject fk = new JSONObject();
// 					fk.put("pk_table", pkTableName);
// 					fk.put("pk_column", pkColumnName);
// 					fk.put("fk_column", fkColumnName);

// 					fks.add(fk);
// 				}

// 				table.put("foreignKeys", fks);

// 				schemaArray.add(table);
// 			}

// 			try (FileWriter writer = new FileWriter("payments_schema.json")) {
// 				writer.write(schemaArray.toString());
// 			}

// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}

// 	private static void DbToJsonSubsciptions() {
// 		String url = "jdbc:mysql://hspay-subscription-service-rds-aur-cls-qa-ind-ap-south-1.cluster-cn2w2llmy7rq.ap-south-1.rds.amazonaws.com/subscriptions_sea";
// 		String username = "root";
// 		String password = "rdsSubQaPassword";

// 		try (Connection conn = DriverManager.getConnection(url, username, password)) {
// 			DatabaseMetaData metadata = conn.getMetaData();

// 			String[] types = {"TABLE"};
// 			ResultSet tableResultSet = metadata.getTables(null, null, "%", types);

// 			JSONArray schemaArray = new JSONArray();

// 			while (tableResultSet.next()) {
// 				String tableName = tableResultSet.getString("TABLE_NAME");
// 				ResultSet columnResultSet = metadata.getColumns(null, null, tableName, null);

// 				JSONObject table = new JSONObject();
// 				table.put("table_name",tableName);
// 				JSONArray columnsArray = new JSONArray();
// 				while (columnResultSet.next()) {
// 					String columnName = columnResultSet.getString("COLUMN_NAME");
// 					String columnType = columnResultSet.getString("TYPE_NAME");
// 					int columnSize = columnResultSet.getInt("COLUMN_SIZE");

// 					JSONObject column = new JSONObject();
// 					column.put("name",columnName);
// 					column.put("type", columnType);
// 					column.put("size", columnSize);

// 					columnsArray.add(column);

// 					table.put("columns", columnsArray);
// 				}

// 				ResultSet fkResultSet = metadata.getImportedKeys(null, null, tableName);

// 				JSONArray fks = new JSONArray();
// 				while (fkResultSet.next()) {
// 					String pkTableName = fkResultSet.getString("PKTABLE_NAME");
// 					String pkColumnName = fkResultSet.getString("PKCOLUMN_NAME");
// 					String fkColumnName = fkResultSet.getString("FKCOLUMN_NAME");

// 					JSONObject fk = new JSONObject();
// 					fk.put("pk_table", pkTableName);
// 					fk.put("pk_column", pkColumnName);
// 					fk.put("fk_column", fkColumnName);

// 					fks.add(fk);
// 				}
// 				table.put("foreignKeys", fks);
// 				schemaArray.add(table);
// 			}

// 			try (FileWriter writer = new FileWriter("subscription_schema.json")) {
// 				writer.write(schemaArray.toString());
// 			}

// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}

}
