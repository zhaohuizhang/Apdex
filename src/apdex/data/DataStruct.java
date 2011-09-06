package apdex.data;

import java.util.ArrayList;

public class DataStruct {
	public String srcip = null;
	public int srcport = 0;
	public String dstip = null;
	public int dstport = 0;
	public double syn_time = 0;
	public double first_byte_time = 0;
	public double last_byte_time = 0;
	public int rtt = 0;
	public int pkts_src = 0;
	public int pkts_dst = 0;
	public int byts_src = 0;
	public int byts_dst = 0;
	public int http_pairs = 0;
	public int close = 0;
	ArrayList<Item> items = new ArrayList<Item>();
	public String getSrcip() {
		return srcip;
	}
	public void setSrcip(String srcip) {
		this.srcip = srcip;
	}
	public int getSrcport() {
		return srcport;
	}
	public void setSrcport(int srcport) {
		this.srcport = srcport;
	}
	public String getDstip() {
		return dstip;
	}
	public void setDstip(String dstip) {
		this.dstip = dstip;
	}
	public int getDstport() {
		return dstport;
	}
	public void setDstport(int dstport) {
		this.dstport = dstport;
	}
	public double getSyn_time() {
		return syn_time;
	}
	public void setSyn_time(double synTime) {
		syn_time = synTime;
	}
	public double getFirst_byte_time() {
		return first_byte_time;
	}
	public void setFirst_byte_time(double firstByteTime) {
		first_byte_time = firstByteTime;
	}
	public double getLast_byte_time() {
		return last_byte_time;
	}
	public void setLast_byte_time(double lastByteTime) {
		last_byte_time = lastByteTime;
	}
	public int getRtt() {
		return rtt;
	}
	public void setRtt(int rtt) {
		this.rtt = rtt;
	}
	public int getPkts_src() {
		return pkts_src;
	}
	public void setPkts_src(int pktsSrc) {
		pkts_src = pktsSrc;
	}
	public int getPkts_dst() {
		return pkts_dst;
	}
	public void setPkts_dst(int pktsDst) {
		pkts_dst = pktsDst;
	}
	public int getByts_src() {
		return byts_src;
	}
	public void setByts_src(int bytsSrc) {
		byts_src = bytsSrc;
	}
	public int getByts_dst() {
		return byts_dst;
	}
	public void setByts_dst(int bytsDst) {
		byts_dst = bytsDst;
	}
	public int getHttp_pairs() {
		return http_pairs;
	}
	public void setHttp_pairs(int httpPairs) {
		http_pairs = httpPairs;
	}
	public int getClose() {
		return close;
	}
	public void setClose(int close) {
		this.close = close;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	
	


	

}
