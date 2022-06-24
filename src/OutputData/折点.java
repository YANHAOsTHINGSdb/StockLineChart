package OutputData;

import lombok.Data;

@Data
public class 折点 {


	public 折点(折点 s, float 誤差範圍) {
		日時 = s.get日時();
		位置 = s.get位置();
		高低 = s.get高低();
		index = s.getIndex();
		float f =  Float.parseFloat(s.get价格());
		
		价格 = f + f * 誤差範圍 + "";
	}
	public 折点(String s日時, String s位置, String s高低, String s价格, String sIndex) {
		日時 = Integer.parseInt(s日時);
		位置 = s位置;
		高低 = Integer.parseInt(s高低);
		价格 = s价格;
		index = Integer.parseInt(sIndex);
	}
	public 折点() {
		
	}
	int 日時; // YYYYMMDD
	String 位置; //SHLE
	int 高低; //(高。低)
	String 价格;
	int index;
}
