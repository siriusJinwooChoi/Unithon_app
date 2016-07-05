package unithon.rucrazy.kakaologin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.HashMap;

import unithon.rucrazy.R;

/**
 * 추가로 받고자 하는 사용자 정보를 나타내는 layout
 * 이름, 나이, 성별을 입력할 수 있다.
 * @author MJ
 */
public class ExtraUserPropertyLayout extends FrameLayout {
    // property key
    private  static final String NAME_KEY = "name";
    private  static final String AGE_KEY = "age";
    private  static final String GENDER_KEY = "gender";

    private EditText name;
    private EditText age;
    //private KakaoDialogSpinner gender;

    public ExtraUserPropertyLayout(Context context) {
        super(context);
        initView();
    }

    public ExtraUserPropertyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ExtraUserPropertyLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        final View view = inflate(getContext(), R.layout.layout_usermgmt_extra_user_property, this);
        /*name = (EditText) view.findViewById(R.id.name);
        age = (EditText) view.findViewById(R.id.age);
        gender = (KakaoDialogSpinner) view.findViewById(R.id.gender);*/
    }

    public HashMap<String, String> getProperties(){
        final String nickNameValue = name.getText().toString();
        final String ageValue = age.getText().toString();
        //final String genderValue = String.valueOf(gender.getSelectedItem());

        HashMap<String, String> properties = new HashMap<String, String>();
        if(nickNameValue != null)
            properties.put(NAME_KEY, nickNameValue);
        if(ageValue != null)
            properties.put(AGE_KEY, ageValue);
        /*
        if(genderValue != null)
            properties.put(GENDER_KEY, genderValue);*/

        return properties;
    }
}
