package com.fredyrx.movil.mycustomers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.model.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    private List<Client> lstClient;
    private OnClientItemListener listener;


    public ClientAdapter(List<Client> lstClient, OnClientItemListener listener) {
        this.lstClient = lstClient;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_client, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Client cli = lstClient.get(position);
        holder.mImgIcon.setImageResource(cli.icon);
        holder.mTxvClientName.setText(cli.name);
    }

    @Override
    public int getItemCount() {
        return lstClient.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mImgIcon;
        public final TextView mTxvClientName;

        private OnClientItemListener listener;

        public ViewHolder(View itemView, final OnClientItemListener listener) {
            super(itemView);
            this.listener = listener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Client client = lstClient.get(getAdapterPosition());
                    listener.onSelectedClient(client);
                }
            });

            mImgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            mTxvClientName = (TextView) itemView.findViewById(R.id.txvClientName);

        }
    }

    public interface OnClientItemListener {
        void onSelectedClient(Client client);
    }
}
