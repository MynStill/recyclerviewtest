package com.example.recyclerviewtest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHold> {

    private List<Fruit> fruitList;

    static class ViewHold extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitText;

        public ViewHold(View v){
            super(v);
            fruitView = v;
            fruitImage = (ImageView) v.findViewById(R.id.fruit_image);
            fruitText = (TextView) v.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        this.fruitList = fruitList;
    }

    //在onCreateViewHolder中添加RecyclerView的点击事件
    @Override
    public ViewHold onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fruit_item, viewGroup, false);
        final ViewHold viewHold = new ViewHold(view);
        //以下分别添加RecyclerView的子项和图片的点击事件
        viewHold.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = viewHold.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                //Toast.makeText(v.getContext(), "You clicked fruitView: " + fruit.getName(), Toast.LENGTH_SHORT).show();
                //点击子项，进入另一个活动，显示水果的详细信息
                Intent intent = new Intent(v.getContext(), ExFruitActivity.class);
                intent.putExtra("fruitName", fruit.getName());
                intent.putExtra("fruitImageId", fruit.getImageId());
                v.getContext().startActivity(intent);
            }
        });
        viewHold.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = viewHold.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), "You clicked fruitImage: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHold;
    }

    @Override
    public void onBindViewHolder( ViewHold viewHold, int position) {
        Fruit fruit = fruitList.get(position);
        viewHold.fruitImage.setImageResource(fruit.getImageId());
        viewHold.fruitText.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
