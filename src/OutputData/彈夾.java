package OutputData;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ParseTool.輸出debug信息Util;
import common.CommonConst;
import lombok.Data;

@Data
public class 彈夾 {
	List<Integer> 對象日期list;
	int i最低价格index;
	int i最高价格index;
	float f最低价格;
	float f最高价格;
	List<折点> 高点list;
	List<折点> 低点list;
	int 平臺開始日期;
	List<String[]> 低點趨勢list;
	List<折点> 折点list;

	
	public 彈夾(){
		對象日期list = new ArrayList();
		高点list = new ArrayList();
		低点list = new ArrayList();
		平臺開始日期 = 0;
		折点list =  new ArrayList();
		低點趨勢list =  new ArrayList();
		i最低价格index =0;
		i最高价格index =0;
	}
	
	public void 初始化(折点 開始折點){
		折点list =  new ArrayList();
		折点list.add(開始折點);
		
		低點趨勢list =  new ArrayList();
		
		i最低价格index =0;
		i最高价格index =0;
		
		f最低价格 = 0;
		f最高价格 = 0;

		高点list = new ArrayList();
		低点list = new ArrayList();
		低点list.add(開始折點);
		
		// 重置平臺開始日期
		// 下一个开始点是上一个结束点
		平臺開始日期 = 開始折點.get日時();	

	}

	/**
	 * 
	 *  #取得期间每个低点与最新低点的关系：
	 *		#是否在颈线范围内
	 *
	 *	#判断是否打破原来模式：
	 *
	 *	return 上面的结果;	
	 *
	 * @param z
	 * @param 誤差範圍
	 * @return
	 */
	public boolean 追加折点(折点 z, float 誤差範圍) {

		追加低点list(z);
	    追加高点list(z);
	    追加折点list(z);
	    更新最高点(z, 對象日期list);
	    更新最低点(z, 對象日期list);
	    對象日期list.add(z.get日時());
	    

		//非低點不計算
		if(z.get高低() != CommonConst.低点)return false;
		if(低点list.isEmpty())return false;
		

	    // 初次追加。設置平臺開始日期
	    if(平臺開始日期 == 0) {
	    	平臺開始日期 = z.get日時();
	    }
	    
	    String[] 低點趨勢log = 取得低點趨勢log( z, 誤差範圍);
	    
	    boolean b = 是否打破原来模式(低點趨勢log, 低點趨勢list);
	    
	    低點趨勢list.add(低點趨勢log);
	    
		return b;
	    		
		
	}

	private String[] 取得低點趨勢log(折点 z新低点, float 誤差範圍) {

		折点 開始低點 = 低点list.get(0);
		折点 s高 = new 折点(開始低點, 誤差範圍);
	    折点 e高 = new 折点(z新低点, 誤差範圍);
	    折点 s低 = new 折点(開始低點, 誤差範圍 * -1);
	    折点 e低 = new 折点(z新低点, 誤差範圍 * -1);
	    
	    //對於新的點，現在所有的點是否在範圍內
	    List<String > 結果list = new ArrayList();
	    List<折点> 對象低点list = new ArrayList();
	    List<String > 各点风格list = new ArrayList();
	    boolean b = true;
	    
	    // 針對所有低點進行統計
	    // 主要是测试其中的低折点是否满足条件，所以 i 从 1 开始
	    for(int i = 1;i<折点list.size();i++) {
	    	if(折点list.get(i).get高低() == CommonConst.低点) {
	    		折点 對象低点 = 折点list.get(i);
	    		/*
				  #指定折點是否在範圍內
				  	|--開始高點-----------------結束高點
				  	|               對象低點
				  	|--開始低點-----------------結束低點
	    		 */
	    		//String s是否在范围内 = 指定折点是否在范围内(s高, e高, s低, e低, 對象低点);
	    		/*
			 	  #指定折點輸出風格
				    |                        對象低點
				  	|--對象低點的頸線價格-----------------
				  	                         對象低點
	    		 */
	    		String s折点输出风格 = 指定折點輸出風格(開始低點, z新低点, 對象低点);	    		
	    		
	    		if (b == false) {
	    			// 如果判负就直接淘汰
	    			// 判負條件：1，是否在范围内 = false
	    			//           2, 輸出風格改變 = true
	    			結果list.add("N");
	    			continue;
	    		}else {
	    			// b = 判断结果(s是否在范围内, 各点风格list, s折点输出风格);
	    			 b = 判断结果(各点风格list, s折点输出风格);
	    			 if (b == true) {
	    				 結果list.add("Y");	    			 
	    			 }else {
	    				 結果list.add("N");
	    			 }
	    		}
	    		
	    		對象低点list.add(對象低点);
	    		各点风格list.add(s折点输出风格);
	    	}
	    }
	    
		// 1、輸出低點趨勢log
		String[] 低點趨勢log = 輸出低點趨勢log(結果list, 對象低点list, 開始低點);
		return 低點趨勢log;
	}
	



