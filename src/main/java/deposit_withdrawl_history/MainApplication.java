package deposit_withdrawl_history;

import java.io.IOException;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer
			= new BankStatementAnalyzer();

		final BankStatementParser bankStatementParser
			= new BankStatementCSVParser();

		bankStatementAnalyzer.analyze(args[0], bankStatementParser);
	}
}
