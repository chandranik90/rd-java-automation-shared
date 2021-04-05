package factory;

import anotherpackage.Qahana2Test;
import org.testng.annotations.Factory;
import testpackage.QahanaTest;

public class MyFactory {

    @Factory()
    public Object[] myFactoryMethod33() {
        Object[] tests = new Object[1];
        tests[0] = new QahanaTest();
//        tests[1] = new Qahana2Test(6);
        return tests;
    }

    @Factory()
    public Object[] myFactoryMethod() {
        Object[] tests = new Object[1];
        tests[0] = new Qahana2Test(4);
//        tests[1] = new Qahana2Test(6);
        return tests;
    }

}