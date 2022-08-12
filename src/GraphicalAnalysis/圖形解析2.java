package GraphicalAnalysis;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.impl.圖形計算_收縮三角形;
import GraphicalAnalysis.Graphical.impl.頸線Util;
import GraphicalAnalysis.Platform.圖形計算_新;
import GraphicalAnalysis.Platform.平臺計算;
import GraphicalAnalysis.Platform.高臺計算Util;
import GraphicalAnalysis.Platform.impl.圖形計算_新_M頭_頭肩頂;
import GraphicalAnalysis.Platform.impl.圖形計算_新_收縮三角形;
import InputData.日線;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import OutputData.頸線;
import ParseTool2.簡單解析Util2;
import ParseTool2.輸出頸線圖數據2;
import common.CommonConst;

public class 圖形解析2 {
	public static void main(String[] args) {
		String[][] o日線Array =
		{{"20190327","11.11","11.08","11.04","11.24","42124489","469246336.00"},{"20190328","11.03","11.03","10.90","11.05","29296120","321585856.00"},{"20190329","10.98","11.28","10.98","11.30","60526266","678436544.00"},{"20190401","11.36","11.44","11.29","11.52","70637405","808657536.00"},{"20190402","11.50","11.44","11.41","11.52","46714710","534896800.00"},{"20190403","11.37","11.50","11.34","11.54","50271029","575799424.00"},{"20190404","11.55","11.71","11.54","11.71","75232527","876099520.00"},{"20190408","11.79","11.72","11.65","11.96","77870373","920513536.00"},{"20190409","11.72","11.54","11.49","11.75","56895992","660406208.00"},{"20190410","11.50","11.48","11.42","11.56","41027539","470666656.00"},{"20190411","11.47","11.47","11.35","11.59","50172794","575765376.00"},{"20190412","11.47","11.49","11.43","11.56","26273690","301752032.00"},{"20190415","11.67","11.47","11.46","11.77","70509167","823853440.00"},{"20190416","11.46","11.95","11.43","11.99","100665400","1188260096.00"},{"20190417","11.96","11.91","11.88","12.09","68157211","816127040.00"},{"20190418","11.91","11.91","11.84","12.05","43048980","513835264.00"},{"20190419","12.01","12.01","11.86","12.20","56013041","672739648.00"},{"20190422","12.02","11.71","11.68","12.07","53389418","631192384.00"},{"20190423","11.68","11.70","11.63","11.80","33847719","396659648.00"},{"20190424","11.76","11.62","11.51","11.77","38201108","444929312.00"},{"20190425","11.56","11.54","11.48","11.69","40876129","473973536.00"},{"20190426","11.43","11.32","11.28","11.56","42469581","485267264.00"},{"20190429","11.35","11.48","11.34","11.54","38586938","442046720.00"},{"20190430","11.70","11.97","11.70","12.09","123474738","1466714752.00"},{"20190506","11.75","11.80","11.54","11.86","124545414","1460217088.00"},{"20190507","11.82","11.80","11.60","11.94","85489922","1010271104.00"},{"20190508","11.64","11.51","11.49","11.78","58500103","677487360.00"},{"20190509","11.48","11.12","11.10","11.56","64128049","722119104.00"},{"20190510","11.23","11.32","11.06","11.42","48550722","548884288.00"},{"20190513","11.20","11.31","11.15","11.40","40284963","455643072.00"},{"20190514","11.18","11.21","11.17","11.44","41888998","473151520.00"},{"20190515","11.28","11.32","11.23","11.42","34404465","389533440.00"},{"20190516","11.28","11.30","11.22","11.36","34141755","385015232.00"},{"20190517","11.32","11.24","11.20","11.35","38399831","433108032.00"},{"20190520","11.28","11.34","11.25","11.44","34904438","396448384.00"},{"20190521","11.33","11.32","11.31","11.45","32975873","374972608.00"},{"20190522","11.32","11.16","11.12","11.34","40000391","447828800.00"},{"20190523","11.12","11.10","10.95","11.15","36312689","401709184.00"},{"20190524","11.17","11.11","11.00","11.22","24160265","269312448.00"},{"20190527","11.09","11.22","10.96","11.26","35087915","390018816.00"},{"20190528","11.19","11.29","11.02","11.30","72278135","809741248.00"},{"20190529","11.17","11.12","11.07","11.29","40860970","455620576.00"},{"20190530","11.18","11.11","11.03","11.18","26650033","295267456.00"},{"20190531","11.11","11.13","11.05","11.23","36976728","412819776.00"},{"20190603","11.17","11.28","11.13","11.29","30492063","342326272.00"},{"20190604","11.29","11.35","11.26","11.37","25077393","283826816.00"},{"20190605","11.43","11.41","11.35","11.52","31423641","359479712.00"},{"20190606","11.51","11.47","11.38","11.51","26427215","303162720.00"},{"20190610","11.57","11.61","11.53","11.70","43183779","502599168.00"},{"20190611","11.35","11.42","11.27","11.45","52266217","594464064.00"},{"20190612","11.42","11.60","11.40","11.70","50635228","584680896.00"},{"20190613","11.57","11.70","11.50","11.79","46966016","548219968.00"},{"20190614","11.74","11.79","11.71","11.87","47385174","558641856.00"},{"20190617","11.78","11.77","11.75","11.92","35220103","416594816.00"},{"20190618","11.82","11.82","11.72","11.90","28965124","341904864.00"},{"20190619","12.04","11.88","11.81","12.07","44927745","537339840.00"},{"20190620","11.95","12.20","11.85","12.32","71647496","869024512.00"},{"20190621","12.18","12.09","12.03","12.30","55381180","670759360.00"},{"20190624","12.09","12.03","11.96","12.13","34195336","411172384.00"},{"20190625","11.98","11.66","11.51","11.98","80359367","940465152.00"},{"20190626","11.56","11.66","11.55","11.73","36973199","431115040.00"},{"20190627","11.68","11.64","11.55","11.84","47997783","561472064.00"},{"20190628","11.67","11.68","11.54","11.68","29545173","343056320.00"},{"20190701","11.86","11.71","11.69","11.92","54887882","646405184.00"},{"20190702","11.72","11.61","11.57","11.74","51165729","595072192.00"},{"20190703","11.62","11.56","11.51","11.63","36567085","422580480.00"},{"20190704","11.61","11.62","11.57","11.67","30369201","352968320.00"},{"20190705","11.63","11.57","11.53","11.64","25753241","298158880.00"},{"20190708","11.56","11.36","11.31","11.57","34710676","395611392.00"},{"20190709","11.40","11.37","11.33","11.43","21885404","248524016.00"},{"20190710","11.43","11.35","11.31","11.43","23409890","265773696.00"},{"20190711","11.43","11.40","11.34","11.46","23285835","265672144.00"},{"20190712","11.39","11.52","11.39","11.62","34816996","400591776.00"},{"20190715","11.40","11.50","11.22","11.54","40305603","459022368.00"},{"20190716","11.50","11.55","11.44","11.57","21606007","248901952.00"},{"20190717","11.49","11.48","11.46","11.57","17480372","201420080.00"},{"20190718","11.53","11.49","11.45","11.53","18260034","209938960.00"},{"20190719","11.51","11.58","11.49","11.63","19619622","227078768.00"},{"20190722","11.54","11.48","11.47","11.63","25617875","295840608.00"},{"20190723","11.43","11.49","11.43","11.56","17927898","206511008.00"},{"20190724","11.54","11.59","11.53","11.68","24112288","279914880.00"},{"20190725","11.57","11.88","11.57","11.96","55900219","660037376.00"},{"20190726","11.83","11.87","11.81","11.94","30368988","360677440.00"},{"20190729","11.90","11.86","11.80","11.94","21465011","254289648.00"},{"20190730","11.84","11.86","11.84","12.00","33731002","401937920.00"},{"20190731","11.81","11.87","11.73","11.94","30650758","362607616.00"},{"20190801","11.76","11.65","11.63","11.85","32471702","380252160.00"},{"20190802","11.48","11.48","11.41","11.56","38976091","447723840.00"},{"20190805","11.42","11.24","11.23","11.46","42719073","483523872.00"},{"20190806","11.10","11.09","10.97","11.23","45203853","501885632.00"},{"20190807","11.14","11.07","11.05","11.16","31462085","349267424.00"},{"20190808","11.15","11.26","11.11","11.31","33258085","373205568.00"},{"20190809","11.31","11.37","11.26","11.41","40637993","461422048.00"},{"20190812","11.33","11.43","11.31","11.45","34989082","398523200.00"},{"20190813","11.40","11.33","11.29","11.40","18839979","213447648.00"},{"20190814","11.42","11.28","11.28","11.48","19874457","225555664.00"},{"20190815","11.16","11.29","11.12","11.32","19101192","214656224.00"},{"20190816","11.25","11.22","11.21","11.34","24823561","279706592.00"},{"20190819","11.22","11.38","11.08","11.38","38253341","430744320.00"},{"20190820","11.30","11.37","11.28","11.47","23758050","270728000.00"},{"20190821","11.35","11.41","11.34","11.44","14656537","167119488.00"},{"20190822","11.43","11.43","11.37","11.45","15866836","180907936.00"},{"20190823","11.39","11.59","11.38","11.59","33655377","387195392.00"},{"20190826","11.39","11.30","11.15","11.44","41845176","472500384.00"},{"20190827","11.37","11.30","11.30","11.57","66247458","756664128.00"},{"20190828","11.37","11.32","11.30","11.40","25525597","289685344.00"},{"20190829","11.30","11.23","11.18","11.35","28049594","315060608.00"},{"20190830","11.34","11.28","11.22","11.37","25424004","287099392.00"},{"20190902","11.30","11.34","11.24","11.42","27749879","315706912.00"},{"20190903","11.39","11.35","11.31","11.41","16286609","184932352.00"},{"20190904","11.40","11.49","11.36","11.50","30670961","350981216.00"},{"20190905","11.50","11.62","11.50","11.74","46828000","544694720.00"},{"20190906","11.68","11.69","11.58","11.70","34392057","400477408.00"},{"20190909","11.78","11.75","11.68","11.79","40059368","470186976.00"},{"20190910","11.79","11.85","11.69","11.86","37041097","437072480.00"},{"20190911","11.85","11.95","11.85","12.00","39063654","466909312.00"},{"20190912","12.08","12.00","11.92","12.09","26104824","313028160.00"},{"20190916","11.99","11.93","11.83","12.01","25489116","303225632.00"},{"20190917","11.96","11.81","11.77","12.01","33558932","399569120.00"},{"20190918","11.94","11.93","11.87","12.00","31387271","375059072.00"},{"20190919","12.00","11.94","11.88","12.00","23742171","283084512.00"},{"20190920","11.99","11.95","11.85","11.99","40109279","478010560.00"},{"20190923","11.90","11.75","11.68","11.92","27710795","325475296.00"},{"20190924","11.81","11.75","11.73","11.86","21870962","257910160.00"},{"20190925","11.75","11.81","11.69","11.95","30136356","356897088.00"},{"20190926","11.88","11.97","11.84","12.18","72726461","876687808.00"},{"20190927","11.95","11.90","11.76","11.99","36807878","437372192.00"},{"20190930","11.85","11.84","11.81","12.07","35947577","430109088.00"},{"20191008","11.80","11.90","11.80","12.03","32415886","386027552.00"},{"20191009","11.82","11.99","11.80","12.13","42209602","506474304.00"},{"20191010","12.02","11.96","11.91","12.04","27261229","326023328.00"},{"20191011","12.05","12.45","12.00","12.45","92030800","1131441664.00"},{"20191014","12.59","12.94","12.52","13.22","123970103","1596408960.00"},{"20191015","12.95","13.09","12.86","13.14","73394591","952804800.00"},{"20191016","13.08","13.08","12.90","13.33","67002223","876220992.00"},{"20191017","13.07","13.17","13.03","13.25","47869313","628571136.00"},{"20191018","13.24","12.78","12.72","13.29","64992896","840281792.00"},{"20191021","12.80","12.91","12.75","13.03","38996287","502880224.00"},{"20191022","13.03","12.93","12.77","13.05","31396257","404182688.00"},{"20191023","12.89","12.86","12.77","12.95","32821414","422141024.00"},{"20191024","12.98","13.09","12.95","13.24","103158806","1347032704.00"},{"20191025","13.09","12.90","12.78","13.09","97876357","1260246528.00"},{"20191028","12.75","12.70","12.65","12.88","72380466","919894912.00"},{"20191029","12.74","12.77","12.62","12.85","52604090","669546624.00"},{"20191030","12.75","12.59","12.52","12.79","53734730","678152768.00"},{"20191031","12.68","12.51","12.50","12.70","33347533","419183008.00"},{"20191101","12.50","12.75","12.44","12.83","62705733","793656960.00"},{"20191104","12.75","12.74","12.69","12.89","49737996","634816384.00"},{"20191105","12.74","12.95","12.69","13.19","74274389","962257408.00"},{"20191106","12.95","12.92","12.86","13.10","46023920","597016896.00"},{"20191107","12.95","12.76","12.71","12.95","46267281","592408768.00"},{"20191108","12.80","12.57","12.56","12.81","48841866","617218176.00"},{"20191111","12.48","12.29","12.29","12.48","38594267","477989504.00"},{"20191112","12.31","12.24","12.17","12.36","39239395","480742752.00"},{"20191113","12.21","12.23","12.15","12.29","32274979","394505184.00"},{"20191114","12.23","12.14","12.10","12.27","28943647","351795392.00"},{"20191115","12.22","12.15","12.12","12.26","27324299","332797312.00"},{"20191118","12.17","12.24","12.13","12.35","28796529","352880160.00"},{"20191119","12.20","12.23","12.18","12.31","29370803","359115488.00"},{"20191120","12.17","12.04","12.01","12.22","38092059","460234688.00"},{"20191121","12.00","11.96","11.91","12.04","34617175","414077536.00"},{"20191122","12.01","11.99","11.94","12.06","29531099","354250528.00"},{"20191125","12.03","12.07","12.00","12.14","25153256","303962336.00"},{"20191126","12.15","12.06","11.98","12.17","59633264","719075392.00"},{"20191127","12.07","11.99","11.90","12.07","28703956","343598880.00"},{"20191128","12.00","11.96","11.92","12.01","17797225","212826176.00"},{"20191129","11.93","11.91","11.89","12.07","24566935","293541792.00"},{"20191202","11.96","11.87","11.82","11.97","22163020","263131792.00"},{"20191203","11.81","11.86","11.77","11.90","19557865","231361392.00"},{"20191204","11.78","11.75","11.70","11.83","24734662","290465760.00"},{"20191205","11.79","11.89","11.76","11.89","24976130","295963968.00"},{"20191206","11.92","11.92","11.83","11.95","20654438","245635920.00"},{"20191209","11.90","11.90","11.85","11.93","17349258","206211632.00"},{"20191210","11.88","11.86","11.86","11.91","15324640","181988688.00"},{"20191211","11.88","11.98","11.84","11.99","33409045","398582368.00"},{"20191212","11.99","11.90","11.88","11.99","27021203","321917920.00"},{"20191213","11.98","12.12","11.94","12.12","59520554","716034816.00"},{"20191216","12.12","12.13","12.00","12.15","37971632","458170272.00"},{"20191217","12.17","12.39","12.10","12.51","57435605","707895680.00"},{"20191218","12.36","12.40","12.34","12.50","34565268","428827232.00"},{"20191219","12.40","12.41","12.38","12.50","23789907","295686656.00"},{"20191220","12.41","12.42","12.38","12.55","40150148","500592352.00"},{"20191223","12.46","12.20","12.17","12.46","37033891","455979040.00"},{"20191224","12.21","12.28","12.20","12.29","21671029","265496464.00"},{"20191225","12.29","12.24","12.20","12.29","13678175","167407904.00"},{"20191226","12.26","12.29","12.23","12.32","15739054","193083040.00"},{"20191227","12.25","12.32","12.25","12.43","27932109","344832512.00"},{"20191230","12.27","12.34","12.12","12.36","41051555","503090496.00"},{"20191231","12.32","12.37","12.21","12.38","31953628","392736224.00"},{"20200102","12.47","12.47","12.45","12.64","51629079","647446144.00"},{"20200103","12.57","12.60","12.47","12.63","38018810","477053344.00"},{"20200106","12.52","12.46","12.42","12.65","41001193","514432544.00"},{"20200107","12.51","12.50","12.46","12.60","28421482","355811744.00"},{"20200108","12.41","12.32","12.25","12.45","35240536","434980256.00"},{"20200109","12.39","12.37","12.35","12.43","26151448","324168064.00"},{"20200110","12.37","12.39","12.31","12.42","18321252","226580304.00"},{"20200113","12.40","12.41","12.31","12.41","20715566","255982384.00"},{"20200114","12.40","12.43","12.39","12.69","29994561","374971648.00"},{"20200115","12.41","12.25","12.25","12.45","31897217","392531136.00"},{"20200116","12.28","12.20","12.16","12.31","22454876","274130144.00"}};
		
		String[][] arrayList折点 =
			{
					{"20190327", "S", "1", "11.11", "0" }, {"20190328", "L", "0", "10.90", "1" }, 
					{"20190408", "H", "1", "11.96", "2" }, {"20190411", "L", "0", "11.35", "3" }, 
					{"20190419", "H", "1", "12.20", "4" }, {"20190426", "L", "0", "11.28", "5" }, 
					{"20190430", "H", "1", "12.09", "6" }, {"20190510", "L", "0", "11.06", "7" }, 
					{"20190514", "H", "1", "11.44", "8" }, {"20190517", "L", "0", "11.20", "9" }, 
					{"20190521", "H", "1", "11.45", "10"}, {"20190523", "L", "0", "10.95", "11"}, 
					{"20190528", "H", "1", "11.30", "12"}, {"20190530", "L", "0", "11.03", "13"}, 
					{"20190610", "H", "1", "11.70", "14"}, {"20190611", "L", "0", "11.27", "15"}, 
					{"20190620", "H", "1", "12.32", "16"}, {"20190625", "L", "0", "11.51", "17"}, 
					{"20190627", "H", "1", "11.84", "18"}, {"20190628", "L", "0", "11.54", "19"}, 
					{"20190701", "H", "1", "11.92", "20"}, {"20190708", "L", "0", "11.31", "21"}, 
					{"20190712", "H", "1", "11.62", "22"}, {"20190715", "L", "0", "11.22", "23"}, 
					{"20190716", "H", "1", "11.57", "24"}, {"20190718", "L", "0", "11.45", "25"}, 
					{"20190719", "H", "1", "11.63", "26"}, {"20190723", "L", "0", "11.43", "27"}, 
					{"20190725", "H", "1", "11.96", "28"}, {"20190729", "L", "0", "11.80", "29"}, 
					{"20190730", "H", "1", "12.00", "30"}, {"20190806", "L", "0", "10.97", "31"}, 
					{"20190814", "H", "1", "11.48", "32"}, {"20190819", "L", "0", "11.08", "33"}, 
					{"20190820", "H", "1", "11.47", "34"}, {"20190821", "L", "0", "11.34", "35"}, 
					{"20190823", "H", "1", "11.59", "36"}, {"20190826", "L", "0", "11.15", "37"}, 
					{"20190827", "H", "1", "11.57", "38"}, {"20190829", "L", "0", "11.18", "39"}, 
					{"20190905", "H", "1", "11.74", "40"}, {"20190906", "L", "0", "11.58", "41"}, 
					{"20190912", "H", "1", "12.09", "42"}, {"20190917", "L", "0", "11.77", "43"}, 
					{"20190918", "H", "1", "12.00", "44"}, {"20190923", "L", "0", "11.68", "45"}, 
					{"20190926", "H", "1", "12.18", "46"}, {"20190927", "L", "0", "11.76", "47"}, 
					{"20191014", "H", "1", "13.22", "48"}, {"20191015", "L", "0", "12.86", "49"}, 
					{"20191016", "H", "1", "13.33", "50"}, {"20191018", "L", "0", "12.72", "51"}, 
					{"20191022", "H", "1", "13.05", "52"}, {"20191023", "L", "0", "12.77", "53"}, 
					{"20191024", "H", "1", "13.24", "54"}, {"20191101", "L", "0", "12.44", "55"}, 
					{"20191105", "H", "1", "13.19", "56"}, {"20191114", "L", "0", "12.10", "57"}, 
					{"20191118", "H", "1", "12.35", "58"}, {"20191121", "L", "0", "11.91", "59"}, 
					{"20191126", "H", "1", "12.17", "60"}, {"20191204", "L", "0", "11.70", "61"}, 
					{"20191217", "H", "1", "12.51", "62"}, {"20191218", "L", "0", "12.34", "63"}, 
					{"20191220", "H", "1", "12.55", "64"}, {"20191223", "L", "0", "12.17", "65"}, 
					{"20191227", "H", "1", "12.43", "66"}, {"20191230", "L", "0", "12.12", "67"}, 
					{"20200106", "H", "1", "12.65", "68"}, {"20200108", "L", "0", "12.25", "69"}, 
					{"20200114", "H", "1", "12.69", "70"}, {"20200116", "L", "0", "12.16", "71"}
			};
		
		List<折点> 折点list1 = new ArrayList();
		for(String[] array折点 : arrayList折点){
			折点list1.add(new 折点(
				array折点[0],
				array折点[1],
				array折点[2],
				array折点[3],
				array折点[4]
				));
		}
		
		
		String[][] arrayList折点2 =
		{
			{"20190327", "S", "1", "11.11", "0"}, 
			{"20190328", "L", "0", "10.90", "1"}, 
			{"20190419", "H", "1", "12.20", "4"}, 
			{"20190510", "L", "0", "11.06", "7"}, 
			{"20190521", "H", "1", "11.45", "10"}, 
			{"20190523", "L", "0", "10.95", "11"}, 
			{"20190620", "H", "1", "12.32", "16"}, 
			{"20190625", "L", "0", "11.51", "17"}, 
			{"20190701", "H", "1", "11.92", "20"}, 
			{"20190715", "L", "0", "11.22", "23"}, 
			{"20190730", "H", "1", "12.00", "30"}, 
			{"20190806", "L", "0", "10.97", "31"}, 
			{"20190814", "H", "1", "11.48", "32"}, 
			{"20190819", "L", "0", "11.08", "33"}, 
			{"20190823", "H", "1", "11.59", "36"}, 
			{"20190826", "L", "0", "11.15", "37"}, 
			{"20190912", "H", "1", "12.09", "42"}, 
			{"20190923", "L", "0", "11.68", "45"}, 
			{"20191016", "H", "1", "13.33", "50"}, 
			{"20191018", "L", "0", "12.72", "51"}, 
			{"20191024", "H", "1", "13.24", "54"}, 
			{"20191114", "L", "0", "12.10", "57"}, 
			{"20191118", "H", "1", "12.35", "58"}, 
			{"20191204", "L", "0", "11.70", "61"}, 
			{"20191220", "H", "1", "12.55", "64"}, 
			{"20191230", "L", "0", "12.12", "67"}, 
			{"20200114", "H", "1", "12.69", "70"}, 
			{"20200116", "L", "0", "12.16", "71"}};
		
		List<折点> 折点list2 = new ArrayList();
		for(String[] array折点 : arrayList折点2){
			折点list2.add(new 折点(
				array折点[0],
				array折点[1],
				array折点[2],
				array折点[3],
				array折点[4]
				));
		}
		
		List<頸線> 頸線list =  new 圖形解析2().輸出圖形解析結果(折点list1,折点list2, 簡單解析Util2.取得日線Array_by_List(o日線Array));
		

	}
	
	
	List<頸線> 輸出圖形解析結果(List<折点> 折点list1, List<折点> 折点list2, List<日線> 日線list) {
		
		List<圖形> 圖形list = new 圖形解析2().o圖形解析(折点list1, 折点list2, 日線list);
		
		List<頸線> 頸線list = new 圖形解析2().輸出頸線圖數據(圖形list, (float)0.1, 折点list1);
		
		return 頸線list;
		
	}


