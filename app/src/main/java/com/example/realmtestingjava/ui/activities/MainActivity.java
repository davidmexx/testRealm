package com.example.realmtestingjava.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.realmtestingjava.R;
import com.example.realmtestingjava.data.api.Product;
import com.example.realmtestingjava.data.api.Sale;
import com.example.realmtestingjava.data.api.User;
import com.example.realmtestingjava.data.repository.ProductRepository;
import com.example.realmtestingjava.data.repository.SaleRepository;
import com.example.realmtestingjava.data.repository.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.addData)
    Button btnInsertSale;

    @BindView(R.id.deleteData)
    Button btnDeleteSale;

    ProductRepository productRepository = ProductRepository.getInstance();

    UserRepository userRepository = UserRepository.getInstance();

    SaleRepository saleRepository = SaleRepository.getInstance();

    ArrayList<Product> productsSale = new ArrayList<>();
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private void saveData() {
        for (int i = 0 ; i <1000; i++) {
            Product product = Product.builder()
                    .uuid(UUID.randomUUID().toString())
                    .productName("Producto: " + i)
                    .build();
            productRepository.create(product);
            productsSale.add(product);
            System.out.println("Este es el objeto guardado: " + product);
        }
    }

    private void creatUser() {
         user = User.builder()
                .uuid(UUID.randomUUID().toString())
                .userName("Usuario vendedor")
                .build();
         userRepository.create(user);

    }

    @OnClick(R.id.deleteData)
    public void deleteData() {
        userRepository.delete();
        productRepository.delete();
        saleRepository.delete();
    }

    @OnClick(R.id.addData)
    public void doSale () {
        saveData();
        creatUser();
        Sale sale = Sale.builder()
                .uuid(UUID.randomUUID().toString())
                .product(productsSale)
                .user(user)
                .build();

        saleRepository.create(sale);
        System.out.println("Este es el objeto guardado: " + sale);
    }


}