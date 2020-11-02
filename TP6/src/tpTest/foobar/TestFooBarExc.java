package tpTest.foobar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestFooBarExc {

	@Test
	public void testFooBar() throws FooBarException {
		SUT sut=new SUT(-1, 2, 3);
		assertThrows(FooBarException.class, ()->{sut.foobar();});
	}
}
