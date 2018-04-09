package kz.cheesenology.mvptest.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private final List<LocalCarsMark> carsList;

    @Nullable
    private Callback mCallback;

    public CarsAdapter(List<LocalCarsMark> carsList) {
        this.carsList = carsList;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cars, parent, false);

        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        final LocalCarsMark localCars = carsList.get(position);

        holder.tvCarNum.setText(String.valueOf(localCars.getLocalCars().getCarID()));
        holder.tvCarName.setText(String.valueOf(localCars.getLocalCars().getCarName()));
        holder.tvCarMark.setText(localCars.getLocalMark().getMarkName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onClick(localCars);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onClick(localCars);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mCallback != null) {
                    mCallback.onLongClick(localCars);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public static class CarsViewHolder extends RecyclerView.ViewHolder {

        TextView tvCarNum;
        TextView tvCarMark;
        TextView tvCarName;

        public CarsViewHolder(View itemView) {
            super(itemView);

            tvCarNum = itemView.findViewById(R.id.tv_car_num);
            tvCarName = itemView.findViewById(R.id.tv_car_name);
            tvCarMark = itemView.findViewById(R.id.tv_car_mark);
        }
    }

    public interface Callback {
        void onClick(LocalCarsMark model);
        void onLongClick(LocalCarsMark model);
    }
}
