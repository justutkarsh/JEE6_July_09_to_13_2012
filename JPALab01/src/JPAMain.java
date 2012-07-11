import java.util.List;

import com.durasoft.Account;
import com.durasoft.dao.AccountsDao;

public class JPAMain {

	public static void main(String[] args) {
		AccountsDao dao = new AccountsDao();
		dao.createAccount(1001, 10000, "Sam");
		dao.createAccount(2001, 20000, "Ram");
		dao.updateAccount(1001, 200);
		System.out.println("Balance: " + dao.getBalance(1001));
		List<Account> accounts = dao.getAllAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
