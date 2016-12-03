package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mundial on 03/12/2016.
 */
public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp(){
        String[] logins ={"login1","login2","login3","login4","login5","login6"};
        this.loginService = new LoginService(logins);
    }

    @Test
    public void testLoginExists() throws Exception {
        String log ="login0";
        String log1 ="loginlogin";
         this.loginService.addLogin(log);
        assertFalse(this.loginService.loginExists(log1));
        assertTrue(this.loginService.loginExists(log));
    }

    @Test
    public void testAddLogin() throws Exception {
        String login ="login7";
        this.loginService.addLogin(login);
        Boolean logExist = this.loginService.loginExists(login);
        assertTrue(logExist);
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
       String log1 ="myLogin1";
        String log2 ="myLogin2";
        this.loginService.addLogin(log1);
        this.loginService.addLogin(log2);
        List<String> number = this.loginService.findAllLoginsStartingWith("my");
        assertEquals(2, number.size());

    }

    @Test
    public void testFindAllLogins() throws Exception {
      this.loginService.addLogin("myLoginLogind");
        List<String> logins = this.loginService.findAllLogins();
        assertEquals(7,logins.size());
    }

}