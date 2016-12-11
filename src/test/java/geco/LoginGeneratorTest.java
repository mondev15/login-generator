package geco;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by mundial on 23/11/2016.
 */
public class LoginGeneratorTest {

    private LoginGenerator loginGenerator;
    private LoginService loginService;

    @Before
    public void setUp(){

        this.loginService = new LoginService(new String[] {"JROL", "BPER",
                "CGUR", "JDUP", "JRAL", "JRAL1"});
        this.loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenomTest() {
     //test 1
        String pdur = this.loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals(pdur,"PDUR");
        assertEquals(true, this.loginService.loginExists(pdur));

        //test 2
        String jrol1 = this.loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals(jrol1,"JROL1");
        assertEquals(true, this.loginService.loginExists(jrol1));

        //test 3
        String pdur1 = this.loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertEquals(pdur1,"PDUR1");
        assertEquals(true, this.loginService.loginExists(pdur1));

        //test 4
        String jral2 = this.loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertEquals(jral2,"JRAL2");
        assertEquals(true, this.loginService.loginExists(jral2));
    }
}
