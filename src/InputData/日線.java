package InputData;

import lombok.Data;

@Data
public class 日線 {
	public 日線(String s日時, String s開盤_价格, String s收盤_价格, String s最高_价格, String s最低_价格) {
		日時 = s日時;
		開盤_价格 =s開盤_价格;
		收盤_价格 =s收盤_价格;
		最高_价格 =s最高_价格;
		最低_价格 =s最低_价格;
	}
	
	String 日時;
	String 開盤_价格;
	String 收盤_价格;
	String 最高_价格;
	String 最低_价格;

}
