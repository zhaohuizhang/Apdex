package apdex.data;

public class PageDetail {
	public int id = 0;
	public int user_id = 0;
	public String page_url = null;
	public double time = 0;
	public double load_time = 0;
	public int page_size = 0;
	public int domain_count = 0;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) { 
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getPage_url() {
		return page_url;
	}
	public void setPage_url(String pageUrl) {
		page_url = pageUrl;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getLoad_time() {
		return load_time;
	}
	public void setLoad_time(double loadTime) {
		load_time = loadTime;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int pageSize) {
		page_size = pageSize;
	}
	public int getDomain_count() {
		return domain_count;
	}
	public void setDomain_count(int domainCount) {
		domain_count = domainCount;
	}
	
	
	

}