	private List<頸線> 輸出頸線圖數據(List<圖形> 圖形list, float f ,List<折点> 折点list1) {	
		
		List<頸線> 頸線list = new ArrayList();
				
		// 為了每個圖形畫頸線
		// 頸線就是法人低价出貨的最大限制的連線：把它畫出來
		// 直線需要定義兩個點：x=時間,y=價格
		// 高台图形:
		//   M形：中間唯一低點的平線（x開始=圖形的開始日時 x結束=圖形的結束日時, y開始結束=中間低點的价格） 
		//   頭肩頂：中間兩個低點的連線（x開始=圖形的開始日時 x結束=圖形的結束日時, y開始=頸線該點（x開始）價格, y結束=頸線該點（x結束）價格） 
		//   高臺：中間第一低點、第二低點的連線（x開始=圖形的開始日時 x結束=圖形的結束日時, y開始=頸線該點（x開始）價格, y結束=頸線該點（x結束）價格） 
		// 三角形图形:
		//   下位三角形:第一高点、第二高点的连线（x開始=圖形的開始日時 x結束=圖形的結束日時）
		//   上位三角形:第一低点，第二低点的连线（x開始=圖形的開始日時 x結束=圖形的結束日時）
		
		
		for(圖形 t : 圖形list) {		
			
			頸線 j = null;
 
			int i開始日時 = t.getI開始日時();
			int i結束日時 = t.getI結束日時();
			
			float f開始价格 = 0;
			float f結束价格 = 0;
			
			折点 z1 = null;
			折点 z2 = null;
			
			switch(t.get形状()) {
			case CommonConst.圖形_M頭_低:
			case CommonConst.圖形_M頭_高:
				
				f開始价格 = Float.parseFloat(t.get高台_第三折点().get价格());
				f結束价格 = f開始价格;

				
			case CommonConst.圖形_頭肩_低:
			case CommonConst.圖形_頭肩_高:
				z1 = t.get高台_第三折点();
				z2 = t.get高台_第五折点();
				
				f開始价格 = 頸線Util.取得该日颈线价格(z1, z2, 折点list1, i開始日時);
				f結束价格 = 頸線Util.取得该日颈线价格(z1, z2, 折点list1, i結束日時);
			case CommonConst.圖形_高臺_低:
			case CommonConst.圖形_高臺_高:
				z1 = t.get高台_第三折点();
				z2 = t.get高台_第五折点();
				
				f開始价格 = 頸線Util.取得该日颈线价格(z1, z2, 折点list1, i開始日時);
				f結束价格 = 頸線Util.取得该日颈线价格(z1, z2, 折点list1, i結束日時);
				
			case CommonConst.圖形_三角形_低:
			case CommonConst.圖形_三角形_高:
				
			}
			j.setI開始日時(i開始日時);
			j.setF開始价格(f結束价格);
			j.setI結束日時(i結束日時);
			j.setF結束价格(f結束价格);
			
			頸線list.add(j);
		}
		return 頸線list;
	}