	private boolean 判断结果(List<String> 各点风格list, String s折点输出风格) {
		int i上 = 0;
		int i下 = 0;
		
		for(String s : 各点风格list) {
			if(s.equals("上")) {
				i上++;
				
			}else if(s.equals("下")) {
				i下++;
			}
		}
		
		if(s折点输出风格.equals("上")) {
			if(i上 > i下 || 各点风格list.isEmpty()) return true;
		}
		if(s折点输出风格.equals("下")) {
			if(i下 > i上) return true;
		}
		
		return false;
	}

	private boolean 判断结果(String s是否在范围内, List<String> 各点风格list, String s折点输出风格) {

		
		int i上 = 0;
		int i下 = 0;
		
		for(String s : 各点风格list) {
			if(s.equals("上")) {
				i上++;
				
			}else if(s.equals("下")) {
				i下++;
			}
		}
		
		if(!s是否在范围内.equals("Y")) {
			return false;
		}
		if(s折点输出风格.equals("上")) {
			if(i上 > i下 || 各点风格list.isEmpty()) return true;
		}
		if(s折点输出风格.equals("下")) {
			if(i下 > i上) return true;
		}
		
		return false;
	}

	private String 指定折點輸出風格(折点 开始折点, 折点 結束低點, 折点 折点) {

		
		float f = 取得某条线上某点价格(开始折点, 結束低點,  折点.getIndex());
		float x价格 = Float.parseFloat(折点.get价格());
		
		boolean b = x价格 >= f;
		
		return b == true ? "上" : "下" ;
	}
	
	/**
	 * 是否打破原来模式()
	 *   本次低點趨勢Y比率 小于 上一次低點趨勢Y比率
	 *   且
	 *   本次低點趨勢Y比率 小于 0.5
	 *   
	 * @param 低點趨勢log
	 * @param 低點趨勢list
	 * @return
	 */

	private boolean 是否打破原来模式(String[] 低點趨勢log, List<String[]> 低點趨勢list) {
		if(null == 低點趨勢list || 低點趨勢list.isEmpty())return false;
		
		String[] 上一次低點趨勢log =低點趨勢list.get(低點趨勢list.size()-1);
		float 上一次低點趨勢Y比率 = 取得某一結果占有比率(上一次低點趨勢log, "Y");
		float 本次低點趨勢Y比率 = 取得某一結果占有比率(低點趨勢log, "Y");
		return 本次低點趨勢Y比率 < 上一次低點趨勢Y比率 && 本次低點趨勢Y比率 < 0.5;
	}

	private float 取得某一結果占有比率(String[] 低點趨勢log, String sY) {
		if(低點趨勢log==null || 低點趨勢log.length == 0) return 0;
		if(StringUtils.isEmpty(sY)) return 0;
		
		int size = 低點趨勢log.length;
		int iR = 0;
		
		for(int i = 0;i<size;i++) {
			if(低點趨勢log[i].contains(sY)) {
				iR ++;
			}
		}
		return iR/size;
	}

	private String[] 輸出低點趨勢log(List<String> 結果list, List<折点> 對象低点list, 折点 開始折點) {
		/*
		开始点与结束点的直线平面上，其他点都在的
        1【S】，2【E】
        1【S】，3【E】 ：2【Y】
        1【S】，4【E】 ：2【Y】、3【N】
        1【S】，5【E】 ：2【N】、3【Y】、4【N
		 */
	    String[] myArray = new String[結果list.size()];
	    List<String> list = new ArrayList();
	    int j = 0;
	    for(int i = 0;i<結果list.size();i++) {
	    	String s = "";
	    	s = s.concat(i+" ").concat("【").concat(結果list.get(i)).concat("】");
	    	
	    	list.add(s);	    			
	    }
	    輸出debug信息Util.print(結果list, 對象低点list, 開始折點);
	    list.toArray(myArray);
	    
		return myArray;
	}

