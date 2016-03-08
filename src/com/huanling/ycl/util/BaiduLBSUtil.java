package com.huanling.ycl.util;

import java.util.Map;

public class BaiduLBSUtil extends BaiduLbsAPIParams {

	public String createGeotable(Map<?, ?> params) {
		String url =getUrl(geotable, create);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String listGeotable(Map<?, ?> params) {
		String url =getUrl(geotable, list);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String detailGeotable(Map<?, ?> params) {
		String url =getUrl(geotable, detail);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String updateGeotable(Map<?, ?> params) {
		String url =getUrl(geotable, update);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String deleteGeotable(Map<?, ?> params) {
		String url =getUrl(geotable, delete);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String createColumn(Map<?, ?> params) {
		String url =getUrl(column, create);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String listColumn(Map<?, ?> params) {
		String url =getUrl(column, list);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String detailColumn(Map<?, ?> params) {
		String url =getUrl(column, detail);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String updateColumn(Map<?, ?> params) {
		String url =getUrl(column, update);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}

	
	public String deleteColumn(Map<?, ?> params) {
		String url =getUrl(column, delete);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String createPOI(Map<?, ?> params) {
		String url =getUrl(poi, create);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}

	
	public String listPOI(Map<?, ?> params) {
		String url =getUrl(poi, create);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}

	public String detailPOI(Map<?, ?> params) {
		String url =getUrl(poi, create);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}

	public String updatePOI(Map<?, ?> params) {
		String url =getUrl(poi, create);
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String deletePOI(Map<?, ?> params) {
		String url =getUrl(poi, delete);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String postPOIsCSVFile(Map<?, ?> params) {
		String url =getUrl(poi, upload);
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
	
	public String listImportStatus(Map<?, ?> params) {
		String url =url_listimportdata;
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}
	
	public String listJob(Map<?, ?> params) {
		String url =url_list;
		return HttpRequestProxy.doGet(url, params, getRecEncoding());
	}

	public String detailJob(Map<?, ?> params) {
		String url =url_detail;
		return HttpRequestProxy.doPost(url, params, getRecEncoding());
	}
}