	private List<圖形> o圖形解析(List<折点> 折点list1, List<折点> 折点list2, List<日線> 日線list) {
		
		 List<圖形> o圖形解析list = new ArrayList();
		
		// 第三次折点计算
		List<折点> 折点list3 = new 輸出頸線圖數據2().輸出折線圖數據(折点list2);
		
//折点list3		
//		折点(日時=20190327, 位置=S, 高低=1, 价格=11.11, index=0), 
//		折点(日時=20190328, 位置=L, 高低=0, 价格=10.90, index=1), 
//		折点(日時=20190419, 位置=H, 高低=1, 价格=12.20, index=2), 
//		折点(日時=20190523, 位置=L, 高低=0, 价格=10.95, index=5), 
//		折点(日時=20190620, 位置=H, 高低=1, 价格=12.32, index=6), 
//		折点(日時=20190715, 位置=L, 高低=0, 价格=11.22, index=9), 
//		折点(日時=20190730, 位置=H, 高低=1, 价格=12.00, index=10), 
//		折点(日時=20190806, 位置=L, 高低=0, 价格=10.97, index=11), 
//		折点(日時=20191016, 位置=H, 高低=1, 价格=13.33, index=18), 
//		折点(日時=20191204, 位置=L, 高低=0, 价格=11.70, index=23), 
//		折点(日時=20200114, 位置=H, 高低=1, 价格=12.69, index=26), 
//		折点(日時=20200116, 位置=L, 高低=0, 价格=12.16, index=27)
			
		
		List<平台> 平台list = new 高臺計算Util().解析出高低臺信息(折点list1, 折点list2, 折点list3, 日線list);
		
		/*
		 * 是高臺還是低臺，在圖形計算時再去解析，
		 * 還是在最初平臺計算時就清楚的標記
		 * 問題
		 * 		1、是否解决了低台上升的需求
		 * 			答：在开始只是解析了平台，并未与其他平台比较就无法得知是高还是低
		 * 
		 *      2、如何解决低台上升的图形计算（提取图形数据，驗證指標圖）
		 *      	答：先解决低台的识别（与其他平台比较）后再计算图形
		 *      
		 *      3、如何解决低位三角形要下降的图形计算
		 *      	答：先解决三角形的识别后再计算上或下的图形计算
		 *      
		 *      4、如何真的要重写，如何解决三角形与高低台同时计算的需求
		 *      	答：各算个的。
		 */	
		
		 List<圖形> 圖形_高低平台list = o圖形解析_高低平台(折点list1, 折点list2, 折点list3, 平台list);
		 
		 List<圖形> 圖形_三角形list = o圖形解析_三角形(折点list1, 折点list2, 折点list3, 平台list);
		
		 o圖形解析list.addAll(圖形_高低平台list);
		 
		 o圖形解析list.addAll(圖形_三角形list);
		 
		return o圖形解析list;
	}


