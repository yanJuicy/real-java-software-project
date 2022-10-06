package deposit_withdrawl_history;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSample {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions
			= bankStatementParser.parseLinesFrom(lines);

		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
	}

	private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
		final List<BankTransaction> bankTransactionInMonth = new ArrayList<>();

		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionInMonth.add(bankTransaction);
			}
		}

		return bankTransactionInMonth;
	}

	private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}


}
