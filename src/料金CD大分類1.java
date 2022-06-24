
public class 料金CD大分類1 implements 料金CD大分類 {


	@Override
	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報) {

		String 大分類CD = "";

		switch (o料金cd作成用情報.get料金対象()) {
 
		case (CommonConst.運搬料):
			switch (o料金cd作成用情報.get送り状種類()) {
			case (CommonConst.送り状種類_納品):
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_運搬料_納品);break;
			case (CommonConst.送り状種類_返品):
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_運搬料_返品);break;
			default:
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_エラー);break;				
			}break;

		case (CommonConst.検品料):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_検品料);break;

		case (CommonConst.館内配送料):
			switch (o料金cd作成用情報.get送り状種類()) {
			case (CommonConst.送り状種類_納品):
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_館内配送料_納品);break;
			case (CommonConst.送り状種類_返品):
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_館内配送料_返品);break;
			case (CommonConst.送り状種類_店間):
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_館内配送料_店間);break;
			default:
				大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_エラー);break;
			}break;

		case (CommonConst.店間移動運賃):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_店間移動運賃);break;
		default:break;
			
		}

		return 大分類CD;
	}

}
