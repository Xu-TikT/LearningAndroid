package com.tikt.learning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tikt on 16-2-15.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

	Context context;
	ArrayList<String> list;
	LayoutInflater layoutInflater;

	public MainActivityAdapter(Context context, ArrayList<String> namelist) {

		this.context = context;
		this.list = namelist;
		this.layoutInflater = LayoutInflater.from(context);
	}

	public void onDateChange(Context context, ArrayList<String> namelist) {
		this.context = context;
		this.list = namelist;

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = layoutInflater.inflate(R.layout.item_mainrecycleview, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		holder.itemName.setText(list.get(position));
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		TextView itemName;

		public ViewHolder(View itemView) {
			super(itemView);
			itemName = (TextView) itemView.findViewById(R.id.id_item_recycleview);
		}
	}
}
