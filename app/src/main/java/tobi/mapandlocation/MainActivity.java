package tobi.mapandlocation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final int GO_FOR_BAIDU_MAP = 1;

    @Bind(R.id.go_in_location_btn)
    Button goInLocationBtn;
    @Bind(R.id.lng_tv)
    TextView lngTv;
    @Bind(R.id.lat_tv)
    TextView latTv;
    @Bind(R.id.address_name_tv)
    TextView addressNameTv;
    @Bind(R.id.address_detail_tv)
    TextView addressDetailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_in_location_btn)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivityForResult(intent, GO_FOR_BAIDU_MAP);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GO_FOR_BAIDU_MAP
                && data != null && data.getExtras() != null) {
            lngTv.setText("经度："+data.getStringExtra("Ing"));
            latTv.setText("维度："+data.getStringExtra("Iat"));
            addressNameTv.setText("地址名："+data.getStringExtra("Address"));
            addressDetailTv.setText("详细地址："+data.getStringExtra("DetailedAddress"));
        }
    }
}
