/**
 * 
 */
package com.huanling.ycl.unittest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.huanling.ycl.util.*;
/**
 * @author mumu
 *
 */
public class BaiduLbsTest {

	private static String ak = "muZOBKNY4QKOFRLCT1qvSrvp";
	private static String geotable_id = "135187";
	private static int testID  = 0;
	private static BaiduLBSUtil baiduLBSUtil = new BaiduLBSUtil();

	@Test
	public void createGeotable() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "around");
		params.put("geotype", "1");
		params.put("is_published", "1");
		params.put("ak", ak);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.createGeotable(params));
	}

	@Test
	public void listGeotable() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.listGeotable(params));
	}

	@Test
	public void detailGeotable() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("id", geotable_id);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.detailGeotable(params));
	}

	@Test
	public void updateGeotable() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("id", "87276");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.updateGeotable(params));
	}

	@Test
	public void deleteGeotable() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("id", "87276");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.deleteGeotable(params));
	}

	@Test
	public void createColumn1() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		params.put("name", "城市");
		params.put("key", "city");
		params.put("type", "3");
		params.put("max_length", "512");
		params.put("is_sortfilter_field", "0");
		params.put("is_search_field", "1");
		params.put("is_index_field", "1");
		params.put("is_unique_field ", "0");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.createColumn(params));
	}

	@Test
	public void createColumn2() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		params.put("name", "地区");
		params.put("key", "district");
		params.put("type", "3");
		params.put("max_length", "512");
		params.put("is_sortfilter_field", "0");
		params.put("is_search_field", "1");
		params.put("is_index_field", "1");
		params.put("is_unique_field ", "0");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.createColumn(params));
	}

	@Test
	public void createColumn3() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		params.put("name", "公司ID");
		params.put("key", "company_id");
		params.put("type", "1");
		params.put("max_length", "512");
		params.put("is_sortfilter_field", "1");
		params.put("is_search_field", "0");
		params.put("is_index_field", "1");
		params.put("is_unique_field ", "0");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.createColumn(params));
	}

	@Test
	public void listColumn() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.listColumn(params));
	}

	@Test
	public void detailColumn() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		params.put("id", "");
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.detailColumn(params));
	}

	@Test
	public void createPOI() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		params.put("title", "标题");
		params.put("address", "地址");
		// 经度
		params.put("latitude", "40.106311");
		// 纬度
		params.put("longitude", "116.310648");
		params.put("tags", "tags");
		params.put("coord_type", "3");
		// 自定义属性
		params.put("city", "城市");
		params.put("district", "地区");
		params.put("company_id", "1");

		System.out.println(" "+ testID++ + " "+baiduLBSUtil.createPOI(params));
	}

	@Test
	public void listPOI() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.listPOI(params));
	}

	@Test
	public void deletePOI() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ak", ak);
		params.put("geotable_id", geotable_id);
		System.out.println(" "+ testID++ + " "+baiduLBSUtil.deletePOI(params));
	}

	public static String getAk() {
		return ak;
	}

	public static void setAk(String ak) {
		BaiduLbsTest.ak = ak;
	}

	public static String getGeotable_id() {
		return geotable_id;
	}

	public static void setGeotable_id(String geotableId) {
		geotable_id = geotableId;
	}

}
