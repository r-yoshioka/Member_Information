package jp.co.aforce.set;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberID {

	public String generateId() {

		// 書式を指定してDateTimeFormatterを取得
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        // 書式を指定してLocalDateTimeのインスタンスを作成する
        LocalDateTime ld = LocalDateTime.now();
        // システム日付を、DateTimeFormatterで指定したフォーマットで文字列に変換
        String date = ld.format(format);

		return "A" + date;
	}

}
