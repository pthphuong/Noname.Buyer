package vn.fpt.nonamebuyer;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.math.BigDecimal;
import java.util.Date;

import vn.fpt.nonamebuyer.model.StoreDetail;
import vn.fpt.nonamebuyer.model.StoreProduct;
import vn.fpt.nonamebuyer.util.ConstDefiner;
import vn.fpt.nonamebuyer.util.RestCaller;

public class UpdatePrice extends AppCompatActivity {

    private EditText txtProductPrice;

    private StoreDetail storeDetail;
    private StoreProduct storeProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_price);

        txtProductPrice = (EditText) findViewById(R.id.txtProductPrice);

        Bundle bundle = getIntent().getExtras();
        String scanContent = bundle.getString(ConstDefiner.SCAN_CONTENT);
        ConstDefiner.setValueToTextview(scanContent, R.id.txtBarcodeContent, this);

        String url = ConstDefiner.SERVER_URL + "/services/getStoreDetail/barcode/" + scanContent + "/shopid/" + ConstDefiner.FIXED_ID_SHOP;
        storeDetail = RestCaller.getObjectFromUrl(url, StoreDetail.class);

        if (storeDetail != null) {
            url = ConstDefiner.SERVER_URL + "/services/getStoreProduct/id/" + storeDetail.getTensanpham_id();
            storeProduct = RestCaller.getObjectFromUrl(url, StoreProduct.class);
            fetchToGui(storeProduct, storeDetail.getGiaban());
            return;
        }

        url = ConstDefiner.SERVER_URL + "/services/getStoreProduct/barcode/" + scanContent;
        storeProduct = RestCaller.getObjectFromUrl(url, StoreProduct.class);

        if (storeProduct != null){
            fetchToGui(storeProduct, storeProduct.getGianiemyet());
            return;
        }

        ConstDefiner.showToast("Hàng hóa này chưa có trong danh mục", this);
    }

    private void fetchToGui(StoreProduct storeProduct, BigDecimal price) {
        ConstDefiner.setValueToTextview(storeProduct.getTensanpham(), R.id.txtProductName, this);
        ConstDefiner.setValueToTextview(storeProduct.getNhomhang(), R.id.txtNhomhang, this);

        String priceAsString = "";

        if (price != null) {
            long l = price.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
            priceAsString = String.valueOf(l);

        }

        ConstDefiner.setValueToTextview(priceAsString, R.id.txtProductPrice, this);
    }

    public void back(View view) {
//        super.onBackPressed();

        Intent intent = new Intent(this, Home.class);
        startActivityForResult(intent, 0);
    }

    public void changePrice(View view) {
        Editable editable = txtProductPrice.getText();

        long price;

        if (editable.length() == 0){
            price = 0;
        }
        else {
            try {
                price = Long.parseLong(editable.toString());
            } catch (NumberFormatException e) {
                price = 0;
            }
        }

        if (view.getId() == R.id.cmdDecrease){
            if (price == 0)
                return;

            price -= 100;
        }

        if (view.getId() == R.id.cmdIncrease){
            price += 100;
        }

        txtProductPrice.setText(String.valueOf(price));
    }

    public boolean isConnected(){

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

    public void updatePrice(View view) {

        if (storeProduct == null){
            ConstDefiner.showToast("Không cập nhật được giá cho hàng hóa không có trong danh mục", this);
            return;
        }

        String priceAsString = txtProductPrice.getText().toString();

        BigDecimal price = priceAsString.length() == 0 ? BigDecimal.ZERO : new BigDecimal(priceAsString);

        if (storeDetail != null) {
            storeDetail.setGiaban(price);
            storeDetail.setThoigiancapnhat(new Date());
        }
        else {
            storeDetail = new StoreDetail();
            storeDetail.setGiaban(new BigDecimal(10000));
            storeDetail.setGiaban_currency("VND");
            storeDetail.setThoigiantao(new Date());
            storeDetail.setTensanpham_id(storeProduct.getId());
            storeDetail.setTenshop_id(ConstDefiner.FIXED_ID_SHOP);
        }

/*
        Gson gson = ConstDefiner.buildGsonWithDateFormat();
        String json = gson.toJson(storeDetail);
*/

        String url = ConstDefiner.SERVER_URL + "/services/saveStoreDetail";
        String response = RestCaller.POST(url, storeDetail);
        storeDetail = ConstDefiner.buildGsonWithDateFormat().fromJson(response, StoreDetail.class);
        ConstDefiner.showToast("Cập nhật thành công", this);
    }

}
