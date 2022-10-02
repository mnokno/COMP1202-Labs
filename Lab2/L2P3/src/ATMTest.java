import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.SecurityManager;
import java.lang.reflect.ReflectPermission;

import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.security.Permission;
import java.util.PropertyPermission;
import java.lang.RuntimePermission;
import java.util.logging.LoggingPermission;

class OutputCapturer {
	private PrintStream origOut;

	private ByteArrayOutputStream outputStream;
	
	public void start()
	{
		this.origOut = System.out;
		this.outputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(this.outputStream);
		System.setOut(ps);	
	}
	
	public String getOutput() {
		System.out.flush();
		return this.outputStream.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");
	}

	public void stop() {
		System.setOut(this.origOut);
	}
}

class ATMTest {
	
	OutputCapturer outputHarness;
	SecurityManager oldSM;

	@BeforeEach
	public void setupTest() {
		oldSM = System.getSecurityManager();
		SecurityManager sm = new SecurityManager() {
			@Override
			public void checkPermission(Permission perm) {
			}
			@Override
			public void checkPermission(Permission perm, Object count) {	
			}
			@Override
			public void checkExit(int status) {
				throw new SecurityException("System exit called");
			}
		};	
		System.setSecurityManager(sm);
		
		this.outputHarness = new OutputCapturer();
		this.outputHarness.start();
	}
	
	@AfterEach
	public void tearDown()
	{
		this.outputHarness.stop();
		System.setSecurityManager(oldSM);
	}

	@Test
	@DisplayName("Test ATM's quit method")
	void testPart3Quit() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(
			out.contains("What do you want to do?") &&
			out.contains("1 : Withdraw") &&
			out.contains("2 : Deposit") &&
			out.contains("3 : Inquire") &&
			out.contains("4 : Quit"),
			"shows menu");
		
		assertEquals("System exit called", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test ATM's inquire method")
	void testPart3Inquire() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
				
		assertTrue(out.contains("100"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}

	@Test
	@DisplayName("Test ATM's deposit method")
	void testPart3Deposit() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("2"), new String ("20"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("120"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
	
	@Test
	@DisplayName("Test ATM's withdrawal method")
	void testPart3Withdraw() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("1"), new String ("20"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("80"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
	
	@Test
	@DisplayName("Test negative deposits")
	void testPart3DepositNeg() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("2"), new String ("-120"), new String ("10"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("110"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
	
	@Test
	@DisplayName("Test negative withdrawals")
	void testPart3WithdrawNeg() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("1"), new String ("-120"), new String ("10"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("90"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
	
	@Test
	@DisplayName("Test withdrawal from negative balance")
	void testPart3WithdrawNegBalance() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("100"), new String("1"), new String ("120"), new String ("10"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("90"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
	
	
	@Test
	@DisplayName("Test withdrawal causing negative balance")
	void testPart3BalanceNeg() {
		
		Integer[] randomNumbers = { };
		String[] inputs = { new String("-100"), new String("100"), new String("3"), new String("4") };
		Toolbox.setTestingData(randomNumbers, inputs);
		
		ATM atm = new ATM();
		Throwable exception = assertThrows(SecurityException.class, () -> {
			atm.go();
		});
		
		String out = outputHarness.getOutput();
		
		assertTrue(out.contains("100"), "correct balance is shown");
		assertEquals("System exit called", exception.getMessage());
	
	}
}
