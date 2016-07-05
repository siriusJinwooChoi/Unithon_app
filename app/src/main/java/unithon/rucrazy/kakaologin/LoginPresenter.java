package unithon.rucrazy.kakaologin;

public class LoginPresenter implements OnLoginListener {
    private LoginActivity loginActivity;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        this.loginInteractor = new LoginInteractor(this, loginActivity.getApplicationContext());
    }

    public void login() {
        loginInteractor.setup();
        loginActivity.showLogin();
    }

    public void onDestroy() {
        loginInteractor.destroy();
    }

    @Override
    public void onUsernameError() {
        loginActivity.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginActivity.setPasswordError();
    }

    @Override
    public void redirectSignupActivity() {
        loginActivity.redirectSignupActivity();
    }

    @Override
    public void refreshActivity() {
        loginActivity.refreshActivity();
    }

    @Override
    public void redirectDepartureActivity() {
        loginActivity.redirectDepartureActivity();
    }
}
