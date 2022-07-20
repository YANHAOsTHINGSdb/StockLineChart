package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import com.feilong.core.util.SortUtil;

import InputData.日線點;
import OutputData.折点;

public class 簡單解析Util2 {

	public static 簡單解析2 取得指定日的前后指定天数的簡單解析2(List<折点> list日線_折点, int index假点, int 對象個數, int get高低) {
		// | ---(對象個數)---- index假点 ----(對象個數)----|
		//i开始index
		
		//int i开始index = i指定index - i指定天数 + 1;
		int i开始index = index假点 - 對象個數;
		//int i結束index = index假点 + i指定天数;
		i开始index = i开始index < 0 ? 0 : i开始index;
		
		//List<日線> list指定数据 = list日線.subList(i开始index, i結束index);
		return 取得指定區間數據製作簡單解析(list日線_折点, i开始index, 對象個數 * 2);
	}

	public static 簡單解析2 取得指定日的前后指定天数的簡單解析(List<折点> list日線_折点, int index假点, int i指定天数, int get求高低) {

		// |index假点 ----(對象個數)----|
		
		
		//int i开始index = i指定index - i指定天数 + 1;
		int i开始index = index假点 + 1;
		//int i結束index = index假点 + i指定天数;
		i开始index = i开始index < 0 ? 0 : i开始index;
		
		//List<日線> list指定数据 = list日線.subList(i开始index, i結束index);
		return 取得指定區間數據製作簡單解析(list日線_折点, i开始index, i指定天数);

	}

	public static 簡單解析2 取得指定區間數據製作簡單解析3(簡單解析2 o處理對象, List<折点> list日線_折点, int 開始index, int 結束index) {
		if(開始index >= list日線_折点.size() -1 ) return null;
		
		List<折点> list指定数据 = null;
		if(結束index >= list日線_折点.size()) {
			list指定数据 = list日線_折点.subList(開始index, list日線_折点.size() - 1);
		}else {
			list指定数据 = list日線_折点.subList(開始index, 結束index+1);
		}
		
		簡單解析2 o簡單解析 = 根据指定日线数据制作簡單解析(list日線_折点, list指定数据);

		o處理對象.setList指定数据(o簡單解析.getList指定数据());
		o處理對象.set开始(o簡單解析.get开始());
		o處理對象.set最低(o簡單解析.get最低());
		o處理對象.set最高(o簡單解析.get最高());
		o處理對象.set結束(o簡單解析.get結束());		
		
		return o處理對象;
	}

	private static 簡單解析2 根据指定日线数据制作簡單解析(List<折点> list日線_折点, List<折点> list指定数据) {

		簡單解析2 o簡單解析 = new 簡單解析2();
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；

		o簡單解析.set开始(簡單解析Util2.取得簡單解析的开始位(list日線_折点, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最低(簡單解析Util2.取得簡單解析的最低位(list日線_折点, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最高(簡單解析Util2.取得簡單解析的最高位(list日線_折点, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set結束(簡單解析Util2.取得簡單解析的結束位(list日線_折点, new ArrayList(list指定数据)));

		o簡單解析.setList指定数据(list指定数据);

		return o簡單解析;
	}

	private static 日線點 取得簡單解析的开始位(List<折点> list日線_折点, List<折点> list指定数据) {
		日線點 o = new 日線點();

		折点 r = list指定数据.get(0);
		o.set价格(r.get价格());
		o.set位置("S");
		o.set日時(r.get日時());
		o.setIndex(取得指定日期的index(list日線_折点, r.get日時()));
		return o;
	}

	public static  int 取得指定日期的index(List<折点> list日線_折点, int i指定日時) {
		int index =0;
		for(折点 i : list日線_折点) {
				if(i.get日時() == i指定日時) {
					return index;
				}
				index++;

		}
		return index;
	}

	private static 日線點 取得簡單解析的結束位(List<折点> list日線_折点, List<折点> list指定数据) {
		日線點 o = new 日線點();

		折点 r = list指定数据.get(list指定数据.size()-1);
		o.set价格(r.get价格());
		o.set位置("E");
		o.set日時(r.get日時());
		o.setIndex(取得指定日期的index(list日線_折点, r.get日時()));
		return o;
	}

	private static 日線點 取得簡單解析的最高位(List<折点> list日線_折点, List<折点> list指定数据) {
		日線點 o = new 日線點();

		//SortUtil.sortList(list指定数据,newPropertyComparator<日线>("价格"));
		List<折点> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"价格");
		折点 最高r = l.get(l.size()-1);
		String s最高价格 = 最高r.get价格();
		
		// 如果最高价格一样，以最先出现的为准
		for( 折点 r : l) {
			if( r.get价格().equals(s最高价格)) {
				最高r = r;
				break;
			}
		}
		
		o.set价格(s最高价格);
		o.set位置("H");
		o.set日時(最高r.get日時() );
		o.setIndex(取得指定日期的index(list日線_折点, 最高r.get日時()));
		return o;
	}

	private static 日線點 取得簡單解析的最低位(List<折点> list日線_折点, List<折点> list指定数据) {
		日線點 o = new 日線點();

		List<折点> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"价格");
		折点 r = l.get(0);
		
		// 如果最低价格一样，以最后出现的为准
		
		
		o.set价格(r.get价格());
		o.set位置("L");
		o.set日時(r.get日時());
		o.setIndex(取得指定日期的index(list日線_折点, r.get日時()));
		return o;
	}



	public static 簡單解析2 取得指定區間數據製作簡單解析(List<折点> list日線_折点, int 指定index, int 對象個數) {
		List<折点> list指定数据 = null;
		if(指定index + 對象個數 >= list日線_折点.size()) {
			list指定数据 = list日線_折点.subList(指定index, list日線_折点.size() - 1);
		}else {
			list指定数据 = list日線_折点.subList(指定index, 指定index  + 對象個數);
		}
		if(list指定数据.size()==0) {
			指定index = 指定index;
		}
		return 根据指定日线数据制作簡單解析(list日線_折点, list指定数据);
	}

	public static 簡單解析2 取得指定區間數據製作簡單解析2(List<折点> list日線_折点, int index, int 對象個數) {
		if(index >= list日線_折点.size() -1 ) return null;
		
		List<折点> list指定数据 = null;
		if(index+對象個數 >= list日線_折点.size()) {
			list指定数据 = list日線_折点.subList(index+1, list日線_折点.size() - 1);
		}else {
			list指定数据 = list日線_折点.subList(index+1, index + 1 + 對象個數);
		}
		
		return 根据指定日线数据制作簡單解析(list日線_折点, list指定数据);
	}



}
