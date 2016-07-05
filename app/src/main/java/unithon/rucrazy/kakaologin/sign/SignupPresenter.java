package unithon.rucrazy.kakaologin.sign;

public class SignupPresenter implements OnSignupListener {
    private SignupActivity signupActivity;
    private SignupInteractor signupInteractor;

    public SignupPresenter(SignupActivity signupActivity) {
        this.signupActivity = signupActivity;
        this.signupInteractor = new SignupInteractor(this);
    }

    public void onSignup(String name, String age, String gender) {
        signupInteractor.signup(name, age, gender);
        signupActivity.redirectDepartureActivity();
    }
}
