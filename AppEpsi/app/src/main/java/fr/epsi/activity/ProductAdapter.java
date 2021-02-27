package fr.epsi.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Category;
import fr.epsi.entity.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private ArrayList<Product> products;
    private MainActivity activity;

    public ProductAdapter(MainActivity activity, ArrayList<Product> products){
        this.activity=activity;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_product, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.getName().setText(product.getName());
        holder.getDescription().setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(holder.getImg());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductInfoActivity.displayActivity(activity, product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView name;
        private final TextView description;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            img = (ImageView) view.findViewById(R.id.imageViewProduct);
            name = (TextView) view.findViewById(R.id.textViewName);
            description = (TextView) view.findViewById(R.id.textViewDescription);
        }

        public ImageView getImg() {
            return img;
        }
        public TextView getName() {
            return name;
        }
        public TextView getDescription() {
            return description;
        }
    }
}