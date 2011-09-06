package apdex.data;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mysql.jdbc.Connection;

import com.mysql.jdbc.Statement;

public class DataOpt {
	int id = 0;

	public void ReadMongo() {
		Mongo mongo;

		try {

			mongo = new Mongo("10.50.15.201");
			DB db = mongo.getDB("http");
			DBCollection dbcoll = db.getCollection("flows_test");
			DBCursor cur = dbcoll.find();

			while (cur.hasNext()) {
				DataStruct datas = new DataStruct();
				DBObject doc = cur.next();
				datas.setSrcip(doc.get("src_ip").toString());
				datas.setSrcport(Integer.parseInt(doc.get("src_port")
						.toString()));
				datas.setDstip(doc.get("dst_ip").toString());
				datas.setDstport(Integer.parseInt(doc.get("dst_port")
						.toString()));
				datas.setSyn_time((Double.parseDouble(doc.get("syn_sec")
						.toString()) * 1000000 + Double.parseDouble(doc.get(
						"syn_usec").toString())));
				System.out.println(datas.getSyn_time());
				datas.setFirst_byte_time((Double.parseDouble(doc.get(
						"first_byte_sec").toString()) * 1000000.0 + Double
						.parseDouble(doc.get("first_byte_usec").toString())));
				datas.setLast_byte_time((Double.parseDouble(doc.get(
						"last_byte_sec").toString()) * 1000000 + Double
						.parseDouble(doc.get("last_byte_usec").toString())));
				datas.setRtt(Integer.parseInt(doc.get("rtt").toString()));
				datas.setPkts_dst(Integer.parseInt(doc.get("pkts_dst")
						.toString()));
				datas.setPkts_src(Integer.parseInt(doc.get("pkts_src")
						.toString()));
				datas.setByts_src(Integer.parseInt(doc.get("byts_src")
						.toString()));
				datas.setByts_dst(Integer.parseInt(doc.get("byts_dst")
						.toString()));
				datas.setHttp_pairs(Integer.parseInt(doc.get("http_pairs")
						.toString()));
				if (Integer.parseInt(doc.get("close").toString()) == 1) {
					List itemslist = (List) doc.get("items");
					ArrayList<Item> items = new ArrayList<Item>();
					for (int i = 0; i < itemslist.size(); i++) {
						Item item = new Item();
						DBObject itobj = (DBObject) itemslist.get(i);
						item.setStart_time(datas.getSyn_time());
						item.setRequest_time((Double.parseDouble(itobj.get(
								"request_sec").toString()) * 1000000.0 + Double
								.parseDouble(itobj.get("request_usec")
										.toString())));
						item
								.setResponse_firstbyte_time((Double
										.parseDouble(itobj.get(
												"response_first_byte_sec")
												.toString()) * 1000000 + Double
										.parseDouble(itobj.get(
												"response_first_byte_usec")
												.toString())));

						item.setConn_time(datas.getFirst_byte_time()
								- datas.getSyn_time());
						item.setSending_time(item.getRequest_time()
								- datas.getFirst_byte_time());
						if (item.getResponse_firstbyte_time() != 0) {
							item.setWaitting_time(item
									.getResponse_firstbyte_time()
									- item.getRequest_time());
							item.setReceving_time(datas.getLast_byte_time()
									- item.getResponse_firstbyte_time());
						}
						if (itobj.get("host") != null) {
							item.setHost(itobj.get("host").toString());
						}
						if (itobj.get("uri") != null) {
							if (itobj.get("uri").toString().length() > 1024) {
								item.setUri(itobj.get("uri").toString()
										.substring(0, 1000));
							} else {
								item.setUri(itobj.get("uri").toString());
							}
						}
						if (itobj.get("referer") != null) {
							item.setRefer(itobj.get("referer").toString());
						}
						if (itobj.get("response_content_type") != null) {
							item.setResponse_type(itobj.get(
									"response_content_type").toString());
						}
						if (itobj.get("response_status") != null) {
							item.setResponse_status(Integer.parseInt(itobj.get(
									"response_status").toString()));
						}
						if (itobj.get("response_content_length") != null) {
							item.setContent_size(Integer.parseInt(itobj.get(
									"response_content_length").toString()));
						}
						if (itobj.get("request_method") != null) {
							item.setMethod(itobj.get("request_method")
									.toString());
						}
						items.add(item);
					}
					datas.setItems(items);
					ToMySQL(datas);
				}

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ToMySQL(DataStruct datas) throws SQLException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:MySQL://10.50.12.2:3306/apdexdb";
		String user = "root";
		String password = "1234";
		try {
			Class.forName(driver);
			Connection conn = (Connection) DriverManager.getConnection(url,
					user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			} else {
				System.out.println("Falled connecting to the Database!");
			}
			Statement stmt = (Statement) conn.createStatement();
			ArrayList<Item> itlist = datas.getItems();
			for (int t = 0; t < itlist.size(); t++) {
				String insql = "insert into elements(id,src_ip,src_port,dst_ip,dst_port,host,uri,method,referrer,content_type,content_size,status,start_time,sending_time,waitting_time,receving_time,connect_time) values("
						+ id
						+ ",'"
						+ datas.getSrcip()
						+ "','"
						+ datas.getSrcport()
						+ "','"
						+ datas.getDstip()
						+ "','"
						+ datas.getDstport()
						+ "','"
						+ itlist.get(t).getHost()
						+ "','"
						+ itlist.get(t).getUri()
						+ "','"
						+ itlist.get(t).getMethod()
						+ "','"
						+ itlist.get(t).getRefer()
						+ "','"
						+ itlist.get(t).getResponse_type()
						+ "','"
						+ itlist.get(t).getContent_size()
						+ "','"
						+ itlist.get(t).getResponse_status()
						+ "','"
						+ itlist.get(t).getStart_time()
						+ "','"
						+ itlist.get(t).getSending_time()
						+ "','"
						+ itlist.get(t).getWaitting_time()
						+ "','"
						+ itlist.get(t).getReceving_time()
						+ "','"
						+ itlist.get(t).getConn_time() + "')";

				stmt.executeUpdate(insql);

				id++;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		DataOpt dataopt = new DataOpt();
		dataopt.ReadMongo();
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
	}
}
