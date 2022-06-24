
public class 料金CD大分類2 implements 料金CD大分類 {

	@Override
	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報) {
		String 大分類CD = "";

		switch (o料金cd作成用情報.get料金対象()) {
 
		case (CommonConst.百貨店請求料):			
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_百貨店請求料);break;

		case (CommonConst.配達先_館内配送料):			
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_配達先_館内配送料);break;
			
		case (CommonConst.百貨店請求料_館内配送料):			
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_百貨店請求料_館内配送料);break;
			
		case (CommonConst.値札加工料):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_値札加工料);break;
			
		case (CommonConst.基本料):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_基本料);break;
			
		case (CommonConst.ジョイント料):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_ジョイント料);break;
			
		case (CommonConst.送り状諸料金):
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_送り状諸料金);break;
		
		default:
			大分類CD = 大分類CD.concat(CommonConst.料金CD_大分類_エラー);break;
		}

		return 大分類CD;
	}



}
