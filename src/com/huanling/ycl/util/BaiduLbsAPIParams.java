package com.huanling.ycl.util;

import java.util.Map;

 abstract class BaiduLbsAPIParams {

	protected static String baseUrl = "http://api.map.baidu.com/geodata/v3/";

	private static String recEncoding = "UTF-8";

	protected static String create = "create";
	protected static String list = "list";
	protected static String detail = "detail";
	protected static String update = "update";
	protected static String delete = "delete";
	protected static String upload = "upload";
	
	protected static String geotable = "geotable";
	protected static String column = "column";
	protected static String poi = "poi";
	
	protected static String url_listimportdata=baseUrl + "job/listimportdata";
	protected static String url_list= baseUrl + "job/list";
	protected static String url_detail= baseUrl + "ob/detail";
	
/*	
	protected static String url_geotable_create= "http://api.map.baidu.com/geodata/v3/geotable/create";
	protected static String url_geotable_list= "http://api.map.baidu.com/geodata/v3/geotable/list";	
	protected static String url_geotable_detail= "http://api.map.baidu.com/geodata/v3/geotable/detail";	
	protected static String url_geotable_update= "http://api.map.baidu.com/geodata/v3/geotable/update";	
	protected static String url_geotable_delete= "http://api.map.baidu.com/geodata/v3/geotable/delete";

	protected static String url_column_create= "http://api.map.baidu.com/geodata/v3/column/create";
	protected static String url_column_list= "http://api.map.baidu.com/geodata/v3/column/list";	
	protected static String url_column_detail= "http://api.map.baidu.com/geodata/v3/column/detail";	
	protected static String url_column_update= "http://api.map.baidu.com/geodata/v3/column/update";	
	protected static String url_column_delete= "http://api.map.baidu.com/geodata/v3/column/delete";


	protected static String url_poi_create= "http://api.map.baidu.com/geodata/v3/poi/create";
	protected static String url_poi_list= "http://api.map.baidu.com/geodata/v3/poi/list";	
	protected static String url_poi_detail= "http://api.map.baidu.com/geodata/v3/poi/detail";	
	protected static String url_poi_update= "http://api.map.baidu.com/geodata/v3/poi/update";	
	protected static String url_poi_delete= "http://api.map.baidu.com/geodata/v3/poi/delete";*/
	
	
	protected String getUrl(String option, String operation) {
		return baseUrl+option+"/"+operation;
	}
	
	public static String getRecEncoding() {
		return recEncoding;
	}

	public static void setRecEncoding(String recEncoding) {
		BaiduLbsAPIParams.recEncoding = recEncoding;
	}
	/**
	 * 
	 * @param params 
	 * @return
	 */
	public abstract String createGeotable(Map<?, ?> params) ;
	public abstract String listGeotable(Map<?, ?> params) ;
	public abstract String detailGeotable(Map<?, ?> params) ;
	public abstract String updateGeotable(Map<?, ?> params) ;
	public abstract String deleteGeotable(Map<?, ?> params) ;
	public abstract String createColumn(Map<?, ?> params) ;
	public abstract String listColumn(Map<?, ?> params) ;
	public abstract String detailColumn(Map<?, ?> params) ;
	public abstract String updateColumn(Map<?, ?> params) ;
	public abstract String deleteColumn(Map<?, ?> params) ;
	public abstract String createPOI(Map<?, ?> params) ;
	public abstract String listPOI(Map<?, ?> params) ;
	public abstract String detailPOI(Map<?, ?> params) ;
	public abstract String updatePOI(Map<?, ?> params) ;
	public abstract String deletePOI(Map<?, ?> params) ;
	public abstract String postPOIsCSVFile(Map<?, ?> params) ;
	public abstract String listImportStatus(Map<?, ?> params) ;
	public abstract String listJob(Map<?, ?> params) ;
	public abstract String detailJob(Map<?, ?> params) ;
}
