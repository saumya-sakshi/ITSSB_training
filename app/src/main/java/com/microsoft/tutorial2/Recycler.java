package com.microsoft.tutorial2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recycler extends AppCompatActivity {


    private AdapterFish Adapter;
    RecyclerView mRVFishPrice;
    List<DataFish2> filterdata2=new ArrayList<DataFish2>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);


        mRVFishPrice = (RecyclerView)findViewById(R.id.fishPriceList);



        DataFish2 sds = new DataFish2("hari","01","202012","IT","98165521" );

        DataFish2 sds2 = new DataFish2("gagan","2","2020123","ECE","65482321321");
        DataFish2 sds3 = new DataFish2("Nishanth","3","2020124","ECE","879846561");

        DataFish2 sds4 = new DataFish2("Ravi","4","2020125","CSE","987946121");

        DataFish2 sds5 = new DataFish2("Santanu","5","2020127","CSIT","9786523132");

        //        DataFish2 sds6 = new DataFish2("1","2","3","4");
        filterdata2.add(sds);
        filterdata2.add(sds3);
        filterdata2.add(sds2);
        filterdata2.add(sds4);
        filterdata2.add(sds5);


        Adapter = new AdapterFish(Recycler.this, filterdata2);
        Adapter.setHasStableIds(false);
        mRVFishPrice.setAdapter(Adapter);
        mRVFishPrice.setHasFixedSize(false);
        //                          mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        //                          mRVFishPrice.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
        mRVFishPrice.setLayoutManager(new LinearLayoutManager(Recycler.this,LinearLayoutManager.VERTICAL,true));

    }


    public class DataFish2 {

        public String name;
        public String rollno;
        public String id;
        public String clas;
        public String phone;


        public DataFish2(String name, String rollno, String id, String clas,String phone) {
            this.name = name;
            this.rollno = rollno;
            this.id = id;
            this.clas = clas;
            this.phone = phone;
        }
    }


    public class AdapterFish extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<DataFish2> data2 = Collections.emptyList();
        int currentPos = 0;
        private Context context;
        private LayoutInflater inflater;
        // create constructor to innitilize context and data sent from MainActivity
        public AdapterFish(Context context, List<DataFish2> data5) {
            this.context = context;
            inflater = LayoutInflater.from(context);
            this.data2 = data5;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.recyclerviewtestitem, parent, false);
            final AdapterFish.MyHolder holder = new AdapterFish.MyHolder(view);
            return holder;
        }


        // Bind data
        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

            // Get current position of item in recyclerview to bind data and assign values from list
            final AdapterFish.MyHolder myHolder = (AdapterFish.MyHolder) holder;


            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(context, data2.get(position).id, Toast.LENGTH_SHORT).show();
                }
            });
            //   mRVFishPrice.scrollToPosition(position);
            //    holder.setIsRecyclable(true);
            final DataFish2 current = data2.get(position);
            //  holder.getLayoutPosition();
            //    setHasStableIds(true);



            myHolder.call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("tel:"+current.phone);
                    Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                }
            });


            Toast.makeText(context, filterdata2.get(position).rollno, Toast.LENGTH_SHORT).show();
            myHolder.name.setText(current.name);
            myHolder.rollno.setText(current.rollno);
//            myHolder.id.setText(current.id);
            myHolder.clas.setText(current.clas);
            myHolder.phone.setText(current.phone);
  //          myHolder.plus.setVisibility(View.GONE);
//            myHolder.minus.setVisibility(View.GONE);
    //        myHolder.delete.setVisibility(View.GONE);




        }

        // return total item from List
        @Override
        public int getItemCount() {
            return data2.size();
        }


        class MyHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView rollno;
            TextView id;
            TextView clas;
            TextView phone;
            Button call;
            ImageView imag;
            ImageButton minus;
            ImageButton delete;

            // create constructor to get widget reference
            public MyHolder(View itemView) {
                super(itemView);
                name = (TextView)itemView.findViewById(R.id.name);
                rollno = (TextView)itemView.findViewById(R.id.rollno);
                id = (TextView)itemView.findViewById(R.id.cost);
                clas = (TextView)itemView.findViewById(R.id.clas);
                phone = (TextView)itemView.findViewById(R.id.phone);
                call = (Button)itemView.findViewById(R.id.call);
                imag =(ImageView)itemView.findViewById(R.id.imag);
  //              plus = (Button)itemView.findViewById(R.id.plus);
//                minus = (ImageButton)itemView.findViewById(R.id.minus);
//                delete = (ImageButton)itemView.findViewById(R.id.del);

                //  id= (TextView)itemView.findViewById(R.id.id);
            }


        }



    }
}
