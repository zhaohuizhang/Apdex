package apdex.data;

public class Item {
	public double request_time = 0;
	public double response_firstbyte_time = 0;
	public String host = null;
	public String uri = null;
	public String refer = null;
	public String response_type = null; 
	public int response_status = 0;
	public int content_size = 0;
	public String method = null;
	public double start_time =0;
	public double conn_time = 0;
	public double sending_time = 0;
	public double waitting_time = 0;
	public double receving_time = 0;
	public double getRequest_time() {
		return request_time;
	}
	public void setRequest_time(double requestTime) {
		request_time = requestTime;
	}
	public double getResponse_firstbyte_time() {
		return response_firstbyte_time;
	}
	public void setResponse_firstbyte_time(double responseFirstbyteTime) {
		response_firstbyte_time = responseFirstbyteTime;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getResponse_type() {
		return response_type;
	}
	public void setResponse_type(String responseType) {
		response_type = responseType;
	}
	public int getResponse_status() {
		return response_status;
	}
	public void setResponse_status(int responseStatus) {
		response_status = responseStatus;
	}
	public int getContent_size() {
		return content_size;
	}
	public void setContent_size(int contentSize) {
		content_size = contentSize;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public double getStart_time() {
		return start_time;
	}
	public void setStart_time(double startTime) {
		start_time = startTime;
	}
	public double getConn_time() {
		return conn_time;
	}
	public void setConn_time(double connTime) {
		conn_time = connTime;
	}
	public double getSending_time() {
		return sending_time;
	}
	public void setSending_time(double sendingTime) {
		sending_time = sendingTime;
	}
	public double getWaitting_time() {
		return waitting_time;
	}
	public void setWaitting_time(double waittingTime) {
		waitting_time = waittingTime;
	}
	public double getReceving_time() {
		return receving_time;
	}
	public void setReceving_time(double recevingTime) {
		receving_time = recevingTime;
	}
	
	

}


