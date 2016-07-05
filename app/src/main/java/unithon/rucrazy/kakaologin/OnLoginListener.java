package unithon.rucrazy.kakaologin;

public interface OnLoginListener {
    void onUsernameError();
    void onPasswordError();

    void redirectSignupActivity();
    void refreshActivity();
    void redirectDepartureActivity();
}
