import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddTest.class,
        SubTest.class,
        MulTest.class,
        DerivTest.class,
        IntegrateTest.class,
        DivTest.class
})

public class TestSuite {
}