	private String 指定折点是否在范围内(折点 s高, 折点 e高, 折点 s低, 折点 e低, 折点 折点) {
		
		// 算出指定日期的上限值	
		float x上限 = 取得某条线上某点价格( s高,  e高, 折点.getIndex());		
				
		// 算出指定日期的下限值
		float x下限 = 取得某条线上某点价格( s低,  e低, 折点.getIndex());
		
		float x价格 = Float.parseFloat(折点.get价格());
		
		boolean b = x价格 <= x上限 && x价格 >= x下限;
		
		return  b == true ? "Y" : "N" ;
	}

	private float 取得某条线上某点价格(折点 s高, 折点 e高, int i對象Index) {		

		
		int x1 = s高.getIndex();
		int x2 = e高.getIndex();	
		
		if(i對象Index == x1) return  Float.parseFloat(s高.get价格());
		
		float y1 = Float.parseFloat(s高.get价格());
		float y2 = Float.parseFloat(e高.get价格());
		// y - y1      x - x1
		//-------- = ----------
		// y2- y1      x2 -x1
			
		// y - y1  = ( x - x1) * (y2- y1) / ( x2 -x1)
		// y  = ( x - x1) * (y2- y1) / ( x2 -x1) + y1
	
		return ( i對象Index - x1) * (y2- y1) / ( x2 -x1) + y1;
	}

	private void 更新最低点(折点 z, List<Integer> 對象日期list) {
		
		float f折点z价格 = Float.parseFloat(z.get价格());

		if(f最低价格 == 0) {
			i最低价格index = 0;
			f最低价格 = f折点z价格;
		}
		if(f最低价格 >= f折点z价格){
			f最低价格 = f折点z价格;
			i最低价格index = 對象日期list.indexOf(z.getIndex());
			
		}
	}

	private void 更新最高点(折点 z, List<Integer> 對象日期list) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	private void 追加折点list(折点 z) {
		折点list.add(z);
		
	}

	private void 追加高点list(折点 z) {
		高点list.add(z);
		
	}

	private void 追加低点list(折点 z) {
		
		if(z.get高低() == CommonConst.低点) {
			低点list.add(z);
		}
		
	}

//	public void is是否出现平台() {
//		/*
//		 * 	数据解析：
//			       高平台，
//			       低平台，
//			               低点：不会出现新低点、不会出现新高点
//			                           最高低点、最低低点
//			                打破条件：下一个低点高于前面的高点
//			                                   下一个高点低于前面的低点
//			       
//			       滑行平台，
//			                低点：線性升降且，高點線性升降
//			                低点：平滑曲线/粗糙平滑曲线
//			
//			然后继续吃豆。
//			如果以后的点也都是这样：
//			之前的截止的信息为一个平台
//			之后为另一个平台
//			同樣開始累積。
//		 */
//		
//	}

	public 平台 取得平台信息(平台 p舊平臺) {
		// 對象日期list 从 平臺結束日期 到 最后一项 的對象輸出
		平台 n = new 平台();
		// 下一个开始点是上一个结束点
		if(p舊平臺 != null) {
			int i開始日時 = p舊平臺.getI結束日時();
			n.setI開始日時(i開始日時);
			n.setI開始index(對象日期list.indexOf(i開始日時));
		}else {
			n.setI開始日時(平臺開始日期);
			n.setI開始index(對象日期list.indexOf(平臺開始日期));
		}
		// 倒数第二位置的低点为结束点
		int i結束日時 = 0;
		if((低点list.size()-2) >= 0 ) {
			i結束日時 = 低点list.get(低点list.size()-2).get日時();
		}
		n.setI結束日時(i結束日時);
		n.setI結束index(對象日期list.indexOf(i結束日時));
		
		
		
		return n;
	}
}
