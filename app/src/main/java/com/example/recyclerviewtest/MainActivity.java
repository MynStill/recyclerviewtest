package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> data = new ArrayList<Fruit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitInit();    //数据初始化
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //横向滑动
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //瀑布流滑动 纵向滑动 3列
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        FruitAdapter fruitAdapter = new FruitAdapter(data);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void fruitInit(){
        for(int i = 0; i < 10; i++){
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_img);
            data.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_img);
            data.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_img);
            data.add(orange);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_img);
            data.add(pear);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_img);
            data.add(pineapple);
            Fruit pototo = new Fruit(getRandomLengthName("Pototo"), R.drawable.pototo_img);
            data.add(pototo);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_img);
            data.add(strawberry);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_img);
            data.add(watermelon);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(name);
        }
        return sb.toString();
    }
}
