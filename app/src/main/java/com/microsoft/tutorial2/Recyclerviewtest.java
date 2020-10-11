package com.microsoft.tutorial2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recyclerviewtest extends AppCompatActivity {





    AdapterDatafish Adapter;
    ArrayList<DataFish> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewtest);


        DataFish dataFish = new DataFish("hari","1234","202001","IT");
        DataFish dataFish2 = new DataFish("hari","1234","202001","IT");
        DataFish dataFish3 = new DataFish("hari","1234","202001","IT");
        DataFish dataFish4 = new DataFish("hari","1234","202001","IT");



        arrayList.add(dataFish);
        arrayList.add(dataFish2);
        arrayList.add(dataFish3);
        arrayList.add(dataFish4);
        arrayList.add(dataFish);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);


        Adapter = new AdapterDatafish(Recyclerviewtest.this, arrayList);
        Adapter.setHasStableIds(false);
        recyclerView.setAdapter(Adapter);
        recyclerView.setHasFixedSize(false);
        //                          mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        //                          mRVFishPrice.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
        recyclerView.setLayoutManager(new LinearLayoutManager(Recyclerviewtest.this,LinearLayoutManager.VERTICAL,true));

    }


    public class DataFish{

        public String item;
        public String noofpieces;
        public String cost;
        public String amt;


        public DataFish(String item,String noofpieces,String cost,String amt){

            this.item = item;
            this.noofpieces = noofpieces;
            this.cost = cost;
            this.amt = amt;
        }

    }

    public class AdapterDatafish extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<DataFish> data2 = Collections.emptyList();
        int currentPos = 0;
        private Context context;
        private LayoutInflater inflater;
        // create constructor to innitilize context and data sent from MainActivity
        public AdapterDatafish(Context context, List<DataFish> data5) {
            this.context = context;
            inflater = LayoutInflater.from(context);
            this.data2 = data5;
        }





        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.recyclerviewtestitem, parent, false);
            final AdapterDatafish.MyHolder holder = new AdapterDatafish.MyHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

            // Get current position of item in recyclerview to bind data and assign values from list
            final AdapterDatafish.MyHolder myHolder = (AdapterDatafish.MyHolder) holder;


            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
                }
            });
            //   mRVFishPrice.scrollToPosition(position);
            //    holder.setIsRecyclable(true);
            final DataFish current = data2.get(position);
            //  holder.getLayoutPosition();
            //    setHasStableIds(true);



            myHolder.item.setText(current.amt);
            myHolder.noofpices.setText(current.cost);
            myHolder.cost.setText(current.noofpieces);
            myHolder.amount.setText(current.item);
            myHolder.plus.setVisibility(View.GONE);
//            myHolder.minus.setVisibility(View.GONE);
            myHolder.delete.setVisibility(View.GONE);




        }

        @Override
        public int getItemCount() {
            return 0;
        }


        class MyHolder extends RecyclerView.ViewHolder {


            TextView item;
            TextView noofpices;
            TextView cost;
            TextView amount;
            Button plus;
            ImageButton delete;

            // create constructor to get widget reference
            public MyHolder(View itemView) {
                super(itemView);
                item = (TextView)itemView.findViewById(R.id.item);
                noofpices = (TextView)itemView.findViewById(R.id.noofpices);
                cost = (TextView)itemView.findViewById(R.id.cost);
                amount = (TextView)itemView.findViewById(R.id.total);
                plus = (Button)itemView.findViewById(R.id.plus);
//                minus = (ImageButton)itemView.findViewById(R.id.minus);
                delete = (ImageButton)itemView.findViewById(R.id.del);

                //  id= (TextView)itemView.findViewById(R.id.id);
            }


        }
    }





}
