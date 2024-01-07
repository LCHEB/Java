package homework2;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AccountBook {
	int num; //번호
	String date; //날짜
	int money,inMon,outMon; //돈, 수입, 지출
	String use; //내역
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBook other = (AccountBook) obj;
		return Objects.equals(date, other.date) && inMon == other.inMon && money == other.money && num == other.num
				&& outMon == other.outMon && Objects.equals(use, other.use);
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, inMon, money, num, outMon, use);
	}
	
	
	
	
	
}