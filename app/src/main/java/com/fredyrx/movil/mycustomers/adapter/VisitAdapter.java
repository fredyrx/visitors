package com.fredyrx.movil.mycustomers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.model.Visit;

import java.util.List;


/**
 * Created by sistemas on 27/04/2017.
 */

public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.ViewHolder>{

    private List<Visit> visits;

    public VisitAdapter(List<Visit> visits){
        this.visits = visits;
    }

    @Override
    public VisitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_visit, parent, false);
        return new VisitAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VisitAdapter.ViewHolder holder, int position) {
        Visit vis = visits.get(position);
        holder.reasonTextView.setText(vis.getReason());
        holder.durationTextView.setText(String.valueOf(vis.getDuration())+" Mins");
        if (vis.getVisitDate() == null){
            holder.dateTextView.setText("No registered");
        }else {
            holder.dateTextView.setText(vis.getDecoraterDate());
        }
    }

    @Override
    public int getItemCount() {
        return visits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final public TextView reasonTextView;
        final public TextView dateTextView;
        final public TextView durationTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            reasonTextView = (TextView) itemView.findViewById(R.id.reason_text_view);
            dateTextView = (TextView) itemView.findViewById(R.id.date_text_view);
            durationTextView = (TextView) itemView.findViewById(R.id.duration_text_view);
        }
    }
}