	private List<圖形> o圖形解析_三角形(List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<平台> 平台list) {
		// 設置高低平臺(与其他平台比较就无法得知是高还是低)
		
		List<圖形> o圖形解析_三角形list = new ArrayList();
		
		平台list = new 高臺計算Util().設置高低平臺(平台list, 折点list3);
		
		// 排除幹擾
		List<折点>折點list_優化後 =new 高臺計算Util().排除幹擾(折点list2, 折点list3, 平台list);		
		
		// 圖形計算_收縮三角形【旧】
		List<圖形> 圖形_收縮三角形list = new 圖形計算_收縮三角形().計算(折點list_優化後, 平台list, 折点list3);
		
		// 
		圖形_收縮三角形list = new 高臺計算Util().設置高低三角形(圖形_收縮三角形list, 折点list3);
		
		圖形計算_新 o圖形計算_收縮三角形1 = new 圖形計算_新_收縮三角形();
		
		// 圖形計算
		for(圖形 t : 圖形_收縮三角形list) {
			
			圖形 o圖形 =  o圖形計算_收縮三角形1.趨勢計算(t, 折点list1, 折点list2, 折点list3,折點list_優化後);
			
			o圖形解析_三角形list.add(o圖形);
		}
		
		return o圖形解析_三角形list;
	}


