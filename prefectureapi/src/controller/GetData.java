package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Prefecture;

@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String[] prefectures = {
			"北海道",
			"青森",
			"岩手",
			"宮城",
			"秋田",
			"山形",
			"福島",
			"茨城",
			"栃木",
			"群馬",
			"埼玉",
			"千葉",
			"東京",
			"神奈川",
			"新潟",
			"富山",
			"石川",
			"福井",
			"山梨",
			"長野",
			"岐阜",
			"静岡",
			"愛知",
			"三重",
			"滋賀",
			"京都",
			"大阪",
			"兵庫",
			"奈良",
			"和歌山",
			"鳥取",
			"島根",
			"岡山",
			"広島",
			"山口",
			"徳島",
			"香川",
			"愛媛",
			"高知",
			"福岡",
			"佐賀",
			"長崎",
			"熊本",
			"大分",
			"宮崎",
			"鹿児島",
			"沖縄",
	};
	public static final String[] specialtys = {
			"ドゥーブルフロマージュ",
			"気になるりんご",
			"かもめのたまご",
			"ずんだ餅",
			"金萬",
			"のし梅",
			"むぎせんべい",
			"はんじゅくちーず",
			"ぎょうざ（まさしorみんみん）",
			"かいこの王国",
			"草加せんべい",
			"ぴーなっつ最中",
			"ベイクドZOO",
			"神奈川の特産品",
			"さとやバウム",
			"ます寿し",
			"まるごとみかん大福",
			"五月ケ瀬",
			"桔梗信玄餅",
			"八幡屋磯五郎の七味",
			"飛騨牛まん",
			"お茶羊羹",
			"鬼まんじゅう・どうぶつえん",
			"おかげサブレ",
			"小あゆ煮",
			"鴨サブレ",
			"ジョリーボンボン",
			"魔法の壷プリン",
			"吉野本葛",
			"宝梅",
			"妖怪饅頭",
			"出雲そば",
			"きびだんご",
			"ひとつぶマスカット",
			"ふぐ煎餅",
			"鳴門金時",
			"讃岐うどん",
			"ポンジュースコロン",
			"土佐日記",
			"博多いちごフロマージュ",
			"いかシュウマイ",
			"茂木びわゼリー",
			"いきなり団子",
			"荒城の月",
			"ぼうちーず",
			"さつまあげ詰合せ",
			"元祖紅いもタルト",
	};


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		name=name==null? "":name;

		boolean hit = false;
		Prefecture pre = new Prefecture();

		for(int i=0;i<prefectures.length;i++) {
			if(name.equals( prefectures[i]) || name.equals( prefectures[i]+"県") ){
				pre.setName(prefectures[i]);
				pre.setSpecialty(specialtys[i]);
				pre.setDescription("作成中");
				hit = true;
				i=prefectures.length;
			}
		}

		if(!hit) {
			pre.setName("存在しない県名です");
		}

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out =response.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(pre));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
