package deposit_withdrawl_history;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class BankStatementCSVParserTest {

	private final BankStatementParser statementParser = new BankStatementCSVParser();

	@Test
	public void shouldParseOneCorrectLine() throws Exception {
		final String line = "30-01-2017, -50, Tesco";
		final BankTransaction result = statementParser.parseFrom(line);
		final BankTransaction expected
			= new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		final double tolerence = 0.0d;

		assertEquals(expected.getDate(), result.getDate());
		assertEquals(expected.getAmount(), result.getAmount(), tolerence);
		assertEquals(expected.getDescription(), result.getDescription());
	}

}
