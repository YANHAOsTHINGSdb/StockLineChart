輸出折線圖數據----------------------------------------------------
	入力：計算目標 , List<日線> , 假点index,  對象個數, List<折点>
	出力： void

		取得处理对象：簡單解析	  做成處理对象
			以假点为
		判断
		最后一次计算
		處理
		最后一次计算
		輸出折線圖數據_B
		递归调用自己




	做成處理对象----------------------------------------------------
	（以对象index为参照，取得對象個數为一区间）
	入力：計算目標 , List<日線> , 对象index, 對象個數,  A_B模式iType
	出力：o簡單解析

		做成處理对象
	     如果假点为空， 
	             （就是全对象）
	             簡單解析Util.取得指定區間數據製作簡單解析
	     如果假点不为空，
	             就是假点以后的对象
	                  （日线，假点index，對象個數 - 假点index - index）
	              A模式_取得新的区间
	              		處理個數
	              B模式_有限区间内再找一点
	              		處理個數
	              簡單解析Util.取得指定區間數據製作簡單解析2
	              	(从指定index的下一个单位开始到對象個數的指定區間的簡單解析数据做成)
	              	(    |--- 1 ---|--------------對象個數--------------|  )
	              	(指定index     开始								  结束 )
	      返回 o簡單解析

	判断--------------------------------------------------------------
	入力：簡單解析 , 計算目標 , List<日線> , 对象index
	出力：iResult：处理mode

	      假点为空：第一次：追加确点，追加假点
	      假点为高，求低，碰见更高：更新假点_高
	      假点为高，求低，未碰见更高：追加新假点_高
	      假点为低，求高，碰见更低：更新假点_低
	      假点为低，求高，未碰见更低：追加新假点_低


	是否最后一次计算---------------------------------------------------
	入力：計算目標 , List<日線>
	出力：true/false

		假点是否最后一天



	處理---------------------------------------------------
	入力：iResult, 簡單解析 , 計算目標 , List<日線> , List<折点> 
	出力：處理對象

		最后申诉：
			无条件向后取得對象個數的数据：                    取得指定日的前后指定天数的簡單解析
			再算一次结果：                                   判斷2是否是周圍的極限點
			如果两次（入力：iResult 和 再算一次结果）结果一样，就按部就班处理
			如果两次结果不一样，按新的结果执行
		根据判断结果处理：
			如果_手持低点_要找高点_但碰见一个更低的谷: 			更新假点
			如果_手持低点_要找高点_但没有碰见一个更低的谷:		追加假点
			如果_手持高点_要找底点_但碰见一个更高的谷:			更新假点
			如果_手持高点_要找底点_但没碰见一个更高的谷:		追加假点
			如果_這是第一次計算:								第一次计算
			如果_這是最後一次計算:							最后一次计算




	取得指定日的前后指定天数的簡單解析---------------------------------------------------
	入力：List<日線> ,  index假点,  i指定天数,  i最大最小值
	出力：簡單解析

		指定开始终了：(|index假点 ----(對象個數)----|)
					（包含index假点本身）
		根据开始终了取得对象数据：								取得指定區間數據製作簡單解析
		


	判斷2是否是周圍的極限點---------------------------------------------------




	輸出折線圖數據_B---------------------------------------------------


	递归调用自己---------------------------------------------------


	// 以index为中心，找前后范围内指定天数的数据