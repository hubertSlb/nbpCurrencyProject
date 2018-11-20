package pl.dashboard.nbp.validators;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArgsValidatorTest {
	
	private String[] args1;
	private String[] args2;
	private String[] args3;
	private String[] args4;
	private String[] args5;
	private String[] args6;
	private String[] args7;
	private String[] args8;
	private ArgsValidator argsValid;
	
	@Before
	public void setUp() {
		args1 = null;
		args2 = new String[] {""};
		args3 = new String[] {"aaa"};
		args4 = new String[] {"aaa", "bbb"};
		args5 = new String[] {"2001/03/15"};
		args6 = new String[] {"2001-03-15", "2006-05-13"};
		args7 = new String[] {"2001-03-15"};
		args8 = new String[] {"2006-05-13"};
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputValid1() {
		argsValid = new ArgsValidator(args1);
		assertThat(argsValid.inputValid());
	}
	
	@Test
	public void testInputValid2() {
		argsValid = new ArgsValidator(args2);
		assertThat(argsValid.inputValid()).isEqualTo("");
	}
	
	@Test
	public void testInputValid3() {
		argsValid = new ArgsValidator(args3);
		assertThat(argsValid.inputValid()).isEqualTo("aaa");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputValid4() {
		argsValid = new ArgsValidator(args4);
		assertThat(argsValid.inputValid());
	}
	
	@Test
	public void testInputValid5() {
		argsValid = new ArgsValidator(args5);
		assertThat(argsValid.inputValid()).isEqualTo("2001/03/15");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputValid6() {
		argsValid = new ArgsValidator(args6);
		assertThat(argsValid.inputValid());
	}
	
	@Test
	public void testInputValid7() {
		argsValid = new ArgsValidator(args7);
		assertThat(argsValid.inputValid()).isEqualTo("2001-03-15");
	}
	
	@Test
	public void testInputValid8() {
		argsValid = new ArgsValidator(args8);
		assertThat(argsValid.inputValid()).isEqualTo("2006-05-13");
	}

}
