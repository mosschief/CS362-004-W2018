


import org.junit.rules.ErrorCollector;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest_2 {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testManualTest()
    {
        //You can use this function to implement your manual testing
        UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        try {
            collector.checkThat(validator.isValid(null), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http"), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("abc.def.google.com"), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http://www....google.com"), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http://www.@@$.com"), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http://localhost:8000"), equalTo(false));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("https://www.pir.com"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http://www.google.com"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("https://www.google.org"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }
        collector.checkThat(validator.isValid("http://www.google.com/search"), equalTo(true));
        try {
            collector.checkThat(validator.isValid("https://www.google.com/search?source=hp&ei=VzGXWrTyKKGJ0wKdt6-gBA&q=hello&oq=hello"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("http://www.google.com:8000"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }
        try {
            collector.checkThat(validator.isValid("ftp://www.google.com"), equalTo(true));
        } catch (Error e) {
            collector.addError(e);
        }

    }

    @Test
    public void testYourFirstPartition()
    {
        //You can use this function to implement your First Partition testing

    }

    @Test
    public void testYourSecondPartition(){
        //You can use this function to implement your Second Partition testing

    }
    //You need to create more test cases for your Partitions if you need to
    @Test
    public void testIsValid()
    {
        //You can use this function for programming based testing

    }
}
