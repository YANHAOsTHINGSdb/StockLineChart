import java.io.IOException;

public class 料金CD算號器 {
	

	
	
	public static void main(String[] args) throws IOException {

		料金CD作成用情報 o料金CD作成用情報 = new 料金CD作成用情報(
				1, // 料金対象
				1, // 送り状種類
				1, // 基本個別区分
				1, // 納品形態
				1, // サイズ有無
				1, // 集着荷区分
				1, // 荷物種類
				1, // サイズ過大判断フラグ
				1);
		String 料金CD = new 料金CD算號器().取得料金CD(o料金CD作成用情報 );
		System.out.print("料金CD:" + 料金CD);
	}

	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報 ) {
		
		料金CD大分類 d = null;
		料金CD中分類 f = null;
		料金CD小分類 s = null;
		switch(o料金cd作成用情報.get料金対象()) {
		
		case(CommonConst.運搬料):
		case(CommonConst.検品料):
		case(CommonConst.館内配送料):
		case(CommonConst.店間移動運賃):
			 d = new 料金CD大分類1();
			 f = new 料金CD中分類1();
			 s = new 料金CD小分類1();
			 break;
			 
		case(CommonConst.百貨店請求料):
		case(CommonConst.配達先_館内配送料):
		case(CommonConst.百貨店請求料_館内配送料):
		case(CommonConst.値札加工料):
		case(CommonConst.基本料):
		case(CommonConst.ジョイント料):
		case(CommonConst.送り状諸料金):
			 d = new 料金CD大分類2();
			 f = new 料金CD中分類2();
			 s = new 料金CD小分類2();
			 break;
			 
		default:
			return null;
		}
		
		String s大分類 = d.取得料金CD(o料金cd作成用情報);
		String s中分類 = f.取得料金CD(o料金cd作成用情報);
		String s小分類 = s.取得料金CD(o料金cd作成用情報);
		return s大分類.concat("-").concat(s中分類).concat("-").concat(s小分類);
	}
}