	/**
	 * 
	 * @param 折点list1
	 * @param 折点list2
	 * @param 折点list3
	 * @param 平台list
	 * @return
	 */
	private List<圖形> o圖形解析_高低平台(List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<平台> 平台list) {
		// 設置高低平臺(与其他平台比较就无法得知是高还是低)
		List<圖形> 圖形_高低平台List = new ArrayList();
		
		平台list = 高臺計算Util.設置高低平臺(平台list, 折点list3);
		
		平臺計算 o平臺計算 = null;
		
		List<折点>平台折点list = new ArrayList();		
		
		// 連接相鄰的高臺
		平台list = new 高臺計算Util().連接相鄰的高臺(折点list1,  折点list2, 折点list3, 平台list);
		
		// 去掉不合格的高台
		平台list = new 高臺計算Util().去掉不合格的高台(折点list2, 折点list3, 平台list);
		
		
		// 排除幹擾
		List<折点>折點list_優化後 = new 高臺計算Util().排除幹擾(折点list2, 折点list3, 平台list);
		
		// 高台充实
		折點list_優化後 = new 高臺計算Util().高台充实By折点list1(折点list1, 折点list2, 折點list_優化後, 平台list);

		// 取得平台折点list
		for(平台 p : 平台list) {
			
			// 由于是各算个的。所以只有高点的类型为对象外
			//		if(p.getI類型() == CommonConst.平台_類型_高点) {
			//			折點list_優化後.addAll(平台Util2.取得指定平台内折点(p, 折点list3));
			//		}
			//int 高低; // 0=高 1=低			
	
			平台折点list = new 高臺計算Util().取得平台折点list(折点list1, 折點list_優化後, p);
			
			p.set平台折点list1(平台折点list);
			
		}
		
		// 圖形計算
		for(平台 p : 平台list) {
			
			圖形計算_新 o圖形計算_M頭_頭肩頂 = new 圖形計算_新_M頭_頭肩頂();
			
			圖形 o圖形 =o圖形計算_M頭_頭肩頂.圖形判别(p, 折点list1, 折點list_優化後, 折点list3);
			
			if(o圖形 == null) {
				continue;
			}
			
			o圖形 = o圖形計算_M頭_頭肩頂.趨勢計算(o圖形, 折点list1, 折点list2, 折点list3,折點list_優化後);
			
			圖形_高低平台List.add(o圖形);
			
		}
		
		return 圖形_高低平台List;
	}
}
