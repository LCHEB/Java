package homework2;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountBook {
	Date date;
	String use;
	int money,inmoney,outmoney;
	int totalmoney, totalInMoney, totalOutMoney;
}
