package common;

public class CommonConst {
	public final static int 低点 = 0;
	public final static int 高点 = 1;
	public final static int 更低点 = 2;
	public final static int 更高点 = 3;
	public final static int 未超想象 = 99;

	public final static int 指定日線数 = 3;

	public final static int 如果_手持低点_要找高点_但碰见一个更低的谷=1;
	public final static int 如果_手持低点_要找高点_但没有碰见一个更低的谷=2;
	public final static int 如果_手持高点_要找底点_但碰见一个更高的谷=3;
	public final static int 如果_手持高点_要找底点_但没碰见一个更高的谷=4;
	public final static int 如果_這是第一次計算=5;
	public final static int 如果_這是最後一次計算=6;
	
	public final static int 日時 = 0;
	public final static int 開盤價 = 1;
	public final static int 收盤價 = 2;
	public final static int 最低價 = 3;
	public final static int 最高價 = 4;
	
	public final static int  A模式_取得新的区间	 = 0;
	public final static int  B模式_有限区间内再找一点 = 1;

	public final static int  本番mode = 0;
	public final static int  調試mode = 1;

	
	public static int 對象個數 = 0;
	public static int debugMode = CommonConst.本番mode; // 0:本番  1:debug
	
	
	public final static int 平臺類型_高平台 = 0;
	public final static int 平臺類型_低平台 = 1;
	public static final int 平臺類型_上坡 = 2;
	public static final int 平臺類型_下坡 = 3;	
	
	
	
	public final static int 全不滿足 = 0;
	public final static int 前面两个都成立 = 2;
	
//	public final static int 平台_類型_高点 = 0;
//	public final static int 平台_類型_高台 = 1;
//	public final static int 平台_類型_低台 = 2;
	public static final int 平台_高低_高 = 0;
	public static final int 平台_高低_低 = 1;
	

}
